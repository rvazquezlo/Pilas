/*
 * Se requiere de un programa que sea capaz de analizar una cadena 
    (un dato tipo String) para determinar si los paréntesis (izquierdos y derechos) 
    están balanceados.  En tu solución debes tener: 
     Interface Pila: según lo estudiado en clase. 
     Clase Pila: según lo estudiado en clase. 
     Clase RevisorParentesis: cuyo atributo es la cadena que se 
        quiere analizar. Además, debe contar con un método que realice el 
        análisis de la misma (con la ayuda de un objeto tipo Pila) y regrese 
        verdadero si se cumple la condición establecida o falso en caso contrario. .
 */
package pilas;

import java.util.Objects;

/**
 *
 * @author RVAZQUEZLO
 */
public class RevisorParentesis {
    private String analizar;

    public RevisorParentesis(String analizar) {
        this.analizar = analizar;
    }

    public String getAnalizar() {
        return analizar;
    }

    public void setAnalizar(String analizar) {
        this.analizar = analizar;
    }

    @Override
    public String toString() {
        return "RevisorParentesis{" + "analizar=" + analizar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RevisorParentesis other = (RevisorParentesis) obj;
        if (!Objects.equals(this.analizar, other.analizar)) {
            return false;
        }
        return true;
    }
    
    public boolean analizaString(){
        PilaA<Character> pila;
        int i, longitud;
        boolean prueba;
        Character ch;
        
        longitud = analizar.length();
        pila = new PilaA<Character>();
        i = 0;
        prueba = true;
        while(i < longitud && prueba){
            if(analizar.charAt(i) == '(')
                  pila.push(analizar.charAt(i));
            else if(analizar.charAt(i) == ')'){ 
                ch = pila.pop();
                if(ch == null)
                    prueba = false;
            }
            i++;
        }
        return prueba && pila.isEmpty();    
    }
    
}
