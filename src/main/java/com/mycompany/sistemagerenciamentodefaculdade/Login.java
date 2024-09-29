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
import exceptions.BairroException;
import exceptions.CelularException;
import exceptions.CidadeException;
import exceptions.CpfException;
import exceptions.DataException;
import exceptions.EmailException;
import exceptions.NomeException;
import exceptions.NumeroException;
import exceptions.RuaException;
import persistence.UsuarioPersistence;
import usuarios.Aluno;
import usuarios.Professor;
import usuarios.ProfessorCoordenador;
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
            String cpf = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            try {
                Map<String, Usuario> usuarios;
                usuarios = UsuarioPersistence.findAll();
                Usuario user = usuarios.get(cpf);
                Usuario userPronto;
                switch (user.getTipoUsuario()) {
                    case 0:
                        userPronto = (Aluno) user;
                        break;
                    case 1:
                        userPronto = (Professor) user;
                        break;
                    case 2:
                        userPronto = (ProfessorCoordenador) user;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de usuário inválido");
                }
    
                if (user != null && user.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Tipo de usuário: " + user.getTipoUsuario());
                    sessionString = "Usuário: " + user.getNome() + " - Tipo: " + user.getTipoUsuario();
                    Dashboardd dashboard = new Dashboardd(userPronto);
                    dashboard.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (CpfException | NomeException | DataException | EmailException | CelularException | RuaException
                    | BairroException | CidadeException | NumeroException e1) {
                e1.printStackTrace();
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
