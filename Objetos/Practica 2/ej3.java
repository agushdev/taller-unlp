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
        
        int cupos=dias*personas, cuposOcupados=0, edadPersona, dniPersona;
        String nombrePersona;
        
        nombrePersona= GeneradorAleatorio.generarString(20);
        while(!nombrePersona.equals("ZZZ") && cuposOcupados < 40){
            dniPersona= GeneradorAleatorio.generarInt(99999);
            edadPersona= GeneradorAleatorio.generarInt(70);
            
        }
        
    }
}
