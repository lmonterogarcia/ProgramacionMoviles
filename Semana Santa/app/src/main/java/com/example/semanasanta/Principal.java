package com.example.semanasanta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        findViewById(R.id.btnHuelva).setOnClickListener(e -> {
            Intent ventanaHuelva = new Intent(this, FrmHuelva.class);
            startActivity(ventanaHuelva);
        });
    }
}