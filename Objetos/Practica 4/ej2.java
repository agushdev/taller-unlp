package tema4;

/*
F- Realizar un programa que instancie un jugador y un entrenador. Informe la
representación String de cada uno.
NOTA: para cada método a implementar piense en que clase/s debe definir el método.
*/

public class ej2 {
     public static void main(String[] args) {
         Jugador jugador= new Jugador("Maradona",10000,20,724,358);
         Entrenador entrenador= new Entrenador("Guardiola",30000,9,39);
         System.out.println(jugador.toString());
         System.out.println(entrenador.toString());
     }
}
