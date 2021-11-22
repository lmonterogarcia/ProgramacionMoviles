package com.luismontero.primerapruebapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cubo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        setTitle(R.string.ventanaCubo);

        findViewById(R.id.btnCalcularCubo).setOnClickListener(e ->{
            CalcularCubo();
        });

    }

    private void CalcularCubo(){
        EditText txtLadoCubo = findViewById(R.id.txtLadoCubo);
        TextView lblResultadoCubo = findViewById(R.id.lblResultadoCubo);
        if (!txtLadoCubo.getText().toString().equals("")){
            double dLado = Double.parseDouble(txtLadoCubo.getText().toString());
            if (dLado > 0){
                lblResultadoCubo.setText("" + (dLado*3));
            } else {
                Toast.makeText(this, R.string.mayorCero, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.faltandatos, Toast.LENGTH_LONG).show();
        }
    }
}