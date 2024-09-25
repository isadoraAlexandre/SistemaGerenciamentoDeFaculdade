package usuarios;

import java.util.ArrayList;
import java.util.List;

import faculdade.Curso;
import faculdade.Disciplina;

public class Aluno extends Usuario {
    protected Curso curso;
    protected List<Disciplina> disciplinas;

        
    public Aluno() {
        this.tipoUsuario = 0;
        this.disciplinas = new ArrayList<>();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso getCurso() {
        return curso;
    }

    public Curso setCurso() {
        return curso;
    }
}
