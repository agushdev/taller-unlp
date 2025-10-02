package tema2;
import PaqueteLectura.GeneradorAleatorio;

public class ej2 {
    public static void main(String[] args) {
        /*
            Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
            15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
            obtener edad 0. Luego de almacenar la información:
             - Informe la cantidad de personas mayores de 65 años.
             - Muestre la representación de la persona con menor DNI.
        */
        GeneradorAleatorio.iniciar();
        int personas=15, dniPersona, edadPersona, dimL=0;
        String nombrePersona;
        Persona vec[]= new Persona[personas];
        int cantMayores=0, menorDni=99999, i, menorPersona=0;
        
        
        // Cargar Vector con datos.
        edadPersona= GeneradorAleatorio.generarInt(70);
        while(dimL < personas && edadPersona!=0){            
            nombrePersona=GeneradorAleatorio.generarString(20);
            dniPersona=GeneradorAleatorio.generarInt(99999);
            vec[dimL]= new Persona(nombrePersona, dniPersona, edadPersona);
            edadPersona= GeneradorAleatorio.generarInt(70);
            dimL++;
        }
        
        // Calcular cant de personas mayores a 65 y la persona con menor DNI
        if (dimL > 0){
            menorDni = vec[0].getDNI();
            menorPersona = 0;
            
            for (i=0; i<dimL; i++){
            if (vec[i].getEdad() > 65)
                cantMayores+=1;
            if (vec[i].getDNI() < menorDni){
                menorDni= vec[i].getDNI();
                menorPersona= i;
            }
        }
        }
        
        // Informar lo anterior.
        if (dimL > 0){
            System.out.println("Cantidad de personas mayores: " + cantMayores);
            System.out.println("Persona con menor dni: " + vec[menorPersona].toString());
        } else
            System.out.println("Error");
    }
}
