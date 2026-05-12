/*
 * Ambriz Cordero Diego Said
 * Medeles Bryan Jonathan
 * Rivera Andrade Jorge
 */
package back;

/**
 *
 * @author jra
 */
public class Cotizacion {
    private double frente;
    private double fondo;
    private double profundidad;
    
    private double costoCubeta;
    private double cantidadCubetas;
    private double rendimiento;
    private double manoObra;
    
    private double litros;
    private double cotizacion;
    private double superficie;
    private double totalCubetas;
    private double totalManoObra;

    public Cotizacion() {}

    public Cotizacion(  double frente, double fondo, double profundidad, 
                        double costoCubeta, double rendimiento, double manoObra) {
        this.frente = frente;
        this.fondo = fondo;
        this.profundidad = profundidad;
        this.costoCubeta = costoCubeta;
        this.rendimiento = rendimiento;
        this.manoObra = manoObra;
    }

    public void setFrente(double frente) { this.frente = frente; }

    public void setFondo(double fondo) { this.fondo = fondo; }

    public void setProfundidad(double profundidad) { this.profundidad = profundidad; }

    public void setCostoCubeta(double costoCubeta) { this.costoCubeta = costoCubeta; }

    public void setManoObra(double manoObra) { this.manoObra = manoObra; }

    public void setRendimiento(double rendimiento) { this.rendimiento = rendimiento; }
    
    public double calculaCotizacion() {         
        if( frente > 0 && fondo > 0 && profundidad > 0 && costoCubeta > 0 && rendimiento > 0 && manoObra >= 0) {
            superficie = ( (frente + frente + fondo + fondo) * profundidad ) + ( frente * fondo );
            litros = superficie / rendimiento;
            cantidadCubetas = litros / 20;
            totalCubetas = cantidadCubetas * costoCubeta;
            totalManoObra = manoObra * superficie;
            cotizacion = totalCubetas + totalManoObra;
        } else {
            cotizacion = 0;
        }
        
        return cotizacion; 
    }

    public double getLitros() { return litros; }

    public double getSuperficie() { return superficie; }

    public double getTotalCubetas() { return totalCubetas; }

    public double getTotalManoObra() { return totalManoObra; }

    public double getCantidadCubetas() { return cantidadCubetas; }
    
}
