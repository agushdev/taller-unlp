public class Torneo {
    
    
    private String nombre;
    private int fechas;
    private int goleadoresPorFecha;
    
    private Goleador[][] tablaGoleadores;
    private int[] cantGoleadoresDimL;
    
    public Torneo(String unNombre, int unasFechas){
        this.nombre=unNombre;
        this.fechas=unasFechas;
        this.goleadoresPorFecha=0;
    }
    
    public void agregarGoleador(int fechaX, Goleador unGoleador){
        int i= fechaX - 1;
        if(i >= 0 && i < fechas){
            int dimLFecha= this.cantGoleadoresDimL[i];
            
            if(dimLFecha < goleadoresPorFecha){
                this.tablaGoleadores[i][dimLFecha] = unGoleador;
                this.cantGoleadoresDimL[i]++;
            } else {
                System.out.println("La Fecha " + fechaX + " está llena.");
            }
        }
    }
    
    public Goleador obtenerGoleadorMenosGoles(int fechaX){
        int i= fechaX - 1;
        int dimLFecha= this.cantGoleadoresDimL[i];
        Goleador menosGoles = this.tablaGoleadores[i][0];
        int minGoles= menosGoles.getGoles();
        
        for(int j=1; j<dimLFecha; j++){
            Goleador actual= this.tablaGoleadores[i][j];
            if(actual.getGoles() < minGoles){
                minGoles= actual.getGoles();
                menosGoles= actual;
            }
        }
        return menosGoles;
    }
    
    public int obtenerCantidadGoleadoresRegistrados(){
        int total= 0;
        for (int i=0; i<fechas; i++){
            total+= this.cantGoleadoresDimL[i];
        }
        return total;
    }
    
}
