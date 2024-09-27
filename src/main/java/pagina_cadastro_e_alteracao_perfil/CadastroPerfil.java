/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pagina_cadastro_e_alteracao_perfil;

import exceptions.*;
import javax.swing.JOptionPane;
import persistence.UsuarioPersistence;
import usuarios.Usuario;

/**
 *
 * @author isinha
 */
public class CadastroPerfil extends javax.swing.JFrame {
    private final Usuario user;
    /**
     * Creates new form NewJFrame1
     */
    public CadastroPerfil() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.user = new Usuario();
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
        panelDadosPessoais = new javax.swing.JPanel();
        labelDataNascimento = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textFieldDataNascimento = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        labelCelular = new javax.swing.JLabel();
        textFieldCelular = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        labelRua = new javax.swing.JLabel();
        textFieldRua = new javax.swing.JTextField();
        labelBairro = new javax.swing.JLabel();
        textFieldBairro = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        textFieldCidade = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        textFieldNumero = new javax.swing.JTextField();
        labelMatricula = new javax.swing.JLabel();
        showMatricula = new javax.swing.JLabel();
        labelCadastroPerfil = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        labelUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Perfil");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("CadastroPerfil"); // NOI18N
        setResizable(false);

        panelExterno.setBackground(new java.awt.Color(242, 247, 251));
        panelExterno.setMaximumSize(new java.awt.Dimension(1000, 700));
        panelExterno.setMinimumSize(new java.awt.Dimension(1000, 700));
        panelExterno.setPreferredSize(new java.awt.Dimension(1000, 700));

        panelDadosPessoais.setBackground(new java.awt.Color(255, 255, 255));
        panelDadosPessoais.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 39, 95), 2, true));

        labelDataNascimento.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelDataNascimento.setForeground(new java.awt.Color(28, 39, 95));
        labelDataNascimento.setText("Data de nascimento (com barras)");


        labelNome.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelNome.setForeground(new java.awt.Color(28, 39, 95));
        labelNome.setText("Nome");

        textFieldDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldDataNascimentoKeyReleased(evt);
            }
        });

        labelEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(28, 39, 95));
        labelEmail.setText("Email");

        labelCelular.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelCelular.setForeground(new java.awt.Color(28, 39, 95));
        labelCelular.setText("Celular (apenas números)");

        jLabelCpf.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        jLabelCpf.setForeground(new java.awt.Color(28, 39, 95));
        jLabelCpf.setText("CPF (apenas números)");

        labelRua.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelRua.setForeground(new java.awt.Color(28, 39, 95));
        labelRua.setText("Rua");

        labelBairro.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelBairro.setForeground(new java.awt.Color(28, 39, 95));
        labelBairro.setText("Bairro");

        labelCidade.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelCidade.setForeground(new java.awt.Color(28, 39, 95));
        labelCidade.setText("Cidade");

        labelNumero.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelNumero.setForeground(new java.awt.Color(28, 39, 95));
        labelNumero.setText("Número");

        labelMatricula.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        labelMatricula.setForeground(new java.awt.Color(28, 39, 95));
        labelMatricula.setText("Matrícula:");

        showMatricula.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        showMatricula.setText("matricula");
        showMatricula.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                showMatriculaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout panelDadosPessoaisLayout = new javax.swing.GroupLayout(panelDadosPessoais);
        panelDadosPessoais.setLayout(panelDadosPessoaisLayout);
        panelDadosPessoaisLayout.setHorizontalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCelular)
                    .addComponent(textFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataNascimento)
                            .addComponent(textFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCpf)))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(labelMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(showMatricula))
                    .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        panelDadosPessoaisLayout.setVerticalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataNascimento)
                    .addComponent(jLabelCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua)
                    .addComponent(labelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatricula)
                    .addComponent(showMatricula))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        labelCadastroPerfil.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        labelCadastroPerfil.setForeground(new java.awt.Color(28, 39, 95));
        labelCadastroPerfil.setText("Cadastro do Usuario");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        labelUser.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        labelUser.setText("user");
        labelUser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                labelUserAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel1.setText("Usuario:");

        javax.swing.GroupLayout panelExternoLayout = new javax.swing.GroupLayout(panelExterno);
        panelExterno.setLayout(panelExternoLayout);
        panelExternoLayout.setHorizontalGroup(
            panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelExternoLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar))
                    .addComponent(labelCadastroPerfil, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelExternoLayout.setVerticalGroup(
            panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExternoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCadastroPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUser)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(panelExternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCadastrar))
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelExterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelExterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirm  = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        if(JOptionPane.showConfirmDialog(rootPane, "Cadastrar informações?", "Cadastrar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
            try{
                this.user.setNome(textFieldNome.getText());
                this.user.setEmail(textFieldEmail.getText());
                this.user.setCpf(jTextFieldCpf.getText());
                this.user.setCelular(textFieldCelular.getText());
                this.user.setDataStr(textFieldDataNascimento.getText());
                this.user.setBairro(textFieldBairro.getText());
                this.user.setRua(textFieldRua.getText());
                this.user.setCidade(textFieldCidade.getText());
                this.user.setNumero(textFieldNumero.getText());

                if(UsuarioPersistence.insereUsuario(this.user)){
                    JOptionPane.showMessageDialog(rootPane, "Cadastro realizado");
                    this.dispose();
                }

            } catch(java.lang.NullPointerException e){
                JOptionPane.showMessageDialog(panelExterno, "Nao foi possivel cadastrar usuario");
            } catch(DataException | NomeException | EmailException | CpfException | CelularException | RuaException | BairroException | CidadeException | NumeroException e){
                JOptionPane.showMessageDialog(panelExterno, e.getMessage());
            }
            
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void labelUserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_labelUserAncestorAdded
        labelUser.setText(user.getUsuario());
    }//GEN-LAST:event_labelUserAncestorAdded

    private void showMatriculaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_showMatriculaAncestorAdded
        showMatricula.setText(user.getMatricula());
    }//GEN-LAST:event_showMatriculaAncestorAdded

    private void textFieldDataNascimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldDataNascimentoKeyReleased
        String texto = textFieldDataNascimento.getText().replaceAll("[^\\d]", "");

                if (texto.length() > 2){
                    texto = texto.substring(0, 2) + "/" + texto.substring(2);
                }
                if (texto.length() > 5){
                    texto = texto.substring(0, 5) + "/" + texto.substring(5);
                }

                textFieldDataNascimento.setText(texto);
    }//GEN-LAST:event_textFieldDataNascimentoKeyReleased

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
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new CadastroPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCadastroPerfil;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JPanel panelExterno;
    private javax.swing.JLabel showMatricula;
    private javax.swing.JTextField textFieldBairro;
    private javax.swing.JTextField textFieldCelular;
    private javax.swing.JTextField textFieldCidade;
    private javax.swing.JTextField textFieldDataNascimento;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldNumero;
    private javax.swing.JTextField textFieldRua;
    // End of variables declaration//GEN-END:variables
}
