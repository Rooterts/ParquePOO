package controller;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorEntidad {

    public int contA=0,contB=0,contT=0,contR=0,contV=0,contP=0,contC=0;

    private char [] entidadesSimbol = {'P','B','T','R','V','A','C'};
    public GeneradorEntidad() {
    }
    public List<Entidad> generarEntidades(int cantidad,int filas,int columnas){
        List<Entidad> entidades = new ArrayList<>();
        while (cantidad>0){
            int x = generarNumeroAleatorio(0,entidadesSimbol.length-1);
            Entidad entidad= generarEntidad(entidadesSimbol[x],filas,columnas);
            if(entidad!=null && posicionOcupada(entidad,entidades) == false){ entidades.add(entidad); cantidad--; }
        }
        return entidades;
    }

    private boolean posicionOcupada(Entidad entidad, List<Entidad> entidades) {
        for(Entidad x : entidades){
            if(x.getPosColumna()==entidad.getPosColumna() &&
                    x.getPosFila()==entidad.getPosFila()){
                return true;
            }
        }
        return false;
    }

    private Entidad generarEntidad(char x,int filas,int columnas) {
        Entidad y = null;

        switch(x)
        {
            case 'A': y= generarPlanta(filas,columnas,x,contA);contA++;break;
            case 'B': y= generarBraquiosaurio(filas,columnas,x,contB);contB++;break;
            case 'T': y= generarTriceratops(filas,columnas,x,contT);contT++;break;
            case 'P': y= generarPterodactilo(filas,columnas,x,contP);contP++;break;
            case 'R': y= generarT_Rex(filas,columnas,x,contR);contR++;break;
            case 'V': y= generarVelocirraptor(filas,columnas,x,contV);contV++;break;
        }
        return y;
    }

    private Entidad generarBraquiosaurio(int filas,int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        Braquiosaurio p = new Braquiosaurio(c,f,simbolo,cont);
        return p;
    }

    private Entidad generarTriceratops(int filas,int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        Triceratops p = new Triceratops(c,f,simbolo,cont);
        return p;
    }

    private Entidad generarT_Rex(int filas,int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        T_Rex p = new T_Rex(c,f,simbolo,cont);
        return p;
    }

    private Entidad generarVelocirraptor(int filas,int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        Velocirraptor p = new Velocirraptor(c,f,simbolo,cont);
        return p;
    }

    private Entidad generarPterodactilo(int filas,int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        Pterodactilo p = new Pterodactilo(c,f,simbolo,cont);
        return p;
    }

    public Entidad generarPlanta(int filas, int columnas, char simbolo,int cont) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        float pesoInicial = generarNumeroAleatorio(10,100);
        float pesoExtinciøn = generarNumeroAleatorio(1,(int)pesoInicial-3);
        Planta p = new Planta(c,f,simbolo, pesoExtinciøn, pesoInicial,2,cont);
        return p;
    }

    public Entidad generarCadaver(int filas,int columnas, char simbolo, int cont){
        Cadaver p = new Cadaver(filas,columnas,simbolo,cont);
        contC++;

        return p;

    }

    public static int generarNumeroAleatorio(int min, int max){
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
