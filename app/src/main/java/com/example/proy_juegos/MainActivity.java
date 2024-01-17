package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ProgressBar p;
    ImageButton b;
    ImageButton play;
    MediaPlayer mp,mb;
    TextView t;
    Handler h = new Handler();
    boolean inActivo=false;
    int i=0;
    Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=(ProgressBar) findViewById(R.id.progressBar);
        b=(ImageButton) findViewById(R.id.imageButtonIng);
        t=(TextView) findViewById(R.id.textView2);
        b.setOnClickListener(this);
        Resources res= getResources();
        Rect bounds=p.getProgressDrawable().getBounds();
       play=(ImageButton) findViewById(R.id.sonido2);
       mp=MediaPlayer.create(this,R.raw.rugrats1);
       mb=MediaPlayer.create(this,R.raw.boton);
       play.setOnClickListener(this);
        mp.setLooping(true);
      mp.start();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sonido2){
            if(mp.isPlaying()){
                mp.pause();
                play.setBackgroundResource(R.drawable.pause);
                Toast.makeText(MainActivity.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
                mp.start();
                play.setBackgroundResource(R.drawable.play);
                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();

            }

        }
        i=0;
        if(v.getId()==R.id.imageButtonIng){
            mb.start();
            if(!inActivo){
                Thread hilo= new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(i<=100){
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    p.setVisibility(v.VISIBLE);
                                    p.setProgressDrawable(getResources().getDrawable(R.drawable.mipbstyle));
                                    t.setVisibility(v.VISIBLE);
                                    t.setShadowLayer(2,10,10, Color.BLACK);
                                    t.setText(i+" %");
                                    p.setProgress(i);
                                }
                            });
                            try {
                                Thread.sleep(100);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            if(i==100){
                                mp.pause();
                                x= new Intent(MainActivity.this,MainActivity2.class);
                                startActivity(x);
                            }
                            i++;
                            inActivo=true;
                        }
                    }
                });
                hilo.start();
            }
        }
    }
}