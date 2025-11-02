package com.pt.colaConPrioridadD.implementation;

import com.pt.colaConPrioridadD.interfaces.IColaConPrioridadD;
import com.pt.nodo.implementations.NodoConPrioridad;
import com.pt.nodo.interfaces.INodoConPrioridad;

/**
 * Implementacion del TDA Cola con Prioridad dinámica
 *
 * Objetivo de la cola con prioridad: se utiliza para gestionar la lista de procesos
 * suspendidos, donde se le agrega una prioridad al momento de pasarle a esta cola.
 * Elegí usar el enfoque dinámico, ya que es más flexible porque no sé la cantidad
 * de procesos que se cargarán.
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public class ColaConPrioridadD implements IColaConPrioridadD {

    // Atributo
    INodoConPrioridad highPriorityNode;

    // Constructor
    public ColaConPrioridadD() {
        this.initialize();
    }

    /**
     * Inicializa la cola con prioridad.
     * Este metodo debe ser llamado antes de cualquier operación.
     */
    @Override
    public void initialize() {
        this.highPriorityNode = null;
    }

    /**
     * Agrega un elemento a la cola según su prioridad.
     *
     * @param value    El valor a almacenar en la cola.
     * @param priority La prioridad del elemento (mayor valor indica mayor prioridad).
     */
    @Override
    public void add(String value, int priority) {
        INodoConPrioridad newNode = new NodoConPrioridad(value, priority);

        // Si la cola está vacía o el nodo a agregar tiene mayor prioridad
        if(this.isEmpty() || priority > this.highPriorityNode.getPriority()) {
            // Pongo el nodo más prioritario primero
            newNode.setNext(this.highPriorityNode);
            this.highPriorityNode = newNode;

        } else {    // Si la cola no está vacía o el elemento tiene < prioridad que el de mayor prioridad en la cola
            INodoConPrioridad aux = this.highPriorityNode;

            // Chequeo:
            // 1) si el nodo sig. al de > prioridad no está vacío y
            // 2) el siguiente tiene mayor o igual prioridad que el nuevo nodo a ingresar
            while (aux.getNext() != null && aux.getNext().getPriority() >= priority) {
                aux = aux.getNext();    // Voy pasando de nodo en nodo
            }

            // Cuando encuentro el lugar que corresponde según prioridad
            newNode.setNext(aux.getNext()); // asigno la referencia al nodo vacío o con menor prioridad
            aux.setNext(newNode);   // cambio la referencia del nodo siguiente desde un nodo con más prioridad que el que quiero agregar
        }
    }

    /**
     * Elimina el elemento de mayor prioridad de la cola.
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("La cola con prioridad está vacía");
        }
        this.highPriorityNode = this.highPriorityNode.getNext();
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return <code>true</code> si la cola no contiene elementos, <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.highPriorityNode == null;
    }

    /**
     * Obtiene el valor del elemento de mayor prioridad sin eliminarlo.
     *
     * @return El valor del elemento con mayor prioridad en la cola.
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    @Override
    public String getFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("La cola con prioridad está vacía");
        }
        return this.highPriorityNode.getInfo();
    }

    /**
     * Obtiene la prioridad del elemento de mayor prioridad sin eliminarlo.
     *
     * @return La prioridad del elemento con mayor prioridad en la cola.
     *
     * @throws IllegalStateException si la cola está vacía
     * @precondition !isEmpty()
     */
    @Override
    public int getPriority() {
        if (this.isEmpty()) {
            throw new IllegalStateException("La cola con prioridad está vacía");
        }
        return this.highPriorityNode.getPriority();
    }

    /**
     * Metodo para copiar una cola con prioridad
     *
     * @return copia de la cola con prioridad actual
     */
    public IColaConPrioridadD copyColaConPrioridad() {
        IColaConPrioridadD copy = new ColaConPrioridadD();
        INodoConPrioridad actual = this.highPriorityNode;

        // Recorro y agrego todos los elementos manteniendo el orden
        while (actual != null) {
            copy.add(actual.getInfo(), actual.getPriority());
            actual = actual.getNext();
        }
        return copy;
    }

    /**
     * Representación en String de la cola con prioridad
     * Muestra los elementos en formato: (valor: prioridad)
     */
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Cola Con Prioridad vacía";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Cola Con Prioridad: [");

        INodoConPrioridad actual = this.highPriorityNode;
        while (actual != null) {
            // formato (valor: prioridad)
            sb.append("(").append(actual.getInfo()).append(": p ").append(actual.getPriority()).append(")");

            if (actual.getNext() != null) {
                sb.append(" → ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
