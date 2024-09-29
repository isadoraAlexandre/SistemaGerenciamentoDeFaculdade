package persistence;

import java.io.File;

public class DisciplinasProfessor extends DisciplinasPersistence {
    /* = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");*/ //private File PATH2 = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv");
        /* = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");*/
    //private File PATH2 = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv");

    public DisciplinasProfessor() {
        super(new File("/src/main/java/banco_arquivo/professores" + ".csv"));
    }
    
}
