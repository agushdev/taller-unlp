package tema4;

/*
Los entrenadores son empleados que se caracterizan por la cantidad de
campeonatos ganados
*/
public class Entrenador extends Empleado{
    private int campeonatos;
    
    public Entrenador(String unNombre,double unSueldo, int unaAntiguedad, int campeonatos){
        super(unNombre, unSueldo, unaAntiguedad);
        this.setCampeonatos(campeonatos);
    }

    public void setCampeonatos(int campeonatos) {
        this.campeonatos = campeonatos;
    }

    public int getCampeonatos() {
        return campeonatos;
    }
    
    @Override
    public double calcularEfectividad(){
        double efectividad;
        efectividad= (double)this.getCampeonatos()/ this.getAntiguedad();
        return efectividad;
    }
    
    @Override
    public double calcularSueldoACobrar(){
        double sueldoFinal;
        double sueldoBase= this.getSueldoBasico();
        double bonoAntiguedad= sueldoBase * 0.1 * this.getAntiguedad();
        double sueldoEstandar= sueldoBase + bonoAntiguedad;
        double plusCampeonatos=0;
        int campeonatos= this.getCampeonatos();
        
        if (campeonatos > 10){
            plusCampeonatos= 50000;
        }
        else if (campeonatos >=5){
            plusCampeonatos = 30000;
            
        } else if (campeonatos >= 1) {
            plusCampeonatos = 5000;
        }
        
        sueldoFinal = sueldoEstandar + plusCampeonatos;
        
        return sueldoFinal;
    }
}
