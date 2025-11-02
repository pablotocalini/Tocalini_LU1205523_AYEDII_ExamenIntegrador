# 🖥️ Simulador de CPU con Tipos de Datos Abstractos

👨‍💻 Autor: Pablo Tocalini

## 📋 Descripción
Simulador de procesos de CPU implementado completamente en Java utilizando **Tipos de Datos Abstractos (TDAs)** desarrollados desde cero. El sistema gestiona procesos mediante tres estructuras principales:

- Cola circular dinámica
- Pila dinámica
- Cola con prioridad

### Estructuras de Datos Implementadas
| TDA | Propósito | Características                 |
|-----|-----------|---------------------------------|
| **Cola Circular Dinámica** | Procesos entrantes | FIFO, capacidad dinámica        |
| **Pila Dinámica** | Procesos en ejecución | LIFO, capacidad dinámica       |
| **Cola con Prioridad** | Procesos suspendidos | Orden por prioridad descendente |
| **Lista Enlazada** | Reportes | Inserción al final    |

### Diagrama de Flujo
Procesos Entrantes → [Cola Circular] → Ejecución → [Pila] → Suspensión → [Cola con Prioridad]