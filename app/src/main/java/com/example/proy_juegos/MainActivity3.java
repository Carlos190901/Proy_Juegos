package com.example.proy_juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    EditText us,pas;
    ImageButton reg,play;
    Button can;
    daoUsuario dao;
    String uUsuario=null;
    String pasContraseña=null;
    MediaPlayer mp,mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        us=(EditText) findViewById(R.id.textUsuario);
        pas=(EditText) findViewById(R.id.textPass);
        reg=(ImageButton)findViewById(R.id.imageButtonIng);
        can=(Button) findViewById(R.id.btnIngresar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);

        dao=new daoUsuario(this);

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
                Toast.makeText(MainActivity3.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
                mp.start();
                play.setBackgroundResource(R.drawable.play);
                Toast.makeText(MainActivity3.this,"Play",Toast.LENGTH_SHORT).show();

            }
        }
        switch (v.getId()){
            case R.id.imageButtonIng:
                mb.start();
                Usuario u=new Usuario();
                u.setCorreo(us.getText().toString());
                u.setContraseña(pas.getText().toString());

                uUsuario=us.getText().toString();
                pasContraseña=pas.getText().toString();
                if ("".equals(uUsuario)){
                    us.setError("introduce un correo");
                    us.requestFocus();
                    return;
                }else {
                    if ("".equals(pasContraseña)){
                        pas.setError("introduce una contraseña");
                        pas.requestFocus();
                        return;
                    }else{
                        if (!u.isNull()){
                            Toast.makeText(this, "Introduce datos",Toast.LENGTH_LONG).show();
                        }
                        else if(dao.insertUsuario(u)){
                            Toast.makeText(this,"Registro existoso",Toast.LENGTH_LONG).show();
                            Intent i2= new Intent(MainActivity3.this,MainActivity4.class);
                            mp.pause();
                            i2.putExtra("jugador",uUsuario);
                            startActivity(i2);
                        }else{
                            Toast.makeText(this,"El Usuario ya Existe",Toast.LENGTH_LONG).show();

                        }
                    }
                }
                mp.pause();
                break;
            case R.id.btnIngresar:
                mb.start();
                mp.pause();
                Intent i= new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(i);
                break;

        }
    }
    }
