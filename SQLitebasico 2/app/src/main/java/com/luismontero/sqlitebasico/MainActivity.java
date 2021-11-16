package com.luismontero.sqlitebasico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
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

        List<String> secciones = Arrays.asList("Monitor", "Memoria", "Raton", "Impresora", "Disco Duro");
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

            //String sInstruccion = "INSERT INTO PRODUCTO (nombre, cantidad, seccion) VALUES('" + sNombre + "'," + Integer.parseInt(sCantidad) + ",'" + sSeccion + "')";
            //conn.execSQL(sInstruccion);

            ContentValues content = new ContentValues();
            content.put("nombre", sNombre);
            content.put("cantidad", sCantidad);
            content.put("seccion", sSeccion);

            conn.insert("PRODUCTO", null, content);

            mostrarMensaje("El producto " + sNombre + " ha sido insertado");
            limpiarCuadros();
            conn.close();
        }
    }
    
    public void eliminarProducto(View vies){

        String sNombre = txtNombre.getText().toString();

        if(sNombre.equals("")){
            mostrarMensaje("El campo nombre es obligatorio");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            //String sInstruccion = "DELETE FROM PRODUCTO WHERE nombre LIKE '" + sNombre + "'";
            //conn.execSQL(sInstruccion);

            String sql = "nombre LIKE '" + sNombre + "'";
            int filasBorradas = conn.delete("PRODUCTO", sql,null);

            limpiarCuadros();
            conn.close();

            mostrarMensaje("Se han borrado " + filasBorradas + "tantas filas.");
        }


    }

    public void modificarProducto(View vies){

        String sNombre = txtNombre.getText().toString();
        String sCantidad = txtCantidad.getText().toString();
        String sSeccion = spSeccion.getSelectedItem().toString();

        if(sNombre.equals("") || sCantidad.equals("")){
            mostrarMensaje("Todo los campos son obligatorios");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            //String sInstruccion = "UPDATE PRODUCTO SET cantidad = " + Integer.parseInt(sCantidad) + ", seccion = '" + sSeccion  + "' WHERE nombre = '" + sNombre + "'";
            //conn.execSQL(sInstruccion);

            ContentValues content = new ContentValues();
            content.put("nombre", sNombre);
            content.put("cantidad", sCantidad);
            content.put("seccion", sSeccion);

            String condicion = "nombre LIKE '" + sNombre + "'";

            conn.update("PRODUCTO", content, condicion, null);

            limpiarCuadros();
            conn.close();

            mostrarMensaje("El producto " + sNombre + " ha sido modificado");
        }

    }

    @SuppressLint("Range")
    public void buscarProducto(View vies){

        String sNombre = txtNombre.getText().toString();

        if(sNombre.equals("")){
            mostrarMensaje("El campo nombre es obligatorio");
        } else {
            DB_SQLite db = new DB_SQLite(this);
            SQLiteDatabase conn = db.getWritableDatabase();

            String sInstruccion = "SELECT * FROM PRODUCTO WHERE nombre = '" + sNombre + "'";
            Cursor cursor = conn.rawQuery(sInstruccion,null);
            String sResultado = "";
            if(cursor.getCount() == 0){
                mostrarMensaje("No se ha encontrado ese producto");
                sResultado = "El producto no existe";
            } else {
                cursor.moveToFirst();
                do{

                    long dataIdProducto = cursor.getLong(cursor.getColumnIndex("Id_Producto"));
                    String dataNombreProducto = cursor.getString(cursor.getColumnIndex("nombre"));
                    int dataCantidadProducto = cursor.getInt(cursor.getColumnIndex("cantidad"));
                    String dataSeccionProducto = cursor.getString(cursor.getColumnIndex("seccion"));

                    sResultado += "\n" + dataIdProducto + " " + dataNombreProducto + " " + dataCantidadProducto + " " + dataSeccionProducto;

                }while(cursor.moveToNext());
            }
            txtResultado .setText(sResultado);

            mostrarMensaje("El producto " + sNombre + " ha sido encontrado");
            limpiarCuadros();
            conn.close();
        }



    }
    @SuppressLint("Range")
    public void listarProducto(View vies){

        DB_SQLite db = new DB_SQLite(this);
        SQLiteDatabase conn = db.getReadableDatabase();

        String sqlTableName = "PRODUCTO";
        String[] sqlFields = {"Id_Producto","nombre", "cantidad","seccion"};
        String sqlWhere = "";
        String sqlGroupBy = "";
        String sqlHaving = "";
        String sqlOrderBy = "nombre ASC";

        //String sInstruccion = "SELECT * FROM PRODUCTO ORDER BY nombre ASC";
        //Cursor cursor = conn.rawQuery(sInstruccion,null);

        Cursor cursor = conn.query(sqlTableName,sqlFields,sqlWhere,null, sqlGroupBy,sqlHaving,sqlOrderBy);

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