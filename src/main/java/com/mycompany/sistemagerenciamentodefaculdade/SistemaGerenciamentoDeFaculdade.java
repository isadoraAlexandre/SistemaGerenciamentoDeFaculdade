package com.mycompany.sistemagerenciamentodefaculdade;

import calculo_Ira.CalculoIra;
import faculdade.Disciplina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import matricula_e_desmatricula.MatriculaDisciplina;
import matricula_e_desmatricula.TrancaDisciplina;
import usuarios.Aluno;

public class SistemaGerenciamentoDeFaculdade {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        usuarios.Aluno a = new Aluno("123456789");
        usuarios.Aluno b = new Aluno("987654321");
        //Disciplina d = new Disciplina();
        
        /*b.getDisciplinas().get("FIS120").setNota(70.0);
        b.getDisciplinas().get("MAT157").setNota(75.0);
        b.getDisciplinas().get("QUI157").setNota(70.0);*/
        
        
        //matricula_e_desmatricula.MatriculaDisciplina m = new MatriculaDisciplina(a);
        //m.setVisible(true);
        
        matricula_e_desmatricula.MatriculaDisciplina m = new MatriculaDisciplina(b);
        m.setVisible(true);
        
        System.out.println("-----------");
        for(Disciplina d : b.getDisciplinas().values())
            System.out.println(d.getCodigo());
        
        //TrancaDisciplina t = new TrancaDisciplina(b);
        //t.setVisible(true);
        
        /*calculo_Ira.CalculoIra c = new CalculoIra(b);
        c.setVisible(true);*/
    }
}
