/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import common.Libro;
import common.Nodo;

/**
*
* @author bryan
*/
public class ColaLibros {
    private Nodo frente;
    private Nodo fin;
    private int cantidad;
    
    public ColaLibros() {
        frente = null;
        fin = null;
        cantidad = 0;
    }
    
    // Inserta al final (enqueue)
    public void offer(Libro libro) {
        Nodo nuevo = new Nodo(libro);
        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        cantidad++;
    }
    // Elimina y devuelve el primero (dequeue)
    public Libro pull() {
        if (isEmpty()) {
            return null;
        }
        Libro libro = frente.objeto;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        cantidad--;
        return libro;
    }
    // Devuelve el primero sin eliminar
    public Libro peek() {
        if (isEmpty()) {
            return null;
        }
        return frente.objeto;
    }
    // Verifica si está vacía
    public boolean isEmpty() {
        return frente == null;
    }
    // Cantidad de elementos
    public int size() {
        return cantidad;
    }
    // Muestra la cola
    public String showQueue() {
        String elementos = "";
        Nodo actual = frente;
        while (actual != null) {
            elementos += actual.objeto + " -> ";
            actual = actual. siguiente;
        }
        return elementos + "null";
    }
    // Vacía toda la cola
    public void clearQueue() {
        frente = null;
        fin = null;
        cantidad = 0;
    }
}