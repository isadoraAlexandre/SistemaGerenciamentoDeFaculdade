package faculdade;

import java.util.*;

import auxiliares.Hora;
import usuarios.Aluno;
import usuarios.Funcionarios;
import usuarios.ProfessorCoordenador;

public class Disciplina {
    protected String nome;
    protected int qtdVagas;
    protected String codigo;
    protected String tipo; // Eletiva ou Obrigatória
    protected String departamento;
    protected String sala;
    protected Hora horarioAula;
    protected List<Funcionarios> professores = new ArrayList<>();
    protected ProfessorCoordenador coordenador;
    protected Hora cargaHoraria; // em hrs
    protected List<Aluno> alunos = new ArrayList<>();
    
    protected int qtdAulas;
    protected int qtdFaltas;
    protected String planoDeCurso;
    protected List<Double> notas = new ArrayList<>(); 
    protected List<String> turmas = new ArrayList<>();
    protected String semestreLetivo;

    public Disciplina() {
    }

    public void addProfessor(Funcionarios professor) {
        professores.add(professor);
    }

    public void removeProfessor(Funcionarios professor) {
        professores.remove(professor);
    }

    public Funcionarios getProfessor(int index) {
        return professores.get(index);
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Aluno getAluno(int index) {
        return alunos.get(index);
    }

    public void addNota(Double nota) {
        notas.add(nota);
    }

    public void removeNota(Double nota) {
        notas.remove(nota);
    }

    public Double getNota(int index) {
        return notas.get(index);
    }

    public void addTurma(String turma) {
        turmas.add(turma);
    }

    public void removeTurma(String turma) {
        turmas.remove(turma);
    }

    public String getTurma(int index) {
        return turmas.get(index);
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }
}