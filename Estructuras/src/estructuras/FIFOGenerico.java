/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import common.Libro;
import common.NodoGenerico;

/**
 *
 * @author jra
 */
public class FIFOGenerico<T> {

    private NodoGenerico frente; // primero en salir
    private NodoGenerico fin; // último en entrar
    private int cantidad;

    public FIFOGenerico() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    // enqueue (antes push)
    public void enqueue(Libro libro) {
        NodoGenerico nuevo = new NodoGenerico(libro);
        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.abajo = nuevo;
            fin = nuevo;
        }
        cantidad++;
    }

    // dequeue (antes pop)
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T actual = (T) frente.elem;
        frente = frente.abajo;
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
        return frente.elem.toString();
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int size() {
        return cantidad;
    }

    public String showQueue() {
        NodoGenerico actual = frente;
        String elementos = "";
        while (actual != null) {
            elementos += actual.elem + " ";
            actual = actual.abajo;
        }
        return elementos;
    }

    public void clear() {
        cantidad = 0;
        frente = null;
        fin = null;
    }
}
