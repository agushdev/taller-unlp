package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ej3 {
    public static void main(String[] args) {
        
        /* Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice
        la matriz con números aleatorios entre 0 y 30.
        Luego realice las siguientes operaciones:
        - Mostrar el contenido de la matriz en consola.
        - Calcular e informar la suma de los elementos de la fila 1
        - Generar un vector de 5 posiciones donde cada posición j contiene la suma
        de los elementos de la columna j de la matriz. Luego, imprima el vector.
        - Leer un valor entero e indicar si se encuentra o no en la matriz. En caso de
        encontrarse indique su ubicación (fila y columna) en caso contrario
        imprima “No se encontró el elemento”.
        */
        
        GeneradorAleatorio.iniciar();
        int[][] matriz = new int[5][5];
        int i,j, filaUno=0,num;
        int df=5;
        int[] vector = new int[5];
        boolean encontro=false;
        
        // Generar matriz
        for (i=0; i<df; i++){
            for (j=0; j<df; j++){
                matriz[i][j]= GeneradorAleatorio.generarInt(50);
            }
        }
        
        // Imprimir matriz
        System.out.println("--- Contenido de la Matriz ---");
        
        for (i=0; i<df; i++){
            for (j=0; j<df; j++){
                System.out.print("(" + i + "," + j + ") [" + matriz[i][j] + "] | ");
            }
            System.out.println(); 
        }
        
        // Calcular suma de fila 1
        for (j=0; j<df; j++){
            filaUno+= matriz[0][j];
        }
        System.out.println("Total de la fila uno = " + filaUno);
        
        // Generar vector donde cada posicion j es la suma de los elementos de la columna
        for (i=0;i<df;i++){
            for (j=0;j<df;j++){
                vector[j] += matriz[i][j];
            }
        }
        System.out.println("----vector-----");
            for(i=0; i<5; i ++){
                System.out.println("Suma Columna" +  i + ": " + vector[i] + ", ");
            }
        System.out.println("Ingresa un numero a buscar en el vector: ");
        num= Lector.leerInt();
        i=0;
        // Imaginando que no hay repetidos, utilizo un while para mayor eficacia
        while (i<df && !encontro){
            j=0;
            while(j<df && !encontro){
                if(matriz[i][j] == num){
                    encontro= true;
                    System.out.print("Se encontro el valor: " + num + " en la posicion " + "(" + i + "," + j + ")");
                } 
                j++;
            }
            i++;
        }
        if (!encontro){
            System.out.println("No se encontro el elemento " + num);
        }
    }
}
