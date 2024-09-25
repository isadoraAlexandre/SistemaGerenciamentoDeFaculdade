import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GerenciamentoAlunosGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;

    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private static final String CSV_FILE = "alunos.csv"; 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GerenciamentoAlunosGUI window = new GerenciamentoAlunosGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

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

        JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        String[] columnNames = {"Usuário", "Nome", "CPF", "Data de Nascimento", "Matrícula", "Endereço", "Email", "Celular", "Gênero", "Portador de deficiência", "Tipo de usuário", "Dados bancários", "Disciplinas", "CRUD informações pessoais", "Valida informações de criação", "Histórico", "Horas Computadas", "Curso", "Semestre de Ingresso", "Turno do curso"};
        Object[][] data = {};

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        for (int i = 1; i < columnNames.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();
        panel.add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar = new JButton("Adicionar");
        panelBotoes.add(btnAdicionar);

        btnEditar = new JButton("Editar");
        panelBotoes.add(btnEditar);

        btnExcluir = new JButton("Excluir");
        panelBotoes.add(btnExcluir);

        btnCancelar = new JButton("Cancelar");
        panelBotoes.add(btnCancelar);

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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] labels = {"Usuário:", "Nome:", "CPF:", "Data de Nascimento:", "Matrícula:", "Endereço:", "Email:", "Celular:", "Gênero:", "Portador de deficiência:", "Tipo de usuário:", "Dados bancários:", "Disciplinas:", "CRUD informações pessoais:", "Valida informações de criação:", "Histórico:", "Horas Computadas:", "Curso:", "Semestre de Ingresso:", "Turno do curso:"};
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

        JScrollPane scrollPane = new JScrollPane(modalPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rowIndex == null) {
                    String[] novoAluno = new String[labels.length];
                    for (int i = 0; i < fields.length; i++) {
                        novoAluno[i] = fields[i].getText();
                    }
                    tableModel.addRow(novoAluno);
                } else {
                    for (int i = 0; i < labels.length; i++) {
                        String valorNovo = fields[i].getText();
                        String valorAntigo = (String) tableModel.getValueAt(rowIndex, i);
                        
                        if (!valorNovo.equals(valorAntigo)) {
                            tableModel.setValueAt(valorNovo, rowIndex, i);
                        }
                    }
                }
                salvarDadosNoCSV(); 
                modalFrame.dispose();
            }
        });

        gbc.gridx = 1;
        gbc.gridy = labels.length;
        modalPanel.add(btnSalvar, gbc);

        modalFrame.add(scrollPane);
        modalFrame.setVisible(true);
    }

    private void limparSelecao() {
        table.clearSelection();
        selectedRow = -1;
    }

    private void salvarDadosNoCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.write((String) tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDadosDoCSV() {
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                tableModel.addRow(dados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
