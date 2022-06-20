package main.java.view;


import main.java.model.entity.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ClienteView extends View {

    /*
    * Metodo que muestra las opciones del menu de clientes
     */
    public int muestraMenuClientes(){
        System.out.println("");
        System.out.println("--Menu de Clientes--");
        System.out.println("");
        System.out.println("1. Anhadir Cliente");
        System.out.println("2. Modificar Cliente");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Mostrar Clientes");
        System.out.println("5. Anhadir Vehiculo");
        System.out.println("6. Borrar Cliente");
        System.out.println("7. Consulta Compleja");
        System.out.println("8. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
Método que pide los datos para insertar un cliente
 */
    public void anhadirCliente(Cliente c) {
        int id = pideInt("Introduce el id del cliente: ");
        String nombre = pideString("Introduce el nombre: ");
        String email = pideString("Introduce el email: ");
        String telefono = pideString("Introduce los telefonos separados por espacios: ");
        String provincia = pideString("Introduce la provincia: ");
        int codigoPostal = pideInt("Introduce el codigo postal: ");
        String direccion = pideString("Introduce la direccion: ");
        String pais = pideString("Introduce el pais: ");
        String localidad = pideString("Introduce la localidad: ");
        c.setIdCliente(id);
        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(new ArrayList<String>(Arrays.asList(telefono.split(" "))));
        c.setProvincia(provincia);
        c.setCodigoPostal(codigoPostal);
        c.setDireccion(direccion);
        c.setPais(pais);
        c.setLocalidad(localidad);
    }

    /*
    * Metodo para modificar los datos de un cliente
     */
    public void modificarCliente(Cliente c) {
        String nombre = pideString("Introduce el nombre: ");
        String email = pideString("Introduce el email: ");
        String telefono = pideString("Introduce los telefonos separados por espacios: ");
        String provincia = pideString("Introduce la provincia: ");
        int codigoPostal = pideInt("Introduce el codigo postal: ");
        String direccion = pideString("Introduce la direccion: ");
        String pais = pideString("Introduce el pais: ");
        String localidad = pideString("Introduce la localidad: ");
        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(new ArrayList<String>(Arrays.asList(telefono.split(" "))));
        c.setProvincia(provincia);
        c.setCodigoPostal(codigoPostal);
        c.setDireccion(direccion);
        c.setPais(pais);
        c.setLocalidad(localidad);
    }

    /*
Método que pide y devuelve un id del cliente
 */
    public int seleccionarCliente() {
        int id = pideInt("Introduce el id del cliente: ");
        return id;
    }

    /*
        Método que muestra todos los clientes
    */
    public void viewClientes(List<Cliente> clientes) {
        System.out.println("------------------ \n");
        clientes.forEach(cliente ->{

            System.out.println("- Id: "+cliente.getIdCliente()+ "\n- Nombre: "+cliente.getNombre()+ "\n- Correo: "+
                    cliente.getEmail() + "\n- Telefono: "+cliente.getTelefono() + "\n- Direccion: "+cliente.getDireccion()
                    + "\n- Localidad: "+cliente.getLocalidad() + "\n- Codigo Postal: "+cliente.getCodigoPostal()
                    + "\n- Provincia: "+cliente.getProvincia() + "\n- Pais: "+cliente.getPais() + "\n- Vehiculos: "+cliente.getVehiculos()
                    +"\n");

        });
        System.out.println("------------------");
    }

    /*
    Metodo que muestra un cliente
     */
    public void viewCliente(Cliente cliente) {
        System.out.println("------------------ \n");
        System.out.println("- Nombre: "+cliente.getNombre()+ "\n- Correo: "+
                cliente.getEmail() + "\n- Telefono: "+cliente.getTelefono() + "\n- Direccion: "+cliente.getDireccion()
                + "\n- Localidad: "+cliente.getLocalidad() + "\n- Codigo Postal: "+cliente.getCodigoPostal()
                + "\n- Provincia: "+cliente.getProvincia() + "\n- Pais: "+cliente.getPais() + "\n- Vehiculos: "+cliente.getVehiculos()
                +"\n");
        System.out.println("------------------");

    }




}