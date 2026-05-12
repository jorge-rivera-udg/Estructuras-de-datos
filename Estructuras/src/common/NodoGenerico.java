/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author jra
 */
public class NodoGenerico<T> {

    public T elem;
    public NodoGenerico abajo;
    public NodoGenerico arriba;

    public NodoGenerico() {
    }

    public NodoGenerico(T elem) {
        this.elem = elem;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

}
