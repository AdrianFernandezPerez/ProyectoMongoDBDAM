package main.java.model.entity;

import java.util.ArrayList;

public class Cliente {

    private int _id;
    private String nombre;
    private ArrayList<String> telefono;
    private String email;
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String provincia;
    private String pais;
    private ArrayList <Integer> vehiculos;

    public Cliente() {
    }

    public Cliente(String nombre, ArrayList<String> telefono, String email, String direccion, String localidad, int codigoPostal, String provincia, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
    }

    public int getIdCliente() {
        return _id;
    }

    public void setIdCliente(int idCliente) {
        this._id = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<String> telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Integer> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Integer> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {

        return "Cliente{" +
                "idCliente=" + _id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
