/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastros;

import java.util.*;
import javax.swing.JTextField;
import usuarios.Usuario;


/**
 *
 * @author isinha
 */
public class Cadastros {
    private HashMap<Integer, Usuario> lista;
    private static int chave;

    public Cadastros() {
        chave = 0;
    }

    public static void incrementaChave(){
        chave++;
    }
    
    public void cadastraUsuario(Usuario u, Cadastros c){
        try{
            incrementaChave();
            this.lista.put(chave, u);
            //conectar banco
        }
        catch(java.lang.NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "nao foi possivel cadastrar usuario");
        }
    }
}
