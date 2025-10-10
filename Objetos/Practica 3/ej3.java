package tema3;

/*
Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”
 */
public class ej3 {
    public static void main(String[] args){
        
        Estante estante=new Estante(4);
        
        Autor autor1=new Autor("Autor A", "olaa", "Peru");
        Autor autor2=new Autor("Autor B", "olaa", "Bolivia");
        Autor autor3=new Autor("Autor c", "olaa", "Paraguay");
        
        Libro libro1=new Libro("Librito", "aa", 2020, autor3, "ISBN433243243", 24.50);
        estante.agregarLibro(libro1);
        
        Libro libro2=new Libro("Mujercitas", "aa", 2020, autor2, "ISBN2342423", 24.50);
        estante.agregarLibro(libro2);
        
        Libro libro3=new Libro("Aa", "aa", 2020, autor1, "ISBN55234155852", 24.50);
        estante.agregarLibro(libro3);
        
        Libro libro4=new Libro("Uu", "aa", 2020, autor2, "ISBN32122455852", 24.50);
        estante.agregarLibro(libro4);
        

        Libro buscoLibro=estante.devolverLibro("Mujercitas");
        if(buscoLibro !=null){
            System.out.println("El autor es: " + buscoLibro.getPrimerAutor());
        }else{
            System.out.println("No se encontro");
        }
        
    }
}
