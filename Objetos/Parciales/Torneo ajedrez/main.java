public class main {
    public static void main(String[] args) {
        SitioTorneoAmateur amateur= new SitioTorneoAmateur("Ajedre","ajedre.com");
        SitioTorneoProfesional profesional= new SitioTorneoProfesional("Chess","chess.com",3);
        
        amateur.setCantUsuarios(30);
        profesional.setCantUsuarios(120);
        
        System.out.println("Sitio Amateur: " + amateur.getNombre() + " ---");
        amateur.registrarTorneoAmateur(240);
        amateur.registrarTorneoAmateur(110);
        System.out.println("Torneos jugados: " + amateur.getCantTorneosJugados()); 
        System.out.println("Total Clicks: " + amateur.getCantClicksPublicidades());
        System.out.println("Cotización Comercial: " + amateur.cotizarSitio()); 
        System.out.println("Representación String: " + amateur.toString()); 
        
        System.out.println("Sitio Profesional: " + profesional.getNombre() + " ---");
        profesional.registrarTorneoProfesional(new TorneoProfesional("Open Invierno", "01/05", 5000, 3000));
        profesional.registrarTorneoProfesional(new TorneoProfesional("Master Final", "15/06", 8000, 7000));
        System.out.println("Torneos realizados: " + profesional.getDimL());
        System.out.println("Cotización Comercial: " + profesional.cotizarSitio());
        System.out.println("Representación String: " + profesional.toString());
        
        profesional.registrarTorneoProfesional(new TorneoProfesional("Otro", "01/07", 10, 5));
        profesional.registrarTorneoProfesional(new TorneoProfesional("Otro", "01/07", 10, 5));
        profesional.registrarTorneoProfesional(new TorneoProfesional("Otro", "01/07", 10, 5));
        System.out.println("Intentando agregar 3 torneos más. Torneos realizados: " + profesional.getDimL());
        boolean ok = profesional.registrarTorneoProfesional(new TorneoProfesional("El que no entra", "01/07", 10, 5));
        System.out.println(ok);
        
    }
    
}
