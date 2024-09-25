package usuarios;

import faculdade.Curso;
import java.util.Random;
import java.util.Scanner;
import auxiliares.Data;
import auxiliares.Endereco;

public class Aluno extends Usuario {
    protected Curso curso;
    protected String etnia;
    protected String estadoCivil;
    protected String celular;
    protected boolean portadorDeficiencia;
    protected Data dataNascimento;
    protected Data dataIngresso;
    protected int tipoUsuario;
    protected String dadosBancarios;
    protected String historico;
    protected String horasComputadas;
    protected String semestreIngresso;
    protected String turnoCurso;


    public Aluno(String nome, String senha, String usuario, String cpf, String rg, Data dataNascimento, String etnia, String estadoCivil, Endereco endereco, String email, String celular, String genero, String departamento,boolean portadorDeficiencia, Data dataIngresso, Curso curso, String dadosBancarios, String historico, String horasComputadas, String semestreIngresso, String turnoCurso) {
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.etnia = etnia;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.email = email;
        this.celular = celular;
        this.genero = genero;
        this.departamento = departamento;
        this.portadorDeficiencia = portadorDeficiencia;
        this.dataIngresso = dataIngresso;
        this.curso = curso;
        this.tipoUsuario = 0;
        this.dadosBancarios = dadosBancarios;
        this.historico = historico;
        this.horasComputadas = horasComputadas;
        this.semestreIngresso = semestreIngresso;
        this.turnoCurso = turnoCurso;
        this.matricula = gerarMatricula();
    }

    
    private String gerarMatricula() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

   
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isPortadorDeficiencia() {
        return portadorDeficiencia;
    }

    public void setPortadorDeficiencia(boolean portadorDeficiencia) {
        this.portadorDeficiencia = portadorDeficiencia;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(String dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getHorasComputadas() {
        return horasComputadas;
    }

    public void setHorasComputadas(String horasComputadas) {
        this.horasComputadas = horasComputadas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getSemestreIngresso() {
        return semestreIngresso;
    }

    public void setSemestreIngresso(String semestreIngresso) {
        this.semestreIngresso = semestreIngresso;
    }

    public String getTurnoCurso() {
        return turnoCurso;
    }

    public void setTurnoCurso(String turnoCurso) {
        this.turnoCurso = turnoCurso;
    }
}
