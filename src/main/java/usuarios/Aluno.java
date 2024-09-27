package usuarios;

import exceptions.HoraException;
import exceptions.NomeException;
import faculdade.*;
import java.util.HashMap;
import java.util.Map;

public class Aluno extends Usuario {
    protected Curso curso;
    protected Map<String, Disciplina> disciplinas;
    protected float ira;
    
    public Aluno() {
        super();
        this.tipoUsuario = 0;
        this.disciplinas = new HashMap<>();
    }

    public Map<String, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Map<String, Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    private double calculaNotas(String codigo){
        Disciplina d = this.disciplinas.get(codigo);
        double notaFinal = 0;
        
        if(d != null){
            for(double nota : d.getNotas()){
                notaFinal += nota;
            }
            return notaFinal;
        }
        
        javax.swing.JOptionPane.showMessageDialog(null, "disciplina nao encontrada na matricula do aluno");
        return notaFinal;
    }
    
    public float calculaIra() throws HoraException, NomeException{
        
        float somatorioHoras = 0;
        float somatorioNota = 0;
        
        try{
            for(Disciplina disciplina : this.disciplinas.values()){
                somatorioNota += calculaNotas(disciplina.getCodigo()) * disciplina.getCargaHoraria();
                somatorioHoras += disciplina.getCargaHoraria();
            }
            this.ira = somatorioNota / somatorioHoras;
            
            if(Double.isNaN(this.ira)){
                this.ira = 0;
            }
                
        }
        catch(java.lang.NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro inasperado");
        }
        
        return this.ira;
    }
}