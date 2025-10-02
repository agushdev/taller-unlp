package tema1;
import PaqueteLectura.GeneradorAleatorio;
public class ej1 {
    public static void main(String[] args) {
        
        /* Genere enteros aleatorios hasta obtener el número 11. Para cada número muestre
        el resultado de multiplicarlo por 2 (accediendo al vector). */
        
        GeneradorAleatorio.iniciar();
        int DF=11;  
        int num, i;
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        
        for (i=0;i<DF;i++) {
            num= GeneradorAleatorio.generarInt(12);
            tabla2[i]= 2*num;
            System.out.println("2 x " + num + " = " + tabla2[i]);
        }
    }
}
