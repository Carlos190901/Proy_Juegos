package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity11 extends AppCompatActivity {
    Button adivinar,salir;

    private TextView mensaje;
    private EditText numero;
    private TextView n_intentos;
    int intento=0;
    int rndvar;
    MediaPlayer mp,mb;
    final Random myRandom=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        n_intentos=(TextView) findViewById(R.id.int1);
        numero = (EditText) findViewById(R.id.numadv2);
        mensaje = (TextView)findViewById(R.id.mensaje);
        rndvar = myRandom.nextInt(100);
        adivinar=(Button) findViewById(R.id.button2);
        salir=(Button)findViewById(R.id.buttonSalir2) ;

        mp= MediaPlayer.create(this,R.raw.rugrats1);
        mb=MediaPlayer.create(this,R.raw.boton);
        mp.setLooping(true);
        mp.start();
        ImageButton play = (ImageButton) findViewById(R.id.sonido2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()== R.id.sonido2){
                    if(mp.isPlaying()){
                        mp.pause();
                        play.setBackgroundResource(R.drawable.pause);
                        Toast.makeText(MainActivity11.this,"Pausa",Toast.LENGTH_SHORT).show();
                    }else{
                        mp.start();
                        play.setBackgroundResource(R.drawable.play);
                        Toast.makeText(MainActivity11.this,"Play",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                Intent intent=new Intent(MainActivity11.this, MainActivity10.class);
                startActivity(intent);
            }
        });
        adivinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                String num = numero.getText().toString();
                int valor1=Integer.parseInt(num);
                //Hacemos la comparacion de los numeros.
                if (valor1 == rndvar)
                {
                    /* mensaje.setText("!Correcto ese es el numero!");*/
                    mostrarDialogo3();

                }
                else
                {
                    if (valor1 > rndvar)
                    {
                        mensaje.setText("Es numero es menor que "+ valor1 + " intenta de nuevo.");
                        numero.setText("");

                    }
                    else
                    {
                        mensaje.setText("Es numero es mayor que " + valor1 + " intenta de nuevo.");

                    }
                }
                //Damos el foco al EditText e incrementamos el numero de intentos
                numero.requestFocus();
                intento++;
                n_intentos.setText("Intento: "+ intento);
            }


        });
    }
    private void mostrarDialogo3(){
        String num = numero.getText().toString();
        int valor1=Integer.parseInt(num);
        new AlertDialog.Builder(this)
                .setTitle("ADIVINASTE el numero es : "+ valor1)
                .setMessage(" !FELICIDADES¡... ")
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("mensaje","Se cancelo");
                        Intent intent=new Intent(getApplicationContext(), MainActivity4.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }
}