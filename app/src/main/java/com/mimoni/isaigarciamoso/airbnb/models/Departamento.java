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
    private String fotografias[];
    private String servicios[];
    private double latitud;
    private double longitud;


    public Departamento(){

    }

    public Departamento(int id, String direccion, int precio, String descripcion, int votos, String[] fotografias, String[] servicios, double latitud, double longitud) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.votos = votos;
        this.fotografias = fotografias;
        this.servicios = servicios;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String[] getFotografias() {
        return fotografias;
    }

    public void setFotografias(String[] fotografias) {
        this.fotografias = fotografias;
    }

    public String[] getServicios() {
        return servicios;
    }

    public void setServicios(String[] servicios) {
        this.servicios = servicios;
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


}
