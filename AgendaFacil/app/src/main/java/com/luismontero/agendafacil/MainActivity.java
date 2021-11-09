package com.luismontero.agendafacil;

import static android.Manifest.permission.CALL_PHONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.ib01).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib01Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });

        findViewById(R.id.ib02).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib02Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });

        findViewById(R.id.ib03).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib03Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });

        findViewById(R.id.ib04).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib04Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });

        findViewById(R.id.ib07).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib05Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });

        findViewById(R.id.ib08).setOnClickListener(e -> {
            String sData01 = "tel:" + "+34" + R.string.ib06Num;

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(sData01));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });
    }
}