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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RevisorParentesis revisa = new RevisorParentesis("22+6+(3)+(9+7");
        System.out.println(revisa.analizaString());
        revisa.setAnalizar("()");
        System.out.println(revisa.analizaString());
        revisa.setAnalizar(")");
        System.out.println(revisa.analizaString());
        
        PilaA<Integer> pila, pila2;
        int i;
        
        pila = new PilaA<Integer>();
        pila2 = new PilaA<Integer>();
        for(i = 0; i < 50; i++)
            pila.push(i + 1);
        for(i = 20; i > 0; i--)
            pila2.push(i);
        
        System.out.println(cuentaElementos(pila));
        System.out.println(determinaContenida(pila, pila2));
    }
    
}
