package tema3;

/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)

*/

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorR; // Color relleno
    private String colorL; // Color linea
    
    public Triangulo(double a, double b, double c, String colorRelleno, String colorLinea){
        lado1= a;
        lado2=b;
        lado3=c;
        colorR= colorRelleno;
        colorL= colorLinea;
    }

    public Triangulo() {}
    
    public double getLadoA(){
        return lado1;
    }
    
    public double getLadoB(){
        return lado2;
    }
    
    public double getLadoC(){
        return lado3;
    }
            
    public String getColorR(){
        return colorR;
    }
    
    public String getColorL(){
        return colorL;
    }
    
    public void setLadoA(double a){
        lado1=a;
    }
    
    public void setLadoB(double b){
        lado2=b;
    }
    
    public void setLadoC(double c){
        lado3=c;
    }
    
    public void setColorR(String colorRelleno){
        colorR=colorRelleno;
    }
    
    public void setColorL(String colorLinea){
        colorL=colorLinea;
    }
    
    public double calcularPerimetro(){
        return lado1+lado2+lado3;
    }
    
    public double calcularArea(){
        double area;
        double s = this.calcularPerimetro() / 2;
        double s2 = s*(s-lado1)*(s-lado2)*(s-lado3);
        area = Math.sqrt(s2);
        return area;
    }
 
}