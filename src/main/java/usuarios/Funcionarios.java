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

    public class LancaFaltaFuncionarioUI extends JFrame {

        private JComboBox<Disciplina> disciplinaComboBox;
        private JComboBox<Aluno> alunoComboBox;
        private JTextField faltasField;
        private JButton lancarButton;

        public LancaFaltaFuncionarioUI(List<Disciplina> disciplinas) {
            setTitle("Lançar Faltas");
            setSize(1000, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new GridLayout(4, 2));

            JLabel disciplinaLabel = new JLabel("Disciplina:");
            JLabel alunoLabel = new JLabel("Aluno:");
            JLabel faltasLabel = new JLabel("Número de Faltas:");

            disciplinaComboBox = new JComboBox<>(disciplinas.toArray(new Disciplina[0]));
            alunoComboBox = new JComboBox<>();
            alunoComboBox.setEnabled(false);

            faltasField = new JTextField(5);
            lancarButton = new JButton("Lançar Falta");
            lancarButton.setEnabled(false);

            add(disciplinaLabel);
            add(disciplinaComboBox);
            add(alunoLabel);
            add(alunoComboBox);
            add(faltasLabel);
            add(faltasField);
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

                        if (alunoSelecionado != null && disciplinaSelecionada != null) {
                            lancarFalta(alunoSelecionado, disciplinaSelecionada, nfaltas);
                            JOptionPane.showMessageDialog(null, "Falta lançada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione um aluno e uma disciplina.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um número válido de faltas.");
                    }
                }
            });
        }
    }
}
