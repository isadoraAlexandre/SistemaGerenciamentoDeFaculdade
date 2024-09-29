package persistence;

import exceptions.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import usuarios.Usuario;

public class UsuarioPersistence{
    private static final File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Usuarios.csv");
    
    public static void save(Map<String, Usuario> itens) {

        File diretorio = PATH.getParentFile();
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        StringBuilder csvBuilder = new StringBuilder();
        
        for(Usuario user : itens.values()){
            csvBuilder.append(user.getCpf())
                    .append(",")
                    .append(user.getTipoUsuario())
                    .append(",")
                    .append(user.getNome())
                    .append(",")
                    .append(user.getDataStr())
                    .append(",")
                    .append(user.getEmail())
                    .append(",")
                    .append(user.getCelular())
                    .append(",")
                    .append(user.getRua())
                    .append(",")
                    .append(user.getBairro())
                    .append(",")
                    .append(user.getCidade())
                    .append(",")
                    .append(user.getNumero())
                    .append(",")
                    .append(user.getUsuario())
                    .append(",")
                    .append(user.getSenha())
                    .append(",")
                    .append(user.getMatricula());
        }

        Arquivo.escreve(PATH, csvBuilder.toString());
    }

    public static Map<String, Usuario> findAll() throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException , CidadeException, NumeroException{
        
        Map<String, Usuario> users = new HashMap<>();
    
        String csv = Arquivo.leitura(PATH);
        
        try{
            if (!csv.trim().equals("")) {
                String[] linhas = csv.split("\n");

                for (String linha : linhas) {
                    String[] campos = linha.split("\\,");

                    if (campos.length >= 13) {
                        String cpf = campos[0].trim();
                        String type = campos[1].trim();
                        String nome = campos[2].trim();
                        String data = campos[3].trim();
                        String email = campos[4].trim();
                        String celular = campos[5].trim();
                        String rua = campos[6].trim();
                        String bairro = campos[7].trim();
                        String cidade = campos[8].trim();
                        String numero = campos[9].trim();
                        String user = campos[10].trim();
                        String senha = campos[11].trim();
                        String matricula = campos[12].trim();

                        Usuario Usuario = new Usuario();
                        
                        Usuario.setCpf(cpf);
                        Usuario.setTipoUsuario(Integer.parseInt(type));//arrumar, joga excessao
                        Usuario.setNome(nome);
                        Usuario.setDataStr(data);
                        Usuario.setEmail(email);
                        Usuario.setCelular(celular);
                        Usuario.setRua(rua);
                        Usuario.setBairro(bairro);
                        Usuario.setCidade(cidade);
                        Usuario.setNumero(numero);
                        Usuario.setUsuario(user);
                        Usuario.setSenha(senha);
                        Usuario.setMatricula(matricula);

                        users.put(user, Usuario);
                    }
                }
            } else{
                javax.swing.JOptionPane.showMessageDialog(null, "nao ha usuarios");
            }
        } catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro findAll: " + e.getMessage());
        } catch(DataException | NomeException | EmailException | CpfException | CelularException | RuaException | BairroException | CidadeException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro findAll: " + e.getMessage());
        }

        return users;
    }
    
    //insere um user
    public static boolean insereUsuario(Usuario nova){
        try {
            
            File diretorio = PATH.getParentFile();
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            if (!PATH.exists()) {
                PATH.createNewFile();
            }    
            try (BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH, true))){
                
                String novaLinha = nova.getCpf() + "," + nova.getUsuario() + "," + nova.getNome()+ "," + nova.getDataStr()+ "," + nova.getEmail()+ 
                        "," + nova.getCelular() + "," + nova.getRua()+ "," + nova.getBairro() + "," + nova.getCidade() + "," + nova.getNumero() + 
                        "," + nova.getSenha() + "," + nova.getMatricula() + "," + nova.getUsuario();
                
                buffer.write(novaLinha);
                buffer.newLine();
                return true;
            }
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return false;
    }
    
    //recebe chave do user a ser removida
    public static boolean removeUsuario(String user) throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException, CidadeException, NumeroException{
        
        Map<String, Usuario> map = findAll();
        
        try{    
            if(map.remove(user) == null){
                javax.swing.JOptionPane.showMessageDialog(null, "Usuario nao listado");
            }
            return true;
        } catch (UnsupportedOperationException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Usuario nao existe");
        }
        
        save(map);
        return false;
    }
    
    //rcebe disciplina ja modificada e muda no arquivo
    public static boolean modificaUsuario(Usuario modificada)throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException, CidadeException, NumeroException{
        
        Map<String, Usuario> map = findAll();
        
        try{
           
           map.replace(modificada.getUsuario(), modificada);
           return true;
        } catch (UnsupportedOperationException e){
            javax.swing.JOptionPane.showMessageDialog(null, "nao eh possivel modificar");
        }catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "chave ou Usuario nulos");
        }catch(IllegalArgumentException e){
            javax.swing.JOptionPane.showMessageDialog(null, "nao foi posivel modificar");
        }catch(ClassCastException e){
            javax.swing.JOptionPane.showMessageDialog(null, "tipo do novo valor nao pode ser armazenado");
        }
        
        save(map);
        return false;
    }
}
package persistence;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import usuarios.Usuario;

public class UsuarioPersistence {
    private static final File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Usuarios.csv");

    public static void save(Map<String, Usuario> usuarios) {
        File diretorio = PATH.getParentFile();
        if (!diretorio.exists())
            diretorio.mkdirs();

        StringBuilder csvBuilder = new StringBuilder();

        for (Usuario usuario : usuarios.values()) {
            csvBuilder.append(usuario.getMatricula())
                      .append(",")
                      .append(usuario.getNome())
                      .append(",")
                      .append(usuario.getUsuario())
                      .append(",")
                      .append(usuario.getSenha())
                      .append(",")
                      .append(usuario.getTipoUsuario())
                      .append(",")
                      .append(usuario.getCpf())
                      .append(",")
                      .append(usuario.getDataNascimento())
                      .append(",")
                      .append(usuario.getRua())
                      .append(",")
                      .append(usuario.getBairro())
                      .append(",")
                      .append(usuario.getCidade())
                      .append(",")
                      .append(usuario.getNumero())
                      .append(",")
                      .append(usuario.getEmail())
                      .append(",")
                      .append(usuario.getCelular())
                      .append(System.lineSeparator());
        }

        Arquivo.escreve(PATH, csvBuilder.toString());
    }

    public static Map<String, Usuario> findAll() {
        Map<String, Usuario> map = new HashMap<>();

        String csv = Arquivo.leitura(PATH);

        try {
            if (!csv.trim().equals("")) {
                String[] linhas = csv.split("\n");

                for (String linha : linhas) {
                    String[] campos = linha.split("\\,");

                    if (campos.length >= 13) {
                        int matricula = Integer.parseInt(campos[0].trim());
                        String nome = campos[1].trim();
                        String usuario = campos[2].trim();
                        String senha = campos[3].trim();
                        int tipoUsuario = Integer.parseInt(campos[4].trim());
                        String cpf = campos[5].trim();
                        String dataNascimento = campos[6].trim();
                        String rua = campos[7].trim();
                        String bairro = campos[8].trim();
                        String cidade = campos[9].trim();
                        String numero = campos[10].trim();
                        String email = campos[11].trim();
                        String celular = campos[12].trim();

                        Usuario user = new Usuario(matricula, nome, usuario, senha, tipoUsuario, cpf, dataNascimento, rua, bairro, cidade, numero, email, celular);
                        map.put(usuario, user);
                    }
                }
            } else {
                System.out.println("Ainda não há registros.");
            }
        } catch (NullPointerException en) {
            System.out.println("Erro: " + en.getMessage());
        }

        return map;
    }

    public static void insereUsuario(Usuario novoUsuario) {
        Map<String, Usuario> usuarios = findAll();
        usuarios.put(novoUsuario.getUsuario(), novoUsuario);
        save(usuarios);
    }

    public static void removeUsuario(String usuario) {
        Map<String, Usuario> usuarios = findAll();

        if (usuarios.remove(usuario) == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            save(usuarios);
        }
    }

    public static void modificaUsuario(Usuario usuarioModificado) {
        Map<String, Usuario> usuarios = findAll();

        if (usuarios.replace(usuarioModificado.getUsuario(), usuarioModificado) == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            save(usuarios);
        }
    }

    public static Usuario autenticarUsuario(String usuario, String senha) {
        Map<String, Usuario> usuarios = findAll();

        Usuario user = usuarios.get(usuario);

        if (user != null && user.getSenha().equals(senha)) {
            return user;
        } else {
            System.out.println("Usuário ou senha inválidos.");
            return null;
        }
    }

    public static void criarUsuarioExemplo() {
        Usuario exemplo = new Usuario(
            1, 
            "João da Silva",
            "joao.silva",
            "senha123", 
            1, 
            "123.456.789-00", 
            "01/01/1980",
            "Rua Exemplo", 
            "Bairro Exemplo",
            "Cidade Exemplo",
            "123", 
            "joao.silva@example.com",
            "(11) 91234-5678" 
        );

        insereUsuario(exemplo);
        System.out.println("Usuário de exemplo criado com sucesso.");
    }
}
