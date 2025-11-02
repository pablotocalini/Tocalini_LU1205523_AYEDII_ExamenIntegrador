package com.pt.colaConPrioridadD.interfaces;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Cola con Prioridad dinámica.
 *
 * Objetivo de la cola con prioridad: se utiliza para gestionar la lista de procesos
 * suspendidos, donde se le agrega una prioridad al momento de pasarle a esta cola.
 * Elegí usar el enfoque dinámico, ya que es más flexible porque no sé la cantidad
 * de procesos que se cargarán.
 *
 * Precondición general: la cola debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface IColaConPrioridadD {

    /**
     * Inicializa la cola con prioridad.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    void initialize();

    /**
     * Agrega un elemento a la cola según su prioridad.
     *
     * @param value El valor a almacenar en la cola.
     * @param priority La prioridad del elemento (mayor valor indica mayor prioridad).
     */
    void add(String value, int priority);

    /**
     * Elimina el elemento de mayor prioridad de la cola.
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
     * Obtiene el valor del elemento de mayor prioridad sin eliminarlo.
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     *
     * @return El valor del elemento con mayor prioridad en la cola.
     */
    String getFirst();

    /**
     * Obtiene la prioridad del elemento de mayor prioridad sin eliminarlo.
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     *
     * @return La prioridad del elemento con mayor prioridad en la cola.
     */
    int getPriority();


}
