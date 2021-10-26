package com.luismontero.volumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ivCubo).setOnClickListener( e ->{
            Intent vntCubo = new Intent(this,Cubo.class);
            startActivity(vntCubo);
        });
        findViewById(R.id.lblCubo).setOnClickListener( e ->{
            Intent vntCubo = new Intent(this,Cubo.class);
            startActivity(vntCubo);
        });
        findViewById(R.id.ivEsfera).setOnClickListener( e ->{
            Intent vntEsfera = new Intent(this,Esfera.class);
            startActivity(vntEsfera);
        });
        findViewById(R.id.lblEsfera).setOnClickListener( e ->{
            Intent vntEsfera = new Intent(this,Esfera.class);
            startActivity(vntEsfera);
        });
        findViewById(R.id.ivCilindro).setOnClickListener( e ->{
            Intent vntCilindro = new Intent(this,Cilindro.class);
            startActivity(vntCilindro);
        });
        findViewById(R.id.lblCilindro).setOnClickListener( e ->{
            Intent vntCilindro = new Intent(this,Cilindro.class);
            startActivity(vntCilindro);
        });
    }
}