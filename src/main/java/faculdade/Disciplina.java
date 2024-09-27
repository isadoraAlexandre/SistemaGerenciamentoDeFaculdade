package faculdade;

import java.util.ArrayList;
import java.util.List;

import usuarios.Aluno;

public class Disciplina{
    protected String nome;
    protected int qtdVagas;
    protected String codigo;
    protected float horarioAula;
    protected String professor;
    protected String coordenador;
    protected float cargaHoraria;
    
    protected List<Aluno> alunos;
    protected int qtdFaltas;
    protected List<Double> notas;

    public Disciplina() {
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    /*public void addProfessor(Funcionarios professor) {
        professores.add(professor);
    }

    public void removeProfessor(Funcionarios professor) {
        professores.remove(professor);
    }

    public Funcionarios getProfessor(int index) {
        return professores.get(index);
    }*/

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
    
    /*public void addTurma(String turma) {
        turmas.add(turma);
    }

    public void removeTurma(String turma) {
        turmas.remove(turma);
    }

    public String getTurma(int index) {
        return turmas.get(index);
    }*/

    
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(float horarioAula) {
        this.horarioAula = horarioAula;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", qtdVagas=" + qtdVagas + ", codigo=" + codigo + ", horarioAula=" + horarioAula + ", professor=" + professor + ", coordenador=" + coordenador + ", cargaHoraria=" + cargaHoraria + '}';
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}