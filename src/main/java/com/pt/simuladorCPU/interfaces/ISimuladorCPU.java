package com.pt.simuladorCPU.interfaces;

import com.pt.linkedList.interfaces.ILinkedList;

/**
 * Interfaz de la clase que implementa la funcionalidad de simulación de un CPU
 *
 * @author Pablo Tocalini
 * @version 1.0
 */
public interface ISimuladorCPU {

    /**
     * Metodo que agrega un nuevo proceso a la cola de procesos
     * entrantes.
     *
     * @param proceso a agregar a la cola
     */
    void agregarProceso(String proceso);

    /**
     * Metodo que mueve el proceso más antiguo de la cola de
     * procesos entrantes a la pila de procesos en ejecución.
     */
    void ejecutarProceso();

    /**
     * Metodo para suspender el proceso actualmente en ejecución
     * y lo mueve a la cola con prioridad.
     */
    void suspenderProceso();

    /**
     * Metodo que retorna una lista con los procesos actualmente
     * en ejecución.
     *
     * @return una lista de los procesos en ejecución
     */
    ILinkedList listarProcesosEnEjecucion();


    /**
     * Metodo que retorna una lista con los procesos actualmente
     * suspendidos.
     *
     * @return una lista de los procesos suspendidos
     */
    ILinkedList listarProcesosSuspendidos();

    /**
     * Metodo que retorna una lista con los procesos actualmente
     * en la cola de procesos de entrada.
     *
     * @return una lista de los procesos en la cola de procesos de entrada
     */
    ILinkedList listarProcesosEntrantes();

    /**
     * Muestra el estado completo del simulador (3 listas)
     *
     * Este metodo se implementa para que sea más legible el main
     *
     * @param titulo Descripción del estado a mostrar
     */
    void mostrarEstado(String titulo);
}
