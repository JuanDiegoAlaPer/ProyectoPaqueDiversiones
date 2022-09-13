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
public class Persona {
    
//    ATRIBUTOS
    
    private String ID;
    
//    CONSTRUCTORES

    public Persona() {
    }

    public Persona(String ID) {
        this.ID = ID;
    }
    
//    GET(TERS) AND SET(S)

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
       
//    TOSTRING
    
    @Override
    public String toString() {
        return "Persona{" + "ID=" + ID + '}';
    }
}