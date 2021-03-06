package com.mimoni.isaigarciamoso.airbnb.controllers;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mimoni.isaigarciamoso.airbnb.R;
import com.mimoni.isaigarciamoso.airbnb.models.Departamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isaigarciamoso on 05/02/17.
 */

public class DepartamentoAdapter extends ArrayAdapter<Departamento> {
    ArrayList items;


    public DepartamentoAdapter(Context context, List<Departamento> departamentosList) {
        super(context, 0, departamentosList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listViewInflate = convertView;
        if (convertView == null) {
            listViewInflate = inflater.inflate(R.layout.item_depa, viewGroup, false);
        }
        ImageView imageDepa = (ImageView) listViewInflate.findViewById(R.id.imagenDepa);
        TextView tittleDepa = (TextView) listViewInflate.findViewById(R.id.descipcionDepa);
        TextView ubicacion = (TextView) listViewInflate.findViewById(R.id.ubicacionDepa);
        TextView price = (TextView) listViewInflate.findViewById(R.id.textView2);


        imageDepa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Departamento item = (Departamento) getItem(position);

        tittleDepa.setText(item.getDescripcion());
        ubicacion.setText(item.getDireccion());
        price.setText("$ " + item.getPrecio() + " M.N.");
        switch (item.getNamePhoto()) {
            case "depa1":
                imageDepa.setImageResource(R.drawable.depa1);
                break;
            case "depa2":
                imageDepa.setImageResource(R.drawable.depa2);
                break;
            case "depa3":
                imageDepa.setImageResource(R.drawable.depa3);
                break;
            case "depa4":
                imageDepa.setImageResource(R.drawable.depa4);
                break;
            case "depa5":
                imageDepa.setImageResource(R.drawable.depa5);
                break;
            case "depa6":
                imageDepa.setImageResource(R.drawable.depa6);
                break;
            case "depa7":
                imageDepa.setImageResource(R.drawable.depa7);
                break;
        }

        System.out.println("PRECIO::::::::::::::::::::: " + item.getPrecio());


        return listViewInflate;
    }

    public void addTodo(ArrayList arrayList) {
        items.addAll(arrayList);
        notifyDataSetChanged();
    }

}
