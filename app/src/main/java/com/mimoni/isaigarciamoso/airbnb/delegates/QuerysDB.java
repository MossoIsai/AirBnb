package com.mimoni.isaigarciamoso.airbnb.delegates;

import android.util.Log;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class QuerysDB {

    private static final String INTEGER = "INTEGER";
    private static final String TEXT = "TEXT";
    private static final String REAL = "REAL";
    private static final String consoleLog = "CONSOLA";

    //Tablas
    private static final String TABLE_USUARIO = "USUARIO";
    private static final String TABLE_DEPARTAMENTO = "DEPARTAMENTO";

    //TABLA USUARIO
    public class Usuario {
        private static final String ID_USER = "id";
        private static final String NOMBRE_USER = "nombre";
        private static final String APELLIDO_USER = "apellido";
        private static final String TELEFONO_USER = "telefono";
        private static final String CORREO_USER = "correo";
        private static final String EDAD_USER = "edad";
        private static final String CONTRASENA_USER = "contrasena";

    }

    //tabla DEPARTAMENTO
    public static class Departamento {
        private static final String ID_DEPTO = "id";
        private static final String DIRECCION_DEPTO = "direccion";
        private static final String PRECIO_DEPTO = "precio";
        private static final String DESCRIPCION_DEPTO = "descripcion";
        private static final String VOTOS_DEPTO = "votos";
        private static final String LATITUD_DEPTO = "latitud";
        private static final String LONGITUD_DEPTO = "longitud";
        private static final String FOTO_DEPTO = "fotoPrincipal";

    }

    public String createTableUsuario() {

        Log.d(consoleLog, "CREATE TABLE " + TABLE_USUARIO + " ( " +
                Usuario.ID_USER + " " + INTEGER + " PRIMARY KEY AUTOINCREMENT" + " ," +
                Usuario.NOMBRE_USER + " " + TEXT + ", " +
                Usuario.APELLIDO_USER + " " + TEXT + " ," +
                Usuario.TELEFONO_USER + " " + TEXT + " ," +
                Usuario.CORREO_USER + " " + TEXT + " ," +
                Usuario.EDAD_USER + " " + INTEGER + "," +
                Usuario.CONTRASENA_USER + " " + TEXT + ")");


        return "CREATE TABLE " + TABLE_USUARIO + " ( " +
                Usuario.ID_USER + " " + INTEGER + " PRIMARY KEY AUTOINCREMENT" + " ," +
                Usuario.NOMBRE_USER + " " + TEXT + ", " +
                Usuario.APELLIDO_USER + " " + TEXT + " ," +
                Usuario.TELEFONO_USER + " " + TEXT + " ," +
                Usuario.CORREO_USER + " " + TEXT + " ," +
                Usuario.EDAD_USER + " " + INTEGER + "," +
                Usuario.CONTRASENA_USER + " " + TEXT + ")";

    }

    public String createTableDepartamento() {

        Log.d(consoleLog, "CREATE TABLE " + TABLE_DEPARTAMENTO + " ( " +
                Departamento.ID_DEPTO + " " + INTEGER + " ," +
                Departamento.DIRECCION_DEPTO + " " + TEXT + " ," +
                Departamento.PRECIO_DEPTO + " " + TEXT + " ," +
                Departamento.DESCRIPCION_DEPTO + " " + TEXT + " ," +
                Departamento.VOTOS_DEPTO + " " + INTEGER + "," +
                Departamento.LATITUD_DEPTO + " " + REAL + " , " +
                Departamento.LONGITUD_DEPTO + " " + REAL + " )");

        return "CREATE TABLE " + TABLE_DEPARTAMENTO + " ( " +
                Departamento.ID_DEPTO + " " + INTEGER + " ," +
                Departamento.DIRECCION_DEPTO + " " + TEXT + " ," +
                Departamento.PRECIO_DEPTO + " " + TEXT + " ," +
                Departamento.DESCRIPCION_DEPTO + " " + TEXT + " ," +
                Departamento.VOTOS_DEPTO + " " + INTEGER + "," +
                Departamento.LATITUD_DEPTO + " " + REAL + " , " +
                Departamento.LONGITUD_DEPTO + " " + REAL +" , " +
                Departamento.FOTO_DEPTO+" "+ TEXT+" "+
                " )";
    }

    public String consultarLogin(String phone, String password) {

        return
                "SELECT * FROM " + TABLE_USUARIO + "  WHERE " + Usuario.TELEFONO_USER + " = '" + phone + "' AND " +
                        Usuario.CONTRASENA_USER + " = '" + password + "'";
        //return "SELECT * FROM USUARIO WHERE telefono = '5574260143' AND  contrasena = '2468'";
    }

    //Prueba
    public String insertarUsuario() {
        Log.d(consoleLog, "INSERT INTO " + TABLE_USUARIO + " (" + Usuario.NOMBRE_USER + " , " + Usuario.APELLIDO_USER + " , " +
                Usuario.TELEFONO_USER + " , " + Usuario.CORREO_USER + " ," + Usuario.CONTRASENA_USER + " ," + Usuario.EDAD_USER + " )" +
                " VALUES('ISAI','MOSO','5574260143','isaimosso@gmail.com','2468',25)");

        return "INSERT INTO " + TABLE_USUARIO + " (" + Usuario.NOMBRE_USER + " , " + Usuario.APELLIDO_USER + " , " +
                Usuario.TELEFONO_USER + " , " + Usuario.CORREO_USER + " ," + Usuario.CONTRASENA_USER + " ," + Usuario.EDAD_USER + " )" +
                " VALUES('ISAI','MOSO','5574260143','isaimosso@gmail.com','2468',25)";
    }

    //Prueba
    public String insertarDepartamento() {
        return "INSERT INTO DEPARTAMENTO(id,direccion,precio,descripcion,votos,latitud,longitud) " +
                "VALUES(1,'Vista Hermosa, Cuernavaca, Morelos',789,'Hermosa departamento para 1 Persona',67,18.9343080,-99.2070589)";
    }

    public static String insertaDepartamento(int id, String direccion, int precio, String descripcion, int votos, double latitud,
                                             double longitud,String namePhoto) {

        return "INSERT INTO DEPARTAMENTO (id,direccion,precio,descripcion,votos,latitud,longitud,fotoPrincipal) " +
                "VALUES (" + id + "," +
                   " '" + direccion + "', " + precio + ", " +
                   " '" + descripcion + "'," + votos + ", " +
                    "" + latitud + ", " + longitud +",'"+namePhoto+"'"+
                " )";

    }

    public static String buscaDepartamentos() {
        return "SELECT * FROM DEPARTAMENTO";
    }

}
