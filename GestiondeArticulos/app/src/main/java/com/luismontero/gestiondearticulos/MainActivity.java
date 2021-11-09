package com.luismontero.gestiondearticulos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        Store.lstArticulos.add(new Articulos("Tornillos0", 26.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos1", 34d, 200));
        Store.lstArticulos.add(new Articulos("Tornillos2", 24.3, 234));
        Store.lstArticulos.add(new Articulos("Tornillos3", 45.3, 754));
        Store.lstArticulos.add(new Articulos("Tornillos4", 264.3, 753));
        Store.lstArticulos.add(new Articulos("Tornillos5", 76.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos6", 21.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos7", 89.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos8", 65.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos9", 11.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos10", 96.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos11", 299.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos12", 48.3, 100));
        Store.lstArticulos.add(new Articulos("Tornillos113", 23.3, 100));
        
        
    }

    private void mostarData() {
        RecyclerView rvArticulos = findViewById(R.id.rvArticulos);
        rvArticulos.setLayoutManager(new LinearLayoutManager(this));
        
        ArticulosAdapter adaptador = new ArticulosAdapter(this);
        rvArticulos.setAdapter(adaptador);

      //  adaptador.setOnClickListener( v->{

      //  });
    }
}