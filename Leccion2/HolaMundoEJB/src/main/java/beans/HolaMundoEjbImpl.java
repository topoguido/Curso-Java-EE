/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author Emiliano
 */
@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote {

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo suma en servidor = " + a+b);
        return a + b;
    }
    
}
