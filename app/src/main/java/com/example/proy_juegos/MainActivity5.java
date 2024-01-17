package com.example.proy_juegos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {


  ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9;
  private String startGame="X";
  int b1=5,b2=5,b3=5,b4=5,b5=5,b6=5,b7=5,b8=5,b9=5,xCount=0,oCount=0,i=0;
  int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0;
  private TextView scorex,scoreo;
  private Button Reset;
  String nombre_jugador="";
  private TextView tv_nombreJugador;
  String nombre_jugador2="";
  private TextView tv_nombreJugador2;
  MediaPlayer mp,mb,mpr,mEmpate,mGanar,mPerder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

      mp= MediaPlayer.create(this,R.raw.tapio);
      mb=MediaPlayer.create(this,R.raw.boton);
      mp.setLooping(true);
      mp.start();
      mEmpate=MediaPlayer.create(this,R.raw.empate);
      mGanar=MediaPlayer.create(this,R.raw.ganaste);
      mPerder=MediaPlayer.create(this,R.raw.perdiste);

      button1=findViewById(R.id.buttonImage1);
      button2=findViewById(R.id.buttonImage2);

      button3=findViewById(R.id.buttonImage3);

      button4=findViewById(R.id.buttonImage4);

      button5=findViewById(R.id.buttonImage5);
      button6=findViewById(R.id.buttonImage6);
      button7=findViewById(R.id.buttonImage7);
      button8=findViewById(R.id.buttonImage8);
      button9=findViewById(R.id.buttonImage9);

      scorex = findViewById(R.id.ScoreX);
      scoreo = findViewById(R.id.ScoreY);

      Reset=findViewById(R.id.Reset);
      nombre_jugador=getIntent().getStringExtra("jugadorG1");
      this.tv_nombreJugador= findViewById(R.id.ScoreX);
      tv_nombreJugador.setText(nombre_jugador+" :- 0");

      nombre_jugador2=getIntent().getStringExtra("jugadorG2");
      this.tv_nombreJugador2= findViewById(R.id.ScoreY);
      tv_nombreJugador2.setText(nombre_jugador2+" :- 0");
      ImageButton play = (ImageButton) findViewById(R.id.sonido2);

      play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if(view.getId()==R.id.sonido2){
            if(mp.isPlaying()){
              mp.pause();
              play.setBackgroundResource(R.drawable.pause);
              Toast.makeText(MainActivity5.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
              mp.start();
              play.setBackgroundResource(R.drawable.play);
              Toast.makeText(MainActivity5.this,"Play",Toast.LENGTH_SHORT).show();

            }
          }
        }
      });
      Reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (xCount>oCount){
           mGanar.start();
           // Toast.makeText(this, "Ganaste "+ nombre_jugador+" Score: "+scorejugador, Toast.LENGTH_LONG).show();
            mostrarDialogo();

          }else if(oCount>xCount){
            mGanar.start();
            //Toast.makeText(this, "Lo siento "+ nombre_jugador+" Gano la computadora,  Score: "+scoreComputer, Toast.LENGTH_LONG).show();
            mostrarDialogo2();

          }else{
            mEmpate.start();
            mostrarDialogo3();
          }
          /*button1.setImageDrawable(null);
          button2.setImageDrawable(null);
          button3.setImageDrawable(null);
          button4.setImageDrawable(null);
          button5.setImageDrawable(null);
          button6.setImageDrawable(null);
          button7.setImageDrawable(null);
          button8.setImageDrawable(null);
          button9.setImageDrawable(null);
          resetValues();
          xCount=0;
          oCount=0;
          scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));
          scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));*/
        }
      });

      button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();

          if(c1==0) {



            if (startGame.equals("X")) {
              button1.setImageResource(R.drawable.cross);
              b1 = 1;
              i++;
              c1=1;
            } else {
              button1.setImageResource(R.drawable.circle);
              b1 = 0;
              i++;
              c1=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });

      button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c2==0)
          {


            if(startGame.equals("X"))
            {
              button2.setImageResource(R.drawable.cross);
              b2=1;
              i++;
              c2=1;
            }
            else
            {
              button2.setImageResource(R.drawable.circle);
              b2=0;
              i++;
              c2=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });

      button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c3==0)
          {


            if(startGame.equals("X"))
            {
              button3.setImageResource(R.drawable.cross);
              b3=1;
              i++;
              c3=1;
            }
            else
            {
              button3.setImageResource(R.drawable.circle);
              b3=0;
              i++;
              c3=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }


        }
      });

      button4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          mb.start();
          if(c4==0)
          {

            if(startGame.equals("X"))
            {
              button4.setImageResource(R.drawable.cross);
              b4=1;
              i++;
              c4=1;
            }
            else
            {
              button4.setImageResource(R.drawable.circle);
              b4=0;
              i++;
              c4=1;
            }
            choosePlayer();
            winningGame();


          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });

      button5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c5==0)
          {

            if(startGame.equals("X"))
            {
              button5.setImageResource(R.drawable.cross);
              b5=1;
              i++;
              c5=1;
            }
            else
            {
              button5.setImageResource(R.drawable.circle);
              b5=0;
              i++;
              c5=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });


      button6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c6==0)
          {

            if(startGame.equals("X"))
            {
              button6.setImageResource(R.drawable.cross);
              b6=1;
              i++;
              c6=1;
            }
            else
            {
              button6.setImageResource(R.drawable.circle);
              b6=0;
              i++;
              c6=1;
            }
            choosePlayer();
            winningGame();


          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }
        }
      });


      button7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();

          if(c7==0)
          {

            if(startGame.equals("X"))
            {
              button7.setImageResource(R.drawable.cross);
              b7=1;
              i++;
              c7=1;
            }
            else
            {
              button7.setImageResource(R.drawable.circle);
              b7=0;
              i++;
              c7=1;
            }
            choosePlayer();
            winningGame();


          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }
        }
      });

      button8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c8==0)
          {

            if(startGame.equals("X"))
            {
              button8.setImageResource(R.drawable.cross);
              b8=1;
              i++;
              c8=1;
            }
            else
            {
              button8.setImageResource(R.drawable.circle);
              b8=0;
              i++;
              c8=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });

      button9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mb.start();
          if(c9==0)
          {

            if(startGame.equals("X"))
            {
              button9.setImageResource(R.drawable.cross);
              b9=1;
              i++;
              c9=1;
            }
            else
            {
              button9.setImageResource(R.drawable.circle);
              b9=0;
              i++;
              c9=1;
            }
            choosePlayer();
            winningGame();

          }
          else
          {
            Toast.makeText(MainActivity5.this,"Casilla Ocupada",Toast.LENGTH_SHORT).show();
          }

        }
      });
    } //TERMINA ONCREATE


