

public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean otorgado;
    
    public Subsidio(double unMontoPedido, String unMotivo){
        this.montoPedido=unMontoPedido;
        this.motivo=unMotivo;
        this.otorgado=false;
    }
    
    public double getMontoPedido(){
        return montoPedido;
    }
    
    public String getMotivo(){
        return motivo;
    }
    
    public boolean isOtorgado(){
        return otorgado;
    }
    
    public void setOtorgado(boolean otorgado){
        this.otorgado=otorgado;
    }
    
}
