import controller.GeneradorEntidad;
import controller.Parque;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int filas = GeneradorEntidad.generarNumeroAleatorio(5,10);
        int columnas = GeneradorEntidad.generarNumeroAleatorio(5,10);
        int ciclos = GeneradorEntidad.generarNumeroAleatorio(15,25);
        Parque parque = new Parque(filas, columnas, ciclos);
        System.out.println("Parque generado");
        int iteraciones = 0;
        while(parque.simulacion()){
            iteraciones++;
            System.out.println("Ciclo: "+iteraciones);
            for(int i=0;i<parque.getFilas();i++){
                for(int j=0;j<parque.getColumnas();j++){
                    System.out.print(parque.getMapa()[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}