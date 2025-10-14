public class main {
    
    public static void main(String[] args) {
        Evento evento= new Evento("Los Piojos",10,"privado","Jorge","25 de mayo");
        evento.agregarTema("Bicho de ciudad");
        evento.agregarTema("Tan solo");
        System.out.println("Costo del Evento: " + evento.calcularCosto());
        
        
        Gira gira= new Gira("Los redondos",3,"Girita",3);
        gira.agregarTema("De Música Ligera");
        gira.agregarTema("Persiana Americana");
        System.out.println("Costo de la Gira: " + gira.calcularCosto());
        
        gira.agregarFecha(new Fecha("Buenos Aires", "10/11")); // Indice 0
        gira.agregarFecha(new Fecha("Santiago de Chile", "15/11")); // Indice 1
        gira.agregarFecha(new Fecha("Lima", "20/11")); // Indice 2
        
        System.out.println("\n--- Actuación 1 (Fecha Actual: 0) ---");
        gira.actuar(); 
        System.out.println("\n--- Actuación 2 (Fecha Actual: 1) ---");
        gira.actuar(); 
        System.out.println("\n--- Actuación 3 (Fecha Actual: 2) ---");
        gira.actuar();
        System.out.println("\n--- Actuación 4 (Gira Finalizada) ---");
        gira.actuar();
    }
    
}
