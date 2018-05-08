/*
 * Estructura de datos Pila usando estructuras enlazadas
 */
package pilas;

import estructurasenlzadas.LinkedList;
import java.util.Iterator;



/**
 *
 * @author Regina Vazquez
 */
public class PilaEE<T> implements PilaADT<T>{
    private LinkedList<T> pila;
    
    public PilaEE(){
        pila = new LinkedList();
    }
    
    public boolean isEmpty(){
        return pila.isEmpty();
    }
    
    public void push(T dato){
        pila.addHead(dato);
    }
    
    public T pop(){
        return pila.removeFirst();
    }
   
    public T peek(){
        T respuesta;
        Iterator<T> iterador = pila.iterator();
        
        if(iterador.hasNext())
            respuesta = iterador.next();
        else
            respuesta = null;
        return respuesta;          
    }

    @Override
    public boolean equals(Object otra) {
        return pila.equals(otra); 
    }

}
