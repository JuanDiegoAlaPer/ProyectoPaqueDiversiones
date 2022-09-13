/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparquediversiones;

import java.util.Scanner;

/**
 *
 * @author juand
 */
public class ProyectoParqueDiversiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CREANDO UN PRIMER OBJETO POR DEFECTO DE CADA CLASE
        ParqueDiversiones parque = new ParqueDiversiones("forDefault", 0, 0);
        parque.agregarAtraccion(0, "forDefault", 0, 0, true, true);
        parque.agregarEmpleado(0, "forDefault");
        parque.agregarProveedor("forDefault", 0);
        parque.agregarUsuario(0, "forDefault");
        
        Scanner entrada= new Scanner(System.in);
        int opcion = 0;
        int ingresar = 0;
        
        System.out.println("Bienvenido al menú principal del parque de diversiones");
        
        while (ingresar != 1){
            System.out.println("Ingrese 1 para comenzar: ");
            ingresar = entrada.nextInt();
        }
        
        while (opcion != 1){
            int opcion2 = 0;
            
            System.out.println("Ingrese: \n"
                +"1. para salir \n"
                +"2. para gestionar la informacion parque de diversiones \n"
                +"3. para agregar informacion al sistema \n"
                +"4. para rodar una atraccion \n"
                +"5. para hacer mantenimiento a una atraccion \n"
                +"6. para realizar una devolución \n"
                +"7. para cobrar una garantía a un proveedor \n"
                +"8. para cobrar daño a un empleado \n"
                +"9. para calcular movimientos de dinero \n"
                +"10. para listar información del sistema \n"
                +"11. para modificar información del sistema \n"
                +"12. para cambiar estado de una atracción \n");
            opcion = entrada.nextInt();
            
            switch (opcion){
                case 1:
                    System.out.println("Bye");
                    break;
                    
                case 2:
                    while (opcion2 != 0){
                        System.out.println("Ingrese: \n"
                            +"1. para regresar \n"
                            +"2. para modificar nombre \n"
                            +"3. para modificar el valor de ingresos \n"
                            +"4. para modificar el valor de egresos \n"
                            +"5. para ver valores actuales \n");
                        opcion2 = entrada.nextInt();
                        
                        switch (opcion2){
                            case 1:
                                System.out.println("Bye");
                                break;
                                
                            case 2:
                                System.out.println("Ingrese el nuevo nombre: ");
                                parque.nombre = entrada.next();
                                break;
                                
                            case 3:
                                System.out.println("Ingrese el nuevo valor para ingresos");
                                parque.setIngresos(entrada.nextFloat());
                                break;
                                
                            case 4:
                                System.out.println("Ingrese el nuevo valor de egresos: ");
                                parque.setEgresos(entrada.nextFloat());
                                
                            case 5:
                                System.out.println(parque);
                        }
                    }
                    break;
                    
                case 3:
                    while (opcion2 != 0){
                        System.out.println("Ingrese: \n"
                            +"1. para regresar \n"
                            +"2. para agregar una atraccion \n"
                            +"3. para agregar un proveedor \n"
                            +"4. para agregar un usuario \n"
                            +"5. para agregar un empleado \n");
                        opcion2 = entrada.nextInt();
                        
                        switch (opcion2){
                            case 1:
                                System.out.println("Bye");
                                break;
                                
                            case 2:
                                System.out.println("Ingrese el costo para los usuarios de la atracción");
                                float precioPublico = entrada.nextFloat();
                                
                                System.out.println("Ingrese el codigo de la atracción");
                                String codigo = entrada.next();
                                
                                System.out.println("Ingrese los rodamientos máximos antes de hacerle mantenimiento a la atracción");
                                int rodamientos = entrada.nextInt();
                                
                                System.out.println("Ingrese el costo de mantenimiento de la atracción");
                                float costoMantenimiento = entrada.nextFloat();
                                
                                parque.agregarAtraccion(precioPublico, codigo, costoMantenimiento, rodamientos, true, true);
                                break;
                                
                            case 3:
                                System.out.println("Ingrese la marca");
                                String marca = entrada.next();
                                
                                parque.agregarProveedor(marca, 0);
                                break;
                                
                            case 4:
                                System.out.println("Ingrese el ID del usuario");
                                parque.agregarUsuario(0, entrada.next());
                                break;
                                
                            case 5:
                                System.out.println("Ingrese el ID del empleado");
                                parque.agregarEmpleado(0, entrada.next());
                                break;
                                
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Ingrese la cantidad de usuarios que van a subir a la atracción: ");
                    int usuarios = entrada.nextInt();
                    
                    System.out.println("Ingrese el codigo de la atracción a usar");
                    String codigoAtraccion = entrada.next();
                    
                    if(parque.buscarAtraccion(codigoAtraccion) != null){                        
                        System.out.println("Ingrese el ID del empleado");
                        String IDComision = entrada.next();
                        
                        float precioVoleta = parque.buscarAtraccion(codigoAtraccion).realizarRodamiento();
                        
                        if (precioVoleta != 0){
                            for (int i = 0; i < usuarios; i++){
                                System.out.println("Ingrese la ID del usuario numero: " + (i+1));
                                System.out.println("Si la ID no está registrada, se saltará a este usuario\nPorfavor esté seguro antes de ingresar la ID");
                                String IDconsumidor = entrada.next();
                                
                                if(parque.buscarUsuario(IDconsumidor) != null){
                                    parque.buscarUsuario(IDconsumidor).rodar(precioVoleta); 
                                    parque.buscarEmpleado(IDComision).setTotalComision(parque.buscarEmpleado(IDComision).getTotalComision() + ((precioVoleta)*15/100));
                                }                                
                            }
                        }
                    }  
                    break;
                    
                case 5:
                    System.out.println("Ingrese el código de la atracción para registrar el mantenimiento");
                    String codigoMantenimiento = entrada.next();
                    
                    System.out.println("Ingrese la marca del proveedor para la garantia");
                    String marcaGarantía = entrada.next();
                    
                    if(parque.buscarAtraccion(codigoMantenimiento) != null && parque.buscarProveedor(marcaGarantía) != null){
                        float factura = parque.buscarAtraccion(codigoMantenimiento).realizarMantenimiento();
                        
                        parque.buscarProveedor(marcaGarantía).setInversiones(parque.buscarProveedor(marcaGarantía).getInversiones() + factura);
                    }
                    break;
                    
                case 6:
                    System.out.println("Ingrese el ID del usuario para la devolución");
                    String IDDevolucion = entrada.next();
                    
                    if (parque.buscarUsuario(IDDevolucion) != null){
                        System.out.println("Ingrese el valor de devolucion");
                        float devolucion = entrada.nextFloat();
                        
                        parque.buscarUsuario(IDDevolucion).darDevolucion(devolucion);
                    }
                    break;
                    
                case 7:
                    System.out.println("Ingrese la marca del proveedor de la garantía");
                    String marcaPGarantia = entrada.next();                  
                    
                    if(parque.buscarProveedor(marcaPGarantia) != null){
                        System.out.println("Ingrese el valor de la garantía");
                        float precioGarantia = entrada.nextFloat();
                        
                        parque.buscarProveedor(marcaPGarantia).pedirGarantia(precioGarantia);
                    }
                    break;
                    
                case 8:
                    System.out.println("Ingrese el ID del empleado para el cobro");
                    String IDCobro = entrada.next();
                    
                    if (parque.buscarUsuario(IDCobro) != null){
                        System.out.println("Ingrese el valor de cobro");
                        float cobro = entrada.nextFloat();
                        
                        parque.buscarEmpleado(IDCobro).cobrarDaño(cobro);
                    }
                    break;
                    
                case 9:
                    while (opcion2 != 1){
                        System.out.println("Ingrese: \n"
                            +"1. para regresar \n"
                            +"2. para calcular ingresos \n"
                            +"3. para calcular egresos \n"
                            +"4. para calcular ganancias \n");
                        opcion2 = entrada.nextInt();
                        
                        switch (opcion2){
                            case 1:
                                System.out.println("Bye");
                                break;
                                
                            case 2:
                                parque.calcularIngresos();
                                break;
                                
                            case 3:
                                parque.calcularEgresos();
                                break;
                                
                            case 4:
                                parque.calcularGanancias();
                                break;
                        }
                    }
                    break;
                    
                case 10:
                    while (opcion2 != 1){
                        System.out.println("Ingrese: \n"
                            +"1. para regresar \n"
                            +"2. para listar las atracciones \n"
                            +"3. para listar los proveedores \n"
                            +"4. para listar los usuarios \n"
                            +"5. para listar los empleados \n");
                        opcion2 = entrada.nextInt();
                        
                        switch (opcion2){
                            case 1:
                                System.out.println("Bye");
                                break;
                                
                            case 2:
                                parque.mostrarAtracciones();
                                break;
                                
                            case 3:
                                parque.mostrarProveedores();
                                break;
                                
                            case 4:
                                parque.mostrarUsiarios();
                                break;
                                
                            case 5:
                                parque.mostrarEmpleados();
                                break;
                        }
                    }
                    break;   
                    
                case 11:
                    while (opcion2 != 1){
                        System.out.println("Ingrese: \n"
                            +"1. para regresar \n"
                            +"2. para modificar una atracción \n"
                            +"3. para modificar un proveedor \n"
                            +"4. para modificar un usuario \n"
                            +"5. para modificar un empleado \n");
                        opcion2 = entrada.nextInt();
                        
                        switch (opcion2){
                            case 1:
                                System.out.println("Bye");
                                break;
                                
                            case 2:
                                System.out.println("Ingrese el código de la atracción:");
                                String atraccionModificar = entrada.next();
                                
                                if(parque.buscarAtraccion(atraccionModificar) != null)
                                    parque.modificarAtraccion(atraccionModificar);
                                break;
                                
                            case 3:
                                System.out.println("Ingrese la marca del proveedor:");
                                String proveedorModificar = entrada.next();
                                
                                if(parque.buscarProveedor(proveedorModificar) != null)
                                    parque.modificarProveedor(proveedorModificar);
                                break;
                                
                            case 4:
                                System.out.println("Ingrese el código del usuario:");
                                String usuarioModificar = entrada.next();
                                
                                if(parque.buscarUsuario(usuarioModificar) != null)
                                    parque.modificarUsuario(usuarioModificar);
                                break;
                                
                            case 5:
                                System.out.println("Ingrese el código del empleado:");
                                String empleadoModificar = entrada.next();
                                
                                if(parque.buscarEmpleado(empleadoModificar) != null)
                                    parque.buscarEmpleado(empleadoModificar);
                                break;
                        }
                    }
                    break;
                    
                case 12:
                    System.out.println("Ingrese el código de la atracción");
                    String códigoEstado = entrada.next();
                    
                    if (parque.buscarAtraccion(códigoEstado) != null){
                        while (opcion2 != 1){
                            System.out.println("Ingrese: \n"
                                +"1. para regresar \n"
                                +"2. para desactivar la atracción \n"
                                +"3. para acrivar la atracción \n");
                            opcion2 = entrada.nextInt();
                        
                            switch (opcion2){
                                case 1:
                                    System.out.println("Bye");
                                    break;
                                  
                                case 2:
                                    parque.buscarAtraccion(códigoEstado).setEstaActiva(true);
                                    break;
                                    
                                case 3:
                                    parque.buscarAtraccion(códigoEstado).setEstaActiva(false);
                                    break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}