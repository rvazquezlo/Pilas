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
public interface PilaADT <T> {
    void push(T dato);
    T pop();
    T peek();
    boolean isEmpty();  
    boolean equals();
}
