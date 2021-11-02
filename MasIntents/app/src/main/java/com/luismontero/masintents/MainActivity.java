package com.luismontero.masintents;

import static android.Manifest.permission.*;

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

        findViewById(R.id.btnMarcar).setOnClickListener(e ->{


//            String sValue = "+34682145634";
//            String sData = "tel:" + sValue;

//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            Intent intent = new Intent(Intent.ACTION_CALL);
//            intent.setData( Uri.parse(sData));

 //           if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
 //               startActivity(intent);
 //           }else{
 //               requestPermissions(new String[]{CALL_PHONE}, 1);
 //           }

//            String sValue = "user@gmail.com+34682145634";
//            String sData = "mailto:" + sValue;

//            Intent intent = new Intent(Intent.ACTION_SENDTO);
//            intent.setData( Uri.parse(sData));

//            if (ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET) == PackageManager.PERMISSION_GRANTED) {
//                startActivity(intent);
//            }else {
//                requestPermissions(new String[]{INTERNET}, 1);
//            }

//            String sValue = "//www.google.com/maps/place/Sevilla";
//            String sData = "http:" + sValue;

//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData( Uri.parse(sData));

//             startActivity(intent);

            String sValue = "+34654259896";
            String sData = "smsto:" + sValue;

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData( Uri.parse(sData));
//            intent.setPackage("com.whatsapp");

            startActivity(intent);
            
        });
    }
}