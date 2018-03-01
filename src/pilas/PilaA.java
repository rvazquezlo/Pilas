/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author edi
 */
public class PilaA <T> implements PilaADT<T>{
    private T[] coleccion;
    private int tope;//ultimo elemento de la pila
    private final int MAX = 20;

    public PilaA() {
        coleccion = (T[])new Object[MAX];
        tope = -1;
    }
    
    public PilaA(int max) {
        coleccion = (T[])new Object[max];
        tope = -1;
    }
    
    private void expandCapacity(){
        int i;
        T[] expandido;
        
        expandido = (T[])new Object[coleccion.length * 20];
        for(i = 0; i < coleccion.length; i++)
            expandido[i] = coleccion[i];
        coleccion = expandido;
    }
    
    @Override
    public void push(T dato) {
        if (tope == coleccion.length - 1)
            expandCapacity();
        coleccion[tope + 1] = dato;
        tope++;         
    }

    /*
       Alternativa de pop
        public T pop() {
        if(isEmpty())
            throw new ExceptionColeccionVacia( );
        tope--;
        return coleccion[tope + 1];
    }
    
    */
    
    @Override
    public T pop() {
        T popped;
        
        if(isEmpty())
            popped = null;
        else{
            popped = coleccion[tope];
            tope--;
        }
        return popped;
    }

    /*
        public T peek() {
        if(!isEmpty())
            return coleccion[tope];
        throw new ExceptionColeccionVacia( );
        }
    */
    
    @Override
    public T peek() {
        T element;
        
        element = null;
        if(!isEmpty())
            element = coleccion[tope];
        return element;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public boolean equals() {
        return true;
    }
    
    
}
