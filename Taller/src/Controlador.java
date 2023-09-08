import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Clase que representa el controlador del programa.
 */
public class Controlador {

    private Sucursal sucursalPrincipal;
    private List< Sucursal> sucursals; //Lista para añadir las sucursales creadas

    public List<Sucursal> getSucursales() {
        return sucursals;
    }

    public Controlador() {
        this.sucursals = new ArrayList<>();
        this.sucursalPrincipal = new Sucursal("Sucursal principal", "Locación principal");
        this.sucursals.add(this.sucursalPrincipal);
    }

    /**
     * Crea una nueva sucursal y la agrega a las sucursales existentes.
     * 
     * @param nombre
     * @param location
     */
    public void newSucursal(String nombre, String location){
        
        Sucursal sucursal = new Sucursal(nombre, location); // Nueva instancia de sucursal

        sucursals.add(sucursal); // Agrega la sucursal a la lista de sucursales

    }

    /**
     * Registra un nuevo vehículo con todos sus parámetros en la sucursal deseada.
     * 
     * @param sucursalName
     * @param placa
     * @param marca
     * @param linea
     * @param modelo
     * @param dateIngreso
     * @param propietario
     */
    public void registerVehiculo (String sucursalName, String placa, String marca, String linea, String modelo, String dateIngreso, String propietario){
       boolean findSucursal = false;

        for (Sucursal sucursal: sucursals){
            //            
            if (sucursal.getNombre().equals(sucursalName)) {
                Vehiculo vehiculo = new Vehiculo(placa, marca, linea, modelo, dateIngreso, propietario);
                sucursal.getVehiculos().add(vehiculo);
                findSucursal = true ;
                break;
            }
        }

        if (!findSucursal){
            System.out.println("\nLa sucursal ingresada no ha sido encontrada");
        }
    }


    /**
     * Registra un nuevo servicio del vehículo.
     * 
     * @param sucursalName
     * @param placa
     * @param tipo
     * @param Date
     * @param numFactura
     * @param moto
     */
    public void servicio(String placa, String tipo, String Date, String numFactura, double moto){

        for (Sucursal sucursal: sucursals){
            
            
                for( Vehiculo vehiculo: sucursal.getVehiculos()){
                    if( vehiculo.getPlaca().equals(placa)){

                        Servicio servicio = new Servicio(tipo, Date, numFactura, moto);
                        vehiculo.getServices().add(servicio);

                        return;

                    }
                }
            
        }

        System.out.println("\nEl vehículo ingresado no se encuentra en la sucursal.");
    }



    // NOTA:
    // Para realizar la estructura lógica del siguiente fragmento se utilizó como apoyo la IA de ChatGPT
    // OpenAI. Cómo crear una estructura lógica en Java para generar los datos analíticos que mostrarán las estadísticas de: promedio de vehículos reparados en una semana, los tipos de servicios que más se solicitan, las marcas más comunes, los 3 modelos de automóviles más frecuentes que ingresan al taller y los ingresos totales en un rango de fechas determinado. Esto según la Sucursal en la que se encuentre el vehículo, considere que se tiene los datos requeridos. ChatGPT de OpenIA. [consultado el 04/09/2023]. 
   

    public void datosAnaliticos() {
        int totalVehiculosReparados = 0;
        Map<String, Integer> tiposDeServicio = new HashMap<>();
        Map<String, Integer> marcasComunes = new HashMap<>();
        Map<String, Integer> modelosFrecuentes = new HashMap<>();
        double ingresosTotales = 0;
    
        // Obtener la fecha actual para el cálculo de la semana
        LocalDate fechaActual = LocalDate.now();
    
        for (Sucursal sucursal : sucursals) {
            for (Vehiculo vehiculo : sucursal.getVehiculos()) {
                // Verificar si hay servicios en el vehículo antes de acceder a ellos
                if (!vehiculo.getServices().isEmpty()) {
                    // Calcula la diferencia en días entre la fecha actual y la fecha de ingreso
                    LocalDate fechaIngreso = LocalDate.parse(vehiculo.getDateIngreso(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    long diferenciaEnDias = ChronoUnit.DAYS.between(fechaIngreso, fechaActual);
    
                    // Calcula la semana actual
                    long semanaActual = (diferenciaEnDias / 7) + 1;
    
                    if (semanaActual == 1) {
                        totalVehiculosReparados++;
                    }
    
                    // Actualiza el mapa de tipos de servicio
                    String tipoDeServicio = vehiculo.getServices().get(vehiculo.getServices().size() - 1).getReparacion();
                    tiposDeServicio.put(tipoDeServicio, tiposDeServicio.getOrDefault(tipoDeServicio, 0) + 1);
    
                    // Actualiza el mapa de marcas comunes
                    marcasComunes.put(vehiculo.getMarca(), marcasComunes.getOrDefault(vehiculo.getMarca(), 0) + 1);
    
                    // Actualiza el mapa de modelos frecuentes
                    modelosFrecuentes.put(vehiculo.getModelo(), modelosFrecuentes.getOrDefault(vehiculo.getModelo(), 0) + 1);
    
                    // Calcula los ingresos totales
                    for (Servicio servicio : vehiculo.getServices()) {
                        ingresosTotales += servicio.getCosto();
                    }
                }
            }
        }
    
        // Ordenar los modelos frecuentes por cantidad en orden descendente
        modelosFrecuentes = modelosFrecuentes.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    
        

        System.out.println("Promedio de vehículos reparados en la semana actual: " + totalVehiculosReparados);
        System.out.println("Tipos de servicios más solicitados: " + tiposDeServicio);
        System.out.println("Marcas más comunes: " + marcasComunes);
        System.out.println("Modelos de automóviles más frecuentes: " + modelosFrecuentes);
        System.out.println("Ingresos totales: $" + ingresosTotales);
    }
    
    
 
}
