package com.luismontero.gestinmobiliaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
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
        ultimoId();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mostarData();
    }

    private void ultimoId(){
        if (Inmobiliaria.lstCasas.size() == 0){
            Inmobiliaria.ultimoId = 0;
        } else {
            Inmobiliaria.ultimoId = Inmobiliaria.lstCasas.get(Inmobiliaria.lstCasas.size() - 1).getiIdCasa();
        }
    }

    private void cargarData() {
        Inmobiliaria.lstCasas.addAll(loadDBdata());
    }

    private void mostarData() {
        RecyclerView rvCasas = findViewById(R.id.rvCasas);
        rvCasas.setLayoutManager(new LinearLayoutManager(this));

        CasasAdapter adaptador = new CasasAdapter(this);
        rvCasas.setAdapter(adaptador);

        adaptador.setOnClickListener(v -> {
            Inmobiliaria.CasaSeleccionada = rvCasas.getChildAdapterPosition(v);
            Inmobiliaria.booInsertar = false;
            Intent i = new Intent(this, Casa_detalle.class);
            startActivity(i);
        });
    }

    private void mostrarMensaje(String sMensaje){
        Toast.makeText(this, sMensaje, Toast.LENGTH_LONG).show();
    }

    public void insertarProducto(View view){
        Inmobiliaria.booInsertar = true;
        Intent i = new Intent(this, Casa_detalle.class);
        startActivity(i);
    }

    @SuppressLint("Range")
    public List<Casa> loadDBdata(){

        List<Casa> lstCasas = new ArrayList<Casa>();
        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getReadableDatabase();

        String sqlTableName = "CASA";
        String[] sqlFields = {"Id_Casa","calle", "numero","superficie"};
        String sqlWhere = "";
        String sqlGroupBy = "";
        String sqlHaving = "";
        String sqlOrderBy = "calle ASC";

        Cursor cursor = conn.query(sqlTableName,sqlFields,sqlWhere,null, sqlGroupBy,sqlHaving,sqlOrderBy);

        if(cursor.getCount() == 0){
            mostrarMensaje("La Tabla está vacia");
        } else {
            cursor.moveToFirst();
            do{

                long dataIdCasa = cursor.getLong(cursor.getColumnIndex("Id_Casa"));
                String dataCalleCasa = cursor.getString(cursor.getColumnIndex("calle"));
                int dataNuemeroCasa = cursor.getInt(cursor.getColumnIndex("numero"));
                Double dataSuperficieCasa = cursor.getDouble(cursor.getColumnIndex("superficie"));

                lstCasas.add(new Casa((int)dataIdCasa, dataCalleCasa, dataNuemeroCasa, dataSuperficieCasa));
            }while(cursor.moveToNext());
        }
        return lstCasas;
    }

}
