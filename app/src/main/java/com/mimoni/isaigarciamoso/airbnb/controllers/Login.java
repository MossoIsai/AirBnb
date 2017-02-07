package com.mimoni.isaigarciamoso.airbnb.controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mimoni.isaigarciamoso.airbnb.R;
import com.mimoni.isaigarciamoso.airbnb.delegates.DBHelper;
import com.mimoni.isaigarciamoso.airbnb.delegates.QuerysDB;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class Login extends AppCompatActivity {

    private Button btnAccess;
    private Button crearCuenta;
    private EditText phoneUser;
    private EditText passwordUser;
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private QuerysDB querysDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Cargando vistas
        initView();
        //Se crea la base de datos
        dbHelper = new DBHelper(this);
        querysDB = new QuerysDB();
        Log.d("ok", "TODO OK");


        database = dbHelper.getWritableDatabase();
        //Insertando el base de datos usario de prueba
        database.execSQL(querysDB.insertarUsuario());
        database.execSQL(querysDB.insertarDepartamento());
        Log.d("ok","INSERTO EN DEPARTAMENTO");


    }

    private void initView() {
        btnAccess = (Button) findViewById(R.id.btnEnter);
        phoneUser = (EditText) findViewById(R.id.textPhone);
        passwordUser = (EditText) findViewById(R.id.textPassword);

        btnAccess.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnEnter:
                    String telefono = phoneUser.getText().toString();
                    String contrasena = passwordUser.getText().toString();
                    database = dbHelper.getReadableDatabase();

                    if (telefono.equals("") && contrasena.equals("")) {
                        messageDialog("Llena los campo faltantes", "Es necesario llenar los campos para poder acceder", "Aceptar");
                    } else if (telefono.equals("")) {
                        messageDialog("Llena el campo télefono", "Es necesario llenar el campo de télefono", "Aceptar");
                    } else if (contrasena.equals("")) {
                        messageDialog("Llena el campo de contraseña", "Es necesario llenar el campo contraseña", "Aceptar");
                    } else {

                        if (database != null) {
                            System.out.print(querysDB.consultarLogin(telefono,contrasena));
                            Toast.makeText(getApplicationContext(),querysDB.consultarLogin(telefono,contrasena),Toast.LENGTH_LONG).show();
                            Cursor cursor = database.rawQuery(querysDB.consultarLogin(telefono, contrasena), null);
                            int filas = cursor.getCount();
                            if (filas > 0) {
                                // si el usuario existe
                                Intent intent = new Intent(getApplicationContext(), Principal.class);
                                startActivity(intent);
                            } else {
                                messageDialog("Usuario y/o contraseña incorrecta", "El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros " +
                                        "por favor, revisa e inténtalo de nuevo", "Aceptar");
                            }
                        }
                    }
                    dbHelper.close();
                    //fin del primer case
                        break;
                case R.id.btnCrearCuenta:


                    break;
            }
        }
    };
    //messageDialog
    public void messageDialog(String titulo, String mensaje, String btnNombre) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton(btnNombre, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }



}
