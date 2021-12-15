package com.luismontero.primerosfragment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSuperficies).setOnClickListener( v ->{
            BlankFragment f1 = new BlankFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentContainerView, f1, null);
            ft.commit();

        });

        findViewById(R.id.btnVolumenes).setOnClickListener( v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirmar apertura").setMessage("¿Desea cambiar a ver volúmenes").setPositiveButton("SI",(dialog, id) ->{
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, new SegundoFragment(), null).commit();
            }).setNegativeButton("No", (dialog, id) ->{
                Toast.makeText(getApplicationContext(),"Pues no se cambia!", Toast.LENGTH_LONG).show();
            });

            AlertDialog dialog = builder.create();
            dialog.show();





        });
    }
}