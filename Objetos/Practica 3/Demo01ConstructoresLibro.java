/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;
public class Demo01ConstructoresLibro {

    public static void main(String[] args) {
        Autor autorLibro1= new Autor("Herbert Schildt","Blablablabla","USA");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 autorLibro1, "978-0071809252", 21.72);
        
        Autor autorLibro2= new Autor("John Horton","Blaaablaa","Alemania");
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               autorLibro2, "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        // Libro libro3= new Libro(); 
    }
    
}
