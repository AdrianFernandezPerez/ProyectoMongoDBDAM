package main.java.view;

import main.java.model.entity.Reparacion;
import main.java.model.entity.TipoVehiculo;
import main.java.model.entity.Vehiculo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReparacionView extends View{

    /*
     * Metodo que muestra las opciones del menu de reparaciones
     */
    public int mostrarMenuReparaciones(){
        System.out.println("");
        System.out.println("--Menu de Reparaciones--");
        System.out.println("");
        System.out.println("1. Anhadir reparacion");
        System.out.println("2. Modificar reparacion");
        System.out.println("3. Buscar reparacion");
        System.out.println("4. Mostrar reparaciones");
        System.out.println("5. Anhadir Mecanico");
        System.out.println("6. Finalizar reparacion");
        System.out.println("7. Borrar reparacion");
        System.out.println("8. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
    * Metodo que devuelve el id de una reparacion
     */
    public int seleccionarReparacion() {
        int id = pideInt("Introduce el id de la reparacion: ");
        return id;
    }

    /*
    Método que pide los datos para insertar una reparacion
    */
    public void anhadirReparacion(Reparacion reparacion) {
        int id = pideInt("Introduce el id de la reparacion: ");
        String descripcion = pideString("Introduce la descripcion: ");
        LocalDate fechaInicio = LocalDate.now();
        reparacion.setIdReparacion(id);
        reparacion.setDescripcion(descripcion);
        reparacion.setFechaInicio(fechaInicio);
        reparacion.setFechaFin(null);
    }

    /*
Método que muestra todos las reparaciones
*/
    public void viewReparaciones(List<Reparacion> reparaciones) {
        System.out.println("------------------ \n");
        reparaciones.forEach(reparacion ->{

            System.out.println("- Id: "+reparacion.getIdReparacion()+ "\n- Descripcion: "+reparacion.getDescripcion()
                    + "\n- Fecha Inicio: "+reparacion.getFechaInicio()+"\n- Fecha Fin: "+ reparacion.getFechaFin() +
                    "\n- Lista Mecanicos: "+reparacion.getlMecanicos()+"\n");

        });
        System.out.println("------------------");
    }

    /*
    Metodo que muestra los datos de un reparacion
     */
    public void viewReparacion(Reparacion reparacion) {
        System.out.println("------------------ \n");
        System.out.println("- Id: "+reparacion.getIdReparacion()+ "\n- Descripcion: "+reparacion.getDescripcion()
                + "\n- Fecha Inicio: "+reparacion.getFechaInicio()+"\n- Fecha Fin: "+ reparacion.getFechaFin() +
                "\n- Lista Mecanicos: "+reparacion.getlMecanicos()+"\n");
        System.out.println("------------------");

    }

    /*
   * Metodo que actualiza los datos de una reparacion
     */
    public void actualizarReparacion(Reparacion r) {
        String descripcion = pideString("Introduce la descripcion: ");
        r.setDescripcion(descripcion);
    }
}
