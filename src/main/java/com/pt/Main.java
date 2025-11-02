package com.pt;

import com.pt.simuladorCPU.implementation.SimuladorCPU;
import com.pt.simuladorCPU.interfaces.ISimuladorCPU;


public class Main {
    public static void main(String[] args) {
        ISimuladorCPU simulador = new SimuladorCPU();

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║         SIMULADOR DE CPU - BIENVENIDO/A          ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        try {
            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado inicial de las listas de procesos del simulador");

            // Agrego varios procesos a la cola de procesos
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ AGREGANDO 3 PROCESOS A LA COLA DE PROCESOS ENTRANTES - (Metodo - agregarProceso(String proceso)) │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────┘");

            for (int i = 1; i <= 3; i++) {
                simulador.agregarProceso("Proceso " + i);
                System.out.println("✓ Agregado: Proceso " + i);
            }

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado de las listas de procesos del simulador luego de agregar 3 procesos");

            // Ejecuto alguno de esos procesos
            System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ EJECUTANDO 2 PROCESOS - Pasan a la Pila de Procesos en Ejecución - (Método - ejecutarProceso()) │");
            System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────┘");

            for (int i = 1; i <= 2; i++) {
                simulador.ejecutarProceso();
                System.out.println("✓ Ejecutado: Proceso " + i);
            }

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado de las listas de procesos del simulador luego de ejecutar 2 de los 3 procesos");

        } catch (IllegalStateException e) {
            System.out.println("Error en la simulación: " + e.getMessage());
            System.out.println("Solución: Agregue más procesos antes de ejecutar");
        }

        try {
            // Suspendo 2 procesos
            System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ SUSPENDIENDO 2 PROCESOS - Pasan a la Cola de Procesos Suspendidos) - (Método - suspenderProceso())  │");
            System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────┘");

            for (int i = 1; i <= 2; i++) {
                simulador.suspenderProceso();

                // Muestro el estado actual de las listas de procesos
                simulador.mostrarEstado("Después de suspender el proceso actual en en ejecución");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error al suspender: " + e.getMessage());
            System.out.println("Solución: Ejecute procesos primero antes de suspender");
        }

        try {
            // Agrego 5 procesos a la cola de procesos
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ AGREGANDO 5 PROCESOS ADICIONALES A LA COLA DE PROCESOS ENTRANTES - (Metodo - agregarProceso(String proceso)) │");
            System.out.println("└──────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

            for (int i = 4; i <= 9; i++) {
                simulador.agregarProceso("Proceso " + i);
                System.out.println("✓ Agregado: Proceso " + i);
            }

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado de las listas de procesos del simulador luego de agregar 5 procesos adicionales");

            // Ejecuto 3 procesos
            System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ EJECUTANDO 3 PROCESOS - Pasan a la Pila de Procesos en Ejecución - (Método - ejecutarProceso()) │");
            System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────┘");

            for (int i = 1; i <= 3; i++) {
                simulador.ejecutarProceso();
                System.out.println("✓ Ejecutado: Proceso " + i);
            }

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado de las listas de procesos del simulador luego de ejecutar 3 procesos");

        } catch (IllegalStateException e) {
            System.out.println("Error en la simulación: " + e.getMessage());
            System.out.println("Solución: Agregue más procesos antes de ejecutar");
        }

        try {
            // Suspendo un proceso
            System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ SUSPENDIENDO 1 PROCESO - Pasan a la Cola de Procesos Suspendidos) - (Método - suspenderProceso())  │");
            System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────┘");

            simulador.suspenderProceso();

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Después de suspender el proceso actual en en ejecución");

        } catch (IllegalStateException e) {
            System.out.println("Error al suspender: " + e.getMessage());
            System.out.println("Solución: Ejecute procesos primero antes de suspender");
        }

        try {
            // Intento ejecutar 10 procesos - PARA QUE FALLE
            System.out.println("┌─────────────────────────────────────────────────┐");
            System.out.println("│ INTENTANDO EJECUTAR 10 PROCESOS (TEST DE ERROR) │");
            System.out.println("└─────────────────────────────────────────────────┘");

            for (int i = 1; i <= 10; i++) {
                simulador.ejecutarProceso();
                System.out.println("✓ Ejecutado: Proceso " + i);
            }

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado de las listas de procesos del simulador luego de ejecutar 10 procesos");

        } catch (IllegalStateException e) {
            System.out.println("\nError en la simulación: " + e.getMessage());
            System.out.println("Solución: Agregue más procesos antes de ejecutar");

        } finally {
            // Listar procesos
            System.out.println("\n╔══════════════════════════════════════════════════╗");
            System.out.println("║           SIMULACIÓN COMPLETADA                  ║");
            System.out.println("╚══════════════════════════════════════════════════╝");

            // Muestro el estado actual de las listas de procesos
            simulador.mostrarEstado("Estado final de las listas de procesos del simulador");
        }
    }
}