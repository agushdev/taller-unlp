package tema4;

/*

*/
public class Jugador extends Empleado{
    
    private int partidos;
    private int goles;
    
    public Jugador(String unNombre,double unSueldo, int unaAntiguedad, int partidos, int goles){
        super(unNombre, unSueldo, unaAntiguedad);
        this.setPartidos(partidos);
        this.setGoles(goles);
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
    @Override
    public double calcularEfectividad(){
        double efectividad;
        efectividad= (double)this.getGoles() / this.getPartidos();
        return efectividad;
    }
    
    @Override
    public double calcularSueldoACobrar(){
        double sueldoFinal;
        double sueldoBase= this.getSueldoBasico();
        double bonoAntiguedad= sueldoBase * 0.1 * this.getAntiguedad();
        double sueldoEstandar= sueldoBase + bonoAntiguedad;
        
        if (this.calcularEfectividad() > 0.5){
            sueldoFinal= sueldoEstandar + sueldoBase;
        } else{
            sueldoFinal= sueldoEstandar;
        }
        return sueldoFinal;
    }
}