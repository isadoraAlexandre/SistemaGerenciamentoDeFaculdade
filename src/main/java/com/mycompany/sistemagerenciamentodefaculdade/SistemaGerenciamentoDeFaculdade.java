package com.mycompany.sistemagerenciamentodefaculdade;

import java.util.ArrayList;
import java.util.List;

import faculdade.Disciplina;
import usuarios.Professor;
import usuarios.Funcionarios;
import usuarios.Funcionarios.LancaFaltaFuncionarioUI;

public class SistemaGerenciamentoDeFaculdade {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Disciplina disciplina1 = new Disciplina();
        Disciplina disciplina2 = new Disciplina();
        disciplina1.setNome("Matemática");
        disciplina2.setNome("Português");
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);
        Professor professor = new Professor();
        professor.setDisciplinas(disciplinas);
        LancaFaltaFuncionarioUI lancaFaltaUI = professor.new LancaFaltaFuncionarioUI();
        lancaFaltaUI.setVisible(true);

    }
}
