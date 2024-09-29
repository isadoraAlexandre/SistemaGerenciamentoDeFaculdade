package persistence;

import java.io.File;

public class DisciplinaGeral extends DisciplinasPersistence{
    
    public DisciplinaGeral() {
        super(new File("/src/main/java/banco_arquivo/DisciplinasGeral.csv"));
    }
    
}
