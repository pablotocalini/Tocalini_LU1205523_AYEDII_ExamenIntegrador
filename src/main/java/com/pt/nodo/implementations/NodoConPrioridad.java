package com.pt.nodo.implementations;

import com.pt.nodo.interfaces.INodo;
import com.pt.nodo.interfaces.INodoConPrioridad;

/**
 * Implementación de un nodo con prioridad para estructuras de datos ordenadas.
 * Cada nodo contiene un valor, una prioridad y referencia al siguiente nodo.
 */
public class NodoConPrioridad implements INodoConPrioridad {

    // Atributos
    private String info;
    private int priority;
    private INodoConPrioridad next;

    // Constructor
    public NodoConPrioridad() {
        this.next = null;
    }

    /**
     * Constructor con valores iniciales.
     *
     * @param info Valor a almacenar en el nodo
     * @param priority Prioridad del nodo
     */
    public NodoConPrioridad(String info, int priority) {
        this.info = info;
        this.priority = priority;
        this.next = null;
    }

    // Implementación de métodos de la interfaz NodoConPrioridad

    /**
     * Obtiene la prioridad del nodo.
     *
     * @return Valor de prioridad del nodo
     */
    @Override
    public int getPriority() {
        return this.priority;
    }

    /**
     * Establece la prioridad del nodo
     *
     * @param priority del nodo
     */
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Establece la referencia al siguiente nodo con prioridad.
     *
     * @param next Siguiente nodo en la estructura (debe ser NodoConPrioridad)
     */
    @Override
    public void setNext(INodoConPrioridad next) {
        this.next = next;
    }

    /**
     * Obtiene la referencia al siguiente nodo con prioridad.
     *
     * @return Siguiente nodo en la estructura
     */
    @Override
    public INodoConPrioridad getNext() {
        return this.next;
    }

    // Implementación de métodos de la interfaz Nodo

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
     * Realiza casting a NodoConPrioridad para mantener consistencia de tipos.
     *
     * @param next el nodo siguiente
     */
    @Override
    public void setNext(INodo next) {
        this.next = (INodoConPrioridad) next;
    }
}
