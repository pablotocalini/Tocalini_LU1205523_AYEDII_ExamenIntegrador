package com.pt.pilaD.interfaces;

/**
 * IPilaDProcesosEnEjecucion: Interfaz de Pila Dinamica de Procesos en Ejecución
 *
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Pila.
 * Una pila es una estructura de datos que sigue el principio LIFO
 * (Last-In, First-Out) - último en entrar, primero en salir.
 *
 * Objetivo de la Pila dinámica: se utiliza para mantener la pila de procesos en
 * ejecución, donde el último proceso en la pila es el que se está ejecutando
 * actualmente.
 *
 * Precondición general: la pila debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface IPilaD {

    /**
     * Inicializa la pila.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    void initialize();

    /**
     * Agrega un elemento al inicio (tope de la pila).
     *
     * @param value El elemento a apilar.
     */
    void add(String value);

    /**
     * Elimina el elemento del tope de la pila.
     *
     * @throws IllegalStateException si la pila está vacía
     * @precondition !isEmpty()
     */
    void remove();

    /**
     * Verifica si la pila está vacía.
     *
     * @return <code>true</code> si la pila no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el elemento del tope de la pila sin eliminarlo.
     *
     * @throws IllegalStateException si la pila está vacía
     * @precondition !isEmpty()
     *
     * @return El elemento en el tope de la pila (último elemento apilado).
     */
    String getTop();
}
