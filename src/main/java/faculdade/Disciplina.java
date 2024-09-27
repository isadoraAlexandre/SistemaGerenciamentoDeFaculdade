package faculdade;

import java.util.*;
import exceptions.*;
import java.util.regex.Pattern;
import usuarios.Aluno;

public class Disciplina{

    protected String codigo;
    protected String nome;
    protected String horarioAula;
    protected String professor;
    protected int qtdVagas;
    protected int cargaHoraria;
    protected String coordenador;
    
    protected List<Aluno> alunos;
    protected int qtdFaltas;
    protected List<Double> notas;

    public Disciplina() {
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public Disciplina(String codigo, String nome, String horarioAula, String professor, int qtdVagas, String coordenador, int cargaHoraria) {
        this.nome = nome;
        this.qtdVagas = qtdVagas;
        this.codigo = codigo;
        this.horarioAula = horarioAula;
        this.professor = professor;
        this.coordenador = coordenador;
        this.cargaHoraria = cargaHoraria;
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

    public void setNome(String nome) throws NomeException{
        nome = nome.trim();
        if(!isValidNome(nome))
            throw new NomeException();
        this.nome = nome;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) throws VagasException{
        if(qtdVagas <= 0)
            throw new VagasException();
        this.qtdVagas = qtdVagas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws CodigoException{
        codigo = codigo.trim();
        
        if(!isValidCodigo(codigo))
            throw new CodigoException();
        
        
        this.codigo = codigo;
    }

    public String getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(String horarioAula) throws HoraException{
        horarioAula = horarioAula.replaceAll("\\s", "");
        
        //if(!isValidHorario(horarioAula))
        //    throw new HoraException();
        
        //String[] s = horarioAula.split(",");
        
        
        this.horarioAula = horarioAula;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) throws NomeException{
        professor = professor.trim();
        
        if(!isValidNome(professor))
            throw new NomeException();
        
        this.professor = professor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) throws NomeException{
        coordenador = coordenador.trim();
        
        if(!isValidNome(coordenador))
            throw new NomeException();
        
        this.coordenador = coordenador;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) throws CargaHException{
        cargaHoraria = cargaHoraria.replaceAll("\\s", "");
        
        if(!isValidCargaH(cargaHoraria))
            throw new CargaHException();
                
        int c = Integer.parseInt(cargaHoraria);
        
        if(c <= 0 || c >= 200)
            throw new CargaHException();
        
        this.cargaHoraria = c;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
    
    private boolean isValidCodigo(String cod){
        String codPattern = "^[A-Z]{3}\\d{3}$";
        Pattern compPattern = Pattern.compile(codPattern);
        return (cod != null && compPattern.matcher(cod).matches());
    }
    
    private boolean isValidNome(String nome){
        String nomePattern = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\s-]{3,100}$";
        Pattern compPattern = Pattern.compile(nomePattern);
        return (nome != null && compPattern.matcher(nome).matches());
    }
    
    /*private boolean isValidHorario(String horario){
        String horarioPattern = "\\[a-z]{3}\\,\\d{1,2}\\:\\d{1,2}";
        Pattern compPattern = Pattern.compile(horarioPattern);
        return (horario != null && compPattern.matcher(horario).matches());
    }*/
    
    private boolean isValidCargaH(String cargaHoraria){
        String horarioPattern = "\\d{2,3}";
        Pattern compPattern = Pattern.compile(horarioPattern);
        return (cargaHoraria != null && compPattern.matcher(cargaHoraria).matches());
    }
}
