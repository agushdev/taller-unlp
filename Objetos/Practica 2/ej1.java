package tema2;
import PaqueteLectura.Lector;

public class ej1 {
    public static void main(String[] args) {
        /*
            Realice un programa que cree un objeto persona con datos leídos desde teclado. Luego
            muestre en consola la representación de ese objeto en formato String
        */
        
        System.out.println("Ingresa un nombre: ");
        String nombrePersona=Lector.leerString();
        System.out.println("Ingrese un DNI: ");
        int dniPersona=Lector.leerInt();
        System.out.println("Ingrese una edad: ");
        int edadPersona=Lector.leerInt();
        
        Persona persona1=new Persona(nombrePersona, dniPersona, edadPersona);
        System.out.println(persona1.toString());
    }
}
