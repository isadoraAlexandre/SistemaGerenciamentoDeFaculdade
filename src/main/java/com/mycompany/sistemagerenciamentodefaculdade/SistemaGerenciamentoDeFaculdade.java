package com.mycompany.sistemagerenciamentodefaculdade;

import matricula_e_desmatricula.MatriculaDisciplina;
import persistence.DisciplinaAluno;
import usuarios.Aluno;

public class SistemaGerenciamentoDeFaculdade {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Aluno a = new Aluno("123456789");
        DisciplinaAluno p = new DisciplinaAluno(a.getUsuario());
        
        matricula_e_desmatricula.MatriculaDisciplina m = new MatriculaDisciplina(a);
        m.setVisible(true);
    }
}
