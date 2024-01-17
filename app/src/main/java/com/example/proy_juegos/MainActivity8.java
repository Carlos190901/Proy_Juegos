package com.example.proy_juegos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity8 extends AppCompatActivity {
  TextView puntaje;
  TextView intentos;
  TextView intentosTotales;

  // id de imagenes
  ImageView iv_11;
  ImageView iv_12;
  ImageView iv_13;
  ImageView iv_14;
  ImageView iv_21;
  ImageView iv_22;
  ImageView iv_23;
  ImageView iv_24;
  ImageView iv_31;
  ImageView iv_32;
  ImageView iv_33;
  ImageView iv_34;
  Button salida;
  ImageButton play;
  MediaPlayer mp,mpr,mb,mEmpate,mGanar,mPerder;
  // Array para las imagenes
  Integer[] cardArray = {101, 102, 103, 104, 105, 106, 201, 202,
    203, 204, 205, 206};

  // imagenes actuales
  int image101, image102, image103, image104, image105, image106,
    image201, image202, image203, image204, image205, image206;

  int firstCard;
  int secondCard;
  int clickedFirst;
  int clickedSecond;
  int cardNumber = 1;
  int turn0 = 1;
  int turn = 1;
  int turn2 = 1;
  int playersPoints = 0;
  int attempts = 0;
  int attemptsTotals = 0;
  int cpuPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
      puntaje = findViewById(R.id.puntaje);
      intentos = findViewById(R.id.int1);
      intentosTotales = findViewById(R.id.intentosTotales);
      salida=(Button) findViewById(R.id.buttonSalir2);
      play=(ImageButton) findViewById(R.id.sonido2);
      mp= MediaPlayer.create(this,R.raw.tapio);

      play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if(view.getId()==R.id.sonido2){
            if(mp.isPlaying()){
              mp.pause();
              play.setBackgroundResource(R.drawable.pause);
              Toast.makeText(MainActivity8.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
              mp.start();
              play.setBackgroundResource(R.drawable.play);
              Toast.makeText(MainActivity8.this,"Play",Toast.LENGTH_SHORT).show();

            }
          }
        }
      });
      mpr=MediaPlayer.create(this,R.raw.pacman);
      mb=MediaPlayer.create(this,R.raw.boton);
      mEmpate=MediaPlayer.create(this,R.raw.empate);
      mGanar=MediaPlayer.create(this,R.raw.ganaste);
      mPerder=MediaPlayer.create(this,R.raw.perdiste);
      mp.setLooping(true);
      mp.start();
      iv_11 = findViewById(R.id.iv_11);
      iv_12 = findViewById(R.id.iv_12);
      iv_13 = findViewById(R.id.iv_13);
      iv_14 = findViewById(R.id.iv_14);
      iv_21 = findViewById(R.id.iv_21);
      iv_22 = findViewById(R.id.iv_22);
      iv_23 = findViewById(R.id.iv_23);
      iv_24 = findViewById(R.id.iv_24);
      iv_31 = findViewById(R.id.iv_31);
      iv_32 = findViewById(R.id.iv_32);
      iv_33 = findViewById(R.id.iv_33);
      iv_34 = findViewById(R.id.iv_34);

      // etiquetar id de imagenes
      iv_11.setTag("0");
      iv_12.setTag("1");
      iv_13.setTag("2");
      iv_14.setTag("3");
      iv_21.setTag("4");
      iv_22.setTag("5");
      iv_23.setTag("6");
      iv_24.setTag("7");
      iv_31.setTag("8");
      iv_32.setTag("9");
      iv_33.setTag("10");
      iv_34.setTag("11");

      salida.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent i= new Intent(MainActivity8.this,MainActivity4.class);
          startActivity(i);
        }
      });
      // cargando las imagenes
      frontOfCardsResources();

      // barajea las imagenes
      Collections.shuffle(Arrays.asList(cardArray));

      // cambia el color del jugador 2
