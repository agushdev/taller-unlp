package tema1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class ej4 {
    public static void main(String[] args) {
        /*
            Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
            (1..4). Realice un programa que permita informar la cantidad de personas que
            concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
            edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
            oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
            de piso 9. Al finalizar la llegada de personas, informe lo pedido. 
        */
        int pisos=8, oficinas=4, i, j;
        int matriz[][]= new int[pisos][oficinas];
        int piso=0,oficina; // Datos a leer.
        
        // Inicializar matriz en 0
        for (i=0;i<pisos;i++){
            for (j=0;j<oficinas;j++){
                matriz[i][j]= 0;
            }
        }
        
        // Llenamos de datos, corta con piso 9.
        while (piso <= 8){
            System.out.println("Ingresa nro de piso: ");
            piso= Lector.leerInt();
            System.out.println("Ingresa nro de oficina: ");
            oficina= Lector.leerInt();
            
            if (piso <=8 && oficina<=4){
                matriz[piso-1][oficina-1]+= 1;
            } 
            else System.out.println("Error");
        }
        
        // Imprimimos matriz, recorriendola.
        for (i=0; i<pisos; i++){
            System.out.println("-----");
            for(j=0; j<oficinas; j++){
                System.out.print("( Piso " + (i+1) + ", oficina " + (j+1) + ") " + "Personas:" + matriz[i][j] + " | ");
            }
        }
    }
}
