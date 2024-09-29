package com.mycompany.sistemagerenciamentodefaculdade;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Gabhriel.CrudCursos;
import exceptions.CpfException;
import exceptions.DataException;
import exceptions.NomeException;
import faculdade.Curso;
import usuarios.Aluno;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GerenciamentoAlunosGUI extends JFrame {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;

    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private static final String CSV_FILE = "Usuarios.csv";
    private static final Color AZUL_ESCURO = new Color(28, 39, 95);
    private static final Color AZUL_MEDIO = new Color(2, 122, 160);
    private static final Color AZUL_QUASE_BRANCO = new Color(242, 247, 251);
    private static final Color BRANCO = Color.WHITE; 


    public GerenciamentoAlunosGUI() {
        initialize();
        setupEvents();
        carregarDadosDoCSV();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gerenciamento de Alunos");

        frame.getContentPane().setBackground(BRANCO); 
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(BRANCO); 
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Configurar a tabela
        String[] columnNames = {"Matrícula:", "Nome:", "CPF:", "Data de Nascimento:", "Curso:"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
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
                abrirModalAdicionarEditar("Adicionar Aluno", null);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    abrirModalAdicionarEditar("Editar Aluno", selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um aluno para editar.");
                }
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir este aluno?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        salvarDadosNoCSV();
                        selectedRow = -1;
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um aluno para excluir.");
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

        String[] labels = {"Matrícula:", "Nome:", "CPF:", "Data de Nascimento:", "Curso:"};
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
                fields[i].setText((String) tableModel.getValueAt(rowIndex, i));
            }
        }

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(AZUL_ESCURO);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rowIndex == null) {
                    try {
                        Aluno novoAluno = new Aluno(fields[0].getText());
                        novoAluno.setMatricula(fields[0].getText());
                        novoAluno.setNome(fields[1].getText());
                        novoAluno.setCpf(fields[2].getText());
                        novoAluno.setDataStr(fields[3].getText());
                        novoAluno.setCursosStr(fields[4].getText());

                        String[] aluno = {novoAluno.getMatricula(), novoAluno.getNome(), novoAluno.getCpf(), novoAluno.getDataStr(), novoAluno.getCursoStr()};
                        tableModel.addRow(aluno);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                    }
                } else {
                    String[] valorNovo = new String[labels.length];
                    for (int i = 0; i < labels.length; i++) {
                        valorNovo[i] = fields[i].getText();
                    }
                    for (int i = 0; i < labels.length; i++) {
                        tableModel.setValueAt(valorNovo[i], rowIndex, i);
                    }
                }
                salvarDadosNoCSV();
                modalFrame.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = labels.length; 
        gbc.gridwidth = 2; 
        modalPanel.add(btnSalvar, gbc);

        modalFrame.add(modalPanel);
        modalFrame.setVisible(true);
    }

    private void carregarDadosDoCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                tableModel.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarDadosNoCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    sb.append(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        sb.append(",");
                    }
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparSelecao() {
        table.clearSelection();
        selectedRow = -1;
    }
}
