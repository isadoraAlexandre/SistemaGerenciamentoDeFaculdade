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
