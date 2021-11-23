package com.luismontero.listadetareas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarData();
        mostarData();
        //ultimoId();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Store.lstTareas.clear();
        cargarData();
        mostarData();
    }
/**
    @SuppressLint("Range")
    private void ultimoId(){
        if (Store.lstTareas.size() == 0){
            Store.ultimoId = 0;
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getReadableDatabase();

            String sInstruccion = "SELECT max(id_tarea) FROM TAREA";
            Cursor cursor = conn.rawQuery(sInstruccion, null);

            cursor.moveToFirst();
            Store.ultimoId = (int) cursor.getLong(cursor.getColumnIndex("id_tarea"));
        }
    }
    **/

    private void cargarData() {
        Store.lstTareas.addAll(loadDBdata());
    }

    private void mostarData() {
        RecyclerView rvCasas = findViewById(R.id.rvTareas);
        rvCasas.setLayoutManager(new LinearLayoutManager(this));

        TareaAdapter adaptador = new TareaAdapter(this);
        rvCasas.setAdapter(adaptador);

        adaptador.setOnClickListener(v -> {
            Store.tareaSeleccionada = rvCasas.getChildAdapterPosition(v);
            Store.booInsertar = false;
            Intent i = new Intent(this, Tarea_detalle.class);
            startActivity(i);
        });
    }

    private void mostrarMensaje(String sMensaje){
        Toast.makeText(this, sMensaje, Toast.LENGTH_LONG).show();
    }

    public void insertarTarea(View view){
        Store.booInsertar = true;
        Intent i = new Intent(this, Tarea_detalle.class);
        startActivity(i);
    }

    @SuppressLint("Range")
    public List<Tarea> loadDBdata(){

        List<Tarea> lstTareas = new ArrayList<Tarea>();
        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getReadableDatabase();

        String sqlTableName = "TAREA";
        String[] sqlFields = {"id_tarea","titulo", "fecha","hora", "categoria"};
        String sqlWhere = "";
        String sqlGroupBy = "";
        String sqlHaving = "";
        String sqlOrderBy = "id_tarea ASC";

        Cursor cursor = conn.query(sqlTableName,sqlFields,sqlWhere,null, sqlGroupBy,sqlHaving,sqlOrderBy);

        if(cursor.getCount() == 0){
            mostrarMensaje("No hay tareas por hacer, aniade una.");
        } else {
            cursor.moveToFirst();
            do{

                long dataIdTarea = cursor.getLong(cursor.getColumnIndex("id_tarea"));
                String dataTituloTarea = cursor.getString(cursor.getColumnIndex("titulo"));
                String dataFechaTarea = cursor.getString(cursor.getColumnIndex("fecha"));
                String dataHoraTarea = cursor.getString(cursor.getColumnIndex("hora"));
                int dataCategoriaTarea = cursor.getInt(cursor.getColumnIndex("categoria"));

                lstTareas.add(new Tarea((int)dataIdTarea, dataTituloTarea, dataFechaTarea, dataHoraTarea, dataCategoriaTarea));
            }while(cursor.moveToNext());
        }
        return lstTareas;
    }
}