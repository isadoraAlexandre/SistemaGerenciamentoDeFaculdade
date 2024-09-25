import usuarios.Aluno;
import faculdade.Disciplina;
import faculdade.Curso;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VerHorario extends JFrame {

    public VerHorario(Aluno aluno) {
        // configurações da janela
        setTitle("Horário das Aulas - " + aluno.getNome());
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // painel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#F2F7FB"));  // cor de fundo

        // título
        JLabel titleLabel = new JLabel("Horário das Aulas", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(true);  // permite que a cor de fundo seja aplicada
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // cria os dados da tabela com as disciplinas do aluno
        String[] colunas = {"Código", "Disciplina", "Horário", "Professor"};
        List<Disciplina> disciplinasAluno = getDisciplinasMatriculadas(aluno);
        Object[][] dados = new Object[disciplinasAluno.size()][4];

        for (int i = 0; i < disciplinasAluno.size(); i++) {
            Disciplina disciplina = disciplinasAluno.get(i);
            dados[i][0] = disciplina.getCodigo();
            dados[i][1] = disciplina.getNome();
            dados[i][2] = disciplina.getHorarioAula();
            dados[i][3] = disciplina.getProfessor();
        }

        // modelo da tabela
        DefaultTableModel model = new DefaultTableModel(dados, colunas) {
            public boolean isCellEditable(int row, int column) {
                return false;  // impede a edição da tabela
            }
        };

        // cria a tabela e ajusta as cores
        JTable tabela = new JTable(model);
        tabela.setBackground(Color.decode("#F2F7FB"));
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.getViewport().setBackground(Color.decode("#F2F7FB"));

        panel.add(scrollPane, BorderLayout.CENTER);

        // botão de imprimir
        JButton btnImprimir = new JButton("Imprimir Horário");
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirHorario(aluno, disciplinasAluno);
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#F2F7FB"));
        buttonPanel.add(btnImprimir);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // adiciona o painel à janela
        add(panel);
    }

    // busca as disciplinas em que o aluno está matriculado
    private List<Disciplina> getDisciplinasMatriculadas(Aluno aluno) {
        Curso curso = aluno.getCurso();  // supondo que o aluno tenha um curso associado
        return curso.getGrade();  // retorna a lista de disciplinas do curso
    }

    // simula a impressão do horário
    private void imprimirHorario(Aluno aluno, List<Disciplina> disciplinas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Horário de Aulas - ").append(aluno.getNome()).append("\n\n");

        for (Disciplina disciplina : disciplinas) {
            sb.append("Código: ").append(disciplina.getCodigo())
              .append(", Disciplina: ").append(disciplina.getNome())
              .append(", Horário: ").append(disciplina.getHorarioAula())
              .append(", Professor: ").append(disciplina.getProfessor()).append("\n");
        }

        // exibe o horário em uma caixa de diálogo
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), 
                                      "Horário de Aulas", JOptionPane.INFORMATION_MESSAGE);
    }
}
