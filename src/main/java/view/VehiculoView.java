package main.java.view;

import main.java.model.entity.Cliente;
import main.java.model.entity.TipoVehiculo;
import main.java.model.entity.Vehiculo;

import java.util.List;

public class VehiculoView extends View{

    /*
     * Metodo que muestra las opciones del menu de vehiculos
     */
    public int muestraMenuVehiculos(){
        System.out.println("");
        System.out.println("--Menu de Vehiculos--");
        System.out.println("");
        System.out.println("1. Anhadir Vehiculo");
        System.out.println("2. Modificar Vehiculo");
        System.out.println("3. Buscar Vehiculo");
        System.out.println("4. Mostrar Vehiculos");
        System.out.println("5. Anhadir Reparacion");
        System.out.println("6. Borrar Vehiculo");
        System.out.println("7. Consulta Compleja");
        System.out.println("8. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
Método que pide y devuelve un id del vehiculo
*/
    public int seleccionarVehiculo() {
        int id = pideInt("Introduce el id del vehiculo: ");
        return id;
    }

    /*
    Método que muestra todos los vehiculos
*/
    public void viewVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("------------------ \n");
        vehiculos.forEach(vehiculo ->{

            System.out.println("- Id: "+vehiculo.getIdVehiculo()+ "\n- Matricula: "+vehiculo.getMatricula()
                    + "\n- Marca: "+vehiculo.getMarca()+"\n- Modelo: "+ vehiculo.getModelo() + "\n- Carroceria: "
                    +vehiculo.getCarroceria() + "\n- Cilindrada: "+vehiculo.getCc()+  "\n- TipoDeVehiculo: "+vehiculo.getTipoVehiculo()+
                    "\n- Reparaciones: "+vehiculo.getReparaciones()+"\n");

        });
        System.out.println("------------------");
    }

    /*
    Metodo que muestra los datos de un vehiculo
     */
    public void viewVehiculo(Vehiculo vehiculo) {
        System.out.println("------------------ \n");
        System.out.println("- Id: "+vehiculo.getIdVehiculo()+ "\n- Matricula: "+vehiculo.getMatricula()
                + "\n- Marca: "+vehiculo.getMarca()+"\n- Modelo: "+ vehiculo.getModelo() + "\n- Carroceria: "
                +vehiculo.getCarroceria() + "\n- Cilindrada: "+vehiculo.getCc()+  "\n- TipoDeVehiculo: "+vehiculo.getTipoVehiculo()+
                "\n- Reparaciones: "+vehiculo.getReparaciones()+"\n");
        System.out.println("------------------");

    }

    /*
    Método que pide los datos para insertar un vehiculo
     */
    public void anhadirVehiculo(Vehiculo v) {
        int _id = pideInt("Introduce el id del vehiculo: ");
        String marca = pideString("Introduce la marca: ");
        String modelo = pideString("Introduce el modelo: ");
        String carroceria = pideString("Introduce la carroceria: ");
        int cc = pideInt("Introduce la cilindrada: ");
        String matricula = pideString("Introduce la matricula: ");
        TipoVehiculo tipoVehiculo = tipoVehiculo("Introduce el tipo de vehiculo 'Coche-Moto-Tractor': ");
        v.setIdVehiculo(_id);
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setCarroceria(carroceria);
        v.setCc(cc);
        v.setMatricula(matricula);
        v.setTipoVehiculo(tipoVehiculo);
    }

    /*
    Método que pide los datos para modificar un vehiculo
     */
    public void actualizarVehiculo(Vehiculo v) {
        String marca = pideString("Introduce la marca: ");
        String modelo = pideString("Introduce el modelo: ");
        String carroceria = pideString("Introduce la carroceria: ");
        int cc = pideInt("Introduce la cilindrada: ");
        String matricula = pideString("Introduce la matricula: ");
        TipoVehiculo tipoVehiculo = tipoVehiculo("Introduce el tipo de vehiculo 'Coche-Moto-Tractor': ");
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setCarroceria(carroceria);
        v.setCc(cc);
        v.setMatricula(matricula);
        v.setTipoVehiculo(tipoVehiculo);
    }

}
