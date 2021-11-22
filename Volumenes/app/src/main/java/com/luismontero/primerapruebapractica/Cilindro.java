package com.luismontero.primerapruebapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cilindro extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        setTitle(R.string.ventanaCilindro);

        findViewById(R.id.btnCalcularCilindro).setOnClickListener(e ->{
            CalcularCilindro();
        });

    }

    private void CalcularCilindro(){
        EditText txtRadioCilindro = findViewById(R.id.txtRadioCilindro);
        EditText txtAlturaCilindro = findViewById(R.id.txtAlturaCilindro);
        TextView lblResultadoCilindro = findViewById(R.id.lblResultadoCilindro);

        if (!txtRadioCilindro.getText().toString().equals("") && !txtAlturaCilindro.getText().toString().equals("")){
            double dRadio = Double.parseDouble(txtRadioCilindro.getText().toString());
            double dAltura = Double.parseDouble(txtAlturaCilindro.getText().toString());
            if (dRadio > 0 && dAltura > 0 ){
                Double dResultado = (3.1415 * dAltura *(dRadio*dRadio));
                lblResultadoCilindro.setText("" + dResultado);
            } else {
                Toast.makeText(this, R.string.mayorCero, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.faltandatos, Toast.LENGTH_LONG).show();
        }
    }
}