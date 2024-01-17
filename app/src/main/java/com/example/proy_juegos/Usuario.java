package com.example.proy_juegos;

public class Usuario {
    int id;
    String correo, contraseña;

    public  Usuario(){

    }

    public Usuario(String correo, String contraseña) {

        this.correo = correo;
        this.contraseña = contraseña;
    }

    public  boolean isNull(){
        if(correo.equals("")&&contraseña.equals("")){
            return  false;
        }else{
            return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
