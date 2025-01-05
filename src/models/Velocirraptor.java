package models;

import controller.GeneradorEntidad;

import java.util.List;

public class Velocirraptor extends Animal{

    public Velocirraptor(int posColumna, int posFila, char simbolo,int contCodigo) {
        super(posColumna, posFila, simbolo);
        this.setCodigo("V"+String.valueOf(contCodigo));
        this.setEdadMaxima(8);//Establecer edad maxima pues son los mas longevos

        //Inicializar el resto de atributos especificos del animal


    }
    GeneradorEntidad generadorEntidad = new GeneradorEntidad();
    @Override
    public void jugar(List<Entidad> entidades, int me) {
        this.edad++;
        morir();
        if(!isVivo()){
            Cadaver cadaver = new Cadaver(this.posColumna,this.posFila,'C',generadorEntidad.contC);
            generadorEntidad.contC++;
            entidades.add(cadaver);
        }
        else
        {
            //Implementar resto de las acciones segun la estrategia del animal
        }
    }

    @Override
    public char simbolo() {
        return this.simbolo;
    }

    //Acciones del animal

    @Override
    public void comer() {

    }

    @Override
    public void morir() {

        if(this.getEdad()>this.getEdadMaxima()){this.setVivo(false);}

    }

    @Override
    public void desplazarse() {

    }

    @Override
    public void avisar() {

    }

    @Override
    public void insepccionar() {

    }

    @Override
    public void aparearse() {

    }

    @Override
    public void atacar() {

    }

    @Override
    public void defender() {

    }


}
