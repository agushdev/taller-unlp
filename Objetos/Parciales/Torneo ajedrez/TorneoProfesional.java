public class TorneoProfesional {
    private String nombre;
    private String fecha;
    private double montoRecaudado;
    private double montoPagado;
    
    public TorneoProfesional(String nombre, String fecha, double montoRecaudado, double montoPagado){
        this.nombre=nombre;
        this.fecha=fecha;
        this.montoRecaudado=montoRecaudado;
        this.montoPagado= montoPagado;
    }
    
    public double getMontoRecaudado(){ return this.montoRecaudado; }
    public double getMontoPagado(){ return this.montoPagado; }
}
