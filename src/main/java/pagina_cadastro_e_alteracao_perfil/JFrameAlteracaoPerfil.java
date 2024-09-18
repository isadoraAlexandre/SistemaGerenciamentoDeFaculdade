/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pagina_cadastro_e_alteracao_perfil;

import javax.swing.JOptionPane;

/**
 *
 * @author isinha
 */
public class JFrameAlteracaoPerfil extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public JFrameAlteracaoPerfil() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelExterno = new javax.swing.JPanel();
        labelCadastroPerfil = new javax.swing.JLabel();
        panelContato = new javax.swing.JPanel();
        labelContato = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textFieldCelular = new javax.swing.JTextField();
        labelCelular = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        panelEndereco = new javax.swing.JPanel();
        labelEndereco = new javax.swing.JLabel();
        labelBairro = new javax.swing.JLabel();
        textFieldRua = new javax.swing.JTextField();
        labelRua = new javax.swing.JLabel();
        textFieldBairro = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        textFieldNumero = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        textFieldCidade = new javax.swing.JTextField();
        label1Estado = new javax.swing.JLabel();
        textFieldEstao = new javax.swing.JTextField();
        labelCep = new javax.swing.JLabel();
        textFieldCep = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelDadosBancarios = new javax.swing.JPanel();
        labelDadosBancarios = new javax.swing.JLabel();
        jLabelNumeroConta = new javax.swing.JLabel();
        jLabelBanco = new javax.swing.JLabel();
        jLabelAgencia = new javax.swing.JLabel();
        jTextFieldBanco = new javax.swing.JTextField();
        jTextFieldAgencia = new javax.swing.JTextField();
        jTextFieldNumeroConta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Perfil");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("AlteracaoPerfil"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        panelExterno.setBackground(new java.awt.Color(242, 247, 251));

        labelCadastroPerfil.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        labelCadastroPerfil.setForeground(new java.awt.Color(28, 39, 95));
        labelCadastroPerfil.setText("Alterar Dados");

        panelContato.setBackground(new java.awt.Color(255, 255, 255));
        panelContato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        labelContato.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 20)); // NOI18N
        labelContato.setForeground(new java.awt.Color(28, 39, 95));
        labelContato.setText("Contato");

        labelEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(28, 39, 95));
        labelEmail.setText("Email");

        labelCelular.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelCelular.setForeground(new java.awt.Color(28, 39, 95));
        labelCelular.setText("Celular:");

        javax.swing.GroupLayout panelContatoLayout = new javax.swing.GroupLayout(panelContato);
        panelContato.setLayout(panelContatoLayout);
        panelContatoLayout.setHorizontalGroup(
            panelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelContato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContatoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmail)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCelular)
                            .addComponent(textFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContatoLayout.setVerticalGroup(
            panelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        panelEndereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        labelEndereco.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 20)); // NOI18N
        labelEndereco.setForeground(new java.awt.Color(28, 39, 95));
        labelEndereco.setText("Endereço");

        labelBairro.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelBairro.setForeground(new java.awt.Color(28, 39, 95));
        labelBairro.setText("Bairro");

        labelRua.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelRua.setForeground(new java.awt.Color(28, 39, 95));
        labelRua.setText("Rua");

        labelNumero.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelNumero.setForeground(new java.awt.Color(28, 39, 95));
        labelNumero.setText("Número");

        labelCidade.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelCidade.setForeground(new java.awt.Color(28, 39, 95));
        labelCidade.setText("Cidade");

        label1Estado.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        label1Estado.setForeground(new java.awt.Color(28, 39, 95));
        label1Estado.setText("Estado");

        textFieldEstao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEstaoActionPerformed(evt);
            }
        });

        labelCep.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelCep.setForeground(new java.awt.Color(28, 39, 95));
        labelCep.setText("CEP");

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEnderecoLayout.createSequentialGroup()
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(217, 217, 217))
                            .addGroup(panelEnderecoLayout.createSequentialGroup()
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1Estado)
                                    .addComponent(textFieldEstao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCep)
                                    .addComponent(textFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua)
                    .addComponent(labelBairro)
                    .addComponent(labelNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1Estado)
                    .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCidade)
                        .addComponent(labelCep)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEstao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanelDadosBancarios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDadosBancarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        labelDadosBancarios.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 20)); // NOI18N
        labelDadosBancarios.setForeground(new java.awt.Color(28, 39, 95));
        labelDadosBancarios.setText("Dados Bancários");

        jLabelNumeroConta.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        jLabelNumeroConta.setForeground(new java.awt.Color(28, 39, 95));
        jLabelNumeroConta.setText("Número da Conta");

        jLabelBanco.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        jLabelBanco.setForeground(new java.awt.Color(28, 39, 95));
        jLabelBanco.setText("Banco");

        jLabelAgencia.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        jLabelAgencia.setForeground(new java.awt.Color(28, 39, 95));
        jLabelAgencia.setText("Agência");

        javax.swing.GroupLayout jPanelDadosBancariosLayout = new javax.swing.GroupLayout(jPanelDadosBancarios);
        jPanelDadosBancarios.setLayout(jPanelDadosBancariosLayout);
        jPanelDadosBancariosLayout.setHorizontalGroup(
            jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDadosBancarios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadosBancariosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumeroConta)
                            .addComponent(jTextFieldNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBanco)
                            .addComponent(jTextFieldBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAgencia)
                            .addComponent(jTextFieldAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanelDadosBancariosLayout.setVerticalGroup(
            jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDadosBancarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroConta)
                    .addComponent(jLabelBanco)
                    .addComponent(jLabelAgencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelExternoLayout = new javax.swing.GroupLayout(panelExterno);
        panelExterno.setLayout(panelExternoLayout);
        panelExternoLayout.setHorizontalGroup(
            panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelExternoLayout.createSequentialGroup()
                        .addComponent(labelCadastroPerfil)
                        .addContainerGap(824, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExternoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDadosBancarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExternoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlterar)
                .addGap(24, 24, 24))
        );
        panelExternoLayout.setVerticalGroup(
            panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelCadastroPerfil)
                .addGap(18, 18, 18)
                .addComponent(panelContato, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDadosBancarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAlterar))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelExterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelExterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldEstaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEstaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEstaoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code
    }//GEN-LAST:event_jButtonAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAlteracaoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAlteracaoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAlteracaoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAlteracaoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAlteracaoPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelAgencia;
    private javax.swing.JLabel jLabelBanco;
    private javax.swing.JLabel jLabelNumeroConta;
    private javax.swing.JPanel jPanelDadosBancarios;
    private javax.swing.JTextField jTextFieldAgencia;
    private javax.swing.JTextField jTextFieldBanco;
    private javax.swing.JTextField jTextFieldNumeroConta;
    private javax.swing.JLabel label1Estado;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCadastroPerfil;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelContato;
    private javax.swing.JLabel labelDadosBancarios;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JPanel panelContato;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JPanel panelExterno;
    private javax.swing.JTextField textFieldBairro;
    private javax.swing.JTextField textFieldCelular;
    private javax.swing.JTextField textFieldCep;
    private javax.swing.JTextField textFieldCidade;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldEstao;
    private javax.swing.JTextField textFieldNumero;
    private javax.swing.JTextField textFieldRua;
    // End of variables declaration//GEN-END:variables
}
