package tema4;

public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    
    public Persona(String unNombre, int unDni, int unaEdad){
        this.nombre= unNombre;
        this.dni= unDni;
        this.edad= unaEdad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public int getDni(){
        return dni;
    }
    
    public void setDni(int dni){
        this.dni=dni;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    @Override
    public String toString(){
        String aux= "Mi nombre es " + nombre + ", mi DNI es " + dni + " y tengo " + edad + " años.";
        return aux;
    }
}
