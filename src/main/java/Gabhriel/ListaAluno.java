package Gabhriel;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.CpfException;
import exceptions.NomeException;
import usuarios.Aluno;

public class ListaAluno extends JFrame {

    private JTable tabelaAlunos; // Tabela para exibir alunos
    private DefaultTableModel tableModel; // Modelo da tabela
    private List<Aluno> alunos; // Lista de alunos

    public ListaAluno() {
        setTitle("Listagem de Alunos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

       
        alunos = carregarAlunosDoCSV(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/alunos.csv");

        String[] colunas = {"Lista de Alunos", "Aluno", "CPF"};
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

                    Aluno aluno = new Aluno(cpf); 
                    try {
                        aluno.setNome(nome);
                    } catch (NomeException e) {
                        System.err.println("Erro no nome: " + e.getMessage());
                    }
                    aluno.setMatricula(matricula); 
                    try {
                        aluno.setCpf(cpf); 
                    } catch (CpfException e) {
                        System.err.println("Erro no CPF: " + e.getMessage());
                    }
                    listaAlunos.add(aluno); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAlunos; 
    }

    private void atualizarTabelaAlunos() {
        tableModel.setRowCount(0); 

        for (Aluno aluno : alunos) {
            Object[] row = {aluno.getNome(), aluno.getMatricula(), aluno.getCpf()};
            tableModel.addRow(row); 
        }
    }

}
