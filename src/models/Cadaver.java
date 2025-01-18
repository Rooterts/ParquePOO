package models;

import controller.GeneradorEntidad;

import java.util.List;

public class Cadaver extends Entidad{
    private int deteriorase;
    GeneradorEntidad generadorEntidad = new GeneradorEntidad();


    public Cadaver(int posColumna, int posFila, char simbolo,int contCodigo) {
        super(posColumna, posFila, simbolo);
        deteriorase = 3;
        this.setCodigo("C"+String.valueOf(contCodigo));
        generadorEntidad.contC++;
    }

    @Override
    public void jugar(List<Entidad> entidades, int me) {
        deteriorase--;
        if(deteriorase <= 0) {
            this.vivo = false;
            int numero = GeneradorEntidad.generarNumeroAleatorio(1,5);
            if(numero %2 == 0){
                GeneradorEntidad generadorEntidad = new GeneradorEntidad();
                float pesoInicial = GeneradorEntidad.generarNumeroAleatorio(10,100);
                float pesoExtinciøn = GeneradorEntidad.generarNumeroAleatorio(1,(int)pesoInicial-3);
                //Planta planta = new Planta(this.getPosColumna(),this.getPosFila(),'P',pesoExtinciøn,pesoInicial,2);
                Entidad planta = generadorEntidad.generarPlanta(this.getPosColumna(),this.getPosFila(),'P',generadorEntidad.contA);
                generadorEntidad.contA++;

                entidades.add(planta);
            }
        }
    }

    @Override
    public char simbolo() {
        return this.simbolo;
    }
}
