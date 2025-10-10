package tema3;


public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    public Autor(String unNombre, String unaBiografia, String unOrigen){
        nombre= unNombre;
        biografia= unaBiografia;
        origen= unOrigen;
    }
    
    public Autor(){}
    
    public String getNombre(){
        return nombre;
    }
    
    public String getBiografia(){
        return biografia;
    }
    
    public String getOrigen(){
        return origen;
    }
    
    public void setNombre(String unNombre){
        this.nombre= unNombre;
    }
    
    public void setBiografia(String unaBiografia){
        this.biografia= unaBiografia;
    }
    
    public void setOrigen(String unOrigen){
        this.origen= unOrigen;
    }
    
    @Override
    public String toString(){
        String aux;
        aux= nombre + " - " + biografia + " - " + origen;
        return aux;
    }
}
