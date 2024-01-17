package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity implements View.OnClickListener {
    Button salida;
    ImageButton Bpiedra;
    ImageButton Bpapel;
    ImageButton Btijera;
    ImageButton play;
    MediaPlayer mp,mb,mPapel,mPiedra,mTijera,mScore,mEmpate,mGanar,mPerder;
    String nombre_jugador="";
    int datoJugador=0;
    int datocomputer=0;
    int scorejugador;
    int scoreComputer;
    private TextView tv_nombreJugador;

    private ImageView dataJugador;
    private ImageView dataComputer;
    private TextView tv_scoreJugador;
    private TextView tv_scoreComputer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        salida=(Button) findViewById(R.id.buttonSalir2);
       Bpiedra=(ImageButton)findViewById(R.id.Piedra);
       Bpapel=(ImageButton)findViewById(R.id.Papel);
       Btijera=(ImageButton)findViewById(R.id.Tijera);

        nombre_jugador=getIntent().getStringExtra("jugador2");
        this.tv_nombreJugador= findViewById(R.id.NombreJugador);
        tv_nombreJugador.setText(nombre_jugador);

        this.dataJugador=findViewById(R.id.dataJugador);
        this.dataComputer=findViewById(R.id.dataComputer);
        this.tv_scoreJugador=findViewById(R.id.ScoreJugador);
        this.tv_scoreComputer=findViewById(R.id.ScoreComputer);

        play=(ImageButton) findViewById(R.id.sonido2);
        mp= MediaPlayer.create(this,R.raw.tapio);
        mb=MediaPlayer.create(this,R.raw.boton);
        mPapel=MediaPlayer.create(this,R.raw.papel);
        mPiedra=MediaPlayer.create(this,R.raw.piedra);
        mTijera=MediaPlayer.create(this,R.raw.tijera);
        mScore=MediaPlayer.create(this,R.raw.score);
        mEmpate=MediaPlayer.create(this,R.raw.empate);
        mGanar=MediaPlayer.create(this,R.raw.ganaste);
        mPerder=MediaPlayer.create(this,R.raw.perdiste);
        play.setOnClickListener(this);
        mp.setLooping(true);
        mp.start();

        salida.setOnClickListener(this);
        Bpiedra.setOnClickListener(this);
        Bpapel.setOnClickListener(this);
        Btijera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sonido2){
            if(mp.isPlaying()){
                mp.pause();
                play.setBackgroundResource(R.drawable.pause);
                Toast.makeText(MainActivity6.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
                mp.start();
                play.setBackgroundResource(R.drawable.play);
                Toast.makeText(MainActivity6.this,"Play",Toast.LENGTH_SHORT).show();

            }

        }
        if (v.getId()==R.id.buttonSalir2){
            mb.start();
            mp.pause();
            Intent i= new Intent(MainActivity6.this,MainActivity4.class);
            startActivity(i);
        }else if(v.getId()==R.id.Piedra){
            mPiedra.start();
            datoJugador=1;
            SystemClock.sleep(1000);
            AleatorioDataComputer();
        }else if (v.getId()==R.id.Papel){
            mPapel.start();
            datoJugador=2;
            SystemClock.sleep(1000);
            AleatorioDataComputer();
        }else if (v.getId()==R.id.Tijera){
            mTijera.start();
            datoJugador=3;
            SystemClock.sleep(1000);
            AleatorioDataComputer();
        }
    }

    public void ResultadoJugador(){
        if (datoJugador==1){
            dataJugador.setImageResource(R.drawable.piedra2);
        }else if(datoJugador==2){
            dataJugador.setImageResource(R.drawable.papel2);
        }else if(datoJugador==3){
            dataJugador.setImageResource(R.drawable.tijera2);
        }
        Resultado();
    }
    public void  AleatorioDataComputer(){
        int num_Aleatorio=(int) (Math.random()*3);
        num_Aleatorio=num_Aleatorio+1;
        if(num_Aleatorio==1){
            dataComputer.setImageResource(R.drawable.piedra2);
            datocomputer=1;
        }else if(num_Aleatorio==2){
            dataComputer.setImageResource(R.drawable.papel2);
            datocomputer=2;
        }else if(num_Aleatorio==3){
            dataComputer.setImageResource(R.drawable.tijera2);
            datocomputer=3;//3
        }
        ResultadoJugador();
    }
    public  void Resultado(){
        try {
            if (datoJugador==datocomputer){
                mEmpate.start();
                Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            }else if(datoJugador==1&&datocomputer==2){
                mScore.start();
                //piedra vs papel gana papel computer
                scoreComputer++;
                tv_scoreComputer.setText("Score: "+String.valueOf(scoreComputer));

            }else if(datoJugador==1&&datocomputer==3){
                mScore.start();
                //piedra vs tijera gana dato jugador
                scorejugador++;
                tv_scoreJugador.setText("Score: "+String.valueOf(scorejugador));

            }else if(datoJugador==2&&datocomputer==3){
                mScore.start();
                //papel vs tijera gana computadora
                scoreComputer++;
                tv_scoreComputer.setText("Score: "+String.valueOf(scoreComputer));
            }else if(datoJugador==2&&datocomputer==1){
                mScore.start();
                //papel vs piedra gana jugador
                scorejugador++;
                tv_scoreJugador.setText("Score: "+String.valueOf(scorejugador));
            }else if(datoJugador==3&&datocomputer==1){
                mScore.start();
                //tijera vs piedra gana piedra computer
                scoreComputer++;
                tv_scoreComputer.setText("Score: "+String.valueOf(scoreComputer));
            }else if(datoJugador==3&&datocomputer==2){
                mScore.start();
                //tijera vs papel gana tijera jugador
                scorejugador++;
                tv_scoreJugador.setText("Score: "+String.valueOf(scorejugador));
            }
            fin();
        }catch (Exception e){
            Toast.makeText(this, "Error en" + e, Toast.LENGTH_LONG).show();
        }
    }

    public  void fin(){
        if (scorejugador==5){
            mGanar.start();
            //Toast.makeText(this, "Ganaste "+ nombre_jugador+" Score: "+scorejugador, Toast.LENGTH_LONG).show();
           mostrarDialogo();

        }else if(scoreComputer==5){
            mPerder.start();
            //Toast.makeText(this, "Lo siento "+ nombre_jugador+" Gano la computadora,  Score: "+scoreComputer, Toast.LENGTH_LONG).show();
            mostrarDialogo2();

        }
    }

    private void mostrarDialogo(){
        new AlertDialog.Builder(this)
                .setTitle("...FELICIDADES GANASTE..."+nombre_jugador)
                .setMessage(" Puntaje " +nombre_jugador+": "+scorejugador+" Puntaje Computadora: "+scoreComputer)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("mensaje","Se cancelo");
                        mb.start();
                        Intent intent=new Intent(MainActivity6.this,MainActivity4.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }
    private void mostrarDialogo2(){
        new AlertDialog.Builder(this)
                .setTitle("...PERDISTE..."+nombre_jugador)
                .setMessage(" Gano la computadora ")
                .setMessage(" Puntaje Computadora: "+scoreComputer+ " Puntaje " +nombre_jugador+": "+scorejugador)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mb.start();
                        Log.d("mensaje","Se cancelo");
                        Intent intent=new Intent(MainActivity6.this,MainActivity4.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }
}