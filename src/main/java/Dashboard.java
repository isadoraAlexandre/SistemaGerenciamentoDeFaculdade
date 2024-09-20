import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private String tipoUsuario;

    public Dashboard(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;

        setTitle("Dashboard - Sistema de Gerenciamento de Faculdade");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F2F7FB"));
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Dashboard - Sistema de Gerenciamento de Faculdade");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.decode("#11183B"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 20, 0)); 
        add(titleLabel, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 30, 30)); 
        panel.setBackground(Color.decode("#F2F7FB"));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); 

        add(panel, BorderLayout.CENTER);
        criarDashboard(panel);
        setVisible(true);
    }

    private void criarDashboard(JPanel panel) {
        panel.removeAll();
        if (tipoUsuario.equals("Coordenador")) {
            adicionarBotao(panel, "Alteração de Perfil");
            adicionarBotao(panel, "Alteração de Disciplinas");
            adicionarBotao(panel, "Alteração de Cursos");
            adicionarBotao(panel, "Alteração de Professores");
            adicionarBotao(panel, "Alteração de Alunos");
            adicionarBotao(panel, "Lançamentos de Notas e Faltas");
            adicionarBotao(panel, "Relatórios e impressões");

        } else if (tipoUsuario.equals("Professor")) {
            adicionarBotao(panel, "Alteração de Perfil");
            adicionarBotao(panel, "Listagem de Disciplinas Aptas");
            adicionarBotao(panel, "Alteração de Disciplinas");
            adicionarBotao(panel, "Lançamento de Notas e Faltas");
            adicionarBotao(panel, "Visualização do Perfil");
            adicionarBotao(panel, "Listagem de Alunos");
        } else if (tipoUsuario.equals("Aluno")) {
            adicionarBotao(panel, "Alteração de Perfil");
            adicionarBotao(panel, "Listagem das Disciplinas");
            adicionarBotao(panel, "Alteração de Disciplinas Matriculadas");
            adicionarBotao(panel, "Imprimir Horário");
            adicionarBotao(panel, "Imprimir Histórico");
            adicionarBotao(panel, "Cálculo do IRA");
        }
        adicionarBotao(panel, "Sair");
        panel.revalidate();
        panel.repaint();
    }

    private void adicionarBotao(JPanel panel, String texto) {
        JButton botao = new JButton("<html><center>" + texto + "</center></html>"); 
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setForeground(Color.decode("#A1CAE3"));
        botao.setBackground(Color.decode("#1C275F"));
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        botao.setHorizontalTextPosition(SwingConstants.CENTER);
        botao.setVerticalTextPosition(SwingConstants.BOTTOM);

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(Color.decode("#233178"));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(Color.decode("#1C275F"));
            }
        });

        botao.setPreferredSize(new Dimension(200, 0));
        panel.add(botao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard("Aluno"));
    }
}
