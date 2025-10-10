package tema3;
import PaqueteLectura.Lector;

/*
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados
. La función raíz cuadrada es Math.sqrt(#)
*/

public class ej1 {
    public static void main(String[] args){
        Triangulo t= new Triangulo();
        double lado;
        String color;
        
        System.out.println("Ingrese lado A: ");
        lado = Lector.leerDouble();
        t.setLadoA(lado);
        System.out.println("Ingrese lado B: ");
        lado = Lector.leerDouble();
        t.setLadoB(lado);
        System.out.println("Ingrese lado C: ");
        lado = Lector.leerDouble();
        t.setLadoC(lado);
        
        System.out.println("Ingrese color relleno");
        color= Lector.leerString();
        t.setColorR(color);
        System.out.println("Ingrese color linea");
        color= Lector.leerString();
        t.setColorL(color);
        
        System.out.println("Perimetro: " + t.calcularPerimetro());
        System.out.println("Area: " + t.calcularArea());
    }
}
