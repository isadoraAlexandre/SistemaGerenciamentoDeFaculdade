package usuarios;

import java.util.regex.Pattern;
import auxiliares.Data;
import exceptions.*;


public abstract class Usuario {

    protected String nome;
    protected String senha;
    protected String usuario;//usar cpf
    protected String cpf;
    protected Data dataNascimento;
    protected String dataStr; //gambiarra pra usar no banco
    protected String matricula; //formato 2024XXX
    protected String rua;//tbm gambiarra
    protected String bairro;
    protected String cidade;
    protected String numero;//termina aqui a gambiarra
    protected String email;
    protected String celular;
    protected int tipoUsuario; // 0 - aluno, 1 - professor, 2 - prof coord
    protected static int cont = 2024000;
    
    public Usuario(){
        geraMatricula();
    }
    
    private void geraMatricula() {
        cont++;
        
        String matricula;
        switch (this.tipoUsuario) {
            case 0:
                matricula = cont + "A"; //aluno
                break;
            case 1:
                matricula = cont + "P"; //professor
                break;
            case 2:
                matricula = cont + "C"; //coordenador
                break;
            default:
                throw new AssertionError();
        }
        
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeException{
        nome = nome.trim();
        
        if(!isValidNome(nome))
            throw new NomeException();
        
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

    public void setCpf(String cpf) throws CpfException{
        cpf = cpf.trim();
        
        if (isValidCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new CpfException();
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

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException{
        email = email.trim();
        
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new EmailException();
        }
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) throws CelularException{
        celular = celular.trim();
        
        if (isValidCelular(celular)) {
            this.celular = celular;
        } else {
            throw new CelularException();
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

    public void setRua(String rua) throws RuaException{
        rua = rua.trim();
        
        if(!isValidNome(rua))
            throw new RuaException();
        
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws BairroException{
        bairro = bairro.trim();
        
        if(!isValidNomeGererico(bairro))
            throw new BairroException();
        
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws CidadeException{
        cidade = cidade.trim();
        
        if(!isValidNomeGererico(cidade))
            throw new CidadeException();
        
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws NumeroException{
        numero = numero.trim();
        
        if(!isValidNumero(numero))
            throw new NumeroException();
        
        this.numero = numero;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) throws DataException{
        dataStr = dataStr.replaceAll("\s", "");
        
        if(!isValidDataNascimento(dataStr))
            throw new DataException();
        
        String[] s = dataStr.split("\\/");
        int dd = Integer.parseInt(s[0]);
        int mm = Integer.parseInt(s[1]);
        int aa = Integer.parseInt(s[2]);
        
        if(aa >= 1900 && aa <= 2010){
            if(mm > 0 && mm <= 12){
                if(dd >= 0 && dd <= 31){  
                    switch (mm) {
                        case 4, 6, 9, 11:
                            if(dd == 31)
                                throw new DataException();
                            break;
                        case 2:
                            if(dd > 29 || (dd == 29 && aa % 4 != 0))
                                throw new DataException();
                            break;
                        case 1, 3, 5, 7, 8, 10, 12:
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else
                    throw new DataException();
            } else
                throw new DataException();
        } else
            throw new DataException();
        
        Data data =  new Data(dd, mm, aa);
        
        this.dataNascimento = data;
        this.dataStr = dataStr;
    }
    
    private boolean isValidNome(String nome){
        String nomePattern = "^[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$";
        Pattern compPattern = Pattern.compile(nomePattern);
        return (nome != null && compPattern.matcher(nome).matches());
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
    
    private boolean isValidDataNascimento(String data){
        String dataPattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        Pattern compPattern = Pattern.compile(dataPattern);
        return (data != null && compPattern.matcher(data).matches());
    }
    
    private boolean isValidNomeGererico(String nome){
        String nomePattern = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s\\-\\.]+$";
        Pattern compPattern = Pattern.compile(nomePattern);
        return (nome != null && compPattern.matcher(nome).matches());
    }
    
    private boolean isValidNumero(String numero){
        String numPattern = "\\d{1,6}";
        Pattern compPattern = Pattern.compile(numPattern);
        return (numero != null && compPattern.matcher(numero).matches());
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + ", usuario=" + usuario + ", cpf=" + cpf + ", matricula=" + matricula + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", numero=" + numero + ", email=" + email + ", celular=" + celular + ", tipoUsuario=" + tipoUsuario + '}';
    }

}