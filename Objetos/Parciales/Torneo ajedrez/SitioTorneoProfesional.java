public class SitioTorneoProfesional extends Sitio{
    private TorneoProfesional[] torneos;
    private int maxTorneos;
    private int dimL;
    
    public int getDimL(){ return this.dimL; }
    
    public SitioTorneoProfesional(String nombre, String direccionWeb, int maxTorneos){
        super(nombre,direccionWeb);
        this.maxTorneos= maxTorneos;
        this.dimL=0;
        this.torneos= new TorneoProfesional[maxTorneos];
    }
    
    public boolean registrarTorneoProfesional(TorneoProfesional t){
        boolean ok=false;
        if (this.dimL < maxTorneos){
            this.torneos[dimL]=t;
            this.dimL++;
            ok=true;
        }
        return ok;
    }
    
    @Override
    public double cotizarSitio(){
        double total= (this.dimL * 1000);
        for (int i=0; i< this.dimL; i++){
            TorneoProfesional t= this.torneos[i];
            double beneficio= t.getMontoRecaudado() - t.getMontoPagado();
            total+= beneficio;
        }
        return total;
    }
}
