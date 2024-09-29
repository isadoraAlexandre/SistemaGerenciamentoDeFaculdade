package matricula_e_desmatricula;

import exceptions.*;
import faculdade.Disciplina;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistence.DisciplinaAluno;
import usuarios.Aluno;

public class TrancaDisciplina extends javax.swing.JFrame {
    private Map<String, Disciplina> mapMatriculadas;
    private final DisciplinaAluno matriculadas;
    
    public TrancaDisciplina(Aluno user) {
        initComponents();
        this.setLocationRelativeTo(null);
        matriculadas = new DisciplinaAluno(user.getUsuario());
        mapMatriculadas = user.getDisciplinas();
        carregaDisciplinas();
    }
    
    public final void carregaDisciplinas(){
        mapMatriculadas = matriculadas.findAll();
        DefaultTableModel modelDisciplinas = (DefaultTableModel) tableDisciplinas.getModel();
        modelDisciplinas.setRowCount(0);
        
        for (Disciplina d : mapMatriculadas.values()){
            Object[] rowData = {
                d.getCodigo(),
                d.getNome(),
                d.getHorarioAula(),
                d.getProfessor(),
                d.getCargaHoraria(),
                d.getStatus()
            };

            modelDisciplinas.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDisciplinas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trancamento de disciplina");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        tableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Horário", "Professor", "Carga Hor.", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
                tableDisciplinasdesmatriculaMouse(evt);
            }
        });
        jScrollPane1.setViewportView(tableDisciplinas);
        if (tableDisciplinas.getColumnModel().getColumnCount() > 0) {
            tableDisciplinas.getColumnModel().getColumn(0).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(1).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(2).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableDisciplinas.getColumnModel().getColumn(3).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(4).setResizable(false);
            tableDisciplinas.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Disciplinas matriculadas");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDisciplinasdesmatriculaMouse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDisciplinasdesmatriculaMouse
        int linhaSelecao = tableDisciplinas.getSelectedRow();
    
        if (linhaSelecao != -1) {

            javax.swing.table.DefaultTableModel modelMatriculadas = (javax.swing.table.DefaultTableModel) tableDisciplinas.getModel();
            String[] linhaTabela = new String[modelMatriculadas.getColumnCount()];
            
            for(int i = 0; i < modelMatriculadas.getColumnCount(); i++){
                linhaTabela[i] = modelMatriculadas.getValueAt(linhaSelecao, i).toString();
            }
            
            int confirma = JOptionPane.showConfirmDialog(this, "Trancar a disciplina: " + linhaTabela[1] + "?", "Confirmar trancamento", JOptionPane.YES_NO_OPTION);

            if (confirma == JOptionPane.YES_OPTION) {
                if(!mapMatriculadas.get(linhaTabela[0]).getStatus().equals("trancado")){
                    
                    mapMatriculadas.get(linhaTabela[0]).setStatus("trancado");
                    
                    try {
                        matriculadas.modificaDisciplina(mapMatriculadas.get(linhaTabela[0]));
                    } catch (CodigoException | NomeException | HoraException | CargaHException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                    }
                    carregaDisciplinas();
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Disciplina já foi tranacada");
                }
            }
        }
    }//GEN-LAST:event_tableDisciplinasdesmatriculaMouse

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TrancaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrancaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrancaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrancaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TrancaDisciplina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDisciplinas;
    // End of variables declaration//GEN-END:variables
}
