package usuarios;

import faculdade.Curso;
import faculdade.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    protected Curso curso;
    protected List<Disciplina> disciplinas;

        
    public Aluno() {
        super();
        this.tipoUsuario = 0;
        this.disciplinas = new ArrayList<>();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
