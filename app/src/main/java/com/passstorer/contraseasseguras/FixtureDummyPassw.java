package com.passstorer.contraseasseguras;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lau on 15/04/17.
 */

public class FixtureDummyPassw {

    public static ArrayList<DatosUsuario> listaDummyPassw;
    private String todosloschars;

    private String u;
    private String p;
    private Random r;

    public FixtureDummyPassw(int n){
        listaDummyPassw = new ArrayList<DatosUsuario>();
        r = new Random();

        todosloschars = "0123456789abcdefghijklmnopqrstuvwxyz";


        for (int i = 0; i<n; i++){
            agregarDatoUsuarioRandom();
        }
    }

    private void agregarDatoUsuarioRandom(){
        //asignar string random a u y p
        u="";
        p="";
        int tam = todosloschars.length();
        for (int i = 0; i<5;i++) {
            u = u + todosloschars.charAt(r.nextInt(tam));
            p = p + todosloschars.charAt(r.nextInt(tam));
            }
        listaDummyPassw.add(new DatosUsuario(u,u,null,p,null));
    }

    public ArrayList<DatosUsuario> getListaDummyPassw() {
        return listaDummyPassw;
    }

    }
