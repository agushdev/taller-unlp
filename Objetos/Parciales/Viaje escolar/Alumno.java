public class Alumno {
    private int dni;
    private String nombre;
    private int polizaSeguro;
    private String obraSocial;
    
    public Alumno(int unDni, String unNombre, int unaPoliza, String unaObra){
        this.dni= unDni;
        this.nombre= unNombre;
        this.polizaSeguro= unaPoliza;
        this.obraSocial= unaObra;
    }
    
    public int getDni(){ return dni; }
    public void setDni(int dni){ this.dni=dni; }
    
    public int getPoliza(){ return polizaSeguro; }
    public void setPoliza(int poliza){ this.polizaSeguro= poliza; }
    
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre=nombre; }
    
    public String getObra(){ return obraSocial; }
    
    @Override
    public String toString(){
        String aux= this.dni + " - " + this.nombre + " - " + this.polizaSeguro + " - " + this.obraSocial;
        return aux;
    }
}
