package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrmDividir extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_dividir);

        setTitle(R.string.dividir);
        Button btnCalcularSumar = findViewById(R.id.btnCalcularDividir);

        btnCalcularSumar.setOnClickListener( e -> calcualarDivision());
    }

    private void calcualarDivision(){
        EditText dNum1 = findViewById(R.id.txtNum1Dividir);
        EditText dNum2 = findViewById(R.id.txtNum2Dividir);
        TextView lblResultadoSumar = findViewById(R.id.lblResultadoDividir);

        if (!dNum1.getText().toString().equals("") && !dNum2.getText().toString().equals("")){
            Double dbNum1 = Double.parseDouble(dNum1.getText().toString()), dbNum2 = Double.parseDouble(dNum2.getText().toString());
            if (dbNum1 == 0 && dbNum2 == 0){
                lblResultadoSumar.setText("Inderteminado");
            } else if (dbNum2 == 0){
                lblResultadoSumar.setText("Infinito");
            } else {
                String sResultado = "" + (dbNum1 / dbNum2);
                lblResultadoSumar.setText(sResultado);
            }
        } else {
            Toast.makeText(getApplicationContext(),"Tiene que rellenar los dos números", Toast.LENGTH_LONG).show();
        }
    }
}