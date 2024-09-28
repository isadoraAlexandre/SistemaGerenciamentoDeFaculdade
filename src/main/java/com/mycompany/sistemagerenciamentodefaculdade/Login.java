package com.mycompany.sistemagerenciamentodefaculdade;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import persistence.UsuarioPersistence;
import usuarios.Usuario;

public class Login extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private final JButton botaoLogin;
    private final JButton botaoCancelar;
    private String sessionString;

    public Login() {
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

        botaoLogin.addActionListener((ActionEvent e) -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            Map<String, Usuario> usuarios = UsuarioPersistence.findAll();
            Usuario user = usuarios.get(usuario);

            if (user != null && user.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido! Tipo de usuário: " + user.getTipoUsuario());
                sessionString = "Usuário: " + user.getNome() + " - Tipo: " + user.getTipoUsuario();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    public String getSessionString() {
        return sessionString;
    }

}
