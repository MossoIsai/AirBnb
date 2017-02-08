package com.mimoni.isaigarciamoso.airbnb.controllers;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/**
 * Created by isaigarciamoso on 05/02/17.
 */

public class ParseJson {

    private static JSONObject jsonObject = null;
    private static String json = "";

    public JSONObject parseJSON(InputStream flujoEntrada) {

        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(flujoEntrada, "UTF_8"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String linea = "";
            //mientras sigan existiendo lineas en el archivo condicion
            while ((linea = lector.readLine()) != null) {
                stringBuilder.append(linea);
            }
            flujoEntrada.close();
            json = stringBuilder.toString();
            jsonObject = new JSONObject(json);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error al parser el Json");
        } catch (IOException e) {
            System.err.println("Error al al leer los datos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON:::::::::::::",jsonObject+"");
        return jsonObject;
    }
    public ParseJson() {

    }
}
