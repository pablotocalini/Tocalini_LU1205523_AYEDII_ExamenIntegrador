package com.pt.colaCircularD.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Cola Dinámica Circular.
 * Una cola es una estructura de datos que sigue el principio FIFO
 * (First-In, First-Out) - primero en entrar, primero en salir.
 *
 * Objetivo de la cola circular: se utiliza para gestionar la lista de procesos entrantes,
 * donde los procesos se ejecutan en orden de llegada. Elegí usar
 * el enfoque dinámico, ya que es más flexible porque no sé la cantidad
 * de procesos que se cargarán.
 *
 * Precondición general: la cola debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface IColaCircularD {

    /**
     * Inicializa la cola.
     * Este metodo debe ser llamado antes de cualquier operación.
     *
     */
    void initialize();

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param value El elemento a agregar a la cola.
     */
    void add(String value);

    /**
     * Elimina el primer elemento de la cola (elemento más antiguo).
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    void remove();

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El elemento más antiguo de la cola (primero en ser agregado).
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    String getFirst();

}
