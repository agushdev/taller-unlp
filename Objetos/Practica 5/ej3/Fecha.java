public class Fecha {
    private String ciudad;
    private String dia;
    
    public Fecha(String unaCiudad, String unDia){
        this.ciudad= unaCiudad;
        this.dia= unDia;
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public String getDia() {
        return dia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    @Override
    public String toString() {
        return "Ciudad: " + ciudad + " (Día: " + dia + ")";
    }
}
