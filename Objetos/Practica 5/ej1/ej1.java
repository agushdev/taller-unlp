

/*
    Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
    subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
    todos los datos del proyecto en pantalla
*/

public class ej1 {
    public static void main(String[] args){
        Proyecto proyecto= new Proyecto("Fondos de inversion", 555, "Ing. Fito");
        
        Investigador inv1, inv2, inv3;
        inv1= new Investigador("Dr. Juan", 3, "Biologia");
        inv2= new Investigador("Lic. Carlos", 2, "Informatica");
        inv3= new Investigador("Dr. Pablo", 1, "Medicina");
        
        proyecto.agregarInvestigador(inv1);
        proyecto.agregarInvestigador(inv2);
        proyecto.agregarInvestigador(inv3);
        
        Subsidio sub1_1, sub1_2, sub2_1, sub2_2, sub3_1, sub3_2;
        
        // SUBSIDIOS DE INV1
        sub1_1= new Subsidio(20000,"Mejorar ambiente");
        sub1_2= new Subsidio(17000,"Comprar cafetera");
        inv1.agregarSubsidio(sub1_1);
        inv1.agregarSubsidio(sub1_2);
        
        // SUBSIDIOS DE INV2
        sub2_1= new Subsidio(90000,"Comprar computadoras");
        sub2_2= new Subsidio(15000, "Software especializado");
        inv2.agregarSubsidio(sub2_1);
        inv2.agregarSubsidio(sub2_2);
        
        // SUBSIDIOS DE INV3
        sub3_1= new Subsidio(9000,"Material bibliografico");
        sub3_2= new Subsidio(53000, "Analisis estadistico");
        inv3.agregarSubsidio(sub3_1);
        inv3.agregarSubsidio(sub3_2);
        
        // OTORGAR SUBSIDIO DE 1 INVESTIGADOR
        proyecto.otorgarTodos("Dr. Pablo");
        
        System.out.println(proyecto.toString());
    }
}
