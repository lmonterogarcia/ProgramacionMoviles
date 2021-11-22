package com.luismontero.primerapruebapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Esfera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);

        setTitle(R.string.ventanaEsfera);

        findViewById(R.id.btnCalcularEsfera).setOnClickListener(e ->{
            CalcularEsfera();
        });

    }

    private void CalcularEsfera(){
        EditText txtRadioEsfera = findViewById(R.id.txtLadoEsfera);
        TextView lblResultadoEsfera = findViewById(R.id.lblResultadoEsfera);
        if (!txtRadioEsfera.getText().toString().equals("")){
            double dRadio = Double.parseDouble(txtRadioEsfera.getText().toString());
            if (dRadio > 0){
                Double dResultado = (4 * 3.1415 * (dRadio*dRadio*dRadio)) / 3;
                lblResultadoEsfera.setText("" + dResultado);
            } else {
                Toast.makeText(this, R.string.mayorCero, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.faltandatos, Toast.LENGTH_LONG).show();
        }
    }
}