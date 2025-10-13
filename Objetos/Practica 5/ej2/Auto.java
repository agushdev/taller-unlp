/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agus
 */
public class Auto {
    private String nombre;
    private String patente;
    
    public Auto(String unNombre, String unaPatente){
        this.nombre=unNombre;
        this.patente=unaPatente;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getPatente(){
        return patente;
    }
    
    public void setNombre(String unNombre){
        this.nombre= unNombre;
    }
    
    public void setPatente(String unaPatente){
        this.patente= unaPatente;
    }
    
    public String toString(){
        String aux= "Nombre duenio: " + this.nombre + ", Patente: " + this.patente;
        return aux;
    }
}
