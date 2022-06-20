package main.java.model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.java.model.entity.Reparacion;
import main.java.model.entity.Vehiculo;
import main.java.view.ReparacionView;
import org.bson.Document;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ReparacionDAO implements InterfaceDAO<Reparacion>{
    private ReparacionView reparacionView;

    public ReparacionDAO() {
        reparacionView = new ReparacionView();
    }

    /*
    * Metodo que inserta una reparacion
     */
    @Override
    public void create(Reparacion reparacion, MongoDatabase db){
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            Document documento = new Document();
            documento.append("_id", reparacion.getIdReparacion());
            documento.append("descripcion", reparacion.getDescripcion());
            documento.append("fechaInicio", reparacion.getFechaInicio().toString());
            documento.append("fechaFin", null);

            coleccion.insertOne(documento);
            reparacionView.muestraMensaje("-------Reparacion anhadida-------");
        }catch (Exception exception){
            System.out.println("Error al crear la reparacion" + exception);
        }
    }

    /*
    * Metodo que devuelve todas las reparaciones
     */
    @Override
    public List<Reparacion> findAll(MongoDatabase db) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            List<Document> consulta = coleccion.find()
                    .into(new ArrayList<Document>());
            //Lista de reparaciones
            List<Reparacion> list = new ArrayList<>();
            //Recorremos la lista de documentos
            for (Document documento : consulta) {
                String json = documento.toJson();
                //Convertir el json a objeto Reparacion
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                        .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                        .create();


                Reparacion reparacion = gson.fromJson(json, Reparacion.class);
                //Añadir la reparacion a la lista
                list.add(reparacion);
            }
            //Devolver la lista
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar las reparaciones" + exception);
        }
        return null;
    }

    /*
    * Metodo que devuelve una reparacion
     */
    @Override
    public Reparacion find(MongoDatabase db, int idReparacion) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            FindIterable<Document> consulta = coleccion.find(eq("_id", idReparacion));
            //Convertir el json a objeto Reparacion

            String json = consulta.first().toJson();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                    .create();

            Reparacion reparacion = gson.fromJson(json, Reparacion.class);

            //Devolver la reparacion
            return reparacion;

        }catch (Exception exception){
            System.out.println("Error en listado de la reparacion " + exception);
        }
        return null;
    }

    /*
    * Metodo para actualizar una reparacion
     */
    @Override
    public void update(MongoDatabase db, Reparacion reparacion) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            //Crear el documento
            Document documento = new Document();
            documento.append("_id", reparacion.getIdReparacion());
            documento.append("descripcion", reparacion.getDescripcion());
            documento.append("fechaInicio", reparacion.getFechaInicio());
            documento.append("fechaFin", reparacion.getFechaFin());
            coleccion.updateOne(eq("_id", reparacion.getIdReparacion()),
                    new Document("$set", documento));
        }catch (Exception exception){
            System.out.println("Error al actualizar la reparacion" + exception);
        }
    }

    /*
    * Metodo para poner la fecha de fin de una reparacion
     */
    public void updateEndDate(MongoDatabase db, Reparacion reparacion) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            //Crear el documento
            Document documento = new Document();
            documento.append("_id", reparacion.getIdReparacion());
            documento.append("descripcion", reparacion.getDescripcion());
            documento.append("fechaInicio", reparacion.getFechaInicio().toString());
            documento.append("fechaFin", LocalDate.now().toString());
            coleccion.updateOne(eq("_id", reparacion.getIdReparacion()),
                    new Document("$set", documento));
        }catch (Exception exception){
            System.out.println("Error al actualizar la fechaFin de la reparacion" + exception);
        }
    }

    /*
    * Metodo para eliminar una reparacion
     */
    @Override
    public void delete(MongoDatabase db, int idReparacion) {
        try{
            MongoCollection<Document> coleccion =
                    db.getCollection("reparaciones");
            coleccion.deleteOne(eq("_id", idReparacion));
        }catch (Exception exception){
            System.out.println("Error al borrar la reparacion" + exception);
        }
    }

}
