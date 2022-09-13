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
public class Usuario extends Persona{
    
//    ATRIBUTOS
    
    private float totalInvertido;
    
//    CONSTRUCTORES

    public Usuario() {
    }

    public Usuario(float totalInvertido, String ID) {
        super(ID);
        this.totalInvertido = totalInvertido;
    }
    
//    GET(TERS) AND SET(S)

    public float getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(float totalInvertido) {
        this.totalInvertido = totalInvertido;
    }
    
//    METODOS PARA EL SISTEMA
    
    public void rodar(float precio) {
        this.totalInvertido += precio;
    }
    
    public void darDevolucion (float costo){
        this.totalInvertido -= costo;
    }
    
//    TOSTRING

    @Override
    public String toString() {
        return "Usuario{" + "totalInvertido=" + totalInvertido + '}';
    }
}