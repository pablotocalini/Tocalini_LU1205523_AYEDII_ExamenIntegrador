package com.pt.linkedList.interfaces;

import com.pt.nodo.interfaces.INodo;

/**
 * Interfaz que define el Tipo de Dato Abstracto (TDA) para una Lista enlazada.
 *
 * Objetivo de la Lista Enlazada: se utiliza para tipar el retorno de los métodos
 * que listan procesos en la clase "SimuladorCPU"
 *
 * Precondición general: la Lista debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface ILinkedList {

    /**
     * Inicializa la lista.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    void initialize();

    /**
     * Agregar un elemento en la última posición.
     *
     * @param value contiene el valor a guardar en la ultima posición.
     */
    void add(String value);

    /**
     * Metodo para eliminar un valor
     *
     * @param value a eliminar
     */
    void remove(String value);

    /**
     * Metodo para buscar si un valor existe
     *
     * @param value a encontrar
     * @return <code>true</code> si el elemento existe,
     * <code>false</code> en caso contrario.
     */
    boolean exist(String value);

    /**
     * Metodo que devuelve el tamaño
     *
     * @return el tamaño de la lista
     */
    int size();

    /**
     * Metodo para saber si está vacía
     *
     * @return <code>true</code> si la lista no contiene elementos, <code>false</code> en caso contrario.
     */
    boolean isEmpty();
}
