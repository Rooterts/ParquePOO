package controller;

import models.Braquiosaurio;
import models.Entidad;
import models.Planta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorEntidad {
    private char [] entidadesSimbol = {'P','B'};
    public GeneradorEntidad() {
    }
    public List<Entidad> generarEntidades(int cantidad,int filas,int columnas){
        List<Entidad> entidades = new ArrayList<>();
        while (cantidad>0){
            int x = generarNumeroAleatorio(0,entidadesSimbol.length-1);
            Entidad entidad= generarEntidad( entidadesSimbol[x],filas,columnas);
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
            case 'P': y= generarPlanta(filas,columnas,x);break;
            case 'B': y= generarBraquiosaurio(filas,columnas,x);break;
        }
        return y;
    }

    private Entidad generarBraquiosaurio(int filas,int columnas, char simbolo) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        Braquiosaurio p = new Braquiosaurio(c,f,simbolo, 12,15);
        return p;
    }

    private Entidad generarPlanta(int filas, int columnas,char simbolo) {
        int f = generarNumeroAleatorio(0,filas-1);
        int c = generarNumeroAleatorio(0,columnas-1);
        float pesoInicial = generarNumeroAleatorio(10,100);
        float pesoExtinciøn = generarNumeroAleatorio(1,(int)pesoInicial-3);
        Planta p = new Planta(c,f,simbolo, pesoExtinciøn, pesoInicial,2);
        return p;
    }

    public static int generarNumeroAleatorio(int min, int max){
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
