package Gabhriel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import faculdade.Disciplina;
import usuarios.Aluno;
import usuarios.Funcionarios;

public class ListaAluno extends JFrame {

    private JComboBox<String> cb;
    private JTable tabelaAlunos;
    private DefaultTableModel tableModel;

    private List<Disciplina> discprof;
    private List<Aluno> alunos;

    public ListaAluno(Funcionarios prof, List<Disciplina> disc) {
        setTitle("Listagem de Alunos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // painel principal
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // obtem as disciplinas do professor
        discprof = new ArrayList<>();
        for (Disciplina d : disc) {
            if (d.getProfessor().equals(prof.getNome())) {
                discprof.add(d);
            }
        }


        alunos = carregarAlunosDoCSV("banco_arquivos/Usuarios.csv");

        // cb seleciona disciplina
        cb = new JComboBox<>();
        for (Disciplina d : discprof) {
            cb.addItem(d.getNome());
        }
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabelaAlunos();
            }
        });

        panel.add(cb, BorderLayout.NORTH);

        // tabela para listar os alunos
        String[] colunas = {"Nome", "Matrícula", "CPF"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabelaAlunos = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        panel.add(scrollPane, BorderLayout.CENTER);

        atualizarTabelaAlunos();
    }

    private List<Aluno> carregarAlunosDoCSV(String caminho) {
        List<Aluno> listaAlunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 3) {
                    String nome = dados[0].trim();
                    String matricula = dados[1].trim();
                    String cpf = dados[2].trim();
                    Aluno aluno = new Aluno(nome);
                    listaAlunos.add(aluno);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }

    // método para atualizar a tabela de alunos
    private void atualizarTabelaAlunos() {
        tableModel.setRowCount(0);

        String disciplinaSelecionada = (String) cb.getSelectedItem();

        for (Disciplina d : discprof) {
            if (d.getNome().equals(disciplinaSelecionada)) {
                for (Aluno aluno : d.getAlunos()) {
                    // adicionar dados do aluno na tabela
                    Object[] row = {aluno.getNome(), aluno.getMatricula(), aluno.getCpf()};
                    tableModel.addRow(row);
                }
                break;
            }
        }
    }
    
}
