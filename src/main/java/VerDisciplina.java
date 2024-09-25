import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import faculdade.Disciplina;
import persistence.DisciplinasPersistence;
import usuarios.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerDisciplina extends JFrame {
    
    private List<Disciplina> getDisciplinas() {
        Map<String, Disciplina> disciplinasMap = DisciplinasPersistence.findAll();
        return new ArrayList<>(disciplinasMap.values());
    }

    private List<Disciplina> getDisciplinasDisponiveisParaAluno(Aluno aluno) {
        Map<String, Disciplina> todasDisciplinas = DisciplinasPersistence.findAll();
        List<Disciplina> disciplinasDisponiveis = new ArrayList<>();

        for (Disciplina disciplina : todasDisciplinas.values()) {
            if (disciplina.getQtdVagas() > 0 && !disciplina.getAlunos().contains(aluno)) {
                disciplinasDisponiveis.add(disciplina);
            }
        }
        return disciplinasDisponiveis;
    }

    public VerDisciplina(Aluno aluno) {
        // Configurações da janela
        setTitle("Disciplinas Disponíveis para Matrícula");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.decode("#F2F7FB"));  // Definindo a cor de fundo

        // Título
        JLabel titleLabel = new JLabel("Disciplinas Disponíveis para Matrícula", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBackground(Color.decode("#F2F7FB")); // Definindo a cor de fundo
        titleLabel.setOpaque(true);  // Para que a cor de fundo seja visível
        panel.add(titleLabel, BorderLayout.NORTH);

        // Dados das disciplinas obtidas dinamicamente
        String[] colunas = {"Código", "Disciplina", "Carga Horária", "Ação"};
        List<Disciplina> disciplinas = getDisciplinasDisponiveisParaAluno(aluno);
        Object[][] dados = new Object[disciplinas.size()][4];

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            dados[i][0] = d.getCodigo();
            dados[i][1] = d.getNome();
            dados[i][2] = d.getCargaHoraria();
            dados[i][3] = "Matricular-se";  // Botão de matrícula
        }

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel(dados, colunas) {
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };

        // Tabela
        JTable tabela = new JTable(model);
        tabela.setBackground(Color.decode("#F2F7FB")); // Definindo a cor de fundo da tabela

        // Renderizar botões na coluna "Ação"
        tabela.getColumn("Ação").setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JButton button = new JButton("Matricular-se");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigo = table.getValueAt(row, 0).toString();
                    String disciplina = table.getValueAt(row, 1).toString();
                    matricularAlunoNaDisciplina(aluno, codigo);
                    JOptionPane.showMessageDialog(null,
                            "Você se matriculou na disciplina: " + disciplina + " (Código: " + codigo + ")");
                }
            });
            return button;
        });

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.getViewport().setBackground(Color.decode("#F2F7FB"));  // Definindo a cor de fundo do scroll pane
        panel.add(scrollPane, BorderLayout.CENTER);

        // Adicionar painel ao frame
        add(panel);
    }

    private void matricularAlunoNaDisciplina(Aluno aluno, String codigoDisciplina) {
        Map<String, Disciplina> todasDisciplinas = DisciplinasPersistence.findAll();
        Disciplina disciplina = todasDisciplinas.get(codigoDisciplina);

        if (disciplina != null && disciplina.getQtdVagas() > 0) {
            disciplina.addAluno(aluno);
            disciplina.setQtdVagas(disciplina.getQtdVagas() - 1);
            DisciplinasPersistence.modificaDisciplina(disciplina);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível matricular na disciplina.");
        }
    }
}
