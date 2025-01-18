package models;

import interfaces.IFuncionesAnimales;

public abstract class Animal extends Entidad implements IFuncionesAnimales {

    protected int edad=0,edadMaxima,edadAdulta;//Solamente cuando se llega a edad adulta el animal se puede aparear

    protected int vision,alcance;

    protected double peso,pesoInicial,pesoMinimo,pesoMaximo;

    protected String sexo;//Se necesitan dos generos opuestos para el apareamiento

    protected int fuerzaAtaque,fuerzaDefensa;//Es especifico para cada especie y hasta que se llegue a la edad adulta el animal solo tiene el 50% del valor

    protected double perdidaPorAtaque,perdidaPorDefensa;//Se calculara usando porcentajes no un valor fijo







    public Animal(int posColumna, int posFila, char simbolo) {
        super(posColumna, posFila, simbolo);
        this.edad = 0;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getEdadAdulta() {
        return edadAdulta;
    }

    public void setEdadAdulta(int edadAdulta) {
        this.edadAdulta = edadAdulta;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getFuerzaAtaque() {
        return fuerzaAtaque;
    }

    public void setFuerzaAtaque(int fuerzaAtaque) {
        this.fuerzaAtaque = fuerzaAtaque;
    }

    public int getFuerzaDefensa() {
        return fuerzaDefensa;
    }

    public void setFuerzaDefensa(int fuerzaDefensa) {
        this.fuerzaDefensa = fuerzaDefensa;
    }

    public double getPerdidaPorAtaque() {
        return perdidaPorAtaque;
    }

    public void setPerdidaPorAtaque(double perdidaPorAtaque) {
        this.perdidaPorAtaque = perdidaPorAtaque;
    }

    public double getPerdidaPorDefensa() {
        return perdidaPorDefensa;
    }

    public void setPerdidaPorDefensa(double perdidaPorDefensa) {
        this.perdidaPorDefensa = perdidaPorDefensa;
    }


}
