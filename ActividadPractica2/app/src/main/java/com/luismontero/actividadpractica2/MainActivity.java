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




    }
}