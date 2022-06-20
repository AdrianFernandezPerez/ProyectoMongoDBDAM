package main.java.controller;

import com.mongodb.client.MongoDatabase;
import main.java.view.View;
import main.java.view.VistaMenu;

import java.text.ParseException;


public class mainController{
    private VistaMenu vista = new VistaMenu();
    private View view = new View();
    private boolean salir = false;
    private int opcion;
    private ClienteController clienteController = new ClienteController();
    private VehiculoController vehiculoController = new VehiculoController();
    private ReparacionController reparacionController = new ReparacionController();

    public void controlaMenu(MongoDatabase db) {
        do {
            vista.muestraMenu();
            opcion = view.pideInt("Ingresa una opcion: ");
            switch (opcion){
                case 1:
                    //Menu Clientes
                    clienteController.mostrarMenuClientes(db);
                    break;

                case 2:
                    //Menu Vehiculos
                    vehiculoController.mostrarMenuVehiculos(db);
                    break;

                case 3:
                    //Menu Reparaciones
                    reparacionController.mostrarMenuReparaciones(db);
                    break;

                case 4:
                    //Menu mecanicos
                    break;

                case 5:
                    //Volver al menu principal
                    vista.muestraMenu();
                    break;

                case 0:
                    salir = true;
                    view.muestraMensaje("Vuelva pronto");
            }
        }while (!salir);

    }
    }


