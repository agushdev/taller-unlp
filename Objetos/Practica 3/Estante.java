package tema3;

/*
3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:

(i) devolver la cantidad de libros que almacenados 

(ii) devolver si el estante está lleno

(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
*/
public class Estante {
    private Libro[] libros;
    private int dimL, capacidadMax;
    private final int maxLibros= 20;
    
    public Estante(int capacidad){
        this.capacidadMax = capacidad;
        this.libros= new Libro[maxLibros];
        this.dimL= 0;
    }
    
    public int getCantLibros(){
        return this.dimL;
    }
    
    public boolean estaLleno(){
        return this.dimL == this.capacidadMax;
    }
    
    public void agregarLibro(Libro unLibro){
        if(!this.estaLleno()){
            this.libros[this.dimL]= unLibro;
            this.dimL++;
        } else{
            System.out.println("Erroooor, esta llenol el estante papai");
        }
    }
    
    public Libro devolverLibro(String tituloBuscado){
        int i=0;
        
        while (i < this.dimL ){
            if (this.libros[i].getTitulo().equals(tituloBuscado)){
                return this.libros[i];
            }
            i++;
        }
        return null; // Si no encuentra nada, devuelve nulo.
    }
}
