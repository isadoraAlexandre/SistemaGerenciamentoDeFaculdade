package faculdade;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import auxiliares.Hora;
import exceptions.CargaHException;
import exceptions.CodigoException;
import exceptions.HoraException;
import exceptions.NomeException;
import exceptions.VagasException;
import usuarios.Aluno;

public class Disciplina {
    protected String nome;
    protected int qtdVagas;
    protected String codigo;
    protected String horarioAula;
    protected String professor;
    protected int cargaHoraria;
    protected String coordenador;
    
    protected List<Aluno> alunos;
    protected List<Integer> qtdFaltas;
    protected List<Double> notas;
    protected Double nota;
    protected String status;
    protected String curso;

    public Disciplina() {
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.qtdFaltas = new ArrayList<>();
    }

    public static List<Disciplina> carregarDisciplinasDoCSV() throws IOException {
        List<Disciplina> disciplinas = new ArrayList<>();
        String caminhoArquivo = "banco_arquivo/DisciplinasGeral.csv";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 9) {
                    Disciplina disciplina = new Disciplina(
                            dados[0],   // código
                            dados[1],   // nome
                            dados[2],   // horário
                            dados[3],   // professor
                            Integer.parseInt(dados[4]), // quantidade de vagas
                            dados[5],   // coordenador
                            Integer.parseInt(dados[6]), // carga horária
                            dados[7],    // status
                            dados[8]    //curso
                    );
                    disciplinas.add(disciplina);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Erro ao ler o arquivo CSV: " + caminhoArquivo);
        }
        return disciplinas;
    }
    

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Integer> getFaltas() {
        return qtdFaltas;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void setFaltas(List<Integer> faltas) {
        this.qtdFaltas = faltas;
    }

    public Disciplina(String codigo, String nome, String horarioAula, String professor,
            int qtdVagas, String coordenador, int cargaHoraria, String status, String curso) {
        this.nome = nome;
        this.qtdVagas = qtdVagas;
        this.codigo = codigo;
        this.horarioAula = horarioAula;
        this.professor = professor;
        this.coordenador = coordenador;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.curso = curso;
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    /*public void addProfessor(Funcionarios professor) {
        professores.add(professor);
    }

    public void removeProfessor(Funcionarios professor) {
        professores.remove(professor);
    }

    public Funcionarios getProfessor(int index) {
        return professores.get(index);
    }*/
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Aluno getAluno(int index) {
        return alunos.get(index);
    }

    public void addNota(Double nota) {
        notas.add(nota);
    }

    public void removeNota(Double nota) {
        notas.remove(nota);
    }

    public Double getNota(int index) {
        return notas.get(index);
    }
    
    /*public void addTurma(String turma) {
        turmas.add(turma);
    }

    public void removeTurma(String turma) {
        turmas.remove(turma);
    }

    public String getTurma(int index) {
        return turmas.get(index);
    }*/

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeException {
        nome = nome.trim();
        if (!isValidNome(nome)) {
            throw new NomeException();
        }
        this.nome = nome;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) throws VagasException {
        if (qtdVagas <= 0) {
            throw new VagasException();
        }
        this.qtdVagas = qtdVagas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws CodigoException {
        codigo = codigo.trim();

        if (!isValidCodigo(codigo)) {
            throw new CodigoException();
        }

        this.codigo = codigo;
    }

    public String getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(String horarioAula) throws HoraException {
        horarioAula = horarioAula.replaceAll("\\s", "");

        if (!Hora.isValidHorario(horarioAula)) {
            throw new HoraException();
        }

        this.horarioAula = horarioAula;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) throws NomeException {
        professor = professor.trim();

        if (!isValidNome(professor)) {
            throw new NomeException();
        }

        this.professor = professor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) throws NomeException {
        coordenador = coordenador.trim();

        if (!isValidNome(coordenador)) {
            throw new NomeException();
        }

        this.coordenador = coordenador;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) throws CargaHException {
        cargaHoraria = cargaHoraria.replaceAll("\\s", "");

        if (!isValidCargaH(cargaHoraria)) {
            throw new CargaHException();
        }

        int c = Integer.parseInt(cargaHoraria);

        if (c <= 0 || c >= 200) {
            throw new CargaHException();
        }

        this.cargaHoraria = c;
    }

    public List<Integer> getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(List<Integer> qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    

    private boolean isValidCodigo(String cod) {
        String codPattern = "^[A-Z]{3}\\d{3}$";
        Pattern compPattern = Pattern.compile(codPattern);
        return (cod != null && compPattern.matcher(cod).matches());
    }

    private boolean isValidNome(String nome) {
        String nomePattern = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\s-]{3,100}$";
        Pattern compPattern = Pattern.compile(nomePattern);
        return (nome != null && compPattern.matcher(nome).matches());
    }

    private boolean isValidCargaH(String cargaHoraria) {
        String horarioPattern = "\\d{2,3}";
        Pattern compPattern = Pattern.compile(horarioPattern);
        return (cargaHoraria != null && compPattern.matcher(cargaHoraria).matches());
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", qtdVagas=" + qtdVagas + ", codigo=" + codigo + ", horarioAula=" + horarioAula + ", professor=" + professor + ", coordenador=" + coordenador + ", cargaHoraria=" + cargaHoraria + '}';
    }
}
