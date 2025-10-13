import PaqueteLectura.Lector;

public class main {
    public static void main(String[] args){
        Estacionamiento estacionamiento= new Estacionamiento("Jorge","21 y 242","08:00","22:00",3,3);
        
        Auto auto1 = new Auto("Juan", "AAA111");
        estacionamiento.agregarAuto(auto1,1,1);
        
        Auto auto2 = new Auto("Carlito", "BBB222");
        estacionamiento.agregarAuto(auto2,2,1);
        
        Auto auto3 = new Auto("Lionel", "CCC333");
        estacionamiento.agregarAuto(auto3,3,1);
        
        Auto auto4 = new Auto("Pedro", "DDD444");
        estacionamiento.agregarAuto(auto4,1,2);
        
        Auto auto5 = new Auto("Lucas", "EEE555");
        estacionamiento.agregarAuto(auto5,2,3);
        
        Auto auto6 = new Auto("Teo", "FFF666");
        estacionamiento.agregarAuto(auto1,3,3);
        
        System.out.println(estacionamiento.toString());
        
        
    }
}
