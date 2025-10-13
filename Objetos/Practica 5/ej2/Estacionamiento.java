public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String horaIni;
    private String horaFin;
    private int NPisos; // num piso
    private int MPlazas; // num plaza
    
    private Auto[][] lugarOcupado;
    
    public Estacionamiento(String nombre, String direccion){
        // this(nombre, direccion, "08:00", "21:00", 5, 10);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.horaIni= "08:00";
        this.horaFin= "21:00";
        this.NPisos= 5;
        this.MPlazas= 10;
        this.lugarOcupado= new Auto[NPisos][MPlazas];
    }
    
    public Estacionamiento(String nombre, String direccion, String horaIni, String horaFin, int NPisos, int MPlazas){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setHoraIni(horaIni);
        this.setHoraFin(horaFin);
        this.setNPisos(NPisos);
        this.setMPlazas(MPlazas);
        this.lugarOcupado= new Auto[NPisos][MPlazas];
    }
    
    public void setNombre(String unNombre){this.nombre= unNombre;}    
    public void setDireccion(String unaDireccion){this.direccion= unaDireccion;}
    public void setHoraIni(String unHorario){this.horaIni= unHorario;}
    public void setHoraFin (String unHorario){this.horaFin= unHorario;}
    public void setNPisos(int pisos){this.NPisos= pisos;}
    public void setMPlazas(int plazas){this.MPlazas= plazas;}
    
    public void agregarAuto(Auto auto, int NPiso, int MPlaza){
        int piso= NPiso - 1;
        int plaza= MPlaza - 1;
        
        if(piso >=0 && piso < this.NPisos &&
           plaza >=0 && plaza < this.MPlazas){
           this.lugarOcupado[piso][plaza] = auto; 
        } else {
            System.out.println("Error, el piso o plaza no entra dentro del limite del estacionamiento.");
        }
    }
    
    public String buscarPatente(int patente){
        String aux= "No existe la patente.";
        boolean ok= false;
        int i=0;
        
        while (i < this.NPisos && !ok){
            int j=0;
            while (j < this.MPlazas && !ok){
                if (this.lugarOcupado[i][j].getPatente().equals(patente)){
                    int piso = i + 1;
                    int plaza = j + 1;
                    aux= "Piso " + piso + ", Plaza " + plaza;
                    ok= true;
                }
                j++;
            }
            i++;
        }
        return aux;
    }
    
    public int obtenerAutosPlaza(int NPlaza){
        int total=0;
        int plaza= NPlaza - 1;
        if (plaza >= 0 && plaza < this.MPlazas){
            for (int i=0; i<this.NPisos; i++){
                if (this.lugarOcupado[i][plaza]!= null){
                    total++;
                }
            }
        }
        return total;
    }
    
    @Override
    public String toString(){
        String aux= "Estacionamiento: " + this.nombre + "--- \n";
        for(int i=0; i<this.NPisos; i++){
            for(int j=0; j<this.MPlazas; j++){
                int piso= i+1;
                int plaza= j+1;
                aux= aux + "Piso " + piso + " Plaza " + plaza + ": ";
                
                Auto autoActual= this.lugarOcupado[i][j];
                if(autoActual == null){
                    aux= aux + "libre\n";
                } else{
                    aux= aux + autoActual.toString() + "\n";
                }
            }
        }
        return aux;
    }
    
}
