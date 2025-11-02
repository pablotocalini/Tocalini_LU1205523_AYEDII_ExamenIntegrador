package com.pt.pilaD.implementation;

import com.pt.nodo.implementations.Nodo;
import com.pt.nodo.interfaces.INodo;
import com.pt.pilaD.interfaces.IPilaD;

/**
 * PilaDProcesosEnEjecucion: Pila Dinamica de Procesos en Ejecución
 *
 * Implementacion del TDA Pila Dinámica
 *
 * Objetivo de la Pila dinámica: se utiliza para mantener la pila de procesos en
 * ejecución, donde el último proceso en la pila es el que se está ejecutando
 * actualmente.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public class PilaD implements IPilaD {

    // Atributos
    private INodo first;

    // Constructor
    public PilaD() {
        this.initialize();
    }

    /**
     * Inicializa la pila.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.first = null;
    }

    /**
     * Agrega un elemento al inicio (tope de la pila).
     *
     * @param value El elemento a apilar.
     */
    @Override
    public void add(String value) {
        INodo newNode = new Nodo();     // Creo un nuevo nodo
        newNode.setInfo(value);         // Le asigno el valor
        newNode.setNext(this.first);    // Le paso la referencia de lo que ya estaba
        this.first = newNode;           // Apunto el 1° nodo al nuevo nodo
    }

    /**
     * Elimina el elemento del tope de la pila.
     *
     * @throws IllegalStateException si la pila está vacía
     * @precondition !isEmpty()
     */
    @Override
    public void remove() {
        if(this.isEmpty()) {    // Chequeo si está vacía
            throw new IllegalStateException("La pila esta vacia");
        }
        this.first = this.first.getNext();  // Asigno al 1° la referencia del nodo siguiente y el que estaba 1° se elimina por el garbage collector
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return <code>true</code> si la pila no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Obtiene el elemento del tope de la pila sin eliminarlo.
     *
     * @throws IllegalStateException si la pila está vacía
     * @precondition !isEmpty()
     *
     * @return El elemento en el tope de la pila (último elemento apilado).
     */
    @Override
    public String getTop() {
        if(this.isEmpty()) {    // Chequeo si está vacía
            throw new IllegalStateException("La pila esta vacia");
        }
        return this.first.getInfo();
    }

    /**
     * Metodo para copiar una pila
     *
     * @return pilaCopiada
     */
    public IPilaD copyPilaD() {
        // Creo dos pilas, una auxiliar y otra en donde se va a copiar
        IPilaD pilaCopiada = new PilaD();
        IPilaD aux = new PilaD();

        // 1° recorrido para pasar la pila a la auxiliar
        while (!this.isEmpty()) {
            aux.add(this.getTop());
            this.remove();
        }

        // 2° recorrido para reconstruir la pila original y la copia
        while (!aux.isEmpty()) {
            pilaCopiada.add(aux.getTop());
            this.add(aux.getTop());
            aux.remove();
        }

        return pilaCopiada;
    }

    /**
     * Representación en String de la pila
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Pila vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Pila: tope → [");
        INodo actual = this.first;
        while (actual != null) {
            sb.append(actual.getInfo());
            if (actual.getNext() != null) {
                sb.append(" → ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
