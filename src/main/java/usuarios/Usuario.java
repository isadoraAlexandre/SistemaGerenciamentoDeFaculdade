/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import auxiliares.Endereco;
import auxiliares.Data;
import java.util.*;



/**
 *
 * @author isinha
 */
public class Usuario {
    protected String nome;
    protected String senha;
    protected String usuario;  // Email no formato "email@ufjf.com"
    protected String cpf;
    protected Data dataNascimento;
    protected String matricula;
    protected Endereco endereco;
    protected String email;
    protected String telefone;
    protected String genero;
    protected String departamento;
    protected boolean portadorDeficiencia;
    protected Data dataIngresso;
    protected int tipoUsuario; // 0 - aluno, 1 - professor, 2 - prof coord
    //protected List<Disciplina> disciplinas;

    //Construtor, getters e setters
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    
    
    
    
}
