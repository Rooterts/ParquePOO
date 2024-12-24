package models;

import java.util.List;

public abstract class Entidad {
    protected int posFila;
    protected int posColumna;
    protected char simbolo;
    protected boolean vivo;

    public Entidad(int posColumna, int posFila, char simbolo) {
        this.posColumna = posColumna;
        this.posFila = posFila;
        this.simbolo = simbolo;
        this.vivo = true;
    }

    public abstract void jugar(List<Entidad> entidades,int me);


    public abstract char simbolo();

    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
