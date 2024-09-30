package com.mycompany.sistemagerenciamentodefaculdade;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JFrame;

import Gabhriel.CrudCursos;
import Gabhriel.ListaAluno;
import Gabhriel.VerHorario;
import crud_disciplinas.PaginaCrudDisciplinas;
import exceptions.BairroException;
import exceptions.CelularException;
import exceptions.CidadeException;
import exceptions.CpfException;
import exceptions.EmailException;
import exceptions.NomeException;
import exceptions.NumeroException;
import exceptions.RuaException;
import matricula_e_desmatricula.MatriculaDisciplina;
import matricula_e_desmatricula.TrancaDisciplina;
import usuarios.Aluno;
import usuarios.Professor;
import usuarios.ProfessorCoordenador;
import usuarios.Usuario;

/**
 *
 * @author letic
 */
public class Dashboardd extends javax.swing.JFrame {
    private final Usuario user;
    private Aluno al;
    private Professor p;
    private ProfessorCoordenador pc;

    /**
     * Creates new form Dashboardd
     */
    public Dashboardd(Usuario u) {
        user = u;
        initComponents();
        converte(user);
        if (user.getTipoUsuario() == 1) {
            listaDisciplinas.setText("Lista de Alunos");
            btnMatricula.setVisible(false);
            matricula.setVisible(false);
            btnHorario.setVisible(false);
            horario.setVisible(false);
            btnHistorico.setVisible(false);
            historico.setVisible(false);
            btnIRA.setVisible(false);
            IRA.setVisible(false);
        }
        if (user.getTipoUsuario() == 2) {
            matricula.setText("Alteração de Disciplinas");
            horario.setText("Alteração de Cursos");
            historico.setText("Alteração de Professores");
            btnIRA.setVisible(false);
            listaDisciplinas.setText("Alteração de Alunos");
            IRA.setVisible(false);
        }
        else if (user.getTipoUsuario() == 0) {
            btnIRA.setVisible(false);
            IRA.setVisible(false);
            btnHistorico.setVisible(false);
            historico.setVisible(false);
            horario.setVisible(false);
            btnHorario.setVisible(false);
        }
        this.setLocationRelativeTo(null);
    }

