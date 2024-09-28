package faculdade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usuarios.Aluno;
import usuarios.Funcionarios;
import usuarios.Professor;
import usuarios.ProfessorCoordenador;

public class Curso {
    protected String nome;
    protected String departamento;
    protected ProfessorCoordenador coordenador;
    protected Map<String, Disciplina> grade;
    protected List<Funcionarios> professores;
    private List<Aluno> alunos;

    public Curso(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.grade = new HashMap<>();
    }
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null; 
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
    }

    public Funcionarios buscarProfessor(String nome) {
        for (Funcionarios professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ProfessorCoordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(ProfessorCoordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Map<String, Disciplina> getGrade() {
        return grade;
    }

    public void setGrade(Map<String, Disciplina> grade) {
        this.grade = grade;
    }

    public List<Funcionarios> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Funcionarios> professores) {
        this.professores = professores;
    }
    

}
