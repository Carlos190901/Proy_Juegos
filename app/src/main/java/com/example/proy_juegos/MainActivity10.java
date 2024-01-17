package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity10 extends AppCompatActivity {
    ImageButton salida;
    MediaPlayer mp,mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

   salida=(ImageButton)findViewById(R.id.salida2);
       ImageButton play = (ImageButton) findViewById(R.id.sonido2);
       Button b1=(Button)findViewById(R.id.nivel1);
       Button b2 =(Button)findViewById(R.id.nivel2);
       Button b3=(Button)findViewById(R.id.nivel3);

        mp= MediaPlayer.create(this,R.raw.rugrats1);
        mb=MediaPlayer.create(this,R.raw.boton);
        mp.setLooping(true);
        mp.start();

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mb.start();
               mp.pause();
               Intent i= new Intent(MainActivity10.this,MainActivity9.class);
               startActivity(i);
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mb.start();
               mp.pause();
               Intent i= new Intent(MainActivity10.this,MainActivity11.class);
               startActivity(i);
           }
       });
       b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mb.start();
               mp.pause();
               Intent i= new Intent(MainActivity10.this,MainActivity12.class);
               startActivity(i);
           }
       });
        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                mp.pause();
                Intent i= new Intent(MainActivity10.this,MainActivity4.class);
                startActivity(i);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()== R.id.sonido2){
                    if(mp.isPlaying()){
                        mp.pause();
                        play.setBackgroundResource(R.drawable.pause);
                        Toast.makeText(MainActivity10.this,"Pausa",Toast.LENGTH_SHORT).show();
                    }else{
                        mp.start();
                        play.setBackgroundResource(R.drawable.play);
                        Toast.makeText(MainActivity10.this,"Play",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}