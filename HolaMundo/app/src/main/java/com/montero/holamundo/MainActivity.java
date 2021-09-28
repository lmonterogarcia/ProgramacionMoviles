package com.montero.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //System.out.println("Estoy en; Oncreate()");

        Log.i("MonteroInfo","Estoy en el: OnCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("MonteroInfo","Estoy en el: OnStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("MonteroInfo","Estoy en el: OnRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("MonteroInfo","Estoy en el: OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("MonteroInfo","Estoy en el: OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("MonteroInfo","Estoy en el: OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("MonteroInfo","Estoy en el: OnDestroy()");
    }
}