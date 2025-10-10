

public class Investigador {
    private final int subsidiosMax=5;
    
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio[] subsidios;
    private int dimLSubsidios;
    
    public Investigador(String unNombre, int unaCategoria, String unaEspecialidad){
        this.nombre=unNombre;
        this.categoria=unaCategoria;
        this.especialidad=unaEspecialidad;
        this.subsidios=new Subsidio[subsidiosMax];
        this.dimLSubsidios=0;
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if (dimLSubsidios < subsidiosMax){
            this.subsidios[this.dimLSubsidios]= unSubsidio;
            this.dimLSubsidios++;
        }
    }
    
    /* devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
       todos los subsidios otorgados de todos los investigadores) */
    
    public double dineroOtorgadoTotal(){        
        double montoTotal=0;
        int i;
        for (i=0; i<this.dimLSubsidios; i++){
            if(this.subsidios[i].isOtorgado()){
                montoTotal+= this.subsidios[i].getMontoPedido();
            }
        }
        return montoTotal;
    }
    
    // //otorgar todos los subsidios no-otorgados del investigador llamado nombreCompleto
    
    public void otorgarTodosSubsidios(){
        int i;
        for (i=0; i<dimLSubsidios; i++){
            if(!this.subsidios[i].isOtorgado()){
                this.subsidios[i].setOtorgado(true);
            }
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String unNombre){
        this.nombre=unNombre;
    }
    
    public int getCategoria(){
        return categoria;
    }
    
    public void setCategoria(int unaCategoria){
        this.categoria=unaCategoria;
    }
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String unaEspecialidad){
        this.especialidad=unaEspecialidad;
    }
}
