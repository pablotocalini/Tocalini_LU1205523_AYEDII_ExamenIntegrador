package com.pt.colaCircularD.implementation;

import com.pt.colaCircularD.interfaces.IColaCircularD;
import com.pt.nodo.implementations.Nodo;
import com.pt.nodo.interfaces.INodo;

/**
 * Implementación del TDA Cola Dinámica Circular.
 * Se agrega al final y se elimina desde el inicio
 *
 * Objetivo de la cola circular: se utiliza para gestionar la lista de procesos entrantes,
 * donde los procesos se ejecutan en orden de llegada. Elegí usar
 * el enfoque dinámico, ya que es más flexible porque no sé la cantidad
 * de procesos que se cargarán.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public class ColaCircularD implements IColaCircularD {

    // Atributos
    INodo firstNode;
    INodo lastNode;
    int size;

    // Constructor
    public ColaCircularD() {
        this.initialize();
    }

    /**
     * Inicializa la cola.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param value El elemento a agregar a la cola.
     */
    @Override
    public void add(String value) {
        // creo un nuevo nodo y le asigno el valor
        INodo newNode = new Nodo();
        newNode.setInfo(value);

        // Caso en que esté vacía la cola
        if(this.isEmpty()) {
            newNode.setNext(newNode);   // Al se circular se tiene que apuntar a si mismo
            this.firstNode = newNode;       // El primero actual apunta al nuevo nodo
            this.lastNode = newNode;        // El último actual apunta al nuevo nodo

        } else {
            // Insertar al final (después de lastNode)
            newNode.setNext(this.firstNode);    // para que sea cíclico, el último apunta al primero
            this.lastNode.setNext(newNode);     // el que era último, apunta al nuevo ultimo
            this.lastNode = newNode;            // Actualizo el último
        }
        this.size++;    // Actualizo el contador
    }

    /**
     * Elimina el primer elemento de la cola (elemento más antiguo).
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    @Override
    public void remove() {
        if(this.isEmpty()) { // Cola vacía
            throw new IllegalStateException("La cola está vacía");

        } else if(this.size == 1) { // Si hay sólo un elemento
            this.firstNode = null;
            this.lastNode = null;

        }  else {
            // Avanzar el firstNode
            INodo newFirst = this.firstNode.getNext();

            // Reconectar circularidad
            this.lastNode.setNext(newFirst);    // Uno el último al nuevo primero
            this.firstNode = newFirst;      // Actualizo el firstNode
        }
        this.size--;    // disminuyo el contador
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return El elemento más antiguo de la cola (primero en ser agregado).
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    @Override
    public String getFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return this.firstNode.getInfo();
    }

    /**
     * Metodo para copiar la cola circular
     * @return copia de la cola circular actual
     */
    public IColaCircularD copyColaCircular() {
        IColaCircularD copy = new ColaCircularD();

        // Recorro y agrego todos los elementos manteniendo el orden circular
        INodo actual = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            copy.add(actual.getInfo());
            actual = actual.getNext();
        }
        return copy;
    }

    /**
     * Representación
     */
    @Override
    public String toString() {
        if (this.isEmpty()) return "Cola vacía";

        StringBuilder sb = new StringBuilder();
        sb.append("Cola circular [").append(size).append("]: ");

        INodo actual = this.firstNode;
        for (int i = 0; i < this.size; i++) {
            sb.append(actual.getInfo());
            if (i < this.size - 1) sb.append(" ⇄ ");
            actual = actual.getNext();
        }
        sb.append(" (cíclica)");
        return sb.toString();
    }
}
