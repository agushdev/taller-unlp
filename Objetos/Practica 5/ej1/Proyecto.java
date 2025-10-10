

public class Proyecto {
    private final int investigadoresMax=50;
    
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private Investigador[] investigadores;
    private int dimLInvestigadores;
    
    public Proyecto(String unNombre, int unCodigo, String unNombreDirector){
        this.nombre=unNombre;
        this.codigo=unCodigo;
        this.nombreDirector=unNombreDirector;
        this.investigadores=new Investigador[investigadoresMax];
        this.dimLInvestigadores=0;
    }
    
    public void agregarInvestigador(Investigador unInvestigador){
        if (dimLInvestigadores < investigadoresMax){
            this.investigadores[this.dimLInvestigadores]= unInvestigador;
            this.dimLInvestigadores++;
        }
    }
    
    /* devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
       todos los subsidios otorgados de todos los investigadores) */
    
    public double dineroTotalOtorgado(){
        double montoTotal=0;
        int i;
        for (i=0; i<this.dimLInvestigadores; i++){
            montoTotal+= this.investigadores[i].dineroOtorgadoTotal();
        }
        return montoTotal;
    }
    
    // //otorgar todos los subsidios no-otorgados del investigador llamado nombreCompleto
    
    public void otorgarTodos(String nombreCompleto){
        boolean ok=false;
        int i=0;

        while (i< dimLInvestigadores && !ok){
            if (this.investigadores[i].getNombre().equals(nombreCompleto)){
                this.investigadores[i].otorgarTodosSubsidios();
                ok=true;
            }
            i++;
        }
        if(!ok){
            System.out.println("Investigador '\" + nombre_completo + \"' no se encontro.");
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String unNombre){
        this.nombre=unNombre;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int unCodigo){
        this.codigo=unCodigo;
    }
    
    public String getNombreDirector(){
        return nombreDirector;
    }
    
    public void setNombreDirector(String unNombreDirector){
        this.nombreDirector=unNombreDirector;
    }
    
    @Override
    public String toString() {
        String aux= "Proyecto: " + this.nombre + ", codigo: " + this.codigo + ", nombre del director: " + 
                this.nombreDirector + ", total de dinero otorgado: " + this.dineroTotalOtorgado() + 
                "\n------------------------------------------------\n";
        
        for (int i=0; i<dimLInvestigadores; i++){
            Investigador inv= this.investigadores[i];
            aux= aux + "Investigador " + (i+1) + ":\n" +
                    " - Nombre: " + inv.getNombre() +
                    ", Categoria: " + inv.getCategoria() +
                    ", Especialidad: " + inv.getEspecialidad() +
                    "\n - Total de subsidios otorgados: " + inv.dineroOtorgadoTotal();
        }
        
        return aux;
    }
}
