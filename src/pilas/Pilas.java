/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.ArrayList;

/**
 *
 * @author edi
 */
public class Pilas {

    public static <T> int cuentaElementos(PilaADT<T> pila){
        PilaA<T> pilaAuxiliar; 
        int i, total;
        
        try{
            total = 0;
            pilaAuxiliar = new PilaA<T>();
            while(!pila.isEmpty()){
            total++;
            pilaAuxiliar.push(pila.pop());
            }
            for(i = 0; i < total; i++)
                pila.push(pilaAuxiliar.pop());
        }
        catch(NullPointerException e){
            total = -1;
        }
           
        return total;   
    }
    
    public static<T> boolean determinaContenida(PilaADT<T> pGrande, PilaADT<T> pContenida){
        ArrayList<T> auxiliar1, auxiliar2;
        boolean contenida;
        int i;
        
        try{
            auxiliar1 = new ArrayList<T>();
            auxiliar2 = new ArrayList<T>();
            while(!pGrande.isEmpty())
                auxiliar1.add(pGrande.pop());
            while(!pContenida.isEmpty())
                auxiliar2.add(pContenida.pop());
            for(i = 0; i < auxiliar1.size(); i++)
                pGrande.push(auxiliar1.get(i));
            for(i = 0; i < auxiliar2.size(); i++)
                pContenida.push(auxiliar2.get(i));
            contenida = false;
            if(auxiliar1.size() >= auxiliar2.size()){
                i = 0;
                contenida = true;
                while(i < auxiliar2.size() && contenida){
                    if(!auxiliar1.contains(auxiliar2.get(i)))
                        contenida = false;
                    i++;
                }
                
            }
            
        }catch(NullPointerException e){
            contenida = false;
        }
        return contenida;       
    }
    
    public static<T> void invierteElementos(PilaADT<T> pila){
        ArrayList<T> auxiliar;
        int i, sizePila;
        
        try{
            auxiliar = new ArrayList<T>();
            while(!pila.isEmpty())
                auxiliar.add(pila.pop());
            sizePila = auxiliar.size();
            for(i = 0; i < sizePila; i++)
                pila.push(auxiliar.get(i));
        }catch(NullPointerException e){   
        }    
    }
    
    public static<T> void quitaRepetidos(PilaADT<T> pila){
        PilaA<T> auxiliar;
        
        try{
            if(!pila.isEmpty()){
                auxiliar = new PilaA<T>();
                auxiliar.push(pila.pop());
                while(!pila.isEmpty())
                    if(auxiliar.peek().equals(pila.peek()))
                        pila.pop();
                    else
                        auxiliar.push(pila.pop()); 
                while(!auxiliar.isEmpty())
                    pila.push(auxiliar.pop());
            }//end if
        }catch(NullPointerException e){
            
        }
    }
    
    public static<T> String imprimePila(PilaADT<T> pila){
        StringBuilder sb;
        PilaA<T> auxiliar;
        
        sb = new StringBuilder();
        try{
            auxiliar = new PilaA<T>();
            if(pila.isEmpty())
                sb.append("pila vacia");
            else{
                while(!pila.isEmpty())
                    auxiliar.push(pila.pop());
                while(!auxiliar.isEmpty()){
                    sb.append(auxiliar.peek() + "\t");
                    pila.push(auxiliar.pop()); 
                }//end while
            }//end else    
        }catch(NullPointerException e){
            sb.append("Se envió null");   
        }
        return sb.toString();
    }
    
    public static<T> boolean equals(PilaADT<T> pila1, PilaADT<T> pila2){
        boolean equal;
        ArrayList<T> aux1, aux2;
        int size, i;
        
        equal = false;
        try{
            if(pila1 != null && pila1 == pila2)//tienen misma direccion
                equal = true;
            else{
                aux1 = new ArrayList<T>();
                aux2 = new ArrayList<T>();
                while(!pila1.isEmpty() && !pila2.isEmpty() && pila1.peek().equals(pila2.peek())){
                    aux1.add(pila1.pop());
                    aux2.add(pila2.pop());
                }
                if(pila1.isEmpty() && pila2.isEmpty())
                    equal = true;
                size = aux1.size();
                for(i = 0; i < size; i++)
                    pila1.push(aux1.get(i));
                size = aux2.size();
                for(i = 0; i < size; i++)
                    pila2.push(aux2.get(i));
            }
            
        }catch(NullPointerException e){
            
        }
        return equal;
    }
    
    public static<T> boolean sonCasiIguales(PilaADT<T> pila1, PilaADT<T> pila2, int n){
        boolean sonCasiIguales;
        PilaADT<T> pilaAuxiliar1, pilaAuxiliar2;
        int contador1, contador2, i;
        
//        if(n < 0)
//            sonCasiIguales = false;
//        else
        try{
            sonCasiIguales = false;
            pilaAuxiliar1 = new PilaA<T>();
            contador1 = 0;
            while(!pila1.isEmpty()){
                pilaAuxiliar1.push(pila1.pop());
                contador1++;
            }
            if(contador1 >= n){
                pilaAuxiliar2 = new PilaA<T>();
                contador2 = 0;
                while(!pila2.isEmpty()){
                    pilaAuxiliar2.push(pila2.pop());
                    contador2++;
                }//end while
                if(contador2 >= n){
                    i = 0;
                    while(i < n && pilaAuxiliar1.peek().equals(pilaAuxiliar2.peek())){
                        i++;
                        pila2.push(pilaAuxiliar2.pop());
                        pila1.push(pilaAuxiliar1.pop());
                    }
                    if(i == n)
                        sonCasiIguales = true;       
                }// end if
                while(!pilaAuxiliar2.isEmpty())
                    pila2.push(pilaAuxiliar2.pop());  
            }//end outter-if
            while(!pilaAuxiliar1.isEmpty())
                    pila1.push(pilaAuxiliar1.pop());    
        }catch(NullPointerException e){
           sonCasiIguales = false;
        }
        return sonCasiIguales;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        RevisorParentesis revisa = new RevisorParentesis("22+6+(3)+(9+7");
//        System.out.println(revisa.analizaString());
//        revisa.setAnalizar("()");
//        System.out.println(revisa.analizaString());
//        revisa.setAnalizar(")");
//        System.out.println(revisa.analizaString());
        
        PilaA<Integer> pila, pila2;
//        PilaA<Double> pila2;
        int i;
        
        pila = new PilaA<Integer>();
        pila2 = new PilaA<Integer>();
//        pila2 = new PilaA<Double>();
        for(i = 0; i < 50; i++)
           pila.push(i + 1);
        for(i = 0; i < 4; i++)
           pila2.push(i + 1);
//        for(i = 20; i > 0; i--){
//           if(i % 2 == 0)
//               pila2.push(i);
//           else
//               pila2.push(i - 1);
//        }
//        for(i = 20; i > 0; i--){
//           if(i % 2 == 0)
//               pila2.push((double)i);
//           else
//               pila2.push((double)(i - 1));
//        }
//            
        
//        System.out.println(cuentaElementos(pila));
//        System.out.println(determinaContenida(pila, pila2));

//        System.out.println(imprimePila(pila));
//        invierteElementos(pila);
//        System.out.println(imprimePila(pila));
//        quitaRepetidos(pila);
//        System.out.println(imprimePila(pila));
        System.out.println(sonCasiIguales(pila, pila2, -1));
        
        
        
//        System.out.println(equals(pila, pila2));
    }
    
}
