package matricula_e_desmatricula;

import auxiliares.Hora;
import exceptions.*;
import persistence.*;

import faculdade.Disciplina;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import usuarios.Aluno;

public class MatriculaDisciplina extends javax.swing.JFrame {

    private Map<String, Disciplina> mapDisponiveis;
    private Map<String, Disciplina> mapMatriculadas;
    private final DisciplinaGeral disponivies = new DisciplinaGeral();// persistence de todas disciplinas cadastradas pelo coord.
    private final DisciplinaAluno matriculadas;//persistense das displinas vinculadas ao aluno logado
    private final Aluno aluno;

    //inicializa componentes
    public MatriculaDisciplina(Aluno user) {
        initComponents();
        this.setLocationRelativeTo(null);
        aluno = user;
        matriculadas = new DisciplinaAluno(user.getUsuario());//carrega disciplinas do aluno
        mapMatriculadas = user.getDisciplinas();
        carregaDisciplinas();
    }

    //atualiza as tabelas
    public final void carregaDisciplinas() {
        mapDisponiveis = disponivies.findAll();
        mapMatriculadas = matriculadas.findAll();

        DefaultTableModel model1 = (DefaultTableModel) tableDisponiveis.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tableMatriculadas.getModel();

        model1.setRowCount(0);
        for (Disciplina d : mapDisponiveis.values()) {
            Object[] rowData = {
                d.getCodigo(),
                d.getNome(),
                d.getHorarioAula(),
                d.getProfessor(),
                d.getQtdVagas(),
                d.getCargaHoraria(),
                d.getCoordenador(),
                d.getCurso()
            };
            model1.addRow(rowData);
        }

        model2.setRowCount(0);
        for (Disciplina d : mapMatriculadas.values()) {
            Object[] rowData = {
                d.getCodigo(),
                d.getNome(),
                d.getHorarioAula(),
                d.getProfessor(),
                d.getQtdVagas(),
                d.getCargaHoraria(),
                d.getCoordenador(),
                d.getCurso()
            };
            model2.addRow(rowData);
        }
        aluno.setDisciplinas(mapMatriculadas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMatricula = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDisponiveis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMatriculadas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matrícula");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        jpMatricula.setMaximumSize(new java.awt.Dimension(1000, 700));
        jpMatricula.setMinimumSize(new java.awt.Dimension(1000, 700));
        jpMatricula.setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        jLabel1.setText("Matrícula");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Disciplinas disponíveis");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Disciplinas matriculadas");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tableDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Horario", "Professor", "Vagas", "Carga Hor.", "Coordenador", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDisponiveis.getTableHeader().setReorderingAllowed(false);
        tableDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDisciplinasmouse(evt);
            }
        });
        jScrollPane1.setViewportView(tableDisponiveis);
        if (tableDisponiveis.getColumnModel().getColumnCount() > 0) {
            tableDisponiveis.getColumnModel().getColumn(0).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(1).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(2).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableDisponiveis.getColumnModel().getColumn(3).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(4).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(5).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(6).setResizable(false);
            tableDisponiveis.getColumnModel().getColumn(7).setResizable(false);
        }

        tableMatriculadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Disciplina", "Horario", "Professor", "Vagas", "Carga Hor.", "Coordenador", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMatriculadas.getTableHeader().setReorderingAllowed(false);
        tableMatriculadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculadasMouse(evt);
            }
        });
        jScrollPane2.setViewportView(tableMatriculadas);
        if (tableMatriculadas.getColumnModel().getColumnCount() > 0) {
            tableMatriculadas.getColumnModel().getColumn(0).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(1).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(2).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableMatriculadas.getColumnModel().getColumn(3).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(4).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(5).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(6).setResizable(false);
            tableMatriculadas.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jpMatriculaLayout = new javax.swing.GroupLayout(jpMatricula);
        jpMatricula.setLayout(jpMatriculaLayout);
        jpMatriculaLayout.setHorizontalGroup(
            jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createSequentialGroup()
                .addGap(0, 55, Short.MAX_VALUE)
                .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addGap(69, 69, 69))
            .addGroup(jpMatriculaLayout.createSequentialGroup()
                .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMatriculaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(jpMatriculaLayout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMatriculaLayout.setVerticalGroup(
            jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMatriculaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //funcao ativa ao clicar o mouse em uma linha da tabela das disciplinas disponiveis
    private void tabelaDisciplinasmouse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinasmouse
        int linhaSelecao = tableDisponiveis.getSelectedRow();

        if (linhaSelecao != -1) {
            javax.swing.table.DefaultTableModel modelDisponiveis = (javax.swing.table.DefaultTableModel) tableDisponiveis.getModel();
            String[] linhaTabela = new String[modelDisponiveis.getColumnCount()];

            for (int i = 0; i < modelDisponiveis.getColumnCount(); i++) {
                linhaTabela[i] = modelDisponiveis.getValueAt(linhaSelecao, i).toString();
            }

            int confirma = JOptionPane.showConfirmDialog(this, "Matricular na disciplina: " + linhaTabela[0] + "?", "Confirmar matrícula", JOptionPane.YES_NO_OPTION);

            if (confirma == JOptionPane.YES_OPTION) {// resposta sim no pra matricula
                if (!mapMatriculadas.containsKey(linhaTabela[0])) {
                    boolean conflito = false;
                    for (Disciplina d : mapMatriculadas.values()) {//verifica se ha conflito com as ja matriculadas
                        if (Hora.temConflito(d.getHorarioAula(), mapDisponiveis.get(linhaTabela[0]).getHorarioAula())) {
                            conflito = true;
                            break;
                        }
                    }
                    if (conflito) {
                        JOptionPane.showMessageDialog(rootPane, "Conflito de horário");
                    } else {
                        mapDisponiveis.get(linhaTabela[0]).setStatus("matriculado");
                        matriculadas.insereDisciplina(mapDisponiveis.get(linhaTabela[0]));
                        carregaDisciplinas();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Displina já matriculada");
                }
            }
        }
    }//GEN-LAST:event_tabelaDisciplinasmouse
    //botao de sair, pode trocar por this.setVisible(false)
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    //funcao ativa ao clicar o mouse em uma linha da tabela das disciplinas ja matriculadas
    private void matriculadasMouse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculadasMouse
        int linhaSelecao = tableMatriculadas.getSelectedRow();

        if (linhaSelecao != -1) {

            javax.swing.table.DefaultTableModel modelMatriculadas = (javax.swing.table.DefaultTableModel) tableMatriculadas.getModel();
            String[] linhaTabela = new String[modelMatriculadas.getColumnCount()];

            for (int i = 0; i < modelMatriculadas.getColumnCount(); i++) {
                linhaTabela[i] = modelMatriculadas.getValueAt(linhaSelecao, i).toString();
            }

            int confirma = JOptionPane.showConfirmDialog(this, "Desmatricular na disciplina: " + linhaTabela[0] + "?", "Confirmar desmatrícula", JOptionPane.YES_NO_OPTION);

            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    aluno.getDisciplinas().get(linhaTabela[0]).setStatus("0");
                    matriculadas.removeDisciplina(linhaTabela[0]);
                    carregaDisciplinas();
                } catch (CodigoException | HoraException | NomeException | CargaHException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_matriculadasMouse

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatriculaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatriculaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatriculaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatriculaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MatriculaDisciplina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpMatricula;
    private javax.swing.JTable tableDisponiveis;
    private javax.swing.JTable tableMatriculadas;
    // End of variables declaration//GEN-END:variables
}