    private void converte(Usuario user) {
        if (user.getTipoUsuario() == 0) {
            try {

                al = new Aluno(user.getCpf());
                al.setBairro(user.getBairro());
                al.setCelular(user.getCelular());
                al.setCidade(user.getCidade());
                al.setCpf(user.getCpf());
                al.setDataNascimento(user.getDataNascimento());
                al.setEmail(user.getEmail());
                al.setMatricula(user.getMatricula());
                al.setNome(user.getNome());
                al.setNumero(user.getNumero());
                al.setRua(user.getRua());
                al.setSenha(user.getSenha());
                al.setTipoUsuario(user.getTipoUsuario());
                al.setUsuario(user.getUsuario());
            } catch (BairroException | CelularException | CidadeException | CpfException | EmailException
                    | NomeException | NumeroException | RuaException e) {
                e.printStackTrace();
            }
        } else if (user.getTipoUsuario() == 1) {
            try {
                p = new Professor();
                p.setBairro(user.getBairro());
                p.setCelular(user.getCelular());
                p.setCidade(user.getCidade());
                p.setCpf(user.getCpf());
                p.setDataNascimento(user.getDataNascimento());
                p.setEmail(user.getEmail());
                p.setNome(user.getNome());
                p.setNumero(user.getNumero());
                p.setRua(user.getRua());
                p.setSenha(user.getSenha());
                p.setTipoUsuario(user.getTipoUsuario());
                p.setUsuario(user.getUsuario());

            } catch (BairroException | CelularException | CidadeException | CpfException | EmailException
                    | NomeException | NumeroException | RuaException e) {
                e.printStackTrace();
            }
        } else if (user.getTipoUsuario() == 2) {
            try {
                pc = new ProfessorCoordenador();
                pc.setBairro(user.getBairro());
                pc.setCelular(user.getCelular());
                pc.setCidade(user.getCidade());
                pc.setCpf(user.getCpf());
                pc.setDataNascimento(user.getDataNascimento());
                pc.setEmail(user.getEmail());
                pc.setNome(user.getNome());
                pc.setNumero(user.getNumero());
                pc.setRua(user.getRua());
                pc.setSenha(user.getSenha());
                pc.setTipoUsuario(user.getTipoUsuario());
                pc.setUsuario(user.getUsuario());
            } catch (BairroException | CelularException | CidadeException | CpfException | EmailException
                    | NumeroException | RuaException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        JFrame popup = new JFrame("Pop-up");
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setVisible(true);
        fundo = new javax.swing.JPanel();
        dashboardBranca = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMatricula = new javax.swing.JPanel();
        matricula = new javax.swing.JLabel();
        btnListaDisciplinas = new javax.swing.JPanel();
        listaDisciplinas = new javax.swing.JLabel();
        btnIRA = new javax.swing.JPanel();
        IRA = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JPanel();
        historico = new javax.swing.JLabel();
        btnHorario = new javax.swing.JPanel();
        horario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        fundo.setBackground(new java.awt.Color(242, 247, 251));

        dashboardBranca.setBackground(new java.awt.Color(255, 255, 255));
        dashboardBranca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        btnPerfil.setBackground(new java.awt.Color(28, 39, 95));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Meu Perfil");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnPerfilLayout = new javax.swing.GroupLayout(btnPerfil);
        btnPerfil.setLayout(btnPerfilLayout);
        btnPerfilLayout.setHorizontalGroup(
                btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnPerfilLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        btnPerfilLayout.setVerticalGroup(
                btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 23, 91));
        jLabel1.setText("Dashboard");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 160));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 160));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 160));

        btnMatricula.setBackground(new java.awt.Color(28, 39, 95));
        btnMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMatriculaMouseClicked(evt);
            }
        });

        matricula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        matricula.setForeground(new java.awt.Color(255, 255, 255));
        matricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matricula.setText("Matrícula");

        javax.swing.GroupLayout btnMatriculaLayout = new javax.swing.GroupLayout(btnMatricula);
        btnMatricula.setLayout(btnMatriculaLayout);
        btnMatriculaLayout.setHorizontalGroup(
                btnMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(matricula, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        btnMatriculaLayout.setVerticalGroup(
                btnMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnMatriculaLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE)));

        btnListaDisciplinas.setBackground(new java.awt.Color(28, 39, 95));
        btnListaDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaDisciplinasMouseClicked(evt);
            }
        });

        listaDisciplinas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        listaDisciplinas.setForeground(new java.awt.Color(255, 255, 255));
        listaDisciplinas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaDisciplinas.setText("Trancar Matérias");

        javax.swing.GroupLayout btnListaDisciplinasLayout = new javax.swing.GroupLayout(btnListaDisciplinas);
        btnListaDisciplinas.setLayout(btnListaDisciplinasLayout);
        btnListaDisciplinasLayout.setHorizontalGroup(
                btnListaDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listaDisciplinas, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE));
        btnListaDisciplinasLayout.setVerticalGroup(
                btnListaDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                btnListaDisciplinasLayout.createSequentialGroup()
                                        .addContainerGap(27, Short.MAX_VALUE)
                                        .addComponent(listaDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)));

        btnIRA.setVisible(false);;
       

        IRA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IRA.setForeground(new java.awt.Color(255, 255, 255));
        IRA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IRA.setText("Cálculo do IRA");


        btnHistorico.setBackground(new java.awt.Color(28, 39, 95));
        btnHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoricoMouseClicked(evt);
            }
        });

        historico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        historico.setForeground(new java.awt.Color(255, 255, 255));
        historico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historico.setText("Histórico");

        javax.swing.GroupLayout btnHistoricoLayout = new javax.swing.GroupLayout(btnHistorico);
        btnHistorico.setLayout(btnHistoricoLayout);
        btnHistoricoLayout.setHorizontalGroup(
                btnHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(historico, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        btnHistoricoLayout.setVerticalGroup(
                btnHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnHistoricoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(historico, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE)));

        btnHorario.setBackground(new java.awt.Color(28, 39, 95));
        btnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHorarioMouseClicked(evt);
            }
        });

        horario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        horario.setForeground(new java.awt.Color(255, 255, 255));
        horario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horario.setText("Horário");

        javax.swing.GroupLayout btnHorarioLayout = new javax.swing.GroupLayout(btnHorario);
        btnHorario.setLayout(btnHorarioLayout);
        btnHorarioLayout.setHorizontalGroup(
                btnHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(horario, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        btnHorarioLayout.setVerticalGroup(
                btnHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(btnHorarioLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE)));

        javax.swing.GroupLayout dashboardBrancaLayout = new javax.swing.GroupLayout(dashboardBranca);
        dashboardBranca.setLayout(dashboardBrancaLayout);
        dashboardBrancaLayout.setHorizontalGroup(
                dashboardBrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(dashboardBrancaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(264, Short.MAX_VALUE))
                                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                                .addGroup(dashboardBrancaLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(btnMatricula,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnHorario, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46,
                                                        Short.MAX_VALUE)
                                                .addGroup(dashboardBrancaLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(btnListaDisciplinas,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnHistorico,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnIRA,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(62, 62, 62)))));
        dashboardBrancaLayout.setVerticalGroup(
                dashboardBrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(dashboardBrancaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnHorario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(dashboardBrancaLayout.createSequentialGroup()
                                                .addComponent(btnListaDisciplinas,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnHistorico, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35,
                                        Short.MAX_VALUE)
                                .addGroup(dashboardBrancaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnIRA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)));

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
                fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fundoLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(dashboardBranca, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE)));
        fundoLayout.setVerticalGroup(
                fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fundoLayout.createSequentialGroup()
                                .addContainerGap(66, Short.MAX_VALUE)
                                .addComponent(dashboardBranca, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnPerfilMouseClicked
        new PerfilAluno(user).setVisible(true);
    }// GEN-LAST:event_btnPerfilMouseClicked

    private void btnMatriculaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMatriculaMouseClicked
        if (user.getTipoUsuario() == 2)
            new PaginaCrudDisciplinas().setVisible(true);
        else if (user.getTipoUsuario() == 0) {
            new MatriculaDisciplina(al).setVisible(true);
        }
    }// GEN-LAST:event_btnMatriculaMouseClicked

    private void btnListaDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnListaDisciplinasMouseClicked
        if (user.getTipoUsuario() == 1) {
            new ListaAluno().setVisible(true);
        } else if (user.getTipoUsuario() == 2) {
            new GerenciamentoAlunosGUI();
        } else if (user.getTipoUsuario() == 0) {
            new TrancaDisciplina(al).setVisible(true);
        }
    }// GEN-LAST:event_btnListaDisciplinasMouseClicked


    private void btnHistoricoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnHistoricoMouseClicked
        if (user.getTipoUsuario() == 2) {
            new GerenciamentoProfessoresGUI().setVisible(true);
        } 

    }// GEN-LAST:event_btnHistoricoMouseClicked

    private void btnHorarioMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnHorarioMouseClicked
        if (user.getTipoUsuario() == 0) {
            new VerHorario(al).setVisible(true);
        } else {
            new CrudCursos().setVisible(true);
        }

    }// GEN-LAST:event_btnHorarioMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IRA;
    private javax.swing.JPanel btnHistorico;
    private javax.swing.JPanel btnHorario;
    private javax.swing.JPanel btnIRA;
    private javax.swing.JPanel btnListaDisciplinas;
    private javax.swing.JPanel btnMatricula;
    private javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel dashboardBranca;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel historico;
    private javax.swing.JLabel horario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel listaDisciplinas;
    private javax.swing.JLabel matricula;
    // End of variables declaration//GEN-END:variables
}
