public class Goleador {
    private String nombre;
    private String nombreEquipo;
    private int goles;
    
    public Goleador(String unNombre, String unNombreEquipo, int unosGoles){
        this.nombre= unNombre;
        this.nombreEquipo= unNombreEquipo;
        this.goles= unosGoles;
    }
    
    public int getGoles(){
        return goles;
    }
}
