import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa los vehículos del programa.
 */

public class Vehiculo {

    private String placa, marca, linea,  modelo,  dateIngreso, propietario;

    private List<Servicio> servicios;


    // Constructor
    public Vehiculo(String placa, String marca, String linea, String modelo, String dateIngreso, String propietario){
        this.placa = placa;
        this.marca = marca;
        this.linea= linea;
        this.modelo = modelo;
        this.dateIngreso =dateIngreso;
        this.propietario= propietario;

        this.services = new ArrayList<>();
    }

    

    public List<Servicio> getServicios() {
        return services;
    }


    private List<Servicio> services;

    // Getters y setters
    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getLinea() {
        return linea;
    }


    public void setLinea(String linea) {
        this.linea = linea;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getDateIngreso() {
        return dateIngreso;
    }


    public void setDateIngreso(String dateIngreso) {
        this.dateIngreso = dateIngreso;
    }


    public String getPropietario() {
        return propietario;
    }


    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }


    public List<Servicio> getServices() {
        return services;
    }


    public void setServices(List<Servicio> services) {
        this.services = services;
    }
    

}
