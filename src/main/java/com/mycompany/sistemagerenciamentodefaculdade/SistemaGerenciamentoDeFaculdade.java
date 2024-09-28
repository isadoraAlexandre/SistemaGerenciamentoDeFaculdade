package com.mycompany.sistemagerenciamentodefaculdade;

import static persistence.UsuarioPersistence.criarUsuarioExemplo;

public class SistemaGerenciamentoDeFaculdade {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        criarUsuarioExemplo();
        new Login().setVisible(true);
    }
}
