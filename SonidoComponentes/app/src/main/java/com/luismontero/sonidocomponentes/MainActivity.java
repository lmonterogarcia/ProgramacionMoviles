package com.luismontero.sonidocomponentes;

import androidx.appcompat.app.AppCompatActivity;


import android.media.SoundPool;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoundPool soundPandereta = new SoundPool.Builder().setMaxStreams(10).build();
        int soundIdPandereta = soundPandereta.load(this, R.raw.pandereta, 1);

        SoundPool soundZambomba = new SoundPool.Builder().setMaxStreams(10).build();
        int soundIdZambomba = soundZambomba.load(this, R.raw.zambomba, 1);

        findViewById(R.id.ivPandereta).setOnClickListener( v -> {
            soundPandereta.play(soundIdPandereta,1,1,1,0,1);
        });

        findViewById(R.id.ivZambomba).setOnClickListener( v -> {
            soundZambomba.play(soundIdZambomba,1,1,1,0,1);
        });
    }
}