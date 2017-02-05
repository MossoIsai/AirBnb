package com.mimoni.isaigarciamoso.airbnb.controllers;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mimoni.isaigarciamoso.airbnb.R;
import com.mimoni.isaigarciamoso.airbnb.delegates.DBHelper;
import com.mimoni.isaigarciamoso.airbnb.delegates.QuerysDB;

/**
 * Created by isaigarciamoso on 04/02/17.
 */

public class Login extends AppCompatActivity {

    private Button btnAccess;
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

                    database = dbHelper.getReadableDatabase();
                    if (database != null) {
                        Cursor cursor = database.rawQuery(querysDB.consultarLogin("", ""), null);
                        int filas = cursor.getCount();
                        if (filas > 0) {

                        } else {
                            messageDialog("Usuario y/o contraseña incorrecta","El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros " +
                                    "por favor, revisa e inténtalo de nuevo","Aceptar");
                        }
                    }
                    break;
            }

        }
    };

    public void messageDialog(String titulo, String mensaje,String btnNombre) {
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


    public boolean validarLogin(String telefono, String contrasena) {
        if (telefono.equals("") && contrasena.equals("")) {
            return false;
        } else if (telefono.equals("")) {
            return false;
        } else if (contrasena.equals("")) {

        } else {
            return true;
        }
        return true;
    }
}
