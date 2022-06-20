package main.java.controller;

import com.mongodb.client.MongoDatabase;
import main.java.model.dao.ClienteDAO;
import main.java.model.dao.ReparacionDAO;
import main.java.model.dao.VehiculoDAO;
import main.java.model.entity.Cliente;
import main.java.model.entity.Reparacion;
import main.java.model.entity.Vehiculo;
import main.java.view.ClienteView;
import main.java.view.ReparacionView;
import main.java.view.VehiculoView;

import java.util.List;

public class VehiculoController {
    private VehiculoView vehiculoView;
    private ClienteView clienteView;
    private ClienteDAO clienteDAO;
    private VehiculoDAO vehiculoDAO;
    private ReparacionView reparacionView;
    private ReparacionDAO reparacionDAO;

    /*
    * Control del menu de vehiculos
     */
    public void mostrarMenuVehiculos(MongoDatabase db) {
        int opcion = vehiculoView.muestraMenuVehiculos();
        int id;
        switch (opcion) {
            case 1:
                create(db);
                break;
            case 2:
                update(db);
                break;
            case 3:
                findOne(db);
                break;
            case 4:
                findAll(db);
                break;
            case 5:
                addReparation(db);
                break;
            case 6:
                delete(db);
                break;
            case 7:
                sortByType(db);
                break;
            case 8:
                return;
        }
    }

    /*
    * Consulta que muestra los vehiculos ordenados alfabeticamente por tipo
     */
    private void sortByType(MongoDatabase db) {
        System.out.println("Consulta que muestra los vehiculos ordenados alfabeticamente por tipo");
        List<Vehiculo> vehiculos = vehiculoDAO.sortByType(db);
        vehiculoView.viewVehiculos(vehiculos);
    }

    /*
    * Metodo que añade una reparacion a un vehiculo
     */
    private void addReparation(MongoDatabase db) {
        int id = vehiculoView.seleccionarVehiculo();
        Vehiculo vehiculo = vehiculoDAO.find(db, id);
        int idReparacion = reparacionView.seleccionarReparacion();
        Reparacion reparacion = reparacionDAO.find(db, idReparacion);
        if (vehiculo != null) {
            vehiculoDAO.addReparation(db, vehiculo, reparacion);
            vehiculoView.muestraMensaje("-------Reparacion anhadida-------");
        } else {
            vehiculoView.muestraMensaje("-------Vehiculo no encontrado-------");
        }
    }


    public VehiculoController() {
        vehiculoDAO = new VehiculoDAO();
        vehiculoView = new VehiculoView();
        clienteDAO = new ClienteDAO();
        clienteView = new ClienteView();
        reparacionView = new ReparacionView();
        reparacionDAO = new ReparacionDAO();
    }

    /*
    *    Funcion que crea un vehiculo
    */
    public void create(MongoDatabase db) {
        Vehiculo v = new Vehiculo();
        vehiculoView.anhadirVehiculo(v);
        vehiculoDAO.create(v, db);
    }

    /*
    *   Funcion que actualiza un vehiculo
    */
    public void update(MongoDatabase db) {
        int id = vehiculoView.seleccionarVehiculo();
        Vehiculo vehiculoAntiguo = vehiculoDAO.find(db, id);
        vehiculoView.actualizarVehiculo(vehiculoAntiguo);
        vehiculoDAO.update(db, vehiculoAntiguo);
        vehiculoView.muestraMensaje("-------Vehiculo modificado-------");
    }

    /*
        Funcion que busca un vehiculo
     */
    public void findOne(MongoDatabase db) {
        int id = vehiculoView.seleccionarVehiculo();
        Vehiculo v = vehiculoDAO.find(db, id);
        if(v != null) {
            vehiculoView.viewVehiculo(v);
        } else {
            System.out.println("-------Vehiculo no encontrado-------");
        }
    }

    /*
        Funcion que muestra todos los vehiculos
     */
    public void findAll(MongoDatabase db) {
        List<Vehiculo> vehiculos = vehiculoDAO.findAll(db);
        vehiculoView.viewVehiculos(vehiculos);
    }

    /*
        Funcion que elimina un vehiculo
     */
    public void delete(MongoDatabase db) {
        int id = vehiculoView.seleccionarVehiculo();
        vehiculoDAO.delete(db, id);
        vehiculoView.muestraMensaje("-------Vehiculo borrado-------");
    }
}
