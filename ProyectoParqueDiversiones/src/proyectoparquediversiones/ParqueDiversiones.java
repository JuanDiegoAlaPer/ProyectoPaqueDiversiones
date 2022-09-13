/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparquediversiones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class ParqueDiversiones {
    
    Scanner entrada= new Scanner(System.in);
    
//    ATRIBUTOS
            
    public String nombre;
    private float ingresos;
    private float egresos;
    ArrayList<Proveedor> proveedores;
    ArrayList<Atraccion> atracciones;
    ArrayList<Usuario> usuarios;
    ArrayList<Empleado> empleados;
    
//    CONSTRUCTORES

    public ParqueDiversiones() {
        proveedores = new ArrayList<>();
        atracciones = new ArrayList<>();
        usuarios = new ArrayList<>();
        empleados = new ArrayList<>();        
    }

    public ParqueDiversiones(String nombre, float ingresos, float egresos) {
        this.nombre = nombre;
        this.ingresos = ingresos;
        this.egresos = egresos;
        proveedores = new ArrayList<>();
        atracciones = new ArrayList<>();
        usuarios = new ArrayList<>();
        empleados = new ArrayList<>();   
    }
    
//    GET(TERS) AND SET(S)

    public String getNombre() {
        return nombre;
    }

    public float getIngresos() {
        return ingresos;
    }

    public float getEgresos() {
        return egresos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngresos(float ingresos) {
        this.ingresos = ingresos;
    }

    public void setEgresos(float egresos) {
        this.egresos = egresos;
    }
        
//    METODOS PARA EL ARREGLO PROVEEDORES
    
    public void agregarProveedor(String marca, float inversiones){
        Proveedor aux = buscarProveedor(marca);
        
        if(aux == null){
            Proveedor nuevo = new Proveedor(marca,inversiones);
            proveedores.add(nuevo);
            System.out.println("Se ha agregado un proveedor con la marca: "+marca);
        }
        else
            System.out.println("Ya existe un proveedor con la marca: "+ marca);
    }
    
    public Proveedor buscarProveedor(String marcaBuscar){
        for(int i = 0; i < proveedores.size(); i++){
            if(proveedores.get(i).marca.equals(marcaBuscar)){
                return proveedores.get(i);
            }                
        }
        System.out.println("No se encontró ningun proveedor con la marca: " + marcaBuscar);
        return null;
    }
    
    public void modificarProveedor(String marcaBuscar){
        Proveedor aux = buscarProveedor(marcaBuscar);
        Scanner entrada= new Scanner(System.in);
        int opcion = 0;
        
        if (aux == null)
            opcion = 1;

        
        while(opcion != 1){
            System.out.println("Ingrese: \n"+
                    "1. para salir \n"+
                    "2. para modificar la marca del proveedor \n"+
                    "3. para modificar inverciones al proveedor \n");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Bye");
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nuevo nombre de la marca: ");
                    String nuevaMarca = entrada.next();
                    
                    Proveedor aux2 = buscarProveedor(nuevaMarca);
                    
                    if(aux2 == null)
                        aux.marca = nuevaMarca;
                    else
                        System.out.println("Ya hay una un proveedor con la marca: "+nuevaMarca);
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nuevo valor de inverciones: ");
                    aux.setInversiones(entrada.nextFloat());
                    break;
            }
        }
    }
    
    public void mostrarProveedores(){
        for(int i = 0; i < proveedores.size(); i++)
            System.out.println(proveedores.get(i).toString());
    }
    
    //    METODOS PARA EL ARREGLO ATRACCIONES
    
    public void agregarAtraccion(float precioPublico, String codigo, float costoMantenimiento, int rodamientosPreMantenimiento, boolean mantenimientoListo, boolean estaActiva){
        Atraccion aux = buscarAtraccion(codigo);
        
        if(aux == null){
            Atraccion nuevo = new Atraccion(precioPublico, codigo, costoMantenimiento, rodamientosPreMantenimiento, mantenimientoListo, estaActiva);
            atracciones.add(nuevo);
            System.out.println("Se ha agregado una atracción con el código: "+codigo);
        }
        else
            System.out.println("Ya existe una atracción con el código: "+ codigo);
    }
    
    public Atraccion buscarAtraccion(String codigoBuscar){
        for(int i = 0; i < atracciones.size(); i++){
            if(atracciones.get(i).getCodigo().equals(codigoBuscar)){
                return atracciones.get(i);
            }                
        }
        System.out.println("No se encontró ninguna atraccion con el código: " + codigoBuscar);
        return null;
    }
    
    public void modificarAtraccion(String codigoBuscar){
        Atraccion aux = buscarAtraccion(codigoBuscar);
        Scanner entrada= new Scanner(System.in);
        int opcion = 0;
        
        if (aux == null)
            opcion = 1;

        
        while(opcion != 1){
            System.out.println("Ingrese: \n"+
                    "1. para salir \n"+
                    "2. para modificar el precio al publico de la atraccion \n"+
                    "3. para modificar el codigo de la atraccion \n"+
                    "4. para modificar la cantidad de rodamientos máxima antes de hacer mantenimiento"+
                    "5. para modificar el costo de mantenimiento de la atraccion \n"+
                    "6. para modificar el estado de mantenimiento de la atraccion \n"+
                    "7. para modificar el estado de la atraccion \n");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Bye");
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nuevo precio al publico de la atraccion: ");
                    aux.precioPublico = entrada.nextFloat();
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nuevo código de la atraccion: ");
                    String nuevoCodigo = entrada.next();
                    
                    Atraccion aux2 = buscarAtraccion(nuevoCodigo);
                    
                    if (aux2 == null)
                        aux.setCodigo(nuevoCodigo);
                    else
                        System.out.println("Ya hay una atracción con el código: "+nuevoCodigo);
                    break;
                    
                case 4:
                     System.out.println("Ingrese la nueva cantidad de rodamientos máxima de la atraccion: ");
                     aux.setRodamientosPreMantenimiento(entrada.nextInt());
                     break;
                     
                case 5:
                    System.out.println("Ingrese el nuevo costo de mantenimiento de la atraccion: ");
                    aux.setCostoMantenimiento(entrada.nextFloat());
                    break;
                    
                case 6:
                    System.out.println("Ingrese el nuevo estado de mantenimiento de la atraccion: ");
                    aux.setMantenimientoListo(entrada.nextBoolean());
                    break;
                    
                case 7:
                    System.out.println("Ingrese el nuevo estado de la atraccion: ");
                    aux.setEstaActiva(entrada.nextBoolean());
                    break;
            }
        }
    }
    
    public void mostrarAtracciones(){
        for(int i = 0; i < atracciones.size(); i++)
            System.out.println(atracciones.get(i).toString());
    }
    
