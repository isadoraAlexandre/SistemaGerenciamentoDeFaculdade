package com.mycompany.sistemagerenciamentodefaculdade;

public class SistemaGerenciamentoDeFaculdade {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Login login = new Login();
        login.setVisible(true);
        System.out.println(login.getSessionString());
        // new LancaFaltaFuncionarioUI(alunos, disciplinas,
        // funcionario).setVisible(true);
    }
}
