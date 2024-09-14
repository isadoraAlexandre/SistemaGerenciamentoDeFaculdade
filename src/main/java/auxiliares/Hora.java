/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliares;

/**
 *
 * @author isinha
 */
public class Hora {
    private int hh;
    private int mm;

    public Hora(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }
    
    public void imprime(){
        System.out.println(this.hh + ":" + this.mm);
    }
}
