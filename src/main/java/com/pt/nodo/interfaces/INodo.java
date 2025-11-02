package com.pt.nodo.interfaces;

public interface INodo {

    /**
     * Le otorga el valor a guardar en ese nodo
     *
     * @param value valor a guardar
     */
    void setInfo(String value);

    /**
     * Obtiene el valor alojado en ese nodo
     *
     * @return el valor alojado en el nodo
     */
    String getInfo();

    /**
     * Establece el nodo siguiente
     *
     * @param next el nodo siguiente
     */
    void setNext(INodo next);

    /**
     * Obtiene el nodo siguiente
     *
     * @return el proximo nodo si existe
     */
    INodo getNext();
}
