/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlzadas;

import conjuntos.ConjuntoA;
import java.util.Iterator;

/**
 *
 * @author hca
 */
public class LinkedList<T> implements Iterable<T>{
    private Nodo<T> inicio; //el primer nodo de a lista
    private Nodo<T> fin; //el ultimo nodo de la lista
    
    /**
     * Constructor vacio asigna null a los dos atributos
     */
    public LinkedList(){
        inicio = null;
        fin = null;
    }
    
    /**
     * Determina si la lista esta vacia
     * @return: true if list is empty
     */
    public boolean isEmpty(){
        return inicio == null; 
    }
   
    /**
     * Agrega un dato a inicio 
     * @param dato: que se quiere agregar 
     */
    public void addHead(T dato){
        Nodo<T> nuevo;
        
        nuevo = new Nodo(dato);
        if(isEmpty())
            fin = nuevo;
        nuevo.setDireccion(inicio);
        inicio = nuevo;
    }
    
    /**
     * Agrega un dato al final 
     * @param dato: que se quiere agregar 
     */
    public void addTail(T dato){
        Nodo<T> nuevo;
        
        nuevo = new Nodo(dato);
        if(isEmpty())
            inicio = nuevo;
        else
            fin.setDireccion(nuevo);
        fin = nuevo;
    }
    
    private boolean insertaAntesQue(T referencia, T nuevo, Nodo<T> auxiliar){
        Nodo <T> nodoReferencia;
        
        try{
            if(auxiliar.getDireccion().getDato().equals(referencia)){
                nodoReferencia = auxiliar.getDireccion();
                auxiliar.setDireccion(new Nodo(nuevo));
                auxiliar.getDireccion().setDireccion(nodoReferencia);
                return true;
            }
            else
                return insertaAntesQue(referencia, nuevo, auxiliar.getDireccion());
        }catch(NullPointerException e){//referencia no esta. El null se da por .getDato() 
            return false;
        }
    }
    
    public boolean insertaAntesQue(T referencia, T nuevo){
        boolean insertado;
        
        insertado = false;
        if(!isEmpty() && referencia != null && nuevo != null){
            if(referencia.equals(inicio.getDato())){
                addHead(nuevo);
                insertado = true;
            }
            else
                insertado = insertaAntesQue(referencia, nuevo, inicio);
        }
        return insertado;       
    }
    
    public Iterator<T> iterator(){
        return new IteradorLinkedList(inicio);
    }
    
    /**
     * Elimna el primer elemento de la estructura
     * @return: el elemento quitado. Si no habia elemento, regresa null 
     */
    public T removeFirst(){
        T removed;
        Nodo<T> auxiliar;
        
        removed = null;
        if(!isEmpty()){
            removed = inicio.getDato();
            auxiliar = inicio;
            if(inicio == fin)//solo hay un dato;
                fin = null;
            inicio = inicio.getDireccion();
            auxiliar.setDireccion(null);
        }
        return removed;
    }
    
    public T removeLast(){
        Nodo<T> auxiliar;
        T removed;
        
        removed = null;
        if(!isEmpty()){
            auxiliar = inicio;
            removed = fin.getDato();
            if(auxiliar.getDireccion() == null){//solo hay un dato
                inicio = null;
                fin = null;
            }
            else{
                while(fin != auxiliar.getDireccion()){
                    auxiliar = auxiliar.getDireccion();
                }
                auxiliar.setDireccion(null);
                fin = auxiliar;
            }
        }
        return removed;
    }
    
    public T busca(T dato){
        Iterator<T> iterador;
       // encontrado;
        T encontrado, auxiliar;
        
        iterador = this.iterator();
        encontrado = null;
        while(iterador.hasNext() && encontrado == null){
            auxiliar = iterador.next();
            if(auxiliar.equals(dato))
                encontrado = auxiliar;
        }
        return encontrado;
    }
    
    public T buscaRecursiva(T dato){
        Nodo<T> auxiliar;
        T encontrado;
        
        encontrado = null;
        if(!isEmpty()){
            auxiliar = inicio;
            encontrado = buscaRecursiva(dato, auxiliar);
        }
        else
            encontrado = null;
        return encontrado;
    }
    
    private T buscaRecursiva(T dato, Nodo<T> auxiliar){
        try{   
            if(auxiliar.getDato().equals(dato)){
                return auxiliar.getDato();
            }
            return buscaRecursiva(dato, auxiliar.getDireccion());
        }catch(NullPointerException e){
            return null;
        }
    }
    
    public T remove(T dato){
        Nodo<T> auxiliar;
        T removed;
        
        removed = null;
        if(!isEmpty()){
            auxiliar = inicio;
            if(auxiliar.getDireccion() == null){//solo hay un dato
                inicio = null;
                removed = fin.getDato();
                fin = null;
            }
            else if(inicio.getDato().equals(dato)){
                removed = removeFirst();
            }
            else{
                try{
                    while(!auxiliar.getDireccion().getDato().equals(dato)){
                        auxiliar = auxiliar.getDireccion();
                    }
                    if(auxiliar.getDireccion().getDato().equals(dato)){
                        removed = auxiliar.getDireccion().getDato();
                        auxiliar.getDireccion().setDato(null);
                        auxiliar.setDireccion(auxiliar.getDireccion().getDireccion());
                    }
                }catch(NullPointerException e){
                    
                }  
            }
        }
        return removed;
    }
    
