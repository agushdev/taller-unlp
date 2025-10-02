package tema1;
import PaqueteLectura.Lector;

public class ej5 {
    public static void main(String[] args) {
        /*
            El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
            (con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
            de la comida (2) Precio (3) Ambiente.
            Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
            para cada uno de los aspectos y almacene la información en una estructura. Luego
            imprima la calificación promedio obtenida por cada aspecto.
        */
        int clientes=5, aspectos=4, i, j, calificacion;
        int matriz[][]= new int[clientes][aspectos];
        double promedio;
        double[] sumaAspectos = new double[aspectos];
        String[] nombresAspectos = {"Atención al cliente", "Calidad de la comida", "Precio", "Ambiente"};
        
        // Llenamos la matriz de calificaciones y tmb las guardamos en un vec contador.
        for (i=0; i<clientes; i++){
            for (j=0; j<aspectos; j++){
                System.out.print("   > Califique " + nombresAspectos[j] + ": ");
                calificacion = Lector.leerInt();
                matriz[i][j]= calificacion;
                sumaAspectos[j]+= calificacion;
            }
        }
        
        // Recorremos el vec contador para calcular y mostrar el promedio.
        for (j=0; j<aspectos; j++){
            promedio= sumaAspectos[j] / clientes;
            System.out.printf("%s: %.2f\n", nombresAspectos[j], promedio);
        }
    }
}
