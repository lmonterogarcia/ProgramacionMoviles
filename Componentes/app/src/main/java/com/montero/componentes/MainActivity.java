package com.montero.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private static final byte bBotones = 6;
    private static byte bContador = 0;
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
        byte bContador = 0;
        Button btn01 = findViewById(R.id.btn01);
        Button btn02 = findViewById(R.id.btn02);
        Button btn03 = findViewById(R.id.btn03);
        Button btn04 = findViewById(R.id.btn04);
        Button btn05 = findViewById(R.id.btn05);
        Button btn06 = findViewById(R.id.btn06);
        FloatingActionButton btnFlotating = findViewById(R.id.btnFloatating);

        btn01.setOnClickListener(
                v -> {
                    btn01.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btn02.setOnClickListener(
                v -> {
                    btn02.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btn03.setOnClickListener(
                v -> {
                    btn03.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btn04.setOnClickListener(
                v -> {
                    btn04.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btn05.setOnClickListener(
                v -> {
                    btn05.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btn06.setOnClickListener(
                v -> {
                    btn06.setVisibility(View.INVISIBLE);
                    verificar(btnFlotating);
                }
        );

        btnFlotating.setOnClickListener(
                v -> {
                    btnFlotating.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "¡Hemos reiniciado la pantalla!",Toast.LENGTH_LONG).show();
                    btn01.setVisibility(View.VISIBLE);
                    btn02.setVisibility(View.VISIBLE);
                    btn03.setVisibility(View.VISIBLE);
                    btn04.setVisibility(View.VISIBLE);
                    btn05.setVisibility(View.VISIBLE);
                    btn06.setVisibility(View.VISIBLE);


                }
        );
    }

    private static void verificar(FloatingActionButton btnFlotating){
        bContador++;

        if (bContador == bBotones) {
            btnFlotating.setVisibility(View.VISIBLE);
            bContador = 0;
        }
    }
}