package com.luismontero.gestiondearticulos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Articulos_detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos_detalle);

        TextView lblDetallId = findViewById(R.id.lblDetalleId);
        TextView lblDetalleNombre = findViewById(R.id.lblDetalleNombre);
        TextView lblDetallePrecio = findViewById(R.id.lblDetallePrecio);
        TextView lblDetalleStock = findViewById(R.id.lblDetalleStock);

        lblDetallId.setText(Integer.toString(Store.articuloSeleccionado));
        lblDetalleNombre.setText(Store.lstArticulos.get(Store.articuloSeleccionado).getsNombre());
        lblDetallePrecio.setText(Store.lstArticulos.get(Store.articuloSeleccionado).getdPrecio() + " €");
        lblDetalleStock.setText(Store.lstArticulos.get(Store.articuloSeleccionado).getiStock() + " Und.");
    }
}