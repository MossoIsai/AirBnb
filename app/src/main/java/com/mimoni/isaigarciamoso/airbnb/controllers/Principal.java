package com.mimoni.isaigarciamoso.airbnb.controllers;

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

import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Principal extends AppCompatActivity  {
    private ListView listaDepartamentos;
    //private List<Departamento> departamentoList;
    private List<Departamento> departamentoList;
    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    private Departamento  departamento;
    private DepartamentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ParseJson parseJson = new ParseJson();
        JSONObject objetoJSON = parseJson.parseJSON(getResources().openRawResource(R.raw.json));
        initView();

        /*** :::::::::::::::::::: OPCION DEL LEER ::::::::::::::::::: ***/
       /** Gson gson = new GsonBuilder().create();
        java.lang.reflect.Type listType =  new TypeToken<ArrayList<Departamento>>(){}.getType();
        departamentoList = gson.fromJson(objetoJSON.toString(), listType);**/

        System.out.print("tamaño: ---------------"+departamentoList.size());
        /**BufferedReader  lector = new BufferedReader(
         *  new InputStreamReader(getResources().openRawResource(R.raw.json)));
        String word = null;
        StringBuilder builder = new StringBuilder();
        try {
            while((word = lector.readLine()) != null){
                 builder.append(word);
            }
            x = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("OK",x);
        System.out.println(word);**/
    }
    public void initView(){
        listaDepartamentos =  (ListView)findViewById(R.id.listaDepa);
        helper = new DBHelper(this);
        departamentoList = new ArrayList<Departamento>();
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(QuerysDB.buscaDepartamentos(),null);
        //Llenando el Bean
        while (cursor.moveToNext()){
            departamento = new Departamento(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),
                    cursor.getString(3),cursor.getInt(4),cursor.getDouble(5),cursor.getDouble(6));

            departamentoList.add(departamento);
        }
        cursor.close();
        Toast.makeText(getApplicationContext(),"tamaño de la lista:"+departamentoList.size(),Toast.LENGTH_LONG).show();
        adapter = new DepartamentoAdapter(this,departamentoList);
        listaDepartamentos.setAdapter(adapter);
        listaDepartamentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("POSICION..-------"+i);
                System.out.println("LISTA  OBJETO"+ departamentoList.get(i).getPrecio());
            }
        });
    }


}
