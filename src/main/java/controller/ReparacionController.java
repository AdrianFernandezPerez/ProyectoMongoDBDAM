package main.java.controller;

import com.mongodb.client.MongoDatabase;
import main.java.model.dao.ReparacionDAO;
import main.java.model.entity.Reparacion;
import main.java.model.entity.Vehiculo;
import main.java.view.ReparacionView;

import java.util.List;

public class ReparacionController {
    private ReparacionDAO reparacionDAO;
    private ReparacionView reparacionView;

    /*
    * Control del menu de reparaciones
     */
    public void mostrarMenuReparaciones(MongoDatabase db) {
        int opcion = reparacionView.mostrarMenuReparaciones();
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
                addMechanic(db);
                break;
            case 6:
                finishReparation(db);
                break;
            case 7:
                delete(db);
                break;
            case 8:
                return;
        }
    }

    /*
    * Metodo que finaliza una reparacion
     */
    private void finishReparation(MongoDatabase db) {
        int id = reparacionView.seleccionarReparacion();
        Reparacion reparacion = reparacionDAO.find(db, id);
        reparacionDAO.updateEndDate(db, reparacion);
        reparacionView.muestraMensaje("-------Reparacion finalizada-------");
    }

    /*
    * Metodo que insertara mecanicos a la reparacion
     */
    private void addMechanic(MongoDatabase db) {
        System.out.println("Codigo en implementacion");
    }

    public ReparacionController() {
        reparacionView = new ReparacionView();
        reparacionDAO = new ReparacionDAO();
    }


    /*
Funcion que crea un vehiculo
 */
    public void create(MongoDatabase db) {
        Reparacion reparacion = new Reparacion();
        reparacionView.anhadirReparacion(reparacion);
        reparacionDAO.create(reparacion,db);
    }

    /*
Funcion que actualiza un vehiculo
 */
    public void update(MongoDatabase db) {
        int id = reparacionView.seleccionarReparacion();
        Reparacion reparacionAntigua = reparacionDAO.find(db, id);
        reparacionView.actualizarReparacion(reparacionAntigua);
        reparacionDAO.update(db, reparacionAntigua);
        reparacionView.muestraMensaje("-------Reparacion modificada-------");
    }

    /*
        Funcion que busca una reparacion
     */
    public void findOne(MongoDatabase db) {
        int id = reparacionView.seleccionarReparacion();
        Reparacion r = reparacionDAO.find(db, id);
        if(r != null) {
            reparacionView.viewReparacion(r);
        } else {
            System.out.println("-------Reparación no encontrado-------");
        }
    }

    /*
        Funcion que muestra todas las reparaciones
     */
    public void findAll(MongoDatabase db) {
        List<Reparacion> reparaciones = reparacionDAO.findAll(db);
        reparacionView.viewReparaciones(reparaciones);
    }

    /*
        Funcion que elimina una reparacion
     */
    public void delete(MongoDatabase db) {
        int id = reparacionView.seleccionarReparacion();
        reparacionDAO.delete(db, id);
        reparacionView.muestraMensaje("-------Reparacion borrada-------");
    }


}

