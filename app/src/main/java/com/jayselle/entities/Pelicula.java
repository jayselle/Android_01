package com.jayselle.entities;

public class Pelicula {

    private Integer id;
    private String nombre;
    private Integer año;

    public Pelicula(){

    }

    public Pelicula(Integer id, String nombre, Integer año) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", año='" + año + '\'' +
                '}';
    }
}
