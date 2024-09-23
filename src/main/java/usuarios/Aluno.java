package usuarios;

import faculdade.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    protected Curso curso;
    protected List<Disciplina> disciplinas;
    protected float ira;
    
    public Aluno() {
        this.tipoUsuario = 0;
        this.disciplinas = new ArrayList<>();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public float calculaIra(){
        
        float somatorioHoras = 0;
        float somatorioNota = 0;
        
        try{
            for(Disciplina disciplina : this.disciplinas){
                somatorioNota += /*disciplina.getNota()*/0 * disciplina.getCargaHoraria();
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