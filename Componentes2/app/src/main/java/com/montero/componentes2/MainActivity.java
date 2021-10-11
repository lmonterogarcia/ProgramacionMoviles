package com.montero.componentes2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbDam;
    RadioButton rbDaw;
    RadioButton rbAsir;
    RadioButton rbManana;
    RadioButton rbTarde;
    RadioButton rbOnline;
    Switch swIva;
    EditText txtNombre;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbDam = findViewById(R.id.rbDam);
        rbDaw = findViewById(R.id.rbDaw);
        rbAsir = findViewById(R.id.rbAsir);
        rbManana = findViewById(R.id.rbManana);
        rbTarde = findViewById(R.id.rbTarde);
        rbOnline = findViewById(R.id.rbOnline);
        swIva = findViewById(R.id.swIva);
        txtNombre = findViewById(R.id.txtNombre);
        lblResultado = findViewById(R.id.lblResultado);

        findViewById(R.id.btnCalcular).setOnClickListener(v -> calcular());

    }
    private void calcular(){
        final double aPrecioModulo[] = {1000,1200,750};
        final double aPrecioTurno[] = {1000,1200,750};

        double dPreciocModulo = 0;
        double dPrecioxTurno = 0;
        double dIva = 1;
        double dPrecioTotal = 0;


        if (txtNombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Para poder continuar TIENE QUE INTRODUCIR UN NOMBRE", Toast.LENGTH_LONG).show();
        } else {

            if (rbDam.isChecked()) dPreciocModulo = aPrecioModulo[0];
            if (rbDaw.isChecked()) dPreciocModulo = aPrecioModulo[1];
            if (rbAsir.isChecked()) dPreciocModulo = aPrecioModulo[2];

            if (rbManana.isChecked()) dPrecioxTurno = aPrecioTurno[0];
            if (rbTarde.isChecked()) dPrecioxTurno = aPrecioTurno[1];
            if (rbOnline.isChecked()) dPrecioxTurno = aPrecioTurno[2];

            if (swIva.isChecked()) dIva = 1.21;

            dPrecioTotal = (dPreciocModulo + dPrecioxTurno) * dIva;

            lblResultado.setText(Double.toString(dPrecioTotal) + "€");

        }
    }
}