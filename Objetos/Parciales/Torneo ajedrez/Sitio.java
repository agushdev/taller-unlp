public abstract class Sitio {
    private String nombre;
    private String direccionWeb;
    private int cantUsuarios;
    
    public Sitio(String nombre, String direccionWeb){
        this.nombre=nombre;
        this.direccionWeb=direccionWeb;
        this.cantUsuarios=0;
    }
    
    public int getCantUsuarios(){ return this.cantUsuarios; }
    public void setCantUsuarios(int usuarios) { this.cantUsuarios=usuarios; }
    public String getNombre(){ return this.nombre; }
    
    public abstract double cotizarSitio();
    
    public String toString(){
        String aux= this.nombre + "; " + this.direccionWeb + this.cantUsuarios + "; " + this.cotizarSitio();
        return aux;
    }
}
