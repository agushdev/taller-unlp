public class Gira extends Recital{
    private String nombreGira;
    private Fecha[] fechas;
    private int fechaActual;
    private int dimLFechas;
    private final int maxFechas;
    
    public Gira(String unNombreRecital, int unMaxTemas, String unNombreGira, int unMaxFechas){
        super(unNombreRecital,unMaxTemas);
        this.nombreGira= unNombreGira;
        this.maxFechas= unMaxFechas;
        this.fechas= new Fecha[maxFechas];
        this.fechaActual=0;
        this.dimLFechas=0;
    }
    
    public String getNombreGira() {
        return nombreGira;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }

    public int getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(int fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    public void agregarFecha(Fecha fecha){
        if (this.dimLFechas < maxFechas){
            this.fechas[this.dimLFechas]= fecha;
            this.dimLFechas ++;
        }
    }
    
    public void actuar() {
    if (this.fechaActual < this.dimLFechas) {
        Fecha fechaActualObj = this.fechas[this.fechaActual];
        System.out.println("Buenas noches " + fechaActualObj.getCiudad() + "!");
        
        for (int i = 0; i < super.getDimLTemas(); i++) {
            System.out.println("Y ahora tocaremos... " + super.getListaTemas()[i]);
        }
        this.fechaActual++;
    } else {
        System.out.println("La gira ha finalizado. No quedan fechas por tocar.");
    }
}

    @Override
    public double calcularCosto() {
        return this.dimLFechas * 30000;
    }
    
}
