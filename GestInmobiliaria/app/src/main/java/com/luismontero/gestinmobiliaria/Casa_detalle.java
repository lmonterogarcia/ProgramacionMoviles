package com.luismontero.gestinmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Casa_detalle extends AppCompatActivity {

    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtSuperficie;
    private TextView lblId;
    private Button btnBorrar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_detalle);

        txtCalle = findViewById(R.id.txtCalle);
        txtNumero = findViewById(R.id.txtNumero);
        txtSuperficie = findViewById(R.id.txtSuperficie);
        lblId = findViewById(R.id.lblId);
        btnBorrar = findViewById(R.id.btnBorrar);

        if (!Inmobiliaria.booInsertar){
            btnBorrar.setVisibility(View.VISIBLE);
            lblId.setVisibility(View.VISIBLE);
            lblId.setText(Integer.toString(Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getiIdCasa()));
            txtCalle.setText(Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getsCalle());
            txtNumero.setText(Integer.toString(Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getiNumero()));
            txtSuperficie.setText(Double.toString(Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getdSuperficie()));
        } else {
            btnBorrar.setVisibility(View.GONE);
            lblId.setVisibility(View.GONE);
        }

    }

    private void mostrarMensaje(String sMensaje){
        Toast.makeText(this, sMensaje, Toast.LENGTH_LONG).show();
    }

    public void guardar(View view){

        String sCalle = txtCalle.getText().toString();
        String sNumero = txtNumero.getText().toString();
        String sSuperficie = txtSuperficie.getText().toString();

        if(sCalle.equals("") || sNumero.equals("") || sSuperficie.equals("")){
            mostrarMensaje("Todos los campos son obligatorios");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            ContentValues content = new ContentValues();
            content.put("calle", sCalle);
            content.put("numero", sNumero);
            content.put("superficie", sSuperficie);

            if (!Inmobiliaria.booInsertar){
                // MODIFICAR
                String condicion = "Id_Casa LIKE " + Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getiIdCasa();
                conn.update("CASA", content, condicion, null);
                Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).setsCalle(sCalle);
                Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).setiNumero(Integer.parseInt(sNumero));
                Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).setdSuperficie(Double.parseDouble(sSuperficie));
                mostrarMensaje("La casa con dirección " + sCalle + ", " + sNumero + " ha sido modificado");
                } else {
                //INSERTAR
                conn.insert("CASA", null, content);
                Inmobiliaria.lstCasas.add(new Casa(Inmobiliaria.ultimoId + 1, sCalle, Integer.parseInt(sNumero), Double.parseDouble(sSuperficie)));
                Inmobiliaria.ultimoId++;
                mostrarMensaje("La casa con dirección " + sCalle + ", " + sNumero + " ha sido creada");
            }

            conn.close();
            onBackPressed();
        }
    }

    public void eliminarCasa(View views){

        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getWritableDatabase();

        String sql = "Id_Casa LIKE " + Inmobiliaria.lstCasas.get(Inmobiliaria.CasaSeleccionada).getiIdCasa();
        conn.delete("CASA", sql,null);
        Inmobiliaria.lstCasas.remove(Inmobiliaria.CasaSeleccionada);

        conn.close();

        mostrarMensaje("La casa ha sido borrada");

        onBackPressed();



    }
}