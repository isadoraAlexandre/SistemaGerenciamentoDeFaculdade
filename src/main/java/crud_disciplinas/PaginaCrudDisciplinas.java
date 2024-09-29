package crud_disciplinas;

import exceptions.*;
import faculdade.Disciplina;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistence.*;

public class PaginaCrudDisciplinas extends javax.swing.JFrame {

    private Map<String, Disciplina> map;
    private final DisciplinaGeral dados = new DisciplinaGeral();

    public PaginaCrudDisciplinas() {
        initComponents();
        this.setLocationRelativeTo(null);
        carregaDisciplinas();
    }

    public final void carregaDisciplinas() {
        map = dados.findAll();
        DefaultTableModel modelDisciplinas = (DefaultTableModel) tableDisciplinas.getModel();
        modelDisciplinas.setRowCount(0);

        for (Disciplina d : map.values()) {
            Object[] rowData = {
                d.getCodigo(),
                d.getNome(),
                d.getHorarioAula(),
                d.getProfessor(),
                d.getQtdVagas(),
                d.getCargaHoraria(),
                d.getCoordenador(),};

            modelDisciplinas.addRow(rowData);
        }
    }

    private void limpaCampos() {
        fieldCodigo.setText("");
        fieldNome.setText("");
        fieldHorario.setText("");
        fieldProfessor.setText("");
        fieldVagas.setText("");
        fieldCargaH.setText("");
        fieldCoord.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        externo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDisciplinas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldHorario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldProfessor = new javax.swing.JTextField();
        fieldCoord = new javax.swing.JTextField();
        fieldVagas = new javax.swing.JTextField();
        fieldCargaH = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Disciplinas");
        setBackground(new java.awt.Color(242, 247, 251));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        externo.setBackground(new java.awt.Color(242, 247, 251));
        externo.setMaximumSize(new java.awt.Dimension(1000, 700));
        externo.setMinimumSize(new java.awt.Dimension(1000, 700));
        externo.setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Gestão de disciplinas");

        tableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Horario", "Professor", "Vagas", "Carga Hor.", "Coordenador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDisciplinas.getTableHeader().setReorderingAllowed(false);
        tableDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDisciplinas);
        if (tableDisciplinas.getColumnModel().getColumnCount() > 0) {
            tableDisciplinas.getColumnModel().getColumn(0).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(1).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(2).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(3).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(4).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(5).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Horario");

        fieldHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldHorarioKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Carga Hor.");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("Vagas");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("Professor");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setText("Coordenador");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout externoLayout = new javax.swing.GroupLayout(externo);
        externo.setLayout(externoLayout);
        externoLayout.setHorizontalGroup(
            externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(externoLayout.createSequentialGroup()
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(externoLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel1))
                    .addGroup(externoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, externoLayout.createSequentialGroup()
                                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(externoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAdd)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemove)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar)
                                        .addGap(45, 45, 45)
                                        .addComponent(btnLimpar))
                                    .addGroup(externoLayout.createSequentialGroup()
                                        .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(fieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                .addComponent(fieldCargaH))
                                            .addComponent(fieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(123, 123, 123)
                                        .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(fieldProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                            .addComponent(fieldCoord))))
                                .addGap(10, 10, 10)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        externoLayout.setVerticalGroup(
            externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(externoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCargaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(externoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnEditar)
                    .addComponent(btnLimpar))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(externo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(externo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDisciplinasMouseClicked
        int linhaSelecao = tableDisciplinas.getSelectedRow();

        if (linhaSelecao != -1) {

            javax.swing.table.DefaultTableModel modelDisciplinas = (javax.swing.table.DefaultTableModel) tableDisciplinas.getModel();

            String[] linhaTabela = new String[modelDisciplinas.getColumnCount()];
            for (int i = 0; i < modelDisciplinas.getColumnCount(); i++) {
                linhaTabela[i] = modelDisciplinas.getValueAt(linhaSelecao, i).toString();
            }

            fieldCodigo.setText(linhaTabela[0]);
            fieldNome.setText(linhaTabela[1]);
            fieldHorario.setText(linhaTabela[2]);
            fieldProfessor.setText(linhaTabela[3]);
            fieldVagas.setText(linhaTabela[4]);
            fieldCargaH.setText(linhaTabela[5]);
            fieldCoord.setText(linhaTabela[6]);
        }
    }//GEN-LAST:event_tableDisciplinasMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Disciplina d = new Disciplina();

        if (JOptionPane.showConfirmDialog(rootPane, "Cadastrar disciplina?", "Cadastrar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            try {
                d.setNome(fieldNome.getText());
                d.setCodigo(fieldCodigo.getText());
                d.setProfessor(fieldProfessor.getText());
                d.setCoordenador(fieldCoord.getText());
                d.setHorarioAula(fieldHorario.getText());
                d.setCargaHoraria(fieldCargaH.getText());
                d.setQtdVagas(Integer.parseInt(fieldVagas.getText()));
                d.setStatus("0");

                if (!map.containsKey(d.getCodigo())) {
                    dados.insereDisciplina(d);
                    carregaDisciplinas();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Displina já cadastrada");
                }
            } catch (CodigoException | CargaHException | NomeException | HoraException | VagasException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            if (dados.removeDisciplina(fieldCodigo.getText()) && fieldCodigo.getText() != null) {
                map.remove(fieldCodigo.getText());
                JOptionPane.showMessageDialog(rootPane, "ramoção feita");
                carregaDisciplinas();
                limpaCampos();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível remover");
            }
        } catch (CodigoException | HoraException | NomeException | CargaHException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            Disciplina d = new Disciplina();
            d.setCodigo(fieldCodigo.getText());
            d.setNome(fieldNome.getText());
            d.setProfessor(fieldProfessor.getText());
            d.setCoordenador(fieldCoord.getText());
            d.setHorarioAula(fieldHorario.getText());
            d.setCargaHoraria(fieldCargaH.getText());
            d.setQtdVagas(Integer.parseInt(fieldVagas.getText()));

            if (dados.modificaDisciplina(d)) {
                map.replace(fieldCodigo.getText(), d);
                carregaDisciplinas();
                limpaCampos();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível remover");
            }

        } catch (CodigoException | NomeException | HoraException | CargaHException | NullPointerException | VagasException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void fieldHorarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldHorarioKeyReleased
        String text = fieldHorario.getText();
        text = text.replaceAll("[^a-zA-Z0-9]", "");

        if (text.length() > 3) {
            text = text.substring(0, 3).toUpperCase() + "(" + text.substring(3);
        }
        if (text.length() > 6) {
            text = text.substring(0, 6) + ":" + text.substring(6);
        }
        if (text.length() > 8) {
            text = text.substring(0, 9) + ")" + text.substring(9);
        }
        if (text.length() > 10) {
            text = text.substring(0, 10) + "/" + text.substring(10);
        }
        if (text.length() > 14) {
            text = text.substring(0, 14).toUpperCase() + "(" + text.substring(14);
        }
        if (text.length() > 17) {
            text = text.substring(0, 17) + ":" + text.substring(17);
        }
        if (text.length() > 19) {
            text = text.substring(0, 20) + ")";
        }

        fieldHorario.setText(text);
    }//GEN-LAST:event_fieldHorarioKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PaginaCrudDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaCrudDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaCrudDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaCrudDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaCrudDisciplinas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JPanel externo;
    private javax.swing.JTextField fieldCargaH;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldCoord;
    private javax.swing.JTextField fieldHorario;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldProfessor;
    private javax.swing.JTextField fieldVagas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDisciplinas;
    // End of variables declaration//GEN-END:variables
}
