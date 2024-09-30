package Gabhriel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import faculdade.Disciplina;
import usuarios.Aluno;

public class VerDisciplina extends JFrame {

    // Método para carregar disciplinas do CSV
    public static List<Disciplina> carregarDisciplinasDoCSV() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasGeral.csv";
        List<Disciplina> disciplinas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Supondo que o CSV tenha o formato: Código, Nome, Horário, Professor, Qtd Vagas, Coordenador, Carga Horária, Status
                Disciplina disciplina = new Disciplina(values[0], values[1], values[2], values[3], 
                    Integer.parseInt(values[4]), values[5], Integer.parseInt(values[6]), values[7], values[8]);
                disciplinas.add(disciplina);
            }
        }
        
        return disciplinas;
    }

    public VerDisciplina() {
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
        String[] colunas = {"Código", "Disciplina", "Horário", "Professor", "Qtd Vagas", "Coordenador", "Carga Horária"};
        List<Disciplina> disciplinas;
        try {
            disciplinas = carregarDisciplinasDoCSV();
        } catch (IOException e) {
            e.printStackTrace();
            disciplinas = new ArrayList<>();
        }
        Object[][] dados = new Object[disciplinas.size()][7];

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            dados[i][0] = disciplina.getCodigo();
            dados[i][1] = disciplina.getNome();
            dados[i][2] = disciplina.getHorarioAula();
            dados[i][3] = disciplina.getProfessor();
            dados[i][4] = disciplina.getQtdVagas();
            dados[i][5] = disciplina.getCoordenador();
            dados[i][6] = disciplina.getCargaHoraria();
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

}