    private boolean eliminaAnteriorA(T dato, Nodo<T> auxiliar){
        Nodo<T> eliminado;
        
        try{
            if(auxiliar.getDireccion().getDireccion().getDato().equals(dato)){
                eliminado = auxiliar.getDireccion();
                auxiliar.setDireccion(eliminado.getDireccion());
                eliminado = null;
                return true;
            }
            else
                return eliminaAnteriorA(dato, auxiliar.getDireccion());
        }catch(NullPointerException e){//llegue al ultimo elemento y dato no estaba
            return false;
        }
    }
    
    /**
     * Funciona asumiendo que no hay datos repetidos
     * @param dato
     * @return 
     */
    public boolean eliminaAnteriorA(T dato){
        boolean eliminado;
        
        eliminado = false;
        if(dato != null && !isEmpty() && !dato.equals(inicio.getDato()) && inicio != fin){
            if(inicio.getDireccion().getDato().equals(dato)){//hay que eliminar el primer elemento
                    removeFirst();
                    eliminado = true;
            }
            else
                eliminado = eliminaAnteriorA(dato, inicio);
        }
        return eliminado;
    }
    
    private boolean eliminaSiguienteDe(T dato, Nodo<T> auxiliar){
        Nodo<T> eliminado;
        
        if(auxiliar.getDireccion() != null){//no he llegado a fin 
            if(auxiliar.getDato().equals(dato)){
                eliminado = auxiliar.getDireccion();
                auxiliar.setDireccion(eliminado.getDireccion());
                eliminado = null;
                return true;
            }
            else
                return eliminaSiguienteDe(dato, auxiliar.getDireccion());
        }
        else//Llegue al fin y dato no esta.
            return false;
    }
    
    /**
     * Funciona si dato no esta repetido
     * @param dato
     * @return 
     */
    public boolean eliminaSiguienteDe(T dato){
        boolean eliminado;
        
        if(!isEmpty() && dato != null && !dato.equals(fin.getDato())){
            eliminado = eliminaSiguienteDe(dato, inicio);
        }
        else 
            eliminado = false;
        return eliminado;
    }
    
//    toString alternativo    
//    public String toString(){
//        StringBuilder sb;
//        Nodo<T> auxiliar;
//        
//        sb = new StringBuilder();
//        auxiliar = inicio;
//        while(auxiliar != null){
//          sb.append(auxiliar.getDato());
//          auxiliar = auxiliar.getDireccion();
//        }
//        return sb.toString();    
//    }
    
    /**
     * Metodo auxiliar, recursivo de toString
     * @param auxiliar: auxiliar que se mueve de elemento a elemento
     * @param sb
     * @return 
     */
    private String toString(Nodo<T> auxiliar, StringBuilder sb){
        if(auxiliar == null)
            return sb.toString();
        else{
            sb.append(auxiliar.getDato() + "\n");
            return toString(auxiliar.getDireccion(), sb);
        }
    }
    
    /** 
     * @return: los elementos de la estructura en froma de cadena
     * @see private String toString(Nodo<T> auxiliar, StringBuilder sb)
     */
    public String toString(){
        StringBuilder sb;
        Nodo<T> auxiliar;
        
        sb = new StringBuilder();
        auxiliar = inicio;
        sb.append("Elementos de la lista: \n");
        return toString(auxiliar, sb);
    }
     
    private int eliminaTodosRepetidosOrdenado(Nodo<T> auxiliar){
        Nodo<T> siguiente, siguienteSiguiente;
        
        siguiente = auxiliar.getDireccion();
        if(siguiente != null){
            if(siguiente.getDato().equals(auxiliar.getDato())){
                siguienteSiguiente = siguiente.getDireccion();
                auxiliar.setDireccion(siguienteSiguiente);
                siguiente = null;
                if(siguienteSiguiente != null)//hay mas datos despues del que voy a eliminar
                    return 1 + eliminaTodosRepetidosOrdenado(auxiliar);
                else//el dato que voy a eliminar es el ultimo
                    return 1;
            }
            else
                return eliminaTodosRepetidosOrdenado(siguiente);
        }
        else//auxiliar es fin
            return 0;
    }
    
    public int eliminaTodosRepetidosOrdenado(){
        int eliminados;
        
        eliminados = 0;
        if(!isEmpty() && inicio != fin)
            eliminados = eliminaTodosRepetidosOrdenado(inicio);
        return eliminados;
    }
    
    private int eliminaTodosRepetidosDesordenado(ConjuntoA<T> conjunto, Nodo<T> auxiliar){
        Nodo<T> siguiente;
        
        siguiente = auxiliar.getDireccion();
        if(siguiente != null){
            if(!conjunto.add(siguiente.getDato())){//esta repetido
                auxiliar.setDireccion(siguiente.getDireccion());
                siguiente = null;
                return 1 + eliminaTodosRepetidosDesordenado(conjunto, auxiliar);
            }
            else
                return eliminaTodosRepetidosDesordenado(conjunto, siguiente);
        }
        else//auxiliar es fin
            return 0;    
    }
    
    public int eliminaTodosRepetidosDesordenado(){
        ConjuntoA<T> conjunto;
        int contador; 
        
        contador = 0;
        if(!isEmpty()){
            conjunto = new ConjuntoA();
            conjunto.add(inicio.getDato());
            contador = eliminaTodosRepetidosDesordenado(conjunto, inicio);
        }
        return contador;
    }
     
}
