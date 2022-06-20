package main.java.model.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Reparacion {

    private int _id;
    private List<Mecanico> lMecanicos;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public void setIdReparacion(int idReparacion) {
        this._id = idReparacion;
    }

    public List<Mecanico> getlMecanicos() {
        return lMecanicos;
    }


    public List<Mecanico> getMecanicos() {
        return lMecanicos;
    }

    public void setlMecanicos(List<Mecanico> lMecanicos) {
        this.lMecanicos = lMecanicos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdReparacion() {
        return _id;
    }

    public Reparacion(String descripcion, LocalDate fechaInicio) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        lMecanicos= new ArrayList<Mecanico>();
    }

    public Reparacion() {
        lMecanicos= new ArrayList<Mecanico>();
    }

    @Override
    public String toString() {
        return "Reparacion{" + "idReparacion=" + _id + ", lMecanicos=" + lMecanicos + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }


}




