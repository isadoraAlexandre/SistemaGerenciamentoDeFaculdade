package usuarios;

import java.util.regex.Pattern;
import auxiliares.Data;
import auxiliares.Endereco;


public abstract class Usuario {

    protected String nome;
    protected String senha;
    protected String usuario;//usar cpf
    protected String cpf;
    protected Data dataNascimento;
    protected String dataStr; //gambiarra pra usar no banco, fazer funcao parser string->Data e data->string
    protected String matricula; //gerar random
    protected Endereco endereco;
    protected String rua;//tbm gambiarra, fazer parser tbm
    protected String bairro;
    protected String cidade;
    protected String numero;//termina aqui a gambiarra
    protected String email;
    protected String celular;
    protected int tipoUsuario; // 0 - aluno, 1 - professor, 2 - prof coord

    public Usuario(){
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

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
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

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + ", usuario=" + usuario + ", cpf=" + cpf + ", matricula=" + matricula + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", numero=" + numero + ", email=" + email + ", celular=" + celular + ", tipoUsuario=" + tipoUsuario + '}';
    }

}