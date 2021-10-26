package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrmMultiplicar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_multiplicar);

        setTitle(R.string.multiplicar);
        Button btnCalcularSumar = findViewById(R.id.btnCalcularMultiplicar);

        btnCalcularSumar.setOnClickListener( e -> calcualarMultiplicacion());
    }

    private void calcualarMultiplicacion(){
        EditText dNum1 = findViewById(R.id.txtNum1Multiplicar);
        EditText dNum2 = findViewById(R.id.txtNum2Multiplicar);
        TextView lblResultadoSumar = findViewById(R.id.lblResultadoMultiplicar);

        if (!dNum1.getText().toString().equals("") && !dNum2.getText().toString().equals("")){
            String sResultado = "" + (Double.parseDouble(dNum1.getText().toString()) * (Double.parseDouble(dNum2.getText().toString())));
            lblResultadoSumar.setText(sResultado);
        } else {
            Toast.makeText(getApplicationContext(),R.string.avisoNumCavios, Toast.LENGTH_LONG).show();
        }
    }
}