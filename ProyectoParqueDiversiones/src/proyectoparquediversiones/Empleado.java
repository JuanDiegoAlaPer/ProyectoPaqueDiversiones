/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparquediversiones;

/**
 *
 * @author juand
 */
public class Empleado extends Persona{
    
//    ATRIBUTOS
    
    private float totalComision;
    
//    CONSTRUCTORES

    public Empleado() {
    }

    public Empleado(float totalComision, String ID) {
        super(ID);
        this.totalComision = totalComision;
    }
    
//    GET(TERS) AND SET(S)

    public float getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(float totalComision) {
        this.totalComision = totalComision;
    }
    
//    METODOS PARA EL SISTEMA
    
    public void cobrarDaño (float costo){
        this.totalComision -= costo;
    }
    
//    TOSTRING

    @Override
    public String toString() {
        return "Empleado{" + "totalComision=" + totalComision + '}';
    }
}