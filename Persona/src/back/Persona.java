/*
 * Ambriz Cordero Diego Said
 * Medeles Bryan Jonathan
 * Rivera Andrade Jorge
 */
package back;

/**
 *
 * @author Rivera Andrade Jorge
 */
public class Persona {
    private String nombre;
    private int edad;
    private double estatura;
    private double peso;
    private double imc;
    
    public Persona(){}
    
    public Persona(String name, int age, double height, double weight) {
        nombre = name;
        edad = age;
        estatura = height;
        peso = weight;
    }
    
    public void calcularIMC() {
        if(estatura==0.0) {
            imc = 0.0;
            return;
        } 
        imc = peso / (estatura * estatura);
    }
    
    public String getNombre() { return nombre; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getEdad() { return edad; }
    
    public void setEdad(int edad) { this.edad = edad; }
    
    public double getEstatura() { return estatura; }
    
    public void setEstatura(double estatura) { this.estatura = estatura; }
    
    public double getPeso() { return peso; }
    
    public void setPeso(double peso) { this.peso = peso; }
    
    public double getImc() { return imc; }
}
