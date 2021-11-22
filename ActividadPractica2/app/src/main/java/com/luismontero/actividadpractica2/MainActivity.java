package com.luismontero.actividadpractica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




















        /* SPINNER con ARRAYS

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
         */

        /* INTENT mde ACCIONES

            String sValue = "+34682145634";
            String sData = "tel:" + sValue;

            //MARCAR
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData( Uri.parse(sData));

           if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
               startActivity(intent);
           }else{
               requestPermissions(new String[]{CALL_PHONE}, 1);
           }

            //ABRIR MAIL APP
            String sValue = "user@gmail.com";
            String sData = "mailto:" + sValue;

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData( Uri.parse(sData));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            }else {
                requestPermissions(new String[]{INTERNET}, 1);
            }

            //ABRIR NAVEGADOR HACIA UNA WEB O APP
            String sValue = "//www.google.com/maps/place/Sevilla";
            String sData = "http:" + sValue;

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData( Uri.parse(sData));

            startActivity(intent);

            // ENVIAR SMS O MENSAJE APP
            String sValue = "+34654259896";
            String sData = "smsto:" + sValue;

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData( Uri.parse(sData));
            intent.setPackage("com.whatsapp");

            //LANZAR LA ACCION
            startActivity(intent);

         */

        /* SQLITE

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

         */


    }
}