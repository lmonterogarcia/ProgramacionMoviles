package com.luismontero.musicadefondo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musica = MediaPlayer.create(this, R.raw.tocata);
        //musica.start();

        findViewById(R.id.btnPaly).setOnClickListener(v -> {
            if (!musica.isPlaying()) {
                musica.start();
            }
        });

        findViewById(R.id.btnPause).setOnClickListener(v -> {
            if (musica.isPlaying()) {
                musica.pause();
            }
        });

        findViewById(R.id.btnStop).setOnClickListener(v -> {
            if (musica.isPlaying()) {
                musica.stop();
                try {
                    musica.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                musica.seekTo(0);
            }
        });
    }
}