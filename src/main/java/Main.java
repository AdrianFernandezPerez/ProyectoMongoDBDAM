package main.java;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import main.java.controller.mainController;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        //Eliminamos los mensajes log de la consola
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
        //Objeto de la clase conexion
        Conexion conexion = new Conexion();
        //Nos conectamos a la bd mongo con el metodo Conectarse
        MongoClient mongoClient = conexion.conectarse();
        MongoDatabase mongoDatabase = conexion.obtenerDB(mongoClient);
        //Objeto de la clase mainController
        mainController menu = new mainController();
        //Llamamos al metodo menu
        menu.controlaMenu(mongoDatabase);
    }
}