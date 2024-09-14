package usuarios;

import faculdade.Curso;
import java.util.Scanner;

public class Aluno extends Usuario {
    protected Curso curso;
    
    
    public Aluno() {
        this.tipoUsuario = 0;
    }
    

    
    
    public String leitura(){
        Scanner teclado = new Scanner(System.in);
        String t = teclado.nextLine();
        
        return t;
    }

    public void modificaNome(){
        System.out.println("digite novo nome: ");
        String newName = leitura();
        setNome(newName);
    }
}
