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

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    EditText user,pass;
    ImageButton btnIngresar;
    Button btnRegistrar;
    MediaPlayer mp,mb;
    ImageButton play;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user=(EditText) findViewById(R.id.textUsuario);
        pass=(EditText) findViewById(R.id.textPass);
        btnIngresar=(ImageButton)findViewById(R.id.imageButtonIng);
        btnRegistrar=(Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao= new daoUsuario(this);

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
                Toast.makeText(MainActivity2.this,"Pausa",Toast.LENGTH_SHORT).show();
            }else{
                mp.start();
                play.setBackgroundResource(R.drawable.play);
                Toast.makeText(MainActivity2.this,"Play",Toast.LENGTH_SHORT).show();

            }
        }
        switch (v.getId()){
            case R.id.imageButtonIng:
                mb.start();
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "Introduce datos",Toast.LENGTH_LONG).show();

                }else if (dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos Correctos",Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(MainActivity2.this,MainActivity4.class);
                    mp.pause();
                    i2.putExtra("id",ux.getId());
                    i2.putExtra("jugador",u);
                    startActivity(i2);
                }else{
                    Toast.makeText(this, "Datos Incorrectos",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnIngresar:
                mb.start();
                mp.pause();
                Intent i= new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);
                break;

        }
    }
}