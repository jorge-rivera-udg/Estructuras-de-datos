/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.modelo;

import back.estructura.Arista;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jra
 */
public class Nodo {
    private Ciudad ciudad;
    private List<Arista> aristas;
    public int x,y;

    public Nodo() {
    }

    public Nodo(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }
    
    public boolean agregarArista(Nodo destino, int peso){
        try {
            aristas.add(new Arista(destino, peso));
        } catch(Exception ex){
            return false;
        }
        return true;
    }
    
    public boolean removerArista(Nodo d){
        int i = aristas.indexOf(new Arista(d,0));
        if(i>-1){
            aristas.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.ciudad);
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nodo other = (Nodo) obj;
        return Objects.equals(this.ciudad, other.ciudad);
    }

    @Override
    public String toString() {
        return ciudad.getNombre();
    }
    
    
}
