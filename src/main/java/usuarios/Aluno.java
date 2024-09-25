package usuarios;

import faculdade.Curso;
import java.util.Random;
import faculdade.Disciplina;
import java.util.ArrayList;
import java.util.List;
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
    }
    

    
    
    public String leitura(){
        Scanner teclado = new Scanner(System.in);
        String t = teclado.nextLine();
        
        return t;
    }

    public void modificaNome(){
        System.out.println("digite novo nome: ");
        String newName = leitura();
        setNome(newName);
    }
}
