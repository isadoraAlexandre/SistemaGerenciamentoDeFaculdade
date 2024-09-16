import javax.swing.JLabel;

public class Sidebar extends javax.swing.JFrame {

    public Sidebar() {
        initComponents();
        criarSidebar(); 
    }

    private void criarSidebar() {
        String tipoUsuario = getTipoUsuarioLogado(); 
        
        jPanel1.removeAll();
        
        if (tipoUsuario.equals("Aluno")) {
            adicionarLink("Minhas Disciplinas");
            adicionarLink("Minhas Notas");
            adicionarLink("Perfil");
        } else if (tipoUsuario.equals("Professor")) {
            adicionarLink("Gerenciar Disciplinas");
            adicionarLink("Lançar Notas");
            adicionarLink("Perfil");
        } else if (tipoUsuario.equals("Coordenador")) {
            adicionarLink("Gerenciar Cursos");
            adicionarLink("Gerenciar Professores");
            adicionarLink("Relatórios");
            adicionarLink("Perfil");
        }
        
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void adicionarLink(String texto) {
        JLabel link = new JLabel(texto);
        link.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        link.setFont(new java.awt.Font("Calibri", 0, 14));
        link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        link.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                link.setForeground(java.awt.Color.BLUE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                link.setForeground(java.awt.Color.BLACK);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Link clicado: " + texto);
            }
        });

        jPanel1.add(link);
    }

    private String getTipoUsuarioLogado() {
        return "Aluno"; 
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1500, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new java.awt.GridLayout(10, 1, 10, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(834, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sidebar().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