/************+/
 *
 */

private void mostrarDialogo(){
  new android.app.AlertDialog.Builder(this)
          .setTitle("...FELICIDADES GANASTE..."+nombre_jugador)
          .setMessage(" Puntaje " +nombre_jugador+": "+xCount+" Puntaje  "+nombre_jugador2+": "+oCount)
          .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              Log.d("mensaje","Se cancelo");
              mb.start();
              Intent intent=new Intent(MainActivity5.this,MainActivity4.class);
              startActivity(intent);
              finish();
            }
          }).show();
}
  private void mostrarDialogo2(){
    new android.app.AlertDialog.Builder(this)
            .setTitle("...FELICIDADES GANASTE..."+nombre_jugador2)
            .setMessage(" Puntaje"+nombre_jugador2+": "+oCount+ " Puntaje " +nombre_jugador+": "+xCount)
            .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                mb.start();
                Log.d("mensaje","Se cancelo");
                Intent intent=new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
                finish();
              }
            }).show();
  }

  private void mostrarDialogo3(){
    new android.app.AlertDialog.Builder(this)
            .setTitle("...EMPATE...")
            .setMessage(" Puntaje "+nombre_jugador2+": "+oCount+ " Puntaje " +nombre_jugador+": "+xCount)
            .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                mb.start();
                Log.d("mensaje","Se cancelo");
                Intent intent=new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
                finish();
              }
            }).show();
  }
private void winningGame() {


  if((b1==1) && (b2==1) && (b3==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));


  }


  else if((b4==1) && (b5==1) && (b6==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));


  }


  else  if((b7==1) && (b8==1) && (b9==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));





  }

  else  if((b1==1) && (b4==1) && (b7==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));





  }


  else  if((b2==1) && (b5==1) && (b8==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));





  }


  else  if((b3==1) && (b6==1) && (b9==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));





  }


  else  if((b1==1) && (b5==1) && (b9==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));





  }

  else  if((b3==1) && (b5==1) && (b7==1))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    xCount++;
    scorex.setText(nombre_jugador+" :- "+String.valueOf(xCount));


  }

  else  if((b1==0) && (b2==0) && (b3==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }
  else  if((b4==0) && (b5==0) && (b6==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }



  else  if((b7==0) && (b8==0) && (b9==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }


  else  if((b1==0) && (b4==0) && (b7==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }

  else  if((b2==0) && (b5==0) && (b8==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }
  else  if((b3==0) && (b6==0) && (b9==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }
  else  if((b1==0) && (b5==0) && (b9==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }

  else  if((b3==0) && (b5==0) && (b7==0))
  {

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setMessage("EL "+nombre_jugador2+" ES EL GANADOR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        button1.setImageDrawable(null);
        button2.setImageDrawable(null);
        button3.setImageDrawable(null);
        button4.setImageDrawable(null);
        button5.setImageDrawable(null);
        button6.setImageDrawable(null);
        button7.setImageDrawable(null);
        button8.setImageDrawable(null);
        button9.setImageDrawable(null);
        resetValues();
      }
    });

    AlertDialog alertDialog=builder.create();
    alertDialog.show();
    oCount++;
    scoreo.setText(nombre_jugador2+" :- "+String.valueOf(oCount));

  }

  else
  {
    if(i==9)
    {
      AlertDialog.Builder builder=new AlertDialog.Builder(this);
      builder.setMessage("EMPATE").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          button1.setImageDrawable(null);
          button2.setImageDrawable(null);
          button3.setImageDrawable(null);
          button4.setImageDrawable(null);
          button5.setImageDrawable(null);
          button6.setImageDrawable(null);
          button7.setImageDrawable(null);
          button8.setImageDrawable(null);
          button9.setImageDrawable(null);
          resetValues();
        }
      });

      AlertDialog alertDialog=builder.create();
      alertDialog.show();
    }

  }

}
/*********/
private void choosePlayer() {
  if(startGame.equals("X"))
  {
    startGame="O";
  }
  else
  {
    startGame="X";
  }
}

/*******/
private void resetValues() {

  b1=5;
  b2=5;;
  b3=5;
  b4=5;
  b5=5;
  b6=5;
  b7=5;
  b8=5;
  b9=5;
  i=0;
  c1=0;
  c2=0;

  c3=0;
  c4=0;
  c5=0;
  c6=0;
  c7=0;
  c8=0;
  c9=0;




}
}
