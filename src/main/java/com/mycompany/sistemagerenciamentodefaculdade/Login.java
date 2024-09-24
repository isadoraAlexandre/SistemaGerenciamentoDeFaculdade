package com.mycompany.sistemagerenciamentodefaculdade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import auxiliares.BancoDeDados;
import java.sql.SQLException;

public class Login extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private final JButton botaoLogin;
    private final JButton botaoCancelar;
    private BancoDeDados banco;

    public Login() {
        banco = new BancoDeDados();
        
        try {
            banco.conectar();
            banco.criarTabelaUsuarios(); 

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Login");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(null);

        JLabel rotuloUsuario = new JLabel("Usuário (CPF):");
        rotuloUsuario.setBounds(400, 300, 150, 30);
        rotuloUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        add(rotuloUsuario);

        JLabel rotuloSenha = new JLabel("Senha:");
        rotuloSenha.setBounds(400, 350, 100, 30);
        rotuloSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        add(rotuloSenha);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(550, 300, 300, 30);
        add(campoUsuario);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(550, 350, 300, 30);
        add(campoSenha);

        botaoLogin = new JButton("Login");
        botaoLogin.setBounds(550, 400, 140, 40);
        botaoLogin.setFont(new Font("Arial", Font.BOLD, 16));
        add(botaoLogin);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(710, 400, 140, 40);
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 16));
        add(botaoCancelar);

        // Ação do botão de login
        botaoLogin.addActionListener((ActionEvent e) -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            
            try {
                int tipoUsuario = banco.autenticarUsuario(usuario, senha);
                
                if (tipoUsuario != -1) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Tipo de usuário: " + tipoUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao autenticar o usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });

    }
}
