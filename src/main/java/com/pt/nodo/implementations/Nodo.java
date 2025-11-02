package com.pt.nodo.implementations;

import com.pt.nodo.interfaces.INodo;

public class Nodo implements INodo {

    // Atributos
    private String info;
    private INodo next;

    // Constructor
    public Nodo() {
        this.next = null;
    }

    /**
     * Le otorga el valor a guardar en ese nodo
     *
     * @param value valor a guardar
     */
    @Override
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Obtiene el valor alojado en ese nodo
     *
     * @return el valor alojado en el nodo
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * Establece el nodo siguiente
     *
     * @param next el nodo siguiente
     */
    @Override
    public void setNext(INodo next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    @Override
    public INodo getNext() {
        return this.next;
    }
}
