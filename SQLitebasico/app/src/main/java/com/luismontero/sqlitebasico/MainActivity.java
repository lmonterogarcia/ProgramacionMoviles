package com.luismontero.sqlitebasico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtCantidad;
    private Spinner spSeccion;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        spSeccion = findViewById(R.id.spSeccion);
        txtResultado = findViewById(R.id.txtResultados);

        List<String> secciones = Arrays.asList("Monitor", "Memoria", "Raton", "Impresra", "Disco Duro");
        spSeccion.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, secciones));
    }

    private void mostrarMensaje(String sMensaje){
        Toast.makeText(this, sMensaje, Toast.LENGTH_LONG).show();
    }

    private void limpiarCuadros(){
        txtNombre.setText("");
        txtCantidad.setText("");
    }
    
    public void insertarProducto(View vies){
        String sNombre = txtNombre.getText().toString();
        String sCantidad = txtCantidad.getText().toString();
        String sSeccion = spSeccion.getSelectedItem().toString();

        if(sNombre.equals("") || sCantidad.equals("")){
            mostrarMensaje("Todo los campos son obligatorios");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            String sInstruccion = "INSERT INTO PRODUCTO (nombre, cantidad, seccion) VALUES('" + sNombre + "'," + Integer.parseInt(sCantidad) + ",'" + sSeccion + "')";
            conn.execSQL(sInstruccion);
            mostrarMensaje("El producto " + sNombre + " ha sido insertado");
            limpiarCuadros();
            conn.close();
        }
    }
    
    public void eliminarProducto(View vies){

    }

    public void modificarProducto(View vies){

    }

    public void buscarProducto(View vies){

    }
    @SuppressLint("Range")
    public void listarProducto(View vies){

        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getReadableDatabase();

        String sInstruccion = "SELECT * FROM PRODUCTO ORDER BY nombre ASC";
        Cursor cursor = conn.rawQuery(sInstruccion,null);

        if(cursor.getCount() == 0){
            mostrarMensaje("La Tabla está vacia");
        } else {
            String sResultado = "";
            cursor.moveToFirst();
            do{

                long dataIdProducto = cursor.getLong(cursor.getColumnIndex("Id_Producto"));
                String dataNombreProducto = cursor.getString(cursor.getColumnIndex("nombre"));
                int dataCantidadProducto = cursor.getInt(cursor.getColumnIndex("cantidad"));
                String dataSeccionProducto = cursor.getString(cursor.getColumnIndex("seccion"));

                sResultado += "\n" + dataIdProducto + " " + dataNombreProducto + " " + dataCantidadProducto + " " + dataSeccionProducto;

            }while(cursor.moveToNext());
            txtResultado .setText(sResultado);
        }
    }
}