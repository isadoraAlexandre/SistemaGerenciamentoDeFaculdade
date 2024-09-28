package usuarios;

import faculdade.Disciplina;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class Funcionarios extends Usuario {

    protected double salario;
    protected float cargaHoraria;
    protected String nivelFormacao;
    protected int tempoServico;
    protected List<Disciplina> disciplinas;

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivelFormacao() {
        return nivelFormacao;
    }

    public void setNivelFormacao(String nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public void lancarFalta(Aluno aluno, Disciplina disciplina, int nfaltas) {
        disciplina.getAlunos().forEach(a -> {
            if (a.equals(aluno)) {
                int indice = disciplina.getAlunos().indexOf(a);
                List<Integer> faltas = disciplina.getFaltas();
                faltas.set(indice, nfaltas);
                disciplina.setFaltas(faltas);
            }
        });
    }

    public void lancarNota(Aluno aluno, Disciplina disciplina, double nota) {
        disciplina.getAlunos().forEach(a -> {
            if (a.equals(aluno)) {
                int indice = disciplina.getAlunos().indexOf(a);
                List<Double> notas = disciplina.getNotas();
                notas.set(indice, nota);
                disciplina.setNotas(notas);
            }
        });
    }

    public class LancaFaltaFuncionarioUI extends JFrame {

        private JComboBox<Disciplina> disciplinaComboBox;
        private JComboBox<Aluno> alunoComboBox;
        private JTextField faltasField;
        private JTextField notasField; // Campo para as notas
        private JButton lancarButton;

        public LancaFaltaFuncionarioUI() {
            setTitle("Lançar Faltas e Notas");
            setSize(1000, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new GridLayout(5, 2)); // Atualizado para 5 linhas

            JLabel disciplinaLabel = new JLabel("Disciplina:");
            JLabel alunoLabel = new JLabel("Aluno:");
            JLabel faltasLabel = new JLabel("Número de Faltas:");
            JLabel notasLabel = new JLabel("Nota:"); // Rótulo para as notas

            disciplinaComboBox = new JComboBox<>(disciplinas.toArray(new Disciplina[0]));
            alunoComboBox = new JComboBox<>();
            alunoComboBox.setEnabled(false);

            faltasField = new JTextField(5);
            notasField = new JTextField(5); // Campo de texto para inserir a nota
            lancarButton = new JButton("Lançar Falta e Nota");
            lancarButton.setEnabled(false);

            add(disciplinaLabel);
            add(disciplinaComboBox);
            add(alunoLabel);
            add(alunoComboBox);
            add(faltasLabel);
            add(faltasField);
            add(notasLabel);
            add(notasField);
            add(new JLabel());
            add(lancarButton);

            disciplinaComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Disciplina disciplinaSelecionada = (Disciplina) disciplinaComboBox.getSelectedItem();
                    if (disciplinaSelecionada != null) {
                        List<Aluno> alunosDaDisciplina = disciplinaSelecionada.getAlunos();
                        alunoComboBox.removeAllItems();
                        for (Aluno aluno : alunosDaDisciplina) {
                            alunoComboBox.addItem(aluno);
                        }
                        alunoComboBox.setEnabled(true);
                        lancarButton.setEnabled(true);
                    }
                }
            });

            lancarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
                        Disciplina disciplinaSelecionada = (Disciplina) disciplinaComboBox.getSelectedItem();
                        int nfaltas = Integer.parseInt(faltasField.getText());
                        double nota = Double.parseDouble(notasField.getText()); // Conversão da nota

                        if (alunoSelecionado != null && disciplinaSelecionada != null) {
                            lancarFalta(alunoSelecionado, disciplinaSelecionada, nfaltas);
                            lancarNota(alunoSelecionado, disciplinaSelecionada, nota); // Lançar a nota
                            JOptionPane.showMessageDialog(null, "Falta e nota lançadas com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione um aluno e uma disciplina.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para faltas e notas.");
                    }
                }
            });
        }
    }
}
