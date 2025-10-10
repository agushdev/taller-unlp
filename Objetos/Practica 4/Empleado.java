package tema4;

/*
Cualquier empleado se caracteriza por su nombre, sueldo básico y antigüedad. 
*/
public abstract class Empleado {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;
    
    public Empleado(String unNombre, double unSueldo, int unaAntiguedad){
        this.nombre = unNombre;
        this.sueldoBasico = unSueldo;
        this.antiguedad = unaAntiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public abstract double calcularEfectividad();
    
    public abstract double calcularSueldoACobrar();
    
    @Override
    public String toString(){
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldoBasico + ", efectividad=" + this.calcularEfectividad() + '}';
    }
    
}