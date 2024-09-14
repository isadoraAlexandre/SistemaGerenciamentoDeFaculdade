/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import auxiliares.Hora;
import java.util.*;

/**
 *
 * @author isinha
 */
public abstract class Funcionarios extends Usuario{
    protected String horario;
    protected double salario;
    protected Hora cargaHoraria; // em horas por semana
    protected String nivelFormacao;
    protected int tempoServico; // em anos
    protected String notas;
    protected int faltas;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Hora getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Hora cargaHoraria) {
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

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    /* Método abstrato para lançar nota
    public abstract void lancarNota(String nota);

    // Método abstrato para lançar falta
    public abstract void lancarFalta();*/
}
