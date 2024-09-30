package usuarios;

import java.util.Map;
import faculdade.Curso;
import faculdade.Disciplina;
import persistence.DisciplinaAluno;
import java.util.List;

public class Aluno extends Usuario {
    protected Curso curso;
    protected String cursoStr;
    protected List <Disciplina> disciplinasLet;
    protected Map<String, Disciplina> disciplinas;

    public void setCursoStr(String cursoStr) {
        this.cursoStr = cursoStr;
    }

    public String getCursoStr() {
        return cursoStr;
    }
    
    public Aluno(String user) {
        super();
        this.tipoUsuario = 0;
        this.usuario = user;
        DisciplinaAluno per = new DisciplinaAluno(this.usuario);
        this.disciplinas = per.findAll();
    }

    public Map<String, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Map<String, Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina(int index) {
        return disciplinas.get(index);
    }
    private void carregaDisciplinas() {
        DisciplinaAluno per = new DisciplinaAluno(this.usuario);
        this.disciplinas = per.findAll();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.cursoStr = curso.getNome();
    }
}
