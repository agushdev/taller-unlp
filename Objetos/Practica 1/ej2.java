
package tema1;

import PaqueteLectura.Lector;

public class ej2 {
    /*
    2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
    básquet y las almacene en un vector. Luego informe:
    - la altura promedio
    - la cantidad de jugadores con altura por encima del promedio
    NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java
    */
    public static void main(String[] args) {
        int jugadores= 15, i, cant=0;
        double altura, promedio, suma=0;
        double [] vector = new double[jugadores];
    
        // Leemos y guardamos alturas en el vector, tmb dejamos suma como el total de las alturas.
        for (i=0; i<jugadores; i++){
            System.out.println("Ingrese la altura de jugador " + i + ":" );
            altura= Lector.leerDouble();
            vector[i]= altura;
            suma += altura;
        }
        
        // Calculamos el promedio.
        promedio=(double) suma/jugadores;
        System.out.println("El promedio de las alturas ingresadas es: " + promedio);
        
        // Informamos la cantidad de jugadores que superan el promedio
        for (i=0; i<jugadores; i++){
            if (vector[i] > promedio) cant+=1;
        }
        
        // Retornamos la cantidad.
        System.out.println("La cantidad de alturas por encima del promedio fueron: " + cant);
    }
}
