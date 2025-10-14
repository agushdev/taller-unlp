public class Evento extends Recital {
    private String motivo;
    private String nombreContratante;
    private String dia;
    
    public Evento(String unNombre, int unaDimF, String unMotivo, String unNombreContratante, String unDia ){
        super(unNombre, unaDimF);
        this.motivo = unMotivo;
        this.nombreContratante = unNombreContratante;
        this.dia = unDia;
    }
    
    public String getMotivo() { return motivo; }
    public void setMotivo(String unMotivo) { this.motivo = unMotivo; }
    
    public String getNombreContratante() { return nombreContratante; }
    public void setNombreContratante(String unNombreContratante) { this.nombreContratante = unNombreContratante; }

    public String getDia() { return dia; }
    public void setDia(String unDia) { this.dia = unDia; }
    
    public void actuar(){
        if (this.motivo.equals("beneficiencia")){
            System.out.println("Recuerden colaborar con " + this.nombreContratante);
        }
        else if (this.motivo.equals("tv")){
            System.out.println("Saludos amigos televidentes");
        }
        else if (this.motivo.equals("privado")){
            System.out.println("Un feliz cumpleaños para " + this.nombreContratante);
        }
        
        for (int i = 0; i < super.getDimLTemas(); i++) {
            System.out.println("Y ahora tocaremos " + super.getListaTemas()[i]);
        }
    }

    @Override
    public double calcularCosto() {
        int aux=0;
        if (this.motivo.equals("beneficio")) {
            aux=0;
        } 
        else if (this.motivo.equals("tv")) {
            aux=50000;
        } 
        else if (this.motivo.equals("privado")) {
            aux=150000;
        }
        return aux;
    }
}
