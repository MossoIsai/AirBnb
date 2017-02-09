package com.mimoni.isaigarciamoso.airbnb.controllers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mimoni.isaigarciamoso.airbnb.R;
import com.mimoni.isaigarciamoso.airbnb.delegates.DBHelper;
import com.mimoni.isaigarciamoso.airbnb.delegates.QuerysDB;
import com.mimoni.isaigarciamoso.airbnb.models.Departamento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Principal extends AppCompatActivity {
    private ListView listaDepartamentos;
    private List<Departamento> departamentoList;
    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    private Departamento departamento;
    private DepartamentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        initView();

    }

    public void initView() {
        listaDepartamentos = (ListView) findViewById(R.id.listaDepa);
        helper = new DBHelper(this);
        departamentoList = new ArrayList<Departamento>();
        leerJson();


        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(QuerysDB.buscaDepartamentos(), null);
        //Llenando el Bean
        while (cursor.moveToNext()) {
            departamento = new Departamento(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                    cursor.getString(3), cursor.getInt(4), cursor.getDouble(5), cursor.getDouble(6), cursor.getString(7));

            departamentoList.add(departamento);
        }
        cursor.close();
        Toast.makeText(getApplicationContext(), "tamaño de la lista:" + departamentoList.size(), Toast.LENGTH_LONG).show();
        adapter = new DepartamentoAdapter(this, departamentoList);
        listaDepartamentos.setAdapter(adapter);
        listaDepartamentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("POSICION..-------" + i);
                System.out.println("LISTA  OBJETO" + departamentoList.get(i).getPrecio());
                 int idDepartamento = departamentoList.get(i).getId();
                Intent intent = new Intent(getApplicationContext(), DetalleDepartamento.class);
                intent.putExtra("ID",idDepartamento);
                startActivity(intent);

            }
        });
    }

    //Simulo una conexión al servidor donde obtengo un JSON
    public void leerJson() {
        String tagObject = "Departamento";
        String tagId = "id";
        String tagDireccion = "direccion";
        String tagPrecio = "precio";
        String tagDescripcion = "descripcion";
        String tagVotos = "votos";
        String tagLatitud = "latitud";
        String tagLongitud = "longitud";
        String tagFotografia = "fotoPrincipal";

        ParseJson parseJson = new ParseJson();
        JSONObject objetoJSON = parseJson.parseJSON(getResources().openRawResource(R.raw.json));
        try {
            db = helper.getWritableDatabase();
            JSONArray jsonArray = objetoJSON.getJSONArray(tagObject);
            for (int i = 0; i < jsonArray.length(); i++) {

                //obtengo el objeto en la poscion i
                JSONObject jsonObjectDepto = jsonArray.getJSONObject(i);
                db.execSQL(QuerysDB.insertaDepartamento(
                        jsonObjectDepto.getInt(tagId),
                        jsonObjectDepto.getString(tagDireccion),
                        jsonObjectDepto.getInt(tagPrecio),
                        jsonObjectDepto.getString(tagDescripcion),
                        jsonObjectDepto.getInt(tagVotos),
                        jsonObjectDepto.getDouble(tagLatitud),
                        jsonObjectDepto.getDouble(tagLongitud),
                        jsonObjectDepto.getString(tagFotografia)

                ));

                System.out.println("INSERTANDO::::::::::::::::::::::\n"+QuerysDB.insertaDepartamento(
                        jsonObjectDepto.getInt(tagId),
                        jsonObjectDepto.getString(tagDireccion),
                        jsonObjectDepto.getInt(tagPrecio),
                        jsonObjectDepto.getString(tagDescripcion),
                        jsonObjectDepto.getInt(tagVotos),
                        jsonObjectDepto.getDouble(tagLatitud),
                        jsonObjectDepto.getDouble(tagLongitud),
                        jsonObjectDepto.getString(tagFotografia)

                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
