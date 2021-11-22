package com.example.semanasanta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class FrmHuelva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        Spinner lstHermandades = findViewById(R.id.lstHermandades);
        TextView txtNombreHermandad = findViewById(R.id.txtNombreHermandad);
        TextView txtAnioFundacion = findViewById(R.id.txtAnioFundacion);
        TextView txtDiaProcesional = findViewById(R.id.txtDiaProcesional);
        ImageView ivNazareno = findViewById(R.id.ivNazareno);

        String[] aNombreHermandad = res.getStringArray(R.array.nombreHermandad);
        int[] aAnioFundacion = res.getIntArray(R.array.anioFundacion);
        String[] aDiaProcesional = res.getStringArray(R.array.díaProcesional);
        TypedArray icons = res.obtainTypedArray(R.array.icons);

        lstHermandades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                txtNombreHermandad.setText(aNombreHermandad[position]);
                String sAnio = "" + aAnioFundacion[position];
                txtAnioFundacion.setText(sAnio);
                txtDiaProcesional.setText(aDiaProcesional[position]);
                ivNazareno.setImageResource(icons.getResourceId(position,0));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}