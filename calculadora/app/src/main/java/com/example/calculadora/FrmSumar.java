package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrmSumar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_sumar);

        setTitle(R.string.sumar);
        Button btnCalcularSumar = findViewById(R.id.btnCalcularSumar);

        btnCalcularSumar.setOnClickListener( e -> calcualarSuma());
    }

    private void calcualarSuma(){
        EditText dNum1 = findViewById(R.id.txtNum1Sumar);
        EditText dNum2 = findViewById(R.id.txtNum2Sumar);
        TextView lblResultadoSumar = findViewById(R.id.lblResutaldoSumar);

        if (!dNum1.getText().toString().equals("") && !dNum2.getText().toString().equals("")){
            String sResultado = "" + (Double.parseDouble(dNum1.getText().toString()) + (Double.parseDouble(dNum2.getText().toString())));
            lblResultadoSumar.setText(sResultado);
        } else {
            Toast.makeText(getApplicationContext(),R.string.avisoNumCavios, Toast.LENGTH_LONG).show();
        }
    }
}