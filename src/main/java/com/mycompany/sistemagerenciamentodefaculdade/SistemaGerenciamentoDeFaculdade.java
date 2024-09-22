package com.mycompany.sistemagerenciamentodefaculdade;

import auxiliares.Data;
import faculdade.Disciplina;
import java.util.*;
import persistence.*;
import usuarios.*;

public class SistemaGerenciamentoDeFaculdade {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        List<Disciplina> lista = new ArrayList<>();
        Disciplina a = new Disciplina();
                    a.setCodigo("MAT156");
                    a.setNome("Cáculo 2");
                    a.setProfessor("Sofia");
                    a.setHorarioAula(8);
                    a.setCargaHoraria(60);
                    a.setCoordenador("Joana");
                    a.setQtdVagas(100);
        Disciplina b = new Disciplina();
                    b.setCodigo("FIS120");
                    b.setNome("Física 1");
                    b.setProfessor("Carlos");
                    b.setHorarioAula(10);
                    b.setCargaHoraria(60);
                    b.setCoordenador("José");
                    b.setQtdVagas(80);
        
        
        
        lista.add(a);
        lista.add(b);
        
        DisciplinasPersistence per = new DisciplinasPersistence();
        //per.insereDisciplina(b);
        //per.save(lista);
        
        /*List
        if()
            System.out.println("**********************");
        for(Disciplina d : lista2){
            
            System.out.println("*******");
            System.out.println(d.toString());
        }*/
        
        //DisciplinasPersistence.removeDisciplina("FIS120");
        DisciplinasPersistence.insereDisciplina(b);
        DisciplinasPersistence.modificaDisciplina(a);
        HashMap<String, Disciplina> map = DisciplinasPersistence.findAll();
        for (Disciplina objetc : map.values()) {
            System.out.println(objetc.toString());
        }
        
        List<Aluno> lista3 = new ArrayList<>();
        List<Aluno> lista4;
        Data d = new Data(12, 02, 2023);
        Aluno e = new Aluno();
        /*e.setCpf("12345678900");
                        e.setNome("Maria");
                        e.setDataStr("01/20/2025");
                        e.setEmail("maria@gmail.com");
                        e.setCelular("32999990000");
                        e.setRua("Rua m");
                        e.setBairro("Centro");
                        e.setCidade("Brasil");
                        e.setNumero("07");
                        
        lista3.add(e);
        com.save(lista3);*/
        AlunosPersistence com = new AlunosPersistence();
        
        
        lista4 = com.findAll();
        for (Aluno aluno : lista4) {
            System.out.println(aluno.toString());
        }
    }
}
