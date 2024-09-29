package usuarios;

public class ProfessorCoordenador extends Funcionarios{

    private String nome;

    

    public ProfessorCoordenador() {
        this.tipoUsuario = 2;
    }

    


    public ProfessorCoordenador(String nome) {

        this.nome = nome;

    }



    public String getNome() {

        return nome;

    }



    public void setNome(String nome) {

        this.nome = nome;

    }


}
