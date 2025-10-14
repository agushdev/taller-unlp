public class main {
    public static void main(String[] args) {
        
        Minibus minibus1= new Minibus("AB123CD",20);
        Minibus minibus2= new Minibus("AB456CD",28);
        
        Viaje viaje= new Viaje("Media 1", "25/10/2024","Tecnopolis",minibus1,minibus2);
        
        Alumno alumno1= new Alumno(2321322,"Juan",22132,"Ioma");
        Alumno alumno2= new Alumno(1212,"awdwad",3232,"adwadwdwa");
        Alumno alumno3= new Alumno(12313213,"Pedro",23232323,"Ioma");
        minibus1.agregarAlumno(alumno1);
        minibus1.agregarAlumno(alumno3);
        minibus2.agregarAlumno(alumno2);
        
        int dni= 1212;
        int nuevaPoliza= 123;
        viaje.asignarPoliza(dni, nuevaPoliza);
        
        System.out.println(viaje.toString());
        
    }
    
}
