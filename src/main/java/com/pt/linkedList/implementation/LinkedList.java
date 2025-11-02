package com.pt.linkedList.implementation;

import com.pt.linkedList.interfaces.ILinkedList;
import com.pt.nodo.implementations.Nodo;
import com.pt.nodo.interfaces.INodo;

import java.util.NoSuchElementException;

/**
 * Implementación del TDA Lista enlazada.
 *
 * Objetivo de la Lista Enlazada: se utiliza para tipar el retorno de los métodos
 * que listan procesos en la clase "SimuladorCPU"
 *
 * Precondición general: la Lista debe estar inicializada antes de usar cualquier operación.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public class LinkedList implements ILinkedList {

    // Atributos
    private INodo head;     // Apunta al primer elemento
    private INodo tail;     // Apunta al ultimo elemento
    private int size;       // Tamaño de la lista

    // Constructor
    public LinkedList() {
        this.initialize();
    }

    /**
     * Inicializa la lista.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Agregar un elemento en la última posición.
     *
     * @param value contiene el valor a guardar en la ultima posición.
     */
    @Override
    public void add(String value) {
        // Creo un nuevo objeto nodo y le asigno el valor
        INodo newNodo = new Nodo();
        newNodo.setInfo(value);

        if (this.isEmpty()) {    // Lista vacía
            this.head = newNodo;
        }  else {
            this.tail.setNext(newNodo);
        }
        this.tail = newNodo;    // hago que el nuevo nodo agregado sea el último
        this.size++;
    }

    /**
     * Metodo para eliminar un valor
     *
     * @param value a eliminar
     */
    @Override
    public void remove(String value) {
        if (this.isEmpty()) {   // Si la lista está vacía
            throw new IllegalStateException("La lista está vacía");
        }

        INodo previous = null;      // Puntero que apunta al nodo anterior al actual
        INodo current = this.head;  // Puntero que apunta al nodo que actualmetne estamos analizando

        // Busco el elemento a eliminar
        while (current != null && current.getInfo() != value) {
            previous = current;
            current = current.getNext();
        }

        // Sí NO encuetro el elemento
        if (current == null) {
            throw new NoSuchElementException("Elemento " + value + " no encontrado");
        }

        // Sí el elemento a eliminar está en el 1° nodo (no ingreso al bucle)
        if (previous == null) {
            this.head = this.head.getNext();    // Elimino el primer elemento
        } else {
            previous.setNext(current.getNext());    // Elimino el elemento del medio o final
        }
        // Actualizo tail si elimino el último
        if (current == this.tail) {
            this.tail = previous;
        }

        this.size--;

        // Si la lista quedó vacía
        if (this.isEmpty()) {
            this.tail = null;   // Hago que tail también sea null
        }
    }

    /**
     * Metodo para buscar si un valor existe
     *
     * @param value a encontrar
     * @return <code>true</code> si el elemento existe,
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean exist(String value) {
        INodo aux = this.head;

        while (aux != null) {   // Recorre los nodos en busca del valor
            if (aux.getInfo() == value) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    /**
     * Metodo que devuelve el tamaño
     *
     * @return el tamaño de la lista
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Metodo para saber si está vacía
     *
     * @return <code>true</code> si la lista no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "Lista vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        INodo current = this.head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(" → ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
