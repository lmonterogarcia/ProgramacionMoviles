package com.luismontero.listadetareas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tarea_detalle extends AppCompatActivity {

    private TextView lblId;
    private EditText txtTareaTitulo;
    private EditText txtFecha;
    private EditText txtHora;
    private Spinner spCategoria;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_detalle);

        lblId = findViewById(R.id.lblId);
        txtTareaTitulo = findViewById(R.id.txtTitulo);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);
        spCategoria = findViewById(R.id.spCategoria);

        if (!Store.booInsertar){
            lblId.setVisibility(View.VISIBLE);
            lblId.setText(Integer.toString(Store.lstTareas.get(Store.tareaSeleccionada).getiIdTarea()));
            txtTareaTitulo.setText(Store.lstTareas.get(Store.tareaSeleccionada).getsTitulo());
            txtFecha.setText(Store.lstTareas.get(Store.tareaSeleccionada).getsFecha());
            txtHora.setText(Store.lstTareas.get(Store.tareaSeleccionada).getsHora());
            spCategoria.setSelection(Store.lstTareas.get(Store.tareaSeleccionada).getiCategoria());
        } else {
            lblId.setVisibility(View.GONE);
        }

    }

    private void mostrarMensaje(String sMensaje){
        Toast.makeText(this, sMensaje, Toast.LENGTH_LONG).show();
    }

    public void guardar(View view){

        String sTitulo = txtTareaTitulo.getText().toString();
        String sFecha = txtFecha.getText().toString();
        String sHora = txtHora.getText().toString();
        int iCategoria = spCategoria.getSelectedItemPosition();

        if(sTitulo.equals("") || sFecha.equals("") || sHora.equals("")){
            mostrarMensaje("Todos los campos son obligatorios");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            ContentValues content = new ContentValues();
            content.put("titulo", sTitulo);
            content.put("fecha", sFecha);
            content.put("hora", sHora);
            content.put("categoria", iCategoria);

            if (!Store.booInsertar){
                // MODIFICAR
                String condicion = "id_tarea LIKE " + Store.lstTareas.get(Store.tareaSeleccionada).getiIdTarea();
                conn.update("TAREA", content, condicion, null);
                mostrarMensaje("La tarea " + sTitulo + " ha sido modificada");
            } else {
                //INSERTAR
                conn.insert("TAREA", null, content);
                mostrarMensaje("La tarea " + sTitulo + " ha sido creada");
            }

            conn.close();
            onBackPressed();
        }
    }
}