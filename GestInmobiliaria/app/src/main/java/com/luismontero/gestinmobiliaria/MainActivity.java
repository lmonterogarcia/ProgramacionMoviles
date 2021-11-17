package com.luismontero.gestinmobiliaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarData();
        mostarData();
    }

    private void cargarData() {
        //Inmobiliaria.lstArticulos.addAll(DB_SQLite.loadDBdata());


    }

    private void mostarData() {
        RecyclerView rvArticulos = findViewById(R.id.rvCasas);
        rvArticulos.setLayoutManager(new LinearLayoutManager(this));

        ArticulosAdapter adaptador = new ArticulosAdapter(this);
        rvArticulos.setAdapter(adaptador);

        adaptador.setOnClickListener(v -> {
            Store.casaSeleccionado = rvArticulos.getChildAdapterPosition(v);
            //Toast.makeText(this,"Item " + Store.casaSeleccionado, Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Articulos_detalle.class);
            startActivity(i);
        });
    }
}
}