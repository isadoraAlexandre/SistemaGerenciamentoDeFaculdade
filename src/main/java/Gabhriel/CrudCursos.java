package Gabhriel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import faculdade.Curso;
import faculdade.Disciplina;
import usuarios.ProfessorCoordenador;

public class CrudCursos extends JFrame {
    private static final String CSV_FILE = "cursos.csv";
    
    private List<Curso> listaCursos;
    private DefaultTableModel modeloTabela;

    private static final Color AZUL_ESCURO = new Color(28, 39, 95);
    private static final Color BRANCO = Color.WHITE; 

    public CrudCursos() {
        listaCursos = new ArrayList<>();
        configurarJanela();
        carregarDadosDoCSV();
    }

    private void configurarJanela() {
        setTitle("Gerenciamento de Cursos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // painel principal
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.decode("#F2F7FB"));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem

        // título
        JLabel tituloLabel = new JLabel("Gerenciamento de Cursos", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Fonte maior
        painel.add(tituloLabel, BorderLayout.NORTH);

        // tabela de cursos
        String[] colunas = {"Nome", "Departamento", "Coordenador"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabelaCursos = new JTable(modeloTabela);
        JScrollPane painelScroll = new JScrollPane(tabelaCursos);
        painel.add(painelScroll, BorderLayout.CENTER);

        // botões de ação
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 10, 0)); // Grid com espaçamento
        painelBotoes.setBackground(Color.decode("#F2F7FB"));

        JButton botaoAdicionar = new JButton("Adicionar Curso");
        JButton botaoEditar = new JButton("Editar Curso");
        JButton botaoExcluir = new JButton("Excluir Curso");

        // Estilizando botões
        botaoAdicionar.setBackground(AZUL_ESCURO);
        botaoAdicionar.setForeground(BRANCO);
        botaoEditar.setBackground(AZUL_ESCURO);
        botaoEditar.setForeground(BRANCO);
        botaoExcluir.setBackground(AZUL_ESCURO);
        botaoExcluir.setForeground(BRANCO);

        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        // ações dos botões
        botaoAdicionar.addActionListener(e -> abrirModalAdicionarCurso());
        botaoEditar.addActionListener(e -> abrirModalEditarCurso(tabelaCursos.getSelectedRow()));
        botaoExcluir.addActionListener(e -> {
            int selectedRow = tabelaCursos.getSelectedRow();
            excluirCurso(selectedRow);
        });

        // adiciona painel à janela
        add(painel);
    }

    private void abrirModalAdicionarCurso() {
        abrirModalCurso("Adicionar Curso", null);
    }

    private void abrirModalEditarCurso(int rowIndex) {
        abrirModalCurso("Editar Curso", rowIndex);
    }

    private void abrirModalCurso(String titulo, Integer rowIndex) {
        JFrame modalFrame = new JFrame(titulo);
        modalFrame.setSize(600, 400);
        modalFrame.setLocationRelativeTo(this);
        modalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel modalPanel = new JPanel();
        modalPanel.setLayout(new GridBagLayout());
        modalPanel.setBackground(BRANCO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] labels = {"Nome:", "Departamento:", "Coordenador:"};
        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            fields[i] = new JTextField(20);

            gbc.gridx = 0;
            gbc.gridy = i;
            modalPanel.add(label, gbc);

            gbc.gridx = 1;
            modalPanel.add(fields[i], gbc);
            if (rowIndex != null) {
                fields[i].setText((String) modeloTabela.getValueAt(rowIndex, i));
            }
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(AZUL_ESCURO);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.addActionListener(e -> {
            if (rowIndex == null) {
                adicionarCurso(fields);
            } else {
                editarCurso(fields, rowIndex);
            }
            modalFrame.dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        modalPanel.add(btnSalvar, gbc);

        modalFrame.add(modalPanel);
        modalFrame.setVisible(true);
    }

    private void adicionarCurso(JTextField[] fields) {
        try {
            Curso novoCurso = new Curso(fields[0].getText());
            novoCurso.setDepartamento(fields[1].getText());
            novoCurso.setCoordenador(new ProfessorCoordenador(fields[2].getText()));
            Map<String, Disciplina> grade = new HashMap<>();
            novoCurso.setGrade(grade);

            listaCursos.add(novoCurso);
            atualizarTabela();
            salvarDadosNoCSV();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void editarCurso(JTextField[] fields, int rowIndex) {
        Curso curso = listaCursos.get(rowIndex);
        curso.setNome(fields[0].getText());
        curso.setDepartamento(fields[1].getText());
        curso.setCoordenador(new ProfessorCoordenador(fields[2].getText()));

        atualizarTabela();
        salvarDadosNoCSV();
    }

    private void excluirCurso(int rowIndex) {
        if (rowIndex >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Tem certeza que deseja excluir este curso?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                listaCursos.remove(rowIndex);
                modeloTabela.removeRow(rowIndex);
                salvarDadosNoCSV();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (Curso curso : listaCursos) {
            Object[] dadosLinha = {curso.getNome(), curso.getDepartamento(), curso.getCoordenador().getNome()};
            modeloTabela.addRow(dadosLinha);
        }
    }

    private void carregarDadosDoCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                Curso curso = new Curso(dados[0]);
                curso.setDepartamento(dados[1]);
                curso.setCoordenador(new ProfessorCoordenador(dados[2]));
                listaCursos.add(curso);
                modeloTabela.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarDadosNoCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (Curso curso : listaCursos) {
                StringBuilder sb = new StringBuilder();
                sb.append(curso.getNome()).append(",").append(curso.getDepartamento()).append(",").append(curso.getCoordenador().getNome());
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CrudCursos crudCursos = new CrudCursos();
            crudCursos.setVisible(true);
        });
    }
}
