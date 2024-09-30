package usuarios;

import faculdade.Disciplina;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Funcionarios extends Usuario {

    protected double salario;
    protected float cargaHoraria;
    protected String nivelFormacao;
    protected int tempoServico;
    protected List<Disciplina> disciplinas = new ArrayList<>();

    public Funcionarios() {
        super();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivelFormacao() {
        return nivelFormacao;
    }

    public void setNivelFormacao(String nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public void lancarFalta(Aluno aluno, Disciplina disciplina, int nfaltas) {
        disciplina.getAlunos().forEach(a -> {
            if (a.equals(aluno)) {
                int indice = disciplina.getAlunos().indexOf(a);
                List<Integer> faltas = disciplina.getFaltas();
                faltas.set(indice, nfaltas);
                disciplina.setFaltas(faltas);
            }
        });
    }

    public void lancarNota(Aluno aluno, Disciplina disciplina, double nota) {
        disciplina.getAlunos().forEach(a -> {
            if (a.equals(aluno)) {
                int indice = disciplina.getAlunos().indexOf(a);
                List<Double> notas = disciplina.getNotas();
                notas.set(indice, nota);
                disciplina.setNotas(notas);
            }
        });
    }
}
