/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author jra
 */
public class Nodo {

    public Libro libro;
    public Nodo abajo;
    public Nodo arriba;
    public Libro objeto;
    public Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Libro libro) {
        this.libro = libro;
        objeto = libro;

    }

}
