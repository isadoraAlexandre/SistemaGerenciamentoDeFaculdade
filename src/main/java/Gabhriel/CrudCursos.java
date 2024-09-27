package gabhriel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

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
import usuarios.ProfessorCoordenador;

public class CrudCursos extends JFrame {
    
    private List<Curso> listaCursos;
    private DefaultTableModel modeloTabela;

    public CrudCursos() {
        listaCursos = new ArrayList<>();
        configurarJanela();
    }

    private void configurarJanela() {
        setTitle("Gerenciamento de Cursos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // painel principal
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.decode("#F2F7FB"));

        // título
        JLabel tituloLabel = new JLabel("Gerenciamento de Cursos", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        painel.add(tituloLabel, BorderLayout.NORTH);

        // tabela de cursos
        String[] colunas = {"Nome", "Departamento", "Coordenador"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabelaCursos = new JTable(modeloTabela);
        JScrollPane painelScroll = new JScrollPane(tabelaCursos);
        painel.add(painelScroll, BorderLayout.CENTER);

        // botões de ação
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(Color.decode("#F2F7FB"));

        JButton botaoAdicionar = new JButton("Adicionar Curso");
        JButton botaoEditar = new JButton("Editar Curso");
        JButton botaoExcluir = new JButton("Excluir Curso");

        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        // ações dos botões
        botaoAdicionar.addActionListener(e -> adicionarCurso());
        botaoEditar.addActionListener(e -> editarCurso(tabelaCursos.getSelectedRow()));
        botaoExcluir.addActionListener(e -> excluirCurso(tabelaCursos.getSelectedRow()));

        // adiciona painel à janela
        add(painel);
    }

    private void adicionarCurso() {
        JTextField campoNome = new JTextField(10);
        JTextField campoDepartamento = new JTextField(10);
        JTextField campoCoordenador = new JTextField(10);

        JPanel painel = new JPanel(new GridLayout(3, 2));
        painel.add(new JLabel("Nome do Curso:"));
        painel.add(campoNome);
        painel.add(new JLabel("Departamento:"));
        painel.add(campoDepartamento);
        painel.add(new JLabel("Coordenador:"));
        painel.add(campoCoordenador);

        int resultado = JOptionPane.showConfirmDialog(null, painel, "Adicionar Curso", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == JOptionPane.OK_OPTION) {
            String nome = campoNome.getText();
            String departamento = campoDepartamento.getText();
            String nomeCoordenador = campoCoordenador.getText();

            if (!nome.isEmpty() && !departamento.isEmpty() && !nomeCoordenador.isEmpty()) {
                ProfessorCoordenador coordenador = new ProfessorCoordenador(nomeCoordenador); // Simulação de coordenador
                Curso novoCurso = new Curso(nome);
                novoCurso.setDepartamento(departamento);
                novoCurso.setCoordenador(coordenador);

                listaCursos.add(novoCurso);
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
            }
        }
    }

    private void editarCurso(int linhaSelecionada) {
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um curso para editar.");
            return;
        }

        Curso cursoSelecionado = listaCursos.get(linhaSelecionada);

        JTextField campoNome = new JTextField(cursoSelecionado.getNome(), 10);
        JTextField campoDepartamento = new JTextField(cursoSelecionado.getDepartamento(), 10);
        JTextField campoCoordenador = new JTextField(cursoSelecionado.getCoordenador().getNome(), 10);

        JPanel painel = new JPanel(new GridLayout(3, 2));
        painel.add(new JLabel("Nome do Curso:"));
        painel.add(campoNome);
        painel.add(new JLabel("Departamento:"));
        painel.add(campoDepartamento);
        painel.add(new JLabel("Coordenador:"));
        painel.add(campoCoordenador);

        int resultado = JOptionPane.showConfirmDialog(null, painel, "Editar Curso", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == JOptionPane.OK_OPTION) {
            String nome = campoNome.getText();
            String departamento = campoDepartamento.getText();
            String nomeCoordenador = campoCoordenador.getText();

            if (!nome.isEmpty() && !departamento.isEmpty() && !nomeCoordenador.isEmpty()) {
                cursoSelecionado.setNome(nome);
                cursoSelecionado.setDepartamento(departamento);
                cursoSelecionado.getCoordenador().setNome(nomeCoordenador);

                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
            }
        }
    }

    private void excluirCurso(int linhaSelecionada) {
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um curso para excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o curso?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            listaCursos.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);  // limpa a tabela

        for (Curso curso : listaCursos) {
            Object[] dadosLinha = {curso.getNome(), curso.getDepartamento(), curso.getCoordenador().getNome()};
            modeloTabela.addRow(dadosLinha);
        }
    }
}
