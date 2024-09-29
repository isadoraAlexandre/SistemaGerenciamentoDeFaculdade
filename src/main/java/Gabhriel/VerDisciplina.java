package Gabhriel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import faculdade.Disciplina;
import persistence.DisciplinaAluno;
import persistence.DisciplinasPersistence;
import usuarios.Aluno;

public class VerDisciplina extends JFrame {

    // obtém todas as disciplinas
    private List<Disciplina> buscarDisciplinas() {
        DisciplinasPersistence per = new DisciplinaAluno("teste"); // cria persistence para o usuário teste
        Map<String, Disciplina> mapaDisciplinas = per.findAll();
        return new ArrayList<>(mapaDisciplinas.values());
    }

    // busca disciplinas disponíveis para o aluno
    private List<Disciplina> buscarDisciplinasDisponiveisParaAluno(Aluno aluno) {
        DisciplinasPersistence per = new DisciplinaAluno("teste"); // cria persistence para o usuário teste
        Map<String, Disciplina> todasDisciplinas = per.findAll();

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        String[] colunas = {"Código", "Disciplina", "Carga Horária"};
        List<Disciplina> disciplinas = buscarDisciplinasDisponiveisParaAluno(aluno);
        Object[][] dados = new Object[disciplinas.size()][3];

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            dados[i][0] = disciplina.getCodigo();
            dados[i][1] = disciplina.getNome();
            dados[i][2] = disciplina.getCargaHoraria();
        }

        // modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);

        // tabela
        JTable tabela = new JTable(modeloTabela);
        tabela.setBackground(Color.decode("#F2F7FB"));

        JScrollPane painelScroll = new JScrollPane(tabela);
        painelScroll.getViewport().setBackground(Color.decode("#F2F7FB"));
        painelPrincipal.add(painelScroll, BorderLayout.CENTER);

        // adiciona painel ao frame
        add(painelPrincipal);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Criação de um aluno de exemplo
            Aluno alunoExemplo = new Aluno("João da Silva"); // Ajuste os parâmetros conforme necessário
            VerDisciplina verDisciplina = new VerDisciplina(alunoExemplo);
            verDisciplina.setVisible(true);
        });
    }
}
