public class Viaje {
    private String nombreColegio;
    private String fecha;
    private String destino;
    private Minibus minibus1;
    private Minibus minibus2;
    
    public Viaje(String nombreColegio, String fecha, String destino, Minibus m1, Minibus m2) {
        this.nombreColegio = nombreColegio;
        this.fecha = fecha;
        this.destino = destino;
        this.minibus1 = m1;
        this.minibus2 = m2;
    }
    
    public String agregarAlumno(Alumno a){
        int libre1= this.minibus1.getLugaresLibres();
        int libre2= this.minibus2.getLugaresLibres();
        String patenteAsignada = "";
        
        if(libre1 > 0 || libre2 > 0){
            if(libre1 >= libre2 && libre1>0){
                this.minibus1.agregarAlumno(a);
                patenteAsignada= this.minibus1.getPatente();
            }
            else if(libre2 > libre1 && libre2>0){
                this.minibus2.agregarAlumno(a);
                patenteAsignada= this.minibus2.getPatente();
            }
        }
        return patenteAsignada;
    }
    
    public boolean asignarPoliza(int dni, int poliza){
        boolean ok=false;
        if(this.minibus1.asignarPoliza(dni,poliza)){ ok=true; } 
            else if(this.minibus2.asignarPoliza(dni, poliza)){ ok= true; }
        
        return ok;
    }
    
    public int cantidadAlumnosSeguro(String obra){
        int total= this.minibus1.contarAlumnosObra(obra);
        total+= this.minibus2.contarAlumnosObra(obra);
        return total;
    }    
    
    private int getCantidadTotalAlumnos() {
        return this.minibus1.getDimL() + this.minibus2.getDimL();
    }
    
    public String toString(){
        String aux= "VIAJE ESCOLAR: " + this.fecha + ", Cantidad de alumnos total: " + this.getCantidadTotalAlumnos() + "\n";

        aux+= "Minibus 1: " + minibus1.getPatente() + " - " + minibus1.getCapacidad() + "\n";
        aux+= this.minibus1.obtenerReporte();
        
        aux+= "Minibus 2: " + minibus2.getPatente() + " - " + minibus2.getCapacidad() + "\n";
        aux+= this.minibus2.obtenerReporte();
        
        return aux;
    }
}
