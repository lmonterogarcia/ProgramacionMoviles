package com.montero.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtContenido = findViewById(R.id.txtContenido);
        Button btnDoble = findViewById(R.id.btnDoble);
        Button btnTriple = findViewById(R.id.btnTriple);
        TextView lblResultado = findViewById(R.id.lblResultado);

        btnDoble.setOnClickListener(
                v -> {
                    try {
                        Double dNumero = Double.parseDouble(txtContenido.getText().toString());
                        lblResultado.setText(Double.toString(dNumero * 2));
                    } catch( Exception e) {
                        Toast.makeText(this,"INTRODUCE UN NÚMERO",Toast.LENGTH_LONG).show();
                    }
                }
        );

        btnTriple.setOnClickListener(
                v -> {
                    try {
                        Double dNumero = Double.parseDouble(txtContenido.getText().toString());
                        lblResultado.setText(Double.toString(dNumero * 3));
                    } catch( Exception e) {
                        Toast.makeText(this,"INTRODUCE UN NÚMERO",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

}