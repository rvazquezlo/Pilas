/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author rvazquezlo
 */
public class InvierteString {
    private String cadenaInicial;
    private String cadenaInvertida;

    public InvierteString(String cadenaInicial) {
        this.cadenaInicial = cadenaInicial;
        cadenaInvertida = "";
    }

    public String getCadenaInicial() {
        return cadenaInicial;
    }

    public void setCadenaInicial(String cadenaInicial) {
        this.cadenaInicial = cadenaInicial;
    }

    public String getCadenaInvertida() {
        return cadenaInvertida;
    }

    public void setCadenaInvertida(String cadenaInvertida) {
        this.cadenaInvertida = cadenaInvertida;
    }
    
    public String invierteCadena(){
        char[] arregloCadenaInvertida;
        int i, longitud;
        PilaA<Character> pila;
        
        pila = new PilaA<Character>();
        longitud = cadenaInicial.length();
        for(i = 0; i < longitud; i++)
            pila.push(cadenaInicial.charAt(i));
        arregloCadenaInvertida = new char[longitud];
        for(i = 0; i < longitud; i++)
            arregloCadenaInvertida[i] = pila.pop();
        cadenaInvertida.valueOf(arregloCadenaInvertida);
        return cadenaInvertida;
    }
            
}
