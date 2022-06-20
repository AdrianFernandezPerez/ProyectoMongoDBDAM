package main.java;

import com.mongodb.MongoException;
import com.mongodb.MongoClient;
import com.mongodb.client.*;

public class Conexion {

    /*
     * Metodo que permite conectarse a la base de datos de MongoDB con mongoAtlas
     */
    public com.mongodb.client.MongoClient conectarse(){

        //System.setProperty("jdk.tls.trustNameService", "true");
        try{
        String uri = "mongodb+srv://root:abc123.@dbtaller.9ajfzky.mongodb.net/?retryWrites=true&w=majority";
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("dbtaller");
        return mongoClient;
        }catch (Exception e){
            System.out.println("Error al conectar con la base de datos "+e);
        }
        return null;

    }

    public MongoDatabase obtenerDB(com.mongodb.client.MongoClient mongoClient){
        MongoDatabase db = mongoClient.getDatabase("dbtaller");
        return db;
    }

    /*
     * Metodo que permite conectarse a la base de datos de MongoDB sin mongoAtlas
     */
    public MongoClient crearConexion(){
        MongoClient mongoClient = null;
        /*
        String servidor = "localhost";
        int puerto = 27017;
        try {

            mongoClient = new MongoClient(servidor, puerto);
            List<String> nombresBds = mongoClient.getDatabaseNames();
            System.out.println("Se conecto a la base de datos correctamente\n");
            System.out.println("Bases de datos disponibles: " + nombresBds.toString() +"\n");
            MongoDatabase db = mongoClient.getDatabase("dbtaller");
            System.out.println("Usted se a conectado a la base de datos: " + nombresBds.get(2) + "\n");


        } catch (MongoException e) {
            System.out.println("Error al conectar con la base de datos "+e);
        }
        */
        return mongoClient;
    }
}
