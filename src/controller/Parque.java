package controller;

import models.Entidad;
import models.Planta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parque{
    private int filas;
    private int columnas;
    private int ciclos;
    private GeneradorEntidad generadorEntidad;
    private List<Entidad> entidades;
    private char [] []  mapa;

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public GeneradorEntidad getGeneradorEntidad() {
        return generadorEntidad;
    }

    public void setGeneradorEntidad(GeneradorEntidad generadorEntidad) {
        this.generadorEntidad = generadorEntidad;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    public char[][] getMapa() {
        return mapa;
    }

    public void setMapa(char[][] mapa) {
        this.mapa = mapa;
    }

    public Parque(int filas, int columnas, int ciclos) {
        this.filas = filas;
        this.columnas = columnas;
        this.ciclos = ciclos;
        this.generadorEntidad = new GeneradorEntidad();
        this.mapa = new char[20][20];
        limpiarMapa();
        this.entidades = this.generadorEntidad.generarEntidades(/*GeneradorEntidad.generarNumeroAleatorio(Math.min(filas,columnas),
                filas*columnas-(filas+columnas))*/20,filas, columnas);//Puse un limite de 20 entidades solamente para probar el programa
    }

    private void limpiarMapa() {
        for (int i = 0; i < filas; i++) {
            Arrays.fill(this.mapa[i], '.');
        }
    }

    public boolean simulacion(){
        if(ciclos == 0){ return false; }
        else
        {
            int n = entidades.size();
            for(int i = 0; i < n; i++)
            {
                entidades.get(i).jugar(entidades,i);
            }
            eventoAleatorio();
            eliminarMuertos();
            ciclos--;
            actualizarMapa();
            return true;
        }
    }

    private void eliminarMuertos() {
        int index = 0;
        while(index < entidades.size()){
            if(!entidades.get(index).isVivo()){
                entidades.remove(index);
            }else{
                index++;
            }
        }
    }

    private void actualizarMapa() {
        limpiarMapa();
        for(Entidad entidade: entidades){
            mapa[entidade.getPosFila()][entidade.getPosColumna()] = entidade.simbolo();
        }
    }

    private void eventoAleatorio() {
        int evento = GeneradorEntidad.generarNumeroAleatorio(1,10);
        if(evento == 5){ //Plaga en la plantas
            plagaPlantas();
        }

    }

    private void plagaPlantas() {
        int f = GeneradorEntidad.generarNumeroAleatorio(0,this.filas-1);
        int c = GeneradorEntidad.generarNumeroAleatorio(0,this.columnas-1);

        int f1 = f-1;
        int f2 = f+1;
        int c1 = c-1;
        int c2 = c+1;

        for(Entidad entidade: entidades){
            if(entidade instanceof Planta){
                if(f1<= entidade.getPosFila() && entidade.getPosFila()<= f2 &&
                        c1<= entidade.getPosColumna() && entidade.getPosColumna()<= c2){
                    entidade.setVivo(false);
                }
            }
        }
    }

}

