package tema4;

public class ej3 {
    public static void main(String[] args){
        Persona p = new Persona ("Agustin", 44444444, 22);
        Trabajador t = new Trabajador ("Jorge", 46666666, 27, "Programador");
        
        System.out.println(p.toString());
        System.out.println(t.toString());
    }
}
