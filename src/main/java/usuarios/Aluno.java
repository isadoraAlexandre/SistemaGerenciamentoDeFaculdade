package usuarios;

import exceptions.HoraException;
import exceptions.NomeException;
import faculdade.*;
import java.util.HashMap;
import java.util.Map;
import persistence.DisciplinaAluno;

public class Aluno extends Usuario {
    protected Curso curso;
    protected Map<String, Disciplina> disciplinas;
    protected float ira;
    
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
    
    private void carregaDisciplinas(){
        DisciplinaAluno per = new DisciplinaAluno(this.usuario);
        this.disciplinas = per.findAll();
    }
    
    private double calculaNotas(String codigo){
        Disciplina d = this.disciplinas.get(codigo);
        double notaFinal = 0;

        if(d != null){
            if(d.getNotas() != null && !d.getNotas().isEmpty()){
                for(double nota : d.getNotas()){
                    notaFinal += nota;
                }
            } else{
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhuma nota encontrada para a disciplina: " + codigo);
            }
            return notaFinal;
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Disciplina não encontrada na matrícula do aluno.");
        return notaFinal;
    }

    public float calculaIra() throws HoraException, NomeException{
        carregaDisciplinas(); //talvez tirar

        float somatorioHoras = 0;
        float somatorioNota = 0;

        try{
            for(Disciplina disciplina : this.disciplinas.values()){
                double notaDisciplina = calculaNotas(disciplina.getCodigo()); //mudar aqui tbm
                float cargaHoraria = disciplina.getCargaHoraria();

                somatorioNota += notaDisciplina * cargaHoraria;
                somatorioHoras += cargaHoraria;
            }

            if(somatorioHoras > 0){
                this.ira = somatorioNota / somatorioHoras;
            } else{
                this.ira = 0;
            }

            if(Double.isNaN(this.ira)){
                this.ira = 0;
            }

        } catch(java.lang.NullPointerException e){
            //javax.swing.JOptionPane.showMessageDialog(null, "Erro ao calcular o IRA: " + e.getMessage());
        }

        return this.ira;
    }

}