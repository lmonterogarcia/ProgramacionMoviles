package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSumar).setOnClickListener( e ->{
            Intent vntSumar = new Intent(this,FrmSumar.class);
            startActivity(vntSumar);
        });
        findViewById(R.id.btnRestar).setOnClickListener( e ->{
            Intent vntSumar = new Intent(this,FrmRestar.class);
            startActivity(vntSumar);
        });
        findViewById(R.id.btnMultiplicar).setOnClickListener( e ->{
            Intent vntSumar = new Intent(this,FrmMultiplicar.class);
            startActivity(vntSumar);
        });
        findViewById(R.id.btnDividir).setOnClickListener( e ->{
            Intent vntSumar = new Intent(this,FrmDividir.class);
            startActivity(vntSumar);
        });
    }
}