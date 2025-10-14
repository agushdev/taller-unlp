public class SitioTorneoAmateur extends Sitio{
    private int cantTorneosJugados;
    private int cantClicksPublicidades;
    
    public SitioTorneoAmateur(String nombre, String direccion){
        super(nombre,direccion);
        this.cantTorneosJugados=0;
        this.cantClicksPublicidades=0;
    }
    
    public int getCantTorneosJugados(){ return this.cantTorneosJugados; }
    public int getCantClicksPublicidades(){ return this.cantClicksPublicidades; }
    
    @Override
    public double cotizarSitio(){
        double total= (this.cantClicksPublicidades * 10 ) + (super.getCantUsuarios() * 50);
        return total;
    }
    
    public void registrarTorneoAmateur(int clicks){
        this.cantClicksPublicidades= clicks;
        this.cantTorneosJugados++;
    }
    
}