//        tv_p2.setTextColor(Color.GRAY);

      iv_11.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_11, theCard);
        }
      });

      iv_12.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_12, theCard);

        }
      });

      iv_13.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_13, theCard);

        }
      });

      iv_14.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_14, theCard);

        }
      });

      iv_21.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_21, theCard);

        }
      });

      iv_22.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_22, theCard);

        }
      });

      iv_23.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_23, theCard);

        }
      });

      iv_24.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_24, theCard);

        }
      });

      iv_31.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_31, theCard);

        }
      });

      iv_32.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_32, theCard);

        }
      });

      iv_33.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_33, theCard);

        }
      });

      iv_34.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          mb.start();
          int theCard = Integer.parseInt((String) v.getTag());
          doStuff(iv_34, theCard);

        }
      });
    }

  private void doStuff(ImageView iv, int card) {

    // manda las imagenes correctas al imageview
    if (cardArray[card] == 101) {
      iv.setImageResource(image101);
    } else if (cardArray[card] == 102) {
      iv.setImageResource(image102);
    } else if (cardArray[card] == 103) {
      iv.setImageResource(image103);
    } else if (cardArray[card] == 104) {
      iv.setImageResource(image104);
    } else if (cardArray[card] == 105) {
      iv.setImageResource(image105);
    } else if (cardArray[card] == 106) {
      iv.setImageResource(image106);
    } else if (cardArray[card] == 201) {
      iv.setImageResource(image201);
    } else if (cardArray[card] == 202) {
      iv.setImageResource(image202);
    } else if (cardArray[card] == 203) {
      iv.setImageResource(image203);
    } else if (cardArray[card] == 204) {
      iv.setImageResource(image204);
    } else if (cardArray[card] == 205) {
      iv.setImageResource(image205);
    } else if (cardArray[card] == 206) {
      iv.setImageResource(image206);
    }


    // busca cual imagen seleccionar y salva temporalmente
    if (cardNumber == 1) {
      firstCard = cardArray[card];
      if (firstCard > 200) {
        firstCard = firstCard - 100;
      }

      cardNumber = 2;
      clickedFirst = card;
      iv.setEnabled(false);

    } else if (cardNumber == 2) {

      secondCard = cardArray[card];
      if (secondCard > 200) {
        secondCard = secondCard - 100;
      }

      cardNumber = 1;
      clickedSecond = card;

      iv_11.setEnabled(false);
      iv_12.setEnabled(false);
      iv_13.setEnabled(false);
      iv_14.setEnabled(false);
      iv_21.setEnabled(false);
      iv_22.setEnabled(false);
      iv_23.setEnabled(false);
      iv_24.setEnabled(false);
      iv_31.setEnabled(false);
      iv_32.setEnabled(false);
      iv_33.setEnabled(false);
      iv_34.setEnabled(false);

      Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          // verifica si la imagen seleccionada es igual
          calculate();
        }
      }, 500);
    }
  }

  private void calculate() {
    // si las imagenes son iguales remueve la etiqueta (tag)
    // y la adiere al punto

    // turn0 1 para activarse los intentos totales
    if (turn0 == 1) {
      attemptsTotals++;
      intentosTotales.setText("Intentos Totales:" + attemptsTotals);
    }

    if (firstCard == secondCard) {
      if (clickedFirst == 0) {
        iv_11.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 1) {
        iv_12.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 2) {
        iv_13.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 3) {
        iv_14.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 4) {
        iv_21.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 5) {
        iv_22.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 6) {
        iv_23.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 7) {
        iv_24.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 8) {
        iv_31.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 9) {
        iv_32.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 10) {
        iv_33.setVisibility(View.INVISIBLE);
      } else if (clickedFirst == 11) {
        iv_34.setVisibility(View.INVISIBLE);
      }

      /////////////////////////////////////////
      if (clickedSecond == 0) {
        iv_11.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 1) {
        iv_12.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 2) {
        iv_13.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 3) {
        iv_14.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 4) {
        iv_21.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 5) {
        iv_22.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 6) {
        iv_23.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 7) {
        iv_24.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 8) {
        iv_31.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 9) {
        iv_32.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 10) {
        iv_33.setVisibility(View.INVISIBLE);
      } else if (clickedSecond == 11) {
        iv_34.setVisibility(View.INVISIBLE);
      }

      // turn 1 para activarse los completados
      if (turn == 1) {
        playersPoints++;
        puntaje.setText("Completados:" + playersPoints);
        // se verifica si hubo un par completo de cualquiera de los 6, y si es el caso
        // resetea los intentos fallidos a cero para que tenga otras tres oportunidades
        // por cada par encontrado
        verificarIntentosCompletados();
      }



    } else {
      iv_11.setImageResource(R.drawable.rugrats);
      iv_12.setImageResource(R.drawable.rugrats);
      iv_13.setImageResource(R.drawable.rugrats);
      iv_14.setImageResource(R.drawable.rugrats);
      iv_21.setImageResource(R.drawable.rugrats);
      iv_22.setImageResource(R.drawable.rugrats);
      iv_23.setImageResource(R.drawable.rugrats);
      iv_24.setImageResource(R.drawable.rugrats);
      iv_31.setImageResource(R.drawable.rugrats);
      iv_32.setImageResource(R.drawable.rugrats);
      iv_33.setImageResource(R.drawable.rugrats);
      iv_34.setImageResource(R.drawable.rugrats);



      // turn 2 para activarse los fallidos
      if (turn2 == 1) {
        attempts++;
        intentos.setText("Fallidos:" + attempts);
        if (attempts == 5) {
          verificarIntentosFallidos();
        }
      }
    }

    iv_11.setEnabled(true);
    iv_12.setEnabled(true);
    iv_13.setEnabled(true);
    iv_14.setEnabled(true);
    iv_21.setEnabled(true);
    iv_22.setEnabled(true);
    iv_23.setEnabled(true);
    iv_24.setEnabled(true);
    iv_31.setEnabled(true);
    iv_32.setEnabled(true);
    iv_33.setEnabled(true);
    iv_34.setEnabled(true);

    // verifica si el juego termino
    checkEnd();

  }

  private void checkEnd() {
    if (iv_11.getVisibility() == View.INVISIBLE &&
      iv_12.getVisibility() == View.INVISIBLE &&
      iv_13.getVisibility() == View.INVISIBLE &&
      iv_14.getVisibility() == View.INVISIBLE &&
      iv_21.getVisibility() == View.INVISIBLE &&
      iv_22.getVisibility() == View.INVISIBLE &&
      iv_23.getVisibility() == View.INVISIBLE &&
      iv_24.getVisibility() == View.INVISIBLE &&
      iv_31.getVisibility() == View.INVISIBLE &&
      iv_32.getVisibility() == View.INVISIBLE &&
      iv_33.getVisibility() == View.INVISIBLE &&
      iv_34.getVisibility() == View.INVISIBLE) {
      AlertDialog.Builder alertDialogBuilder = new
        AlertDialog.Builder(MainActivity8.this);
      mGanar.start();
      alertDialogBuilder.setMessage("Felicidades haz ganado")
        //alertDialogBuilder.setMessage("Ganaste\nP1:"+playersPoints+"\nP2:" + cpuPoints)
        //alertDialogBuilder.setMessage("Ganaste\nP1:" + playersPoints + "\nP2:" + cpuPoints)
        .setCancelable(false)
        .setPositiveButton("De Nuevo", new
          DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
              startActivity(intent);
              finish();
            }
          })
        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {

            finish();
            ;
          }
        });
      AlertDialog alertDialog = alertDialogBuilder.create();
      alertDialog.show();
    }
  }


  private void intentosMaximos() {
    AlertDialog.Builder alertDialogBuilder = new
      AlertDialog.Builder(MainActivity8.this);
    mPerder.start();
    alertDialogBuilder.setMessage("Solo tienes 5 intentos por PAR")
      //alertDialogBuilder.setMessage("Ganaste\nP1:"+playersPoints+"\nP2:" + cpuPoints)
      //alertDialogBuilder.setMessage("Ganaste\nP1:" + playersPoints + "\nP2:" + cpuPoints)
      .setCancelable(false)
      .setPositiveButton("DE NUEVO", new
        DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(getApplicationContext(), MainActivity8.class);
            startActivity(intent);
            finish();
          }
        })
      .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          finish();
          ;
        }
      });
    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
  }

  private void frontOfCardsResources() {

    image101 = R.drawable.carlitos;
    image102 = R.drawable.angelica;
    image103 = R.drawable.tommy;
    image104 = R.drawable.gemelas;
    image105 = R.drawable.kimi;
    image106 = R.drawable.suzie;
    image201 = R.drawable.carlitos2;
    image202 = R.drawable.angelica2;
    image203 = R.drawable.tommy2;
    image204 = R.drawable.gemelas2;
    image205 = R.drawable.kimi2;
    image206 = R.drawable.suzie2;

  }

  private void verificarIntentosCompletados() {
    if (playersPoints == 1) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (playersPoints == 2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (playersPoints == 3) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (playersPoints == 4) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (playersPoints == 5) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (playersPoints == 6) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
  }

  private void verificarIntentosFallidos() {

    if (image101 == R.drawable.carlitos && image201 == R.drawable.carlitos2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
      if (attempts == 0) {
        intentosMaximos();
      }
    }
    if (image102 == R.drawable.angelica && image202 == R.drawable.angelica2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
      if (attempts == 0) {
        intentosMaximos();
      }
    }
    if (image103 == R.drawable.tommy && image203 == R.drawable.tommy2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
      if (attempts == 0) {
        intentosMaximos();
      }
    }
    if (image104 == R.drawable.gemelas && image204 == R.drawable.gemelas2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
      if (attempts == 0) {
        intentosMaximos();
      }
    }
    if (image105 == R.drawable.kimi && image205 == R.drawable.kimi2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
    }
    if (image106 == R.drawable.suzie && image206 == R.drawable.suzie2) {
      attempts = 0;
      intentos.setText("Fallidos:" + attempts);
      if (attempts == 0) {
        intentosMaximos();
      }
    }
  }
}
