public abstract class Recital {
    private String nombreBanda;
    private String [] listaTemas;
    private int maxTemas;
    private int dimLTemas;
    
    public Recital(String unNombreBanda, int unMaxTemas){
        this.nombreBanda= unNombreBanda;
        this.maxTemas= unMaxTemas;
        this.listaTemas= new String[unMaxTemas];
        this.dimLTemas=0;
    }
    
    public void setNombreBanda(String unNombre){ this.nombreBanda= unNombre; }
    public String getNombreBanda(){ return nombreBanda; }
    public void setMaxTemas(int unMaxTemas){ this.maxTemas= unMaxTemas; }
    public int getMaxTemas(){ return maxTemas; }
    public int getDimLTemas() { return dimLTemas; }
    public String[] getListaTemas() { return listaTemas; }
    
    public void agregarTema(String tema){
        if(this.dimLTemas < this.maxTemas){
            this.listaTemas[this.dimLTemas]= tema;
            this.dimLTemas++;
        } else {
            System.out.println("La lista esta completa.");
        }
    }
    
    public void actuar(){
        for (int i=0; i<this.dimLTemas; i++){
            System.out.println("Y ahora tocaremos... " + this.listaTemas[i]);
        }
    }
    
    public abstract double calcularCosto();
}
