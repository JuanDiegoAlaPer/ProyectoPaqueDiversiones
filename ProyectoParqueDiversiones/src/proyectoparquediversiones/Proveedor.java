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
public class Proveedor {
    
//    ATRIBUTOS
    
    public String marca;
    private float inversiones;
    
//    CONSTRUCTORES

    public Proveedor() {
    }

    public Proveedor(String marca, float inversiones) {
        this.marca = marca;
        this.inversiones = inversiones;
    }
    
//    GET(TERS) AND SET(S)

    public String getMarca() {
        return marca;
    }

    public float getInversiones() {
        return inversiones;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setInversiones(float inversiones) {
        this.inversiones = inversiones;
    }
    
//    METODOS PARA EL SISTEMA
    
    public void pedirGarantia(float valor){
        this.inversiones -= valor;
    }
    
//    TOSTRING

    @Override
    public String toString() {
        return "Proveedor{" + "marca=" + marca + ", inversiones=" + inversiones + '}';
    }
}