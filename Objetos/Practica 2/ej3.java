package tema2;
import PaqueteLectura.GeneradorAleatorio;

public class ej3 {
    public static void main(String[] args) {
        /* 
            Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
            cada día se entrevistarán a 8 personas en distinto turno. 
        */
            GeneradorAleatorio.iniciar();
            int dias=5, personas=8;
            Persona matriz[][]= new Persona[dias][personas];
            
        /*
            a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
            nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
            personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
            siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
            40 cupos de casting.
        */
        
        int cupos=dias*personas, cuposOcupados=0, edadPersona, dniPersona, i=0, j=0;
        String nombrePersona;
        
        System.out.println("Ingrese un nombre ('ZZZ' para finalizar): ");
        nombrePersona= GeneradorAleatorio.generarString(20);
        
        while(i < dias && !nombrePersona.equals("ZZZ") && cuposOcupados < 40){
            j=0;
            while(j < personas && !nombrePersona.equals("ZZZ") && cuposOcupados < 40){
                System.out.println("Ingrese un dni: ");
                dniPersona= GeneradorAleatorio.generarInt(99999);
                System.out.println("Ingrese una edad: ");
                edadPersona= GeneradorAleatorio.generarInt(70);
                
                matriz[i][j]= new Persona(nombrePersona,dniPersona,edadPersona);
                cuposOcupados++;
                
                if (cuposOcupados < cupos){
                    System.out.println("Ingrese un nombre ('ZZZ' para finalizar): ");
                    nombrePersona= GeneradorAleatorio.generarString(20);
                }
                j++;
            }
            i++;
        }
        
        /*
            b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
            NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
            Strings use el método equals.
        */
        int contador=0;
        
        for (i=0; i<dias; i++){
            for (j=0; j<personas; j++){
                if (contador < cuposOcupados){
                    System.out.println("Día " + (i + 1) + ", Turno " + (j + 1) + ": "
                            + matriz[i][j].getNombre() + " - DNI "
                            + matriz[i][j].getDNI() + " - Edad "
                            + matriz[i][j].getEdad());
                    contador++;
                }
            }
        }
    }
}
