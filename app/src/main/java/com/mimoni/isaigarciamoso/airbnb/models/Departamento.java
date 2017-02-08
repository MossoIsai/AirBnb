package com.mimoni.isaigarciamoso.airbnb.models;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class Departamento {

    private int id;
    private String direccion;
    private int precio;
    private String descripcion;
    private int votos;
    private double latitud;
    private double longitud;
    private String namePhoto;


    public Departamento(){

    }
    /*public Departamento(int id, String direccion, int precio, String descripcion, int votos, double latitud, double longitud) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.votos = votos;
        this.latitud = latitud;
        this.longitud = longitud;
    }*/

    public Departamento(int id, String direccion, int precio, String descripcion, int votos, double latitud, double longitud, String namePhoto) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.votos = votos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.namePhoto = namePhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }
}
