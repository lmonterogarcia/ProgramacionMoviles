package com.montero.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*
        FloatingActionButton btnFlotating = findViewById(R.id.btnFloatating);

        btnFlotating.setOnClickListener(
                v -> {
                    Toast.makeText(this,"Has pulsado el flotating button",Toast.LENGTH_LONG).show();
                    btnFloating.setVisibility(View.INVISIBLE); //Hace que desaparezca el boton
                 }
        );
    */

        findViewById(R.id.btnFloatating).setOnClickListener(
                v -> {
                    Toast.makeText(this,"Has pulsado el flotating button",Toast.LENGTH_LONG).show();

                }
        );
    }

}