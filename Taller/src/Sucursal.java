import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la sucursal del programa.s
 */
public class Sucursal {

    private String nombre;
    private String location;

    private List<Vehiculo> vehiculos; // Arreglo dinámico para añadir vehpiculos

    // costructor
    public Sucursal(String nombre,String location){
        this.nombre = nombre ;
        this.location = location;
        this.vehiculos = new ArrayList<>(); // Inicialización de la list
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    

}
