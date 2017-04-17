package com.passstorer.contraseasseguras;

/**
 * Created by lau on 15/04/17.
 */

public class DatosUsuario {

    private String nombreServicio;
    private String usuario;
    private String email;
    private String passw;
    private String datosExtras;


    public DatosUsuario(String n,String u, String e, String p, String  d){
        this.nombreServicio = n ;
        this.usuario = u;
        this.email = e;
        //opciones para mostrar la contraseña:
        //  1- Sacarla encriptada de la db, desencriptarla y ponerla en el textview
        //  2- Sacarla encriptada de la db, dejarla encriptada en el textview, cuando se presione el
        //      boton para mostrarla se desencripta y se muestra, cuando se suelta el boton se vuelve a encriptar
        this.passw = p;
        this.datosExtras = d;
    }

    public String getNombreServicio(){
        return this.nombreServicio;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getEmail() {
        return email;
    }
    public String getPassw() {
        return passw;
    }
    public String getDatosExtras() {
        return datosExtras;
    }
}
