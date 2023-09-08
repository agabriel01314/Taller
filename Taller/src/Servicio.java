/**
 * Clase que representa el servicio.
 */
public class Servicio {

    private String reparacion, date, numFactura;
    private double costo;

    // constructor 
    public Servicio(String reparacion, String date, String numFactura,double costo){
        this.reparacion= reparacion;
        this.date = date;
        this.numFactura = numFactura;
        this.costo =costo;

    }


    // Getters y setters
    public String getReparacion() {
        return reparacion;
    }
    public void setReparacion(String reparacion) {
        this.reparacion = reparacion;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getNumFactura() {
        return numFactura;
    }
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }




}