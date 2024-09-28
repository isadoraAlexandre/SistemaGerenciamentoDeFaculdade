package Gabhriel;
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
import persistence.DisciplinaAluno;

public class VerDisciplina extends JFrame {

    // obtém todas as disciplinas
    private List<Disciplina> buscarDisciplinas() {
        
        DisciplinasPersistence per = new DisciplinaAluno("teste");//cria persistence p user teste
        Map<String, Disciplina> mapaDisciplinas = per.findAll();
        return new ArrayList<>(mapaDisciplinas.values());
    }

    // busca disciplinas disponíveis para o aluno
    private List<Disciplina> buscarDisciplinasDisponiveisParaAluno(Aluno aluno) {
        DisciplinasPersistence per = new DisciplinaAluno("teste");//cria persistence p user teste
        Map<String, Disciplina> todasDisciplinas = per.findAll();
        //Map<String, Disciplina> todasDisciplinas = DisciplinasPersistence.findAll();
        
        List<Disciplina> disciplinasDisponiveis = new ArrayList<>();

        for (Disciplina disciplina : todasDisciplinas.values()) {
            if (disciplina.getQtdVagas() > 0 && !disciplina.getAlunos().contains(aluno)) {
                disciplinasDisponiveis.add(disciplina);
            }
        }
        return disciplinasDisponiveis;
    }

    public VerDisciplina(Aluno aluno) {
        setTitle("Disciplinas Disponíveis para Matrícula");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setBackground(Color.decode("#F2F7FB"));

        // título
        JLabel tituloLabel = new JLabel("Disciplinas Disponíveis para Matrícula", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setBackground(Color.decode("#F2F7FB"));
        tituloLabel.setOpaque(true);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // dados das disciplinas
        String[] colunas = {"Código", "Disciplina", "Carga Horária", "Ação"};
        List<Disciplina> disciplinas = buscarDisciplinasDisponiveisParaAluno(aluno);
        Object[][] dados = new Object[disciplinas.size()][4];

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            dados[i][0] = disciplina.getCodigo();
            dados[i][1] = disciplina.getNome();
            dados[i][2] = disciplina.getCargaHoraria();
            dados[i][3] = "Matricular-se";
        }

        // modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas) {
            public boolean isCellEditable(int row, int column) {
                return column == 3;  // somente a coluna "Ação" é editável
            }
        };

        // tabela
        JTable tabela = new JTable(modeloTabela);
        tabela.setBackground(Color.decode("#F2F7FB"));

        tabela.getColumn("Ação").setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JButton botaoMatricula = new JButton("Matricular-se");
            botaoMatricula.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigoDisciplina = table.getValueAt(row, 0).toString();
                    String nomeDisciplina = table.getValueAt(row, 1).toString();
                    //matricularAlunoEmDisciplina(aluno, codigoDisciplina);
                    JOptionPane.showMessageDialog(null,
                            "Você se matriculou na disciplina: " + nomeDisciplina + " (Código: " + codigoDisciplina + ")");
                }
            });
            return botaoMatricula;
        });

        JScrollPane painelScroll = new JScrollPane(tabela);
        painelScroll.getViewport().setBackground(Color.decode("#F2F7FB"));
        painelPrincipal.add(painelScroll, BorderLayout.CENTER);

        // adiciona painel ao frame
        add(painelPrincipal);
    }
    
}
