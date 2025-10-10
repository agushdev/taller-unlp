package tema4;

public class Trabajador extends Persona {
    private String trabajo;
    
    public Trabajador(String unNombre, int unDNI, int unaEdad, String unTrabajo) {
        super(unNombre, unDNI, unaEdad);
        setTrabajo(unTrabajo);
    }
    
    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    
    @Override
    public String toString() {
        String aux = super.toString() + 
                     " Soy " + trabajo;
        return aux;
    }
}
