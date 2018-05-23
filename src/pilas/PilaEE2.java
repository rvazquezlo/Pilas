/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import estructurasenlzadas.Nodo;
import java.util.Iterator;

/**
 *
 * @author edi
 */
public class PilaEE2<T> implements PilaADT<T>{
    private Nodo<T> tope;
    
    public PilaEE2(){
        tope = null;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales, comparacion;
        PilaEE2<T> otra;
        Nodo<T> aux, auxOtra;
        
        iguales = false;
        if(obj != null){
            if(obj == this)
                iguales = true;
            else if(obj.getClass() == getClass()){
                otra = (PilaEE2<T>) obj;
                comparacion = true;
                auxOtra = otra.tope;
                aux = tope;
                while(aux != null && comparacion && auxOtra != null){
                    
                    //comparar dato por dato hasta llegar a la direccion del ultimo nodo
                    comparacion = aux.getDato().equals(auxOtra.getDato());
                    aux = aux.getDireccion();
                    auxOtra = auxOtra.getDireccion();
                }
                if(aux == null && comparacion && auxOtra == null)
                    iguales = true;
            }
        }
        return iguales;
    }
    
    @Override
    public boolean isEmpty(){
        return tope == null;
    }
    
    @Override
    public void push(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setDireccion(tope);
        tope = nuevo;
    }
    
    public T pop(){
        T popped;
        Nodo<T> auxiliar;
        
        if(!isEmpty()){
            popped = tope.getDato();
            auxiliar = tope;
            tope = tope.getDireccion();
            auxiliar.setDireccion(null);
        }
        else
            popped = null;
        return popped;
    }
    
    public T peek(){
        T dato;
        
        if(!isEmpty())
            dato = tope.getDato();
        else
            dato = null;
        return dato;
    }
}
