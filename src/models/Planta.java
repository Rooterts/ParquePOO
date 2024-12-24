package models;

import java.util.List;

public class Planta extends Entidad {

    private float pesoExtinciøn;
    private float pesoInicial;
    private float aumentoCrecimiento;

    public Planta(int posColumna, int posFila,char simbolo, float pesoExtinciøn, float pesoInicial, float aumentoCrecimiento) {
        super(posColumna, posFila, simbolo);
        this.pesoExtinciøn = pesoExtinciøn;
        this.pesoInicial = pesoInicial;
        this.aumentoCrecimiento = aumentoCrecimiento;
    }


    @Override
    public void jugar(List<Entidad> entidades, int me) {
        if(pesoInicial<pesoExtinciøn) setVivo(false);
        else pesoInicial+=aumentoCrecimiento;
    }

    @Override
    public char simbolo() {
        return 'P';
    }
}
