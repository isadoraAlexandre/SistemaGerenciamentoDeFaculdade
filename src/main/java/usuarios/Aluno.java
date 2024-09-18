package usuarios;

import faculdade.*;

public class Aluno extends Usuario {
    protected Curso curso;
    protected float ira;
    
    public Aluno() {
        this.tipoUsuario = 0;
    }
    
    public float calculaIra(){
        
        float somatorioHoras = 0;
        float somatorioNota = 0;
        
        try{
            for(Disciplina disciplina : this.disciplinas){
                somatorioNota += disciplina.getNota() * disciplina.getCargaHoraria();
                somatorioHoras += disciplina.getCargaHoraria();
            }

            this.ira = somatorioNota / somatorioHoras;
        }
        catch(java.lang.NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro inasperado");
        }
        return this.ira;
    }
}
