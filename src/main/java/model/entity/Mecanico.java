package main.java.model.entity;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mecanico {

    private int idMecanico;
    private String nombre;
    private String apellido;
    private int telefono;


    private List<Reparacion> reparaciones;


    public Mecanico() {
        reparaciones = new ArrayList<Reparacion>();
    }

    public Mecanico(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        reparaciones = new ArrayList<Reparacion>();
    }

    /*
    Añadir reparaciones
    */
    public void setReparaciones(Reparacion r){
        reparaciones.add(r);
    }

    /*
    Metodo que elimina una reparacion del mecanico
    */
    public void deleteReparacion(Reparacion r){
        //Creo un iterador para recorrer la lista de reparaciones
        Iterator<Reparacion> iter = reparaciones.iterator();
        //Mientras encuentre reparaciones
        while(iter.hasNext()){
            //Guardo el id de la reparación que iteró
            int id = iter.next().getIdReparacion();
            //Si el id es igual al id de la reparación que se quiere eliminar
            if(id == r.getIdReparacion()){
                //Elimino la reparación
                iter.remove();
            }
        }
    }

    public List<Reparacion> getReparaciones(){
        return reparaciones;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Mecanico{" + "idMecanico=" + idMecanico + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + '}';
    }

}
