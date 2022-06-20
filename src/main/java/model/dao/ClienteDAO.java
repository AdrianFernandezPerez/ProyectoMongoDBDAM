package main.java.model.dao;


import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.java.Conexion;
import main.java.model.entity.Cliente;
import main.java.model.entity.Vehiculo;
import main.java.view.ClienteView;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ClienteDAO implements InterfaceDAO<Cliente>{

    private ClienteView clienteView;



    public ClienteDAO() {
        clienteView = new ClienteView();
    }

    /*
    * Metodo que inserta un cliente
     */
    @Override
    public void create(Cliente cliente, MongoDatabase db) {

        try {
            /*
            Codigo
             */
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            Document documento = new Document();
            documento.append("_id", cliente.getIdCliente());
            documento.append("nombre", cliente.getNombre());
            documento.append("email", cliente.getEmail());
            documento.append("telefono", cliente.getTelefono());
            documento.append("provincia", cliente.getProvincia());
            documento.append("codigoPostal", cliente.getCodigoPostal());
            documento.append("direccion", cliente.getDireccion());
            documento.append("pais", cliente.getPais());
            documento.append("localidad", cliente.getLocalidad());
            coleccion.insertOne(documento);

            clienteView.muestraMensaje("-------Cliente anhadido-------");
        } catch (Exception exception){
            System.out.println("Error al crear el cliente" + exception);
        }
    }


    /*
    * Metodo que lista todos los clientes
     */
    @Override
    public List<Cliente> findAll(MongoDatabase db) {
        try {

            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            List<Document> consulta = coleccion.find()
                    .into(new ArrayList<Document>());
            //Lista de clientes
            List<Cliente> list = new ArrayList<>();
            //Recorremos la lista de documentos
            for (Document documento : consulta) {
                Cliente cliente = new Cliente();
                String json = documento.toJson();
                //Convertir el json a objeto Cliente
                cliente = new Gson().fromJson(json, Cliente.class);
                //Añadir el cliente a la lista
                list.add(cliente);
            }
            //Devolver la lista
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar los clientes" + exception);
        }
        return null;
    }

    /*
    * Metodo que busca un cliente por su id
     */
    @Override
    public Cliente find(MongoDatabase db, int idCliente) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            FindIterable<Document> consulta = coleccion.find(eq("_id", idCliente));
            //Convertir el json a objeto Cliente
            Cliente cliente = new Cliente();
            String json = consulta.first().toJson();
            cliente = new Gson().fromJson(json, Cliente.class);
            //Devolver el cliente
            return cliente;
        }catch (Exception exception){
            System.out.println("Error en listado del cliente " + exception);
        }
        return null;
    }




    /*
    * Metodo que actualiza los datos de un cliente
     */
    @Override
    public void update(MongoDatabase db, Cliente clienteAntiguo) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            Document documento = new Document();
            documento.append("_id", clienteAntiguo.getIdCliente());
            documento.append("nombre", clienteAntiguo.getNombre());
            documento.append("email", clienteAntiguo.getEmail());
            documento.append("telefono", clienteAntiguo.getTelefono());
            documento.append("provincia", clienteAntiguo.getProvincia());
            documento.append("codigoPostal", clienteAntiguo.getCodigoPostal());
            documento.append("direccion", clienteAntiguo.getDireccion());
            documento.append("pais", clienteAntiguo.getPais());
            documento.append("localidad", clienteAntiguo.getLocalidad());
            coleccion.updateOne(eq("_id", clienteAntiguo.getIdCliente()),
                    new Document("$set", documento));

        }catch (Exception exception){
            System.out.println("Error al actualizar el cliente" + exception);
        }
    }

    /*
    * Metodo que elimina un cliente por su id
     */
    @Override
    public void delete(MongoDatabase db, int idCliente) {
        try{
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            coleccion.deleteOne(eq("_id", idCliente));
        }catch (Exception exception){
            System.out.println("Error al borrar el cliente" + exception);
        }
    }

    /*
    * Metodo que añade un vehiculo a un cliente
     */
    public void addVehicle(MongoDatabase db, Cliente cliente, Vehiculo vehiculo) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            coleccion.updateOne(eq("_id", cliente.getIdCliente()),
                    new Document("$push", new Document("vehiculos", vehiculo.getIdVehiculo())));
        }catch (Exception exception){
            System.out.println("Error al anhadir el vehiculo" + exception);
        }
    }

    /*
    * Metodo que devuelve una consulta que muestra los clientes con vehiculos y ordenados por codigo postal
     */
    public List<Cliente> findAllWithVehiclesAndCPOrder(MongoDatabase db) {
        try {
            MongoCollection<Document> coleccion =
                    db.getCollection("clientes");
            List<Document> pipeline =
                    Arrays.asList(new Document("$project",
                                    new Document("_id", 1L)
                                            .append("nombre", 1L)
                                            .append("email", 1L)
                                            .append("telefono", 1L)
                                            .append("provincia", 1L)
                                            .append("codigoPostal", 1L)
                                            .append("direccion", 1L)
                                            .append("pais", 1L)
                                            .append("localidad", 1L)
                                            .append("vehiculos", 1L)),
                            new Document("$match",
                                    new Document("vehiculos",
                                            new Document("$gt", 0L))),
                            new Document("$sort",
                                    new Document("codigoPostal", 1L)));

            List<Document> results = coleccion.aggregate(pipeline).into(new ArrayList<Document>());
            List<Cliente> list = new ArrayList<>();
            for (Document doc: results) {
                Cliente cliente = new Cliente();
                String json = doc.toJson();
                //Convertir el json a objeto Vehiculo
                cliente = new Gson().fromJson(json, Cliente.class);
                //Añadir el vehiculo a la lista
                list.add(cliente);
            }
            return list;
        }catch (Exception exception){
            System.out.println("Error en listado de clientes " + exception);
        }
        return null;
    }
}
