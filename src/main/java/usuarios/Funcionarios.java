package usuarios;
import auxiliares.Hora;

public abstract class Funcionarios extends Usuario{
    
    protected double salario;
    protected float cargaHoraria; // em horas por semana, usa funçao de calcular horario
    protected String nivelFormacao;
    protected int tempoServico; // em anos

    
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


    /* Método abstrato para lançar nota
    public abstract void lancarNota(String nota);

    // Método abstrato para lançar falta
    public abstract void lancarFalta();*/
}
