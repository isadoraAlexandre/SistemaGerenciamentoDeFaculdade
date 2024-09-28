package persistence;

import java.io.File;

public class DisciplinaAluno extends DisciplinasPersistence {
    /* = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");*/ //private File PATH2 = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv");
        /* = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas" + user.getUsuario() + ".csv");*/
    //private File PATH2 = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv");

    public DisciplinaAluno(String a) {
        super(new File("/src/main/java/banco_arquivo/Disciplinas" + a + ".csv"));
    }
    
}
