/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import common.Libro;
import common.NodoGenerico;

/**
 *
 * @author bryan
 */
public class ColaGenerico<T> {

    private NodoGenerico frente;
    private NodoGenerico fin;
    private int cantidad;

    public ColaGenerico() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    // Inserta al final (enqueue)
    public void offer(T libro) {
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

    // Elimina y devuelve el primero (dequeue)
    public T pull() {
        if (isEmpty()) {
            return null;
        }
        T libro = (T) frente.elem;
        frente = frente.abajo;
        if (frente == null) {
            fin = null;
        }
        cantidad--;
        return libro;
    }

    // Devuelve el primero sin eliminar
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) frente.elem;
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
        NodoGenerico actual = frente;
        while (actual != null) {
            elementos += actual.elem + " -> ";
            actual = actual.abajo;
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
