package models;

import controller.GeneradorEntidad;

import java.util.List;

public class Cadaver extends Entidad{
    private int deteriorase;

    public Cadaver(int posColumna, int posFila, char simbolo) {
        super(posColumna, posFila, simbolo);
        deteriorase = 3;
    }

    @Override
    public void jugar(List<Entidad> entidades, int me) {
        deteriorase--;
        if(deteriorase <= 0) {
            this.vivo = false;
            int numero = GeneradorEntidad.generarNumeroAleatorio(1,5);
            if(numero %2 == 0){
                float pesoInicial = GeneradorEntidad.generarNumeroAleatorio(10,100);
                float pesoExtinciøn = GeneradorEntidad.generarNumeroAleatorio(1,(int)pesoInicial-3);
                Planta planta = new Planta(this.getPosColumna(),this.getPosFila(),'P',pesoExtinciøn,pesoInicial,2);
                entidades.add(planta);
            }
        }
    }

    @Override
    public char simbolo() {
        return this.simbolo;
    }
}
