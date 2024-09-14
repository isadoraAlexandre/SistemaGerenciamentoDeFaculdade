/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliares;

/**
 *
 * @author isinha
 */
public class Data {
    private int dd;
    private int mm;
    private int aa;

    public Data(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }
    
    public void imprime(){
        System.out.println(this.dd + "/" + this.mm + "/" + this.aa);
    }
}
