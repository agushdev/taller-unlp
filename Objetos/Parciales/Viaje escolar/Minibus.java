public class Minibus {
    private String patente;
    private int capacidad;
    private Alumno[] alumnos;
    private int dimL;
    
    public Minibus(String patente, int N){
        this.patente= patente;
        this.capacidad= N;
        this.alumnos= new Alumno[N];
        this.dimL=0;
    }
    
    public void agregarAlumno(Alumno a){
        if (this.dimL < this.capacidad){
            this.alumnos[this.dimL]= a;
            this.dimL++;
        }
    }
    
    public int getLugaresLibres(){
        return this.capacidad - this.dimL;
    }
    
    public String getPatente(){
        return this.patente;
    }
    
    public int getCapacidad(){
        return this.capacidad;
    }
    
    public boolean asignarPoliza(int dni, int poliza){
        boolean ok= false;
        int i=0;
        while(i < this.dimL && !ok){
            if(this.alumnos[i].getDni() == dni){
                this.alumnos[i].setPoliza(poliza);
                ok=true;
            }
            i++;
        }
        return ok;
    }
    
    public int contarAlumnosObra(String obra){
        int total=0;
        for (int i=0; i<this.dimL; i++){
            if(this.alumnos[i].getObra().equals(obra)){
                total++;
            }
        }
        return total;
    }
    
    public int getDimL(){ return this.dimL; }
    
    public String obtenerReporte(){
        String reporte="";
        for (int i = 0; i < this.dimL; i++) {
            reporte += this.alumnos[i].toString() + "\n";
        }
        return reporte;
    }
    
    @Override
    public String toString(){
        String aux= this.patente + " - " + this.capacidad;
        return aux;
    }
    
}
