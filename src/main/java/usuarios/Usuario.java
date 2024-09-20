package usuarios;

import java.util.regex.Pattern;

import auxiliares.DadosBancarios;
import auxiliares.Data;
import auxiliares.Endereco;

public class Usuario {
    protected String nome;
    protected String senha;
    protected String usuario;
    protected String cpf;
    protected String rg;
    protected Data dataNascimento;
    protected String etnia;
    protected String estadoCivil;
    protected String matricula; //gerar random
    protected Endereco endereco;
    protected String email;
    protected String celular;
    protected String genero;
    protected String departamento; 
    protected boolean portadorDeficiencia;
    protected Data dataIngresso;
    protected int tipoUsuario; // 0 - aluno, 1 - professor, 2 - prof coord
    protected DadosBancarios dadosBancarios;
    //protected List<Disciplina> disciplinas;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

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
        if (isValidCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if (isValidCelular(celular)) {
            this.celular = celular;
        } else {
            throw new IllegalArgumentException("Celular inválido");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isPortadorDeficiencia() {
        return portadorDeficiencia;
    }

    public void setPortadorDeficiencia(boolean portadorDeficiencia) {
        this.portadorDeficiencia = portadorDeficiencia;
    }

    public Data getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Data dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    private boolean isValidCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    private boolean isValidCelular(String celular) {
        return celular != null && celular.matches("\\d{10,11}");
    }
}