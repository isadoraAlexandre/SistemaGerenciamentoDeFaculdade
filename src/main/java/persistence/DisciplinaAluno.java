package persistence;

import java.io.File;
import usuarios.Usuario;

public class DisciplinaAluno extends DisciplinasPersistence {
    private usuarios.Usuario user;
    private File PATH;/* = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");*/
    //private File PATH2 = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv");

    public DisciplinaAluno(String a) {
        super(new File("/src/main/java/banco_arquivo/Disciplinas" + a + ".csv"));
        //this.user = new Usuario();
        //File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");
        
    }
}
