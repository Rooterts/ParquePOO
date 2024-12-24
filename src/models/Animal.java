package models;

import interfaces.IMorir;

public abstract class Animal extends Entidad implements IMorir {

    protected int edad;
    protected int edadMaxima;
    protected int vision;

    public Animal(int posColumna, int posFila, char simbolo, int edadMaxima, int vision) {
        super(posColumna, posFila, simbolo);
        this.edad = 0;
        this.edadMaxima = edadMaxima;
        this.vision = vision;
    }


}
