package com.mimoni.isaigarciamoso.airbnb.delegates;

import android.util.Log;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class QuerysDB {

    private static final  String INTEGER = "INTEGER";
    private static final String TEXT = "TEXT";
    private static final String consoleLog = "CONSOLA";

    //Tablas
    private static final String TABLE_USUARIO = "USUARIO";
    private static final String TABLE_DEPARTAMENTO = "DEPARTAMENTO";

    //TABLA USUARIO
    public class Usuario{
        private static final String ID_USER = "id";
        private static final String NOMBRE_USER = "nombre";
        private static final String APELLIDO_USER = "apellido";
        private static final String TELEFONO_USER = "telefono";
        private static final String CORREO_USER = "correo";
        private static final String EDAD_USER = "edad";
        private static final String CONTRASENA_USER = "contrasena";

    }
    //tabla DEPARTAMENTO
    public static class Departamento{
        private static final String ID_DEPTO = "id";
        private static final String DIRECCION_DEPTO = "direccion";
        private static final String PRECIO_DEPTO = "precio";
        private static final String DESCRIPCION_DEPTO = "descripcion";
        private static final String VOTOS_DEPTO = "votos";
    }

    public String createTableUsuario(){

        Log.d(consoleLog,"CREATE TABLE "+TABLE_USUARIO+" ( "+
                Usuario.ID_USER+" "+INTEGER+" PRIMARY KEY AUTOINCREMENT"+" ,"+
                Usuario.NOMBRE_USER+" "+TEXT+", "+
                Usuario.APELLIDO_USER+" "+TEXT+" ,"+
                Usuario.TELEFONO_USER+" "+TEXT+" ,"+
                Usuario.CORREO_USER+" "+TEXT+" ,"+
                Usuario.EDAD_USER+" "+INTEGER+","+
                Usuario.CONTRASENA_USER+" "+TEXT+")");


         return "CREATE TABLE "+TABLE_USUARIO+" ( "+
                Usuario.ID_USER+" "+INTEGER+" PRIMARY KEY AUTOINCREMENT"+" ,"+
                Usuario.NOMBRE_USER+" "+TEXT+", "+
                Usuario.APELLIDO_USER+" "+TEXT+" ,"+
                Usuario.TELEFONO_USER+" "+TEXT+" ,"+
                Usuario.CORREO_USER+" "+TEXT+" ,"+
                Usuario.EDAD_USER+" "+INTEGER+","+
                Usuario.CONTRASENA_USER+" "+TEXT+")";

    }
    public String createTableDepartamento(){

        Log.d(consoleLog,"CREATE TABLE "+TABLE_DEPARTAMENTO+" ( "+
                Departamento.ID_DEPTO+" "+INTEGER+" ,"+
                Departamento.DIRECCION_DEPTO+" "+TEXT+" ,"+
                Departamento.PRECIO_DEPTO+" "+TEXT+" ,"+
                Departamento.DESCRIPCION_DEPTO+" "+TEXT+" ,"+
                Departamento.VOTOS_DEPTO+" "+INTEGER+" )");

        return "CREATE TABLE "+TABLE_DEPARTAMENTO+" ( "+
                Departamento.ID_DEPTO+" "+INTEGER+" ,"+
                Departamento.DIRECCION_DEPTO+" "+TEXT+" ,"+
                Departamento.PRECIO_DEPTO+" "+TEXT+" ,"+
                Departamento.DESCRIPCION_DEPTO+" "+TEXT+" ,"+
                Departamento.VOTOS_DEPTO+" "+INTEGER+" )";
    }
    public String consultarLogin(String phone,String password){

      return  "SELECT * FROM "+TABLE_USUARIO+" WHERE "+Usuario.TELEFONO_USER+"  = '"+phone+"' AND "+
              Usuario.CONTRASENA_USER+" = '"+password+" ' ";
    }

}
