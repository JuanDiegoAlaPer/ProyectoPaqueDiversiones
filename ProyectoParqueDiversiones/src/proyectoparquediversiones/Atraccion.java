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
public class Atraccion {
    
//    ATRIBUTTOS
    
    public float precioPublico;
    private String codigo;
    private float costoMantenimiento;
    private int rodamientosPreMantenimiento;
    private int rodamientos;
    private boolean mantenimientoListo;
    private boolean estaActiva;
    
//    CONSTRUCTORES

    public Atraccion() {
    }

    public Atraccion(float precioPublico, String codigo, float costoMantenimiento, int rodamientosPreMantenimiento, boolean mantenimientoListo, boolean estaActiva) {
        this.precioPublico = precioPublico;
        this.codigo = codigo;
        this.costoMantenimiento = costoMantenimiento;
        this.rodamientosPreMantenimiento = rodamientosPreMantenimiento;
        this.rodamientos = rodamientosPreMantenimiento;
        this.mantenimientoListo = mantenimientoListo;
        this.estaActiva = estaActiva;
    }
    
//    GET(TERS) AND SETS

    public float getPrecioPublico() {
        return precioPublico;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public float getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public int getRodamientosPreMantenimiento() {
        return rodamientosPreMantenimiento;
    }

    public int getRodamientos() {
        return rodamientos;
    }
    
    public boolean isMantenimientoListo() {
        return mantenimientoListo;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setPrecioPublico(float precioPublico) {
        this.precioPublico = precioPublico;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setCostoMantenimiento(float costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public void setRodamientosPreMantenimiento(int rodamientosPreMantenimiento) {
        this.rodamientosPreMantenimiento = rodamientosPreMantenimiento;
    }

    public void setRodamientos(int rodamientos) {
        this.rodamientos = rodamientos;
    }
    
    public void setMantenimientoListo(boolean mantenimientoListo) {
        this.mantenimientoListo = mantenimientoListo;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    
//    METODOS PARA EL SISTEMA
    
    public float realizarMantenimiento(){
        this.estaActiva = true;
        this.mantenimientoListo = true;
        return this.getCostoMantenimiento();
    }
    
    public float realizarRodamiento(){
        if (this.rodamientos <= 0){
            System.out.println("La atraccion debe de pasar por mantenimiento antes de ser usada de nuevo");
            return 0;
        }
        else{
            if (this.estaActiva == true)
                this.rodamientos--;       
            else{
                System.out.println("La atraccíon no se encuentra activa");
                return 0;
            }
        }
        return this.precioPublico;
    }
    
//    TOSTRING

    @Override
    public String toString() {
        return "Atraccion{" + "precioPublico=" + precioPublico + ", codigo=" + codigo + ", costoMantenimiento=" + costoMantenimiento + ", rodamientosPreMantenimiento=" + rodamientosPreMantenimiento + ", mantenimientoListo=" + mantenimientoListo + ", estaActiva=" + estaActiva + '}';
    }
}