package usuarios;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.HoraException;
import exceptions.NomeException;
import faculdade.Curso;
import faculdade.Disciplina;
import persistence.DisciplinaAluno;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

public class Aluno extends Usuario {
    protected Curso curso;
    protected String cursoStr;
    protected List <Disciplina> disciplinasLet;
    protected Map<String, Disciplina> disciplinas;
    protected float ira;

    public void setCursoStr(String cursoStr) {
        this.cursoStr = cursoStr;
    }

    public String getCursoStr() {
        return cursoStr;
    }
    
    public Aluno(String user) {
        super();
        this.tipoUsuario = 0;
        this.usuario = user;
        DisciplinaAluno per = new DisciplinaAluno(this.usuario);
        this.disciplinas = per.findAll();
    }

    public Map<String, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Map<String, Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina(int index) {
        return disciplinas.get(index);
    }
    private void carregaDisciplinas() {
        DisciplinaAluno per = new DisciplinaAluno(this.usuario);
        this.disciplinas = per.findAll();
    }

    private double calculaNotas(String codigo) {
        Disciplina d = this.disciplinas.get(codigo);
        double notaFinal = 0;

        if (d != null) {
            if (d.getNotas() != null && !d.getNotas().isEmpty()) {
                for (double nota : d.getNotas()) {
                    notaFinal += nota;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhuma nota encontrada para a disciplina: " + codigo);
            }
            return notaFinal;
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Disciplina não encontrada na matrícula do aluno.");
        return notaFinal;
    }

    public float calculaIra() throws HoraException, NomeException {
        carregaDisciplinas(); 

        float somatorioHoras = 0;
        float somatorioNota = 0;

        try {
            for (Disciplina disciplina : this.disciplinas.values()) {
                double notaDisciplina = calculaNotas(disciplina.getCodigo()); //mudar aqui tbm
                float cargaHoraria = disciplina.getCargaHoraria();

                somatorioNota += notaDisciplina * cargaHoraria;
                somatorioHoras += cargaHoraria;
            }

            if (somatorioHoras > 0) {
                this.ira = somatorioNota / somatorioHoras;
            } else {
                this.ira = 0;
            }

            if (Double.isNaN(this.ira)) {
                this.ira = 0;
            }

        } catch (java.lang.NullPointerException e) {
            //javax.swing.JOptionPane.showMessageDialog(null, "Erro ao calcular o IRA: " + e.getMessage());
        }

        return this.ira;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.cursoStr = curso.getNome();
    }
   public void exibirInformacoesAluno() {
        
        JFrame frame = new JFrame("Informações do Aluno");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        
        panel.add(new JLabel("Nome do Aluno:"));
        panel.add(new JLabel(this.usuario));

        panel.add(new JLabel("Curso:"));
        panel.add(new JLabel(this.cursoStr));

        try {
            float iraCalculado = calculaIra();
            panel.add(new JLabel("IRA:"));
            panel.add(new JLabel(String.format("%.2f", iraCalculado)));
        } catch (Exception e) {
            panel.add(new JLabel("Erro ao calcular o IRA"));
        }

        panel.add(new JLabel("Disciplinas:"));
        if (disciplinas != null && !disciplinas.isEmpty()) {
            for (Map.Entry<String, Disciplina> entry : disciplinas.entrySet()) {
                Disciplina disciplina = entry.getValue();
                String disciplinaNome = disciplina.getNome();
                String notas = disciplina.getNotas().toString();
                panel.add(new JLabel(disciplinaNome + ":"));
                panel.add(new JLabel("Notas: " + notas));
            }
        } else {
            panel.add(new JLabel("Nenhuma disciplina cadastrada."));
        }

        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> frame.dispose());

        frame.add(panel);
        frame.add(fecharButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
