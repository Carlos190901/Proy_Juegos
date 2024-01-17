package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity4 extends AppCompatActivity {
 FloatingActionButton b1;
 FloatingActionButton b3;
 FloatingActionButton b4;
  FloatingActionButton b5;
 ImageButton b2,b6,b7,b8;
    MediaPlayer mp,mb,mpr;
    ImageButton play,salida;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=(FloatingActionButton) findViewById(R.id.ButtonJ1);
        b2=(ImageButton)findViewById(R.id.nivel2);
        b3=(FloatingActionButton)findViewById(R.id.ButtonJ2);
        b4=(FloatingActionButton) findViewById(R.id.ButtonJ3);
        b5=(FloatingActionButton)findViewById(R.id.ButtonJ4);
        b6=(ImageButton)findViewById(R.id.nivel3);
        b7=(ImageButton) findViewById(R.id.button4);
        b8=(ImageButton) findViewById(R.id.button5);
        Bundle extras = getIntent().getExtras();
        String n1=extras.getString("jugador");
        salida=(ImageButton)findViewById(R.id.salida2);
        play=(ImageButton) findViewById(R.id.sonido2);
        mp= MediaPlayer.create(this,R.raw.rugrats1);
        mb=MediaPlayer.create(this,R.raw.boton);
        mpr=MediaPlayer.create(this,R.raw.pacman);
        mp.setLooping(true);
        mp.start();

        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                mp.pause();
                Intent i= new Intent(MainActivity4.this,MainActivity.class);
                startActivity(i);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.sonido2){
                    if(mp.isPlaying()){
                        mp.pause();
                        play.setBackgroundResource(R.drawable.pause);
                        Toast.makeText(MainActivity4.this,"Pausa",Toast.LENGTH_SHORT).show();
                    }else{
                        mp.start();
                        play.setBackgroundResource(R.drawable.play);
                        Toast.makeText(MainActivity4.this,"Play",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mb.start();
            Toast toast1 =
              Toast.makeText(getApplicationContext(),
                "LOGIN......", Toast.LENGTH_SHORT);

            toast1.show();
            SystemClock.sleep(3000);
              mp.pause();
            Intent i= new Intent(MainActivity4.this,MainActivity10.class);
            i.putExtra("jugadorA2",n1);
            startActivity(i);
          }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "LOGIN......", Toast.LENGTH_SHORT);

                toast1.show();
                SystemClock.sleep(3000);
                mp.pause();
                Intent i= new Intent(MainActivity4.this,MainActivity6.class);
                i.putExtra("jugador2",n1);
                startActivity(i);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.start();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "LOGIN......", Toast.LENGTH_SHORT);

                toast1.show();
                SystemClock.sleep(3000);

                /*Intent i2= new Intent(MainActivity4.this,MainActivity7.class);
                startActivity(i2);*/
              AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity4.this);
              View mView = getLayoutInflater().inflate(R.layout.activity_main7, null);
              String nombre_jugador="";
              final EditText mInvitado = (EditText) mView.findViewById(R.id.textUsuario2);
              final EditText mUsuario = (EditText) mView.findViewById(R.id.textUsuario);
              ImageButton mLogin = (ImageButton) mView.findViewById(R.id.imageButtonIng);


              mBuilder.setView(mView);
              final AlertDialog dialog = mBuilder.create();
              dialog.show();
              mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mb.start();
                  String u=mInvitado.getText().toString();
                  String p=mUsuario.getText().toString();
                  if(!mInvitado.getText().toString().isEmpty() && !mUsuario.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity4.this,
                     "login",
                      Toast.LENGTH_SHORT).show();
                      mp.pause();
                    Intent i2= new Intent(MainActivity4.this,MainActivity5.class);
                    i2.putExtra("jugadorG1",u);
                    i2.putExtra("jugadorG2",p);
                    startActivity(i2);
                    dialog.dismiss();
                  }else{
                    Toast.makeText(MainActivity4.this,
                     "error",
                      Toast.LENGTH_SHORT).show();
                  }
                }
              });
            }



        });

        b4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mb.start();
            Toast toast1 =
              Toast.makeText(getApplicationContext(),
                "LOGIN......", Toast.LENGTH_SHORT);

            toast1.show();
            SystemClock.sleep(3000);
              mp.pause();
            Intent i= new Intent(MainActivity4.this,MainActivity8.class);
            i.putExtra("jugadorM1",n1);
            startActivity(i);
          }
        });
      b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mpr.start();
              mostrarDialogo();
          }
      });

      b6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mpr.start();
          mostrarDialogo2();
        }
      });

      b7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mpr.start();
          mostrarDialogo3();
        }
      });

      b8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mpr.start();
          mostrarDialogo4();
        }
      });
    }


    private void mostrarDialogo(){
        new AlertDialog.Builder(this)
                .setTitle("PIEDRA PAPELO O TIJERA")
                .setMessage("Es un juego usuario vs computadora, en el que existen tres elementos: \n " +
                  "1.-la piedra que vence a la tijera rompiéndola.\n" +
                  "2.-la tijera que vence al papel cortándolo.\n" +
                  "3.-el papel que vence a la piedra envolviéndola.\n" +
                  "dando lugar a un círculo o ciclo cerrado, que caracteriza al juego. " +
                  "Para elegir un ganador se debate sobre usuario y computadora el primero que alcance " +
                  "un puntaje de 5 logra la victoria.")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("mensaje","Se cancelo");
                    }
                }).show();
    }

  private void mostrarDialogo2(){
    new AlertDialog.Builder(this)
      .setTitle("JUEGO GATO")
      .setMessage("1. El juego es únicamente entre dos jugadores.\n" +
        "2. Cada jugador tendrá uno de los símbolos “O” y “X”.\n" +
        "3. El tablero debe consistir en 9 cuadros. \n" +
        "4. Cada jugador debe colocar su símbolo en uno de los recuadros del tablero, un vez por turno.\n" +
        "5. Un jugador gana si consigue tener una línea horizontal, vertical o diagonal de tresde sus símbolos.\n" +
        "6. En caso de que todos los recuadros del tablero tengan símbolo y no exista línea recta por tres de ellos, entonces se declarará un empate.")
      .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          Log.d("mensaje","Se cancelo");
        }
      }).show();
  }

  private void mostrarDialogo3(){
    new AlertDialog.Builder(this)
      .setTitle("MEMORAMA")
      .setMessage("Memorama, juego de la memoria o memorama es un juego de mesa con una baraja de cartas específicas. " +
        "El objetivo consiste en encontrar los pares con la misma figura impresa utilizando la memoria. \n" +
        "1.\tEl jugador cuenta con 5 intentos por turno para encontrar un par \n" +
        "2.\tPara obtener la victoria debe encotrara todas las tarjetas con su respectivo par")
      .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          Log.d("mensaje","Se cancelo");
        }
      }).show();
  }

  private void mostrarDialogo4(){
    new AlertDialog.Builder(this)
      .setTitle("ADIVINA EL NUMERO")
      .setMessage("Adivina el Número es un juego en que tienes que utilizar tu lógica para adivinar un número secreto de  1 AL 100 " +
        "que el ordenador escoge al principio del partido. " +
        "El jugador tiene un infinito numero de intentos hasta adivinar el correcto")
      .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          Log.d("mensaje","Se cancelo");
        }
      }).show();
  }
}
