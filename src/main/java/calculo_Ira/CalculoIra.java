package calculo_Ira;

import exceptions.HoraException;
import exceptions.NomeException;
import javax.swing.JOptionPane;
import usuarios.*;

public class CalculoIra extends javax.swing.JFrame {

    private final Aluno aluno;

    public CalculoIra(/*Aluno a*/) {//recebe o aluno logado
        initComponents();
        this.setLocationRelativeTo(null);
        this.aluno = new Aluno("teste");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneCalulaIra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        paneTexto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        calcularIra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calular IRA");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        paneCalulaIra.setBackground(new java.awt.Color(242, 247, 251));
        paneCalulaIra.setMaximumSize(new java.awt.Dimension(1000, 700));
        paneCalulaIra.setMinimumSize(new java.awt.Dimension(1000, 700));
        paneCalulaIra.setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 39, 95));
        jLabel1.setText("Calcula IRA");

        paneTexto.setBackground(new java.awt.Color(242, 247, 251));
        paneTexto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(242, 247, 251));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("I - O Índice de Rendimento Acadêmico (IRA) é o Somatório das notas multiplicado pela carga horária correspondente, dividido pelo Somatório\nde toda a carga horária, isto é, média ponderada.\nII - Quando reprovado por infrequencia ( RI ) a nota é considerada zero no calculo.\nIII - Não entram no calculo do IRA as disciplinas lançadas como: DISPENSADO, SEM CONCEITO E TRANCADO.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout paneTextoLayout = new javax.swing.GroupLayout(paneTexto);
        paneTexto.setLayout(paneTextoLayout);
        paneTextoLayout.setHorizontalGroup(
            paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneTextoLayout.setVerticalGroup(
            paneTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calcularIra.setText("Calcular");
        calcularIra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularIraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneCalulaIraLayout = new javax.swing.GroupLayout(paneCalulaIra);
        paneCalulaIra.setLayout(paneCalulaIraLayout);
        paneCalulaIraLayout.setHorizontalGroup(
            paneCalulaIraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCalulaIraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCalulaIraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(paneCalulaIraLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(paneCalulaIraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calcularIra)
                            .addComponent(paneTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        paneCalulaIraLayout.setVerticalGroup(
            paneCalulaIraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCalulaIraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(calcularIra)
                .addContainerGap(489, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneCalulaIra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneCalulaIra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularIraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularIraActionPerformed
        float ira = 0;

        try {
            ira = aluno.calculaIra();
        } catch (HoraException | NomeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(rootPane, "IRA calculado: " + ira);
    }//GEN-LAST:event_calcularIraActionPerformed

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
            java.util.logging.Logger.getLogger(CalculoIra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculoIra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculoIra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculoIra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculoIra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularIra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel paneCalulaIra;
    private javax.swing.JPanel paneTexto;
    // End of variables declaration//GEN-END:variables
}
