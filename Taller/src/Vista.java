import java.util.Scanner;
import java.util.List;

/**
 * Clase que representa la vista del programa.
 */
public class Vista {

    private Controlador controlador = new Controlador(); // Nueva instancia del controlador 

    // Declarar el Scanner
    private Scanner scanner = new Scanner(System.in);

    // Menú de opciones que se le mostrará al usuario
    public void show_and_ask() {
        boolean si = true;
       
        // Ciclo inicial que engloba el inicio del programa
                                
        while (si) {

            System.out.println("\nREGISTRO DE INFORMACIÓN \n");

            List<Sucursal> sucursales = controlador.getSucursales(); // Arreglo para agregar las sucursales a una lista

            for (int i = 0; i < sucursales.size(); i++) {
                System.out.println((i + 1) + ". " + sucursales.get(i).getNombre());
            }

            System.out.println((sucursales.size() + 1) + ". Crear nueva sucursal");
            System.out.println((sucursales.size() + 2) + ". Salir");
            System.out.print("Ingrese una opción: ");

            int optSeguir = scanner.nextInt();
            scanner.nextLine(); //  consumir línea

            if (optSeguir ==  sucursales.size() + 1) {
                
                // Se crea una sucursal  nueva
                System.out.print("\nIngrese el nombre de la nueva sucursal: ");
                String nombre = scanner.nextLine();
                
                
                System.out.print("Ingrese la locación de la nueva sucursal: ");
                String locacion = scanner.nextLine();
               

                controlador.newSucursal(nombre, locacion);

            } 
            else if (optSeguir == sucursales.size() + 2) { // de lo contrario se sigue con el programa para determinar sucursal
                si = false;

            } 
            else if (optSeguir > 0 &&  optSeguir<= sucursales.size()) {
                // Mostrar las opciones luego de la principal para sucursal

                Sucursal sucursalSeleccionada =  sucursales.get(optSeguir - 1);
                boolean siSucursal = true;

                while (siSucursal) {
                    System.out.println("\n");
                    
                    System.out.println("1. Registrar vehículo");
                    System.out.println("2. Agregar servicio");
                    System.out.println("3. Generar datos analíticos");
                    System.out.println("4. Regresar al menú principal");

                    System.out.print("Ingrese una opción: ");

                    int decision = scanner.nextInt();

                    // Se elige el caso dada la descisión sobre lo que quiera hacer el usuario
                    switch (decision) {
                        case 1:
                            System.out.println("\nREGISTRO DE VEHÍCULO:");
                            registrarVehiculo(sucursalSeleccionada);

                            break;

                        case 2:
                            System.out.println("Agregar servicio:");
                            System.out.print( "Ingrese la placa del vehículo: ");
                            String placa= scanner.nextLine();
                            scanner.nextLine();
                            
                            
                            System.out.print("Ingrese el tipo de servicio: ");
                            String tipo =  scanner.nextLine();
                            scanner.nextLine() ;
                            
                            System.out.print("Ingrese la fecha del servicio (día/mes/año): ");
                            String fecha = scanner.nextLine();
                            scanner.nextLine( );
                            
                            System.out.print("Ingrese el número de factura: ");
                            String numFactura  = scanner.nextLine();
                            scanner.nextLine(); 
                            
                            System.out.print("Ingrese el costo del servicio: ");
                            double costo  = scanner.nextDouble();
                            
                            controlador.servicio(placa, tipo, fecha, numFactura, costo);
                            break;

                        case 3:
                            
                            System.out.println("Estadísticas:");


                            break;
                        case 4:
                            siSucursal = false;
                            break;
                        default:
                            System.out.println("La opción que ha ingresado no es válida.") ;
                    }
                }
            } 
            else {
                System.out.println("La opción ingresada no es válida");
            }
        }
    }

    /**
     * Solicita los datos para registrar un vehículo.
     * 
     * @param sucursal
     */
    private void registrarVehiculo(Sucursal sucursal) {
    
        // Se le solicitan datos al usuario
        System.out.print("Ingrese la placa del vehículo: ");
        String placa  = scanner.nextLine();

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese la línea del vehículo: ");
        String linea =  scanner.nextLine();

        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo  = scanner.nextLine();

        System.out.print("Ingrese la fecha de ingreso del vehículo (día/mes/año): ");
        String fechaIngreso = scanner.next();

        System.out.print("Ingrese el nombre del propietario del vehículo: ");
        String  propietario = scanner.nextLine();

        //  instancia de Vehiculo 
        Vehiculo vehiculo =  new Vehiculo(placa, marca, linea,  modelo, fechaIngreso,  propietario );

        // vehículo a la sucursal
        controlador.registerVehiculo(sucursal.getNombre(), placa, marca, linea, modelo, fechaIngreso, propietario);

        System.out.println("\n\nEl vehículo ha sido registrado en la sucursal: "  + sucursal.getNombre());
    }
}
