package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrmRestar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_restar);

        setTitle(R.string.restar);
        Button btnCalcularRestar = findViewById(R.id.btnCalcularRestar);

        btnCalcularRestar.setOnClickListener( e -> calcualarResta());
    }

    private void calcualarResta(){
        EditText dNum1 = findViewById(R.id.txtNum1Restar);
        EditText dNum2 = findViewById(R.id.txtNum2Restar);
        TextView lblResultadoSumar = findViewById(R.id.lblResultadoRestar);

        if (!dNum1.getText().toString().equals("") && !dNum2.getText().toString().equals("")){
            String sResultado = "" + (Double.parseDouble(dNum1.getText().toString()) - (Double.parseDouble(dNum2.getText().toString())));
            lblResultadoSumar.setText(sResultado);
        } else {
            Toast.makeText(getApplicationContext(),R.string.avisoNumCavios, Toast.LENGTH_LONG).show();
        }
    }
}