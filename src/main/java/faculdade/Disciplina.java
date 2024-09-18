package faculdade;

import auxiliares.*;
import usuarios.*;
import java.util.*;

public class Disciplina {
    protected String nome;
    protected int qtdVagas;
    protected String codigo;
    protected String tipo; // Eletiva ou Obrigatória
    protected String departamento;
    protected String sala;
    protected Hora horarioAula;
    protected List<Funcionarios> professores;
    protected ProfessorCoordenador coordenador;
    protected float cargaHoraria; // em horas
    protected List<Aluno> alunos;
    
    protected int qtdAulas;
    protected int qtdFaltas;
    protected String planoDeCurso;
    protected float nota; // Notas podem ser armazenadas como uma lista de valores
    protected List<String> turmas; // Lista de turmas que estão cursando essa disciplina
    protected String semestreLetivo;

    public Disciplina() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Hora getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Hora horarioAula) {
        this.horarioAula = horarioAula;
    }

    public List<Funcionarios> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Funcionarios> professores) {
        this.professores = professores;
    }

    public ProfessorCoordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(ProfessorCoordenador coordenador) {
        this.coordenador = coordenador;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    public String getPlanoDeCurso() {
        return planoDeCurso;
    }

    public void setPlanoDeCurso(String planoDeCurso) {
        this.planoDeCurso = planoDeCurso;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public List<String> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<String> turmas) {
        this.turmas = turmas;
    }

    public String getSemestreLetivo() {
        return semestreLetivo;
    }

    public void setSemestreLetivo(String semestreLetivo) {
        this.semestreLetivo = semestreLetivo;
    }
}