//    METODOS PARA  EL ARREGLO USUARIOS
    
    public void agregarUsuario(float totalInvertido, String ID){
        Usuario aux = buscarUsuario(ID);
        
        if(aux == null){
            Usuario nuevo = new Usuario(totalInvertido,ID);
            usuarios.add(nuevo);
            System.out.println("Se ha agregado un usuario con el ID: "+ ID);
        }  
        else
            System.out.println("ya existe un usuario con el ID: "+ ID);
    }
    
    public Usuario buscarUsuario(String idBuscar){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getID().equals(idBuscar)){
                return usuarios.get(i);
            }                
        }
        System.out.println("No se encontró ningun usuario con la ID: " + idBuscar);
        return null;
    }
    
    public void modificarUsuario(String idBuscar){
        Usuario aux = buscarUsuario(idBuscar);
        Scanner entrada= new Scanner(System.in);
        int opcion = 0;
        
        if (aux == null)
            opcion = 1;

        
        while(opcion != 1){
            System.out.println("Ingrese: \n"+
                    "1. para salir \n"+
                    "2. para modificar el total de inversiones del usuario \n"+
                    "3. para modificar el id del usuario \n");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Bye");
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nuevo valor de las inversiones del usuario: ");
                    aux.setTotalInvertido(entrada.nextFloat());
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nuevo ID del Usuario: ");
                    String nuevoIDUsuario = entrada.next();
                    
                    Usuario aux2 = buscarUsuario(nuevoIDUsuario);
                    
                    if(aux2 == null)
                        aux.setID(nuevoIDUsuario);
                    else
                        System.out.println("Ya hay una un Usuario con el ID: "+nuevoIDUsuario);
                    break;
            }
        }
    }
    
    public void mostrarUsiarios(){
        for(int i = 0; i < usuarios.size(); i++)
            System.out.println(usuarios.get(i).toString());
    }
    
//    METODOS PARA EL ARREGLO EMPLEADOS
    
    public void agregarEmpleado(float totalInvertido, String ID){
        Empleado aux = buscarEmpleado(ID);
        
        if(aux == null){
            Empleado nuevo = new Empleado(totalInvertido,ID);
            empleados.add(nuevo);
            System.out.println("Se ha agregado un empleado con el ID: "+ ID);
        }  
        else
            System.out.println("ya existe un empleado con el ID: "+ ID);
    }
    
    public Empleado buscarEmpleado(String idBuscar){
        for(int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getID().equals(idBuscar)){
                return empleados.get(i);
            }                
        }
        System.out.println("No se encontró ningun empleado con la ID: " + idBuscar);
        return null;
    }
    
    public void modificarEmpleado(String idBuscar){
        Empleado aux = buscarEmpleado(idBuscar);
        Scanner entrada= new Scanner(System.in);
        int opcion = 0;
        
        if (aux == null)
            opcion = 1;

        
        while(opcion != 1){
            System.out.println("Ingrese: \n"+
                    "1. para salir \n"+
                    "2. para modificar el total de comision del empleado \n"+
                    "3. para modificar el id del empleado \n");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Bye");
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nuevo valor de la comision del empleado: ");
                    aux.setTotalComision(entrada.nextFloat());
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nuevo ID del empleado: ");
                    String nuevoIDEmpleado = entrada.next();
                    
                    Empleado aux2 = buscarEmpleado(nuevoIDEmpleado);
                    
                    if(aux2 == null)
                        aux.setID(nuevoIDEmpleado);
                    else
                        System.out.println("Ya hay una un empleado con el ID: "+nuevoIDEmpleado);
                    break;
            }
        }
    }
    
    public void mostrarEmpleados(){
        for(int i = 0; i < empleados.size(); i++)
            System.out.println(empleados.get(i).toString());
    }
    
//    METODOS PARA EL SISTEMA
    public void calcularIngresos(){
        for(int i = 0; i < usuarios.size(); i++)
            this.ingresos += usuarios.get(i).getTotalInvertido();
        
        System.out.println("El total de ingresos es: "+ this.ingresos);
    }
    
    public void calcularEgresos(){
        for(int i = 0; i < proveedores.size(); i++)
            this.egresos += proveedores.get(i).getInversiones();

        for(int i = 0; i < empleados.size(); i++)
            this.egresos += empleados.get(i).getTotalComision();
        
        System.out.println("El total de egresos es: "+ this.egresos);
    }
    
    public void calcularGanancias (){
        float ganancias = this.ingresos - this.egresos;
        
        System.out.println("El total de ganancias es: "+ganancias);
    }
//    TOSTRING

    @Override
    public String toString() {
        return "ParqueDiversiones{" + "nombre=" + nombre + ", ingresos=" + ingresos + ", egresos=" + egresos + '}';
    }
}