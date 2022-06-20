package main.java.model.dao;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.java.model.entity.Cliente;
import main.java.model.entity.Reparacion;
import main.java.model.entity.Vehiculo;
import main.java.view.VehiculoView;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class VehiculoDAO implements InterfaceDAO<Vehiculo> {
    private VehiculoView vehiculoView;

    public VehiculoDAO() {
        vehiculoView = new VehiculoView();
    }

    /*
     * Metodo que inserta un vehiculo
     */
    @Override
    public void create(Vehiculo vehiculo, MongoDatabase db) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            Document documento = new Document();
            documento.append("_id", vehiculo.getIdVehiculo());
            documento.append("matricula", vehiculo.getMatricula());
            documento.append("modelo", vehiculo.getModelo());
            documento.append("marca", vehiculo.getMarca());
            documento.append("cc", vehiculo.getCc());
            documento.append("carroceria", vehiculo.getCarroceria());
            documento.append("tipoVehiculo", vehiculo.getTipoVehiculo().toString());
            coleccion.insertOne(documento);
            vehiculoView.muestraMensaje("-------Vehiculo anhadido-------");
        }catch (Exception exception){
            System.out.println("Error al crear el vehiculo" + exception);
        }
    }

    /*
     * Metodo que devuelve todos los vehiculos
     */
    @Override
    public List<Vehiculo> findAll(MongoDatabase db) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            List<Document> consulta = coleccion.find()
                    .into(new ArrayList<Document>());
            //Lista de vehiculos
            List<Vehiculo> list = new ArrayList<>();
            //Recorremos la lista de documentos
            for (Document documento : consulta) {
                Vehiculo vehiculo = new Vehiculo();
                String json = documento.toJson();
                //Convertir el json a objeto Vehiculo
                vehiculo = new Gson().fromJson(json, Vehiculo.class);
                //Añadir el vehiculo a la lista
                list.add(vehiculo);
            }
            //Devolver la lista
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar los vehiculos" + exception);
        }
        return null;
    }

    /*
     * Metodo que busca un vehiculo por su id
     */
    @Override
    public Vehiculo find(MongoDatabase db, int idVehiculo) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            FindIterable<Document> consulta = coleccion.find(eq("_id", idVehiculo));
            //Convertir el json a objeto Vehiculo
            Vehiculo vehiculo = new Vehiculo();
            String json = consulta.first().toJson();
            vehiculo = new Gson().fromJson(json, Vehiculo.class);
            //Devolver el vehiculo
            return vehiculo;
        }catch (Exception exception){
            System.out.println("Error en listado del vehiculo " + exception);

        }
        return null;
    }


    /*
     * Metodo que actualiza los datos de un vehiculo
     */
    @Override
    public void update(MongoDatabase db, Vehiculo vehiculoAntiguo) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            //Crear el documento
            Document documento = new Document();
            documento.append("_id", vehiculoAntiguo.getIdVehiculo());
            documento.append("matricula", vehiculoAntiguo.getMatricula());
            documento.append("modelo", vehiculoAntiguo.getModelo());
            documento.append("marca", vehiculoAntiguo.getMarca());
            documento.append("cc", vehiculoAntiguo.getCc());
            documento.append("carroceria", vehiculoAntiguo.getCarroceria());
            documento.append("tipoVehiculo", vehiculoAntiguo.getTipoVehiculo().toString());
            coleccion.updateOne(eq("_id", vehiculoAntiguo.getIdVehiculo()),
                    new Document("$set", documento));
        }catch (Exception exception){
            System.out.println("Error al actualizar el vehiculo" + exception);
        }
    }

    /*
     * Metodo que elimina un vehiculo por su id
     */
    @Override
    public void delete(MongoDatabase db, int idVehiculo) {
        try{
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            coleccion.deleteOne(eq("_id", idVehiculo));
        }catch (Exception exception){
            System.out.println("Error al borrar el vehiculo" + exception);
        }
    }

    /*
     * Metodo que añade una reparacion a un vehiculo
     */
    public void addReparation(MongoDatabase db, Vehiculo vehiculo, Reparacion reparacion) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            coleccion.updateOne(eq("_id", vehiculo.getIdVehiculo()),
                    new Document("$push", new Document("reparaciones", reparacion.getIdReparacion())));
        }catch (Exception exception){
            System.out.println("Error al anhadir la reparacion al vehiculo" + exception);
        }
    }

    /*
    * Metodo que devuelve una consulta que devuelve todos los vehiculos ordenados por el campo tipoVehiculo
     */
    public List<Vehiculo> sortByType(MongoDatabase db) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("vehiculos");
            List<Document> pipeline =
                    Arrays.asList(new Document("$project",
                                    new Document("_id", 1L)
                                            .append("matricula", 1L)
                                            .append("modelo", 1L)
                                            .append("marca", 1L)
                                            .append("cc", 1L)
                                            .append("carroceria", 1L)
                                            .append("tipoVehiculo", 1L)
                                            .append("reparaciones", 1L)),
                            new Document("$sort",
                                    new Document("tipoVehiculo", 1L)));

            List<Document> results = coleccion.aggregate(pipeline).into(new ArrayList<Document>());
            List<Vehiculo> list = new ArrayList<>();
            for (Document doc: results) {
                Vehiculo vehiculo = new Vehiculo();
                String json = doc.toJson();
                //Convertir el json a objeto Vehiculo
                vehiculo = new Gson().fromJson(json, Vehiculo.class);
                //Añadir el vehiculo a la lista
                list.add(vehiculo);
            }
            //Devolver la lista
            return list;

        }catch (Exception exception){
            System.out.println("Error en listado de los vehiculos " + exception);

        }
        return null;
    }
}
