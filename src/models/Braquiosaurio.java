package models;

import java.util.List;

public class Braquiosaurio extends Animal{


    public Braquiosaurio(int posColumna, int posFila, char simbolo, int edadMaxima, int vision) {
        super(posColumna, posFila, simbolo, edadMaxima, vision);
    }

    @Override
    public void jugar(List<Entidad> entidades, int me) {
        this.edad++;
        morir();
        if(!isVivo()){
            Cadaver cadaver = new Cadaver(this.posColumna,this.posFila,'C');
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

    @Override
    public void morir() {
        if(edad > edadMaxima) {setVivo(false);}
    }
}
