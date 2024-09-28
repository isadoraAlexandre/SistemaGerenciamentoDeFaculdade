package Gabhriel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import faculdade.Curso;
import faculdade.Disciplina;
import usuarios.Aluno;

public class VerHorario extends JFrame {

    public VerHorario(Aluno aluno) {
        setTitle("Horário das Aulas - " + aluno.getNome());
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBackground(Color.decode("#F2F7FB"));

        JLabel tituloLabel = new JLabel("Horário das Aulas", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setBackground(Color.decode("#F2F7FB"));
        tituloLabel.setOpaque(true);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        String[] colunas = {"Código", "Disciplina", "Horário", "Professor"};
        List<Disciplina> disciplinas = buscarDisciplinasMatriculadas(aluno);
        Object[][] dados = new Object[disciplinas.size()][4];

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            dados[i][0] = disciplina.getCodigo();
            dados[i][1] = disciplina.getNome();
            dados[i][2] = disciplina.getHorarioAula();
            dados[i][3] = disciplina.getProfessor();
        }

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas) {
            public boolean editavel(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(modeloTabela);
        tabela.setBackground(Color.decode("#F2F7FB"));
        JScrollPane painelScroll = new JScrollPane(tabela);
        painelScroll.getViewport().setBackground(Color.decode("#F2F7FB"));

        painelPrincipal.add(painelScroll, BorderLayout.CENTER);

        JButton botaoImprimir = new JButton("Imprimir Horário");
        botaoImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirHorario(aluno, disciplinas);
            }
        });

        JPanel painelBotao = new JPanel();
        painelBotao.setBackground(Color.decode("#F2F7FB"));
        painelBotao.add(botaoImprimir);
        painelPrincipal.add(painelBotao, BorderLayout.SOUTH);

        add(painelPrincipal);
    }

    // busca disciplinas que o aluno está matriculado
    private List<Disciplina> buscarDisciplinasMatriculadas(Aluno aluno) {
        Curso curso = aluno.getCurso();
        return curso.getGrade();
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

        JTextArea areaTexto = new JTextArea(sb.toString());
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JOptionPane.showMessageDialog(null, new JScrollPane(areaTexto),"Horário de Aulas", JOptionPane.INFORMATION_MESSAGE);
    }
}
