package main.java.controller;

import com.mongodb.client.MongoDatabase;
import main.java.model.dao.ClienteDAO;
import main.java.model.dao.VehiculoDAO;
import main.java.model.entity.Cliente;
import main.java.model.entity.Vehiculo;
import main.java.view.ClienteView;
import main.java.view.VehiculoView;

import java.util.List;


public class ClienteController {
    private ClienteView clienteView;
    private ClienteDAO clienteDAO;
    private VehiculoView vehiculoView;
    private VehiculoDAO vehiculoDAO;

    /*
    * Control del menu de clientes
     */
    public void mostrarMenuClientes(MongoDatabase db) {
        int opcion = clienteView.muestraMenuClientes();
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
                addVehicle(db);
                break;
            case 6:
                delete(db);
                break;
            case 7:
                findAllWithVehiclesAndCPOrder(db);
                break;
            case 8:
                return;
        }
    }

    /*
    * Consulta que devuelve los clientes con vehiculos y ordenados por codigo postal
     */
    private void findAllWithVehiclesAndCPOrder(MongoDatabase db) {
        System.out.println("Consulta que muestra los clientes con vehiculos y ordenados por codigo postal");
        List<Cliente> clientes = clienteDAO.findAllWithVehiclesAndCPOrder(db);
        clienteView.viewClientes(clientes);
    }

    /*
    * Metodo que inserta un vehiculo a un cliente
     */
    private void addVehicle(MongoDatabase db) {
        int id = clienteView.seleccionarCliente();
        Cliente cliente = clienteDAO.find(db, id);
        int idVehiculo = vehiculoView.seleccionarVehiculo();
        Vehiculo vehiculo = vehiculoDAO.find(db, idVehiculo);
        if (cliente != null && vehiculo != null) {
            clienteDAO.addVehicle(db, cliente, vehiculo);
            clienteView.muestraMensaje("-------Vehiculo anhadido-------");
        } else {
            clienteView.muestraMensaje("-------Cliente no encontrado-------");
        }
    }


    public ClienteController() {
        clienteDAO = new ClienteDAO();
        clienteView = new ClienteView();
        vehiculoView = new VehiculoView();
        vehiculoDAO = new VehiculoDAO();
    }

    /*
        Funcion que crea un cliente
    */
    public void create(MongoDatabase db) {
        Cliente c = new Cliente();
        clienteView.anhadirCliente(c);
        clienteDAO.create(c, db);
    }

    /*
        Funcion que actualiza un cliente
    */
    public void update(MongoDatabase db) {
        int id = clienteView.seleccionarCliente();
        Cliente clienteAntiguo = clienteDAO.find(db, id);
        if (clienteAntiguo != null) {
            clienteView.modificarCliente(clienteAntiguo);
            clienteDAO.update(db, clienteAntiguo);
            clienteView.muestraMensaje("-------Cliente modificado-------");
        } else {
            clienteView.muestraMensaje("-------Cliente no encontrado-------");
        }
    }

    /*
        Funcion que busca un cliente
     */
    public void findOne(MongoDatabase db) {
        int id = clienteView.seleccionarCliente();
        try {
            Cliente c = clienteDAO.find(db, id);
            if(c.getIdCliente()==id){
                clienteView.viewCliente(c);
            }
        }   catch (Exception e) {
            clienteView.muestraMensaje("-------Cliente no encontrado-------" +e.getMessage());
        }


    }

    /*
        Funcion que muestra todos los clientes
     */
    public void findAll(MongoDatabase db) {
        List<Cliente> clientes = clienteDAO.findAll(db);
        clienteView.viewClientes(clientes);
    }

    /*
        Funcion que elimina un cliente
     */
    public void delete(MongoDatabase db) {
        int id = clienteView.seleccionarCliente();
        try {
            clienteDAO.delete(db, id);
            clienteView.muestraMensaje("-------Cliente borrado-------");
        }   catch (Exception e) {
            clienteView.muestraMensaje("-------El cliente no se pudo borrar-------" +e.getMessage());
        }

    }
}
