package com.pt.simuladorCPU.implementation;

import com.pt.colaCircularD.implementation.ColaCircularD;
import com.pt.colaCircularD.interfaces.IColaCircularD;
import com.pt.colaConPrioridadD.implementation.ColaConPrioridadD;
import com.pt.colaConPrioridadD.interfaces.IColaConPrioridadD;
import com.pt.linkedList.implementation.LinkedList;
import com.pt.linkedList.interfaces.ILinkedList;
import com.pt.pilaD.implementation.PilaD;
import com.pt.pilaD.interfaces.IPilaD;
import com.pt.simuladorCPU.interfaces.ISimuladorCPU;

/**
 * Implementación de la clase que simula la funcionalidad de un CPU
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public class SimuladorCPU implements ISimuladorCPU {

    // Atributos
    private final IPilaD pilaProcesosEnEjecucion;
    private final IColaCircularD colaProcesosEntrantes;
    private final IColaConPrioridadD colaProcesosSuspendidos;
    private int contadorSuspensiones;   // Lleva el conteo de la cantidad de procesos suspendidos
    private final int PRIORIDAD_BASE; // Número para ir marcando la prioridad de los procesos que se suspenden

    // Constructor
    public SimuladorCPU() {
        this.colaProcesosEntrantes = new ColaCircularD();
        this.pilaProcesosEnEjecucion = new PilaD();
        this.colaProcesosSuspendidos = new ColaConPrioridadD();
        this.contadorSuspensiones = 0;
        this.PRIORIDAD_BASE = 100000;
    }

    /**
     * Metodo que agrega un nuevo proceso a la cola de procesos
     * entrantes.
     *
     * @param proceso a agregar a la cola
     */
    @Override
    public void agregarProceso(String proceso) {
        try {
            this.colaProcesosEntrantes.add(proceso);    // Agrego el proceso a la cola de procesos entrantes
        } catch (Exception e) {
            throw new IllegalStateException("Error al agregar proceso " + proceso);
        }
    }

    /**
     * Metodo que mueve el proceso más antiguo de la cola de
     * procesos entrantes a la pila de procesos en ejecución.
     */
    @Override
    public void ejecutarProceso() {
        try {
            String oldestProcess = this.colaProcesosEntrantes.getFirst();   // Tomo el proceso más antiguo de los entrantes que está en la 1° posición de la cola
            this.pilaProcesosEnEjecucion.add(oldestProcess);                // Lo meto en la pila de procesos en ejecución
            this.colaProcesosEntrantes.remove();                            // Saco el proceso de la cola de procesos entrantes

        }  catch (IllegalStateException e) {
            throw new IllegalStateException("Error al ejecutar el proceso: " + e.getMessage() +
                    " - No hay procesos en la cola de entrada para ejecutar");
        }
    }

    /**
     * Metodo para suspender el proceso actualmente en ejecución
     * y lo mueve a la cola con prioridad.
     */
    @Override
    public void suspenderProceso() {
        try {
            String suspendedProcess = this.pilaProcesosEnEjecucion.getTop();

            // Establezco la prioridad (el que se suspende 1° tiene más prioridad)
            int prioridad = PRIORIDAD_BASE - this.contadorSuspensiones;

            this.colaProcesosSuspendidos.add(suspendedProcess, prioridad);
            this.contadorSuspensiones++;    // Acualizo el contador de suspensiones

            this.pilaProcesosEnEjecucion.remove();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Error al suspender el proceso: " + e.getMessage() +
                    " - No hay procesos en ejecución para suspender");
        }
    }

    /**
     * Metodo que retorna una lista con los procesos actualmente
     * en ejecución.
     *
     * @return una lista de los procesos en ejecución
     */
    @Override
    public ILinkedList listarProcesosEnEjecucion() {
        ILinkedList executionProcessList = new LinkedList();

        IPilaD executionProcessCopy = ((PilaD) this.pilaProcesosEnEjecucion).copyPilaD();

        while(!executionProcessCopy.isEmpty()) {
            executionProcessList.add(executionProcessCopy.getTop());
            executionProcessCopy.remove();
        }
        return executionProcessList;
    }

    /**
     * Metodo que retorna una lista con los procesos actualmente
     * suspendidos.
     *
     * @return una lista de los procesos suspendidos
     */
    @Override
    public ILinkedList listarProcesosSuspendidos() {
        ILinkedList suspendedProcessList = new LinkedList();

        IColaConPrioridadD suspendedProcessCopy = ((ColaConPrioridadD) this.colaProcesosSuspendidos).copyColaConPrioridad();

        while(!suspendedProcessCopy.isEmpty()) {
            String proceso = suspendedProcessCopy.getFirst();
            int prioridad = suspendedProcessCopy.getPriority();

            suspendedProcessList.add(proceso + " (prioridad: " + prioridad + ")");
            suspendedProcessCopy.remove();
        }
        return suspendedProcessList;
    }

    /**
     * Metodo que retorna una lista con los procesos actualmente
     * en la cola de entrada.
     *
     * @return una lista de los procesos en la cola de procesos de entrada
     */
    @Override
    public ILinkedList listarProcesosEntrantes() {
        ILinkedList entryProcessList = new LinkedList();

        IColaCircularD entryProcessCopy = ((ColaCircularD) this.colaProcesosEntrantes).copyColaCircular();

        while(!entryProcessCopy.isEmpty()) {
            entryProcessList.add(entryProcessCopy.getFirst());
            entryProcessCopy.remove();
        }
        return entryProcessList;
    }

    /**
     * Muestra el estado completo del simulador (3 listas)
     *
     * Este metodo se implementa para que sea mas legible el main
     *
     * @param titulo Descripción del estado a mostrar
     */
    @Override
    public void mostrarEstado(String titulo) {
        // Título
        System.out.println("\n" + titulo + ":");

        // Separador
        System.out.println("──────────────────────────────────────────────────");

        // Las 3 listas
        System.out.println("Procesos entrantes:    " + this.listarProcesosEntrantes().toString());
        System.out.println("Procesos en ejecución: " + this.listarProcesosEnEjecucion().toString());
        System.out.println("Procesos suspendidos:  " + this.listarProcesosSuspendidos().toString() + "\n");
    }
}
