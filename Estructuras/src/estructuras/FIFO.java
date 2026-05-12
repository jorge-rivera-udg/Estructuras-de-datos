/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import common.Libro;
import common.Nodo;

/**
 *
 * @author jra
 */
public class FIFO {
    private Nodo frente; // primero en salir
    private Nodo fin; // último en entrar
    private int cantidad;
    
    public FIFO() {
        frente = null;
        fin = null;
        cantidad = 0;
    }
    
    // enqueue (antes push)
    public void enqueue(Libro libro) {
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

    // dequeue (antes pop)
    public Libro dequeue() {
        if (isEmpty()) {
            return null;
        }
        Libro actual = frente.objeto;
        frente = frente.siguiente;
        if (frente == null) { // si quedó vacía
            fin = null;
        }
        cantidad--;
        return actual;
    }
    
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return frente.objeto.toString();
    }
    
    public boolean isEmpty() {
        return frente == null;
    }
    
    public int size() {
        return cantidad;
    }
    
    public String showQueue() {
        Nodo actual = frente;
        String elementos = "";
        while (actual != null) {
            elementos += actual.objeto + " ";
            actual = actual.siguiente;
        }
        return elementos;
    }
    
    public void clear(){
        cantidad = 0;
        frente=null;
        fin=null;
    }
}