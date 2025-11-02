package com.pt.nodo.interfaces;

/**
 * Interfaz que extiende de Nodo para incluir la funcionalidad de prioridad.
 * Para usar en Colas con Prioridad.
 */
public interface INodoConPrioridad extends INodo {

    /**
     * Obtiene la prioridad del nodo.
     *
     * @return Valor de prioridad del nodo
     */
    int getPriority();

    /**
     * Establece la prioridad del nodo
     *
     * @param priority del nodo
     */
    void setPriority(int priority);

    /**
     * Establece la referencia al siguiente nodo con prioridad.
     *
     * @param next Siguiente nodo en la estructura (debe ser NodoConPrioridad)
     */
    void setNext(INodoConPrioridad next);

    /**
     * Obtiene la referencia al siguiente nodo con prioridad.
     *
     * @return Siguiente nodo en la estructura
     */
    INodoConPrioridad getNext();
}
