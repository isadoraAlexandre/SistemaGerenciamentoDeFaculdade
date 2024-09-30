package com.mycompany.sistemagerenciamentodefaculdade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import exceptions.CpfException;
import exceptions.DataException;
import exceptions.NomeException;
import faculdade.Disciplina;
import usuarios.Aluno;
import usuarios.Funcionarios;
import usuarios.Professor;
import usuarios.ProfessorCoordenador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Map;
import persistence.DisciplinasPersistence;
import persistence.DisciplinasProfessor;

import java.util.List;
import java.util.ArrayList;

public class GerenciamentoProfessoresGUI extends JFrame {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;

    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private static final String CSV_FILE =  System.getProperty("user.dir") + "/src/main/java/banco_arquivo/professores.csv";
    private static final Color AZUL_ESCURO = new Color(28, 39, 95);
    private static final Color AZUL_MEDIO = new Color(2, 122, 160);
    private static final Color AZUL_QUASE_BRANCO = new Color(242, 247, 251);
    private static final Color BRANCO = Color.WHITE;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GerenciamentoProfessoresGUI window = new GerenciamentoProfessoresGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GerenciamentoProfessoresGUI() {
        initialize();
        setupEvents();
        carregarDadosDoCSV();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1200, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Gerenciamento de Professores");

        frame.getContentPane().setBackground(BRANCO);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(BRANCO);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Configurar a tabela
        String[] columnNames = { "Matrícula", "Nome", "CPF", "Data de Nascimento", "Salario", "Carga horária",
                "Formação", "nao sei", "É Coordenador?" };
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false, false, false
            };
        };

        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setBackground(BRANCO);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setGridColor(AZUL_MEDIO);
        table.setSelectionBackground(AZUL_QUASE_BRANCO);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(BRANCO);
        tablePanel.setBorder(BorderFactory.createLineBorder(AZUL_ESCURO, 2));
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        tablePanel.setPreferredSize(new Dimension(1200, 500));
        table.setPreferredScrollableViewportSize(new Dimension(1200, 500));

        JPanel panelBotoes = new JPanel();
        panelBotoes.setBackground(BRANCO);
        panel.add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(AZUL_ESCURO);
        btnAdicionar.setForeground(Color.WHITE);
        panelBotoes.add(btnAdicionar);

        btnEditar = new JButton("Editar");
        btnEditar.setBackground(AZUL_ESCURO);
        btnEditar.setForeground(Color.WHITE);
        panelBotoes.add(btnEditar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(AZUL_ESCURO);
        btnExcluir.setForeground(Color.WHITE);
        panelBotoes.add(btnExcluir);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(AZUL_ESCURO);
        btnCancelar.setForeground(Color.WHITE);
        panelBotoes.add(btnCancelar);

        panel.add(tablePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void setupEvents() {
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirModalAdicionarEditar("Adicionar Professor", null);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    abrirModalAdicionarEditar("Editar Professor", selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um Professor para editar.");
                }
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir este Professor?",
                            "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        salvarDadosNoCSV();
                        selectedRow = -1;
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um Professor para excluir.");
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparSelecao();
            }
        });

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedRow = table.getSelectedRow();
                }
            }
        });
    }

    private void abrirModalAdicionarEditar(String titulo, Integer rowIndex) {
        JFrame modalFrame = new JFrame(titulo);
        modalFrame.setSize(600, 500);
        modalFrame.setLocationRelativeTo(frame);
        modalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel modalPanel = new JPanel();
        modalPanel.setLayout(new GridBagLayout());
        modalPanel.setBackground(BRANCO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels e campos
        String[] labels = { "Matrícula", "Nome", "CPF", "Data de Nascimento", "Salario",
                "Carga horária", "Formação", "Disciplinas", "É Coordenador?" };
        JTextField[] fields = new JTextField[labels.length - 1]; // Um campo a menos para o checkbox
        JCheckBox checkBoxCoordenador = new JCheckBox(); // Checkbox para coordenador

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);

            if (i < 8) { // Campo de texto para os primeiros 8 itens
                fields[i] = new JTextField(20);
                gbc.gridx = 0;
                gbc.gridy = i;
                modalPanel.add(label, gbc);
                gbc.gridx = 1;
                modalPanel.add(fields[i], gbc);

                if (rowIndex != null) {
                    fields[i].setText((String) tableModel.getValueAt(rowIndex, i));
                }
            } else { // Para "É Coordenador?"
                gbc.gridx = 0;
                gbc.gridy = i;
                modalPanel.add(label, gbc);
                gbc.gridx = 1;
                modalPanel.add(checkBoxCoordenador, gbc);

                if (rowIndex != null) {
                    checkBoxCoordenador.setSelected(Boolean.parseBoolean((String) tableModel.getValueAt(rowIndex, i)));
                }
            }
        }

        // Painel para as disciplinas
        JPanel disciplinasPanel = new JPanel();
        preencherDisciplinas(disciplinasPanel);
        gbc.gridx = 0;
        gbc.gridy = 8; // Posição das disciplinas
        gbc.gridwidth = 2; // Ocupa duas colunas
        modalPanel.add(disciplinasPanel, gbc);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(AZUL_ESCURO);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rowIndex == null) {
                    try {
                        if (checkBoxCoordenador.isSelected()) {
                            ProfessorCoordenador novoProfessor = new ProfessorCoordenador();
                            novoProfessor.setMatricula(fields[0].getText());
                            novoProfessor.setNome(fields[1].getText());
                            novoProfessor.setCpf(fields[2].getText());
                            novoProfessor.setDataStr(fields[3].getText());
                            novoProfessor.setSalario(Double.parseDouble(fields[4].getText()));
                            novoProfessor.setCargaHoraria(Float.parseFloat(fields[5].getText()));
                            novoProfessor.setNivelFormacao(fields[6].getText());
                            List<String> disciplinasSelecionadas = new ArrayList<>();
                            for (Component comp : disciplinasPanel.getComponents()) {
                                if (comp instanceof JCheckBox) {
                                    JCheckBox checkBox = (JCheckBox) comp;
                                    if (checkBox.isSelected()) {
                                        disciplinasSelecionadas.add(checkBox.getText());
                                    }
                                }
                            }

                            List<Disciplina> disciplinas = new ArrayList<>();
                            DisciplinasPersistence disciplinaDAO = new DisciplinasProfessor();
                            for (String nome : disciplinasSelecionadas) {
                                Disciplina disciplina = disciplinaDAO.findByName(nome);
                                if (disciplina != null) {
                                    disciplinas.add(disciplina);
                                }
                            }
                            novoProfessor.setDisciplinas(disciplinas);
                            salvarNovoProfessorNoCSV(novoProfessor);

                            // Atualizar tabela
                            tableModel.addRow(new Object[] {
                                    novoProfessor.getMatricula(),
                                    novoProfessor.getNome(),
                                    novoProfessor.getCpf(),
                                    novoProfessor.getDataStr(),
                                    novoProfessor.getSalario(),
                                    novoProfessor.getCargaHoraria(),
                                    novoProfessor.getNivelFormacao(),
                                    String.join(";", disciplinasSelecionadas),
                                    checkBoxCoordenador.isSelected() ? "true" : "false"
                            });

                            modalFrame.dispose();
                        } else {
                            Professor novoProfessor = new Professor();
                            novoProfessor.setMatricula(fields[0].getText());
                            novoProfessor.setNome(fields[1].getText());
                            novoProfessor.setCpf(fields[2].getText());
                            novoProfessor.setDataStr(fields[3].getText());
                            novoProfessor.setSalario(Double.parseDouble(fields[4].getText()));
                            novoProfessor.setCargaHoraria(Float.parseFloat(fields[5].getText()));
                            novoProfessor.setNivelFormacao(fields[6].getText());
                            List<String> disciplinasSelecionadas = new ArrayList<>();
                            for (Component comp : disciplinasPanel.getComponents()) {
                                if (comp instanceof JCheckBox) {
                                    JCheckBox checkBox = (JCheckBox) comp;
                                    if (checkBox.isSelected()) {
                                        disciplinasSelecionadas.add(checkBox.getText());
                                    }
                                }
                            }

                            List<Disciplina> disciplinas = new ArrayList<>();
                            DisciplinasPersistence disciplinaDAO = new DisciplinasProfessor();
                            for (String nome : disciplinasSelecionadas) {
                                Disciplina disciplina = disciplinaDAO.findByName(nome);
                                if (disciplina != null) {
                                    disciplinas.add(disciplina);
                                }
                            }
                            novoProfessor.setDisciplinas(disciplinas);
                            salvarNovoProfessorNoCSV(novoProfessor);

                            // Atualizar tabela
                            tableModel.addRow(new Object[] {
                                    novoProfessor.getMatricula(),
                                    novoProfessor.getNome(),
                                    novoProfessor.getCpf(),
                                    novoProfessor.getDataStr(),
                                    novoProfessor.getSalario(),
                                    novoProfessor.getCargaHoraria(),
                                    novoProfessor.getNivelFormacao(),
                                    String.join(";", disciplinasSelecionadas),
                                    checkBoxCoordenador.isSelected() ? "true" : "false"
                            });

                            modalFrame.dispose();
                        }

                    } catch (NomeException | CpfException | DataException ex) {
                        JOptionPane.showMessageDialog(modalFrame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    for (int i = 0; i < labels.length - 1; i++) {
                        tableModel.setValueAt(fields[i].getText(), rowIndex, i);
                    }
                    // Atualiza o status de coordenador
                    tableModel.setValueAt(checkBoxCoordenador.isSelected() ? "true" : "false", rowIndex,
                            labels.length - 1);
                    salvarDadosNoCSV();
                    modalFrame.dispose();
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = labels.length; // Adiciona o botão de salvar na última linha
        gbc.gridwidth = 2;
        modalPanel.add(btnSalvar, gbc);

        modalFrame.add(modalPanel);
        modalFrame.setVisible(true);
    }

    private void preencherDisciplinas(JPanel panelDisciplinas) {
        DisciplinasPersistence disciplinaDAO = new DisciplinasProfessor();
        Map<String, Disciplina> disciplinas = disciplinaDAO.findAll();
        panelDisciplinas.setLayout(new BoxLayout(panelDisciplinas, BoxLayout.Y_AXIS));

        for (Disciplina disciplina : disciplinas.values()) {
            JCheckBox checkbox = new JCheckBox(disciplina.getNome());
            panelDisciplinas.add(checkbox);
        }
    }

    private void carregarDadosDoCSV() {
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            return; // O arquivo não existe, não há nada para carregar
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(","); // Assumindo que os campos são separados por vírgulas
                tableModel.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao carregar dados do arquivo CSV.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarNovoProfessorNoCSV(Funcionarios professor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            String novaLinha = String.join(",",
                    professor.getMatricula(),
                    professor.getNome(),
                    professor.getCpf(),
                    professor.getDataStr(),
                    String.valueOf(professor.getSalario()),
                    String.valueOf(professor.getCargaHoraria()),
                    professor.getNivelFormacao(),
                    String.join(";",
                            professor.getDisciplinas().stream().map(Disciplina::getNome).toArray(String[]::new)));
            bw.write(novaLinha);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao salvar novo professor no arquivo CSV.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarDadosNoCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    linha.append(tableModel.getValueAt(i, j)).append(",");
                }
                // Remove a última vírgula e adiciona uma nova linha
                linha.deleteCharAt(linha.length() - 1);
                bw.write(linha.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao salvar dados no arquivo CSV.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparSelecao() {
        selectedRow = -1;
        table.clearSelection();
    }
}