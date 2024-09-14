/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade;

import usuarios.*;
import java.util.*;

/**
 *
 * @author isinha
 */
public class Curso {
    protected String nome;
    protected String departamento;
    protected ProfessorCoordenador coordenador;
    protected List<Disciplina> grade;
    protected List<Funcionarios> professores;

    public Curso() {
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

    public List<Disciplina> getGrade() {
        return grade;
    }

    public void setGrade(List<Disciplina> grade) {
        this.grade = grade;
    }

    public List<Funcionarios> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Funcionarios> professores) {
        this.professores = professores;
    }
}
