package persistence;

import exceptions.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import usuarios.Aluno;

public class AlunoPersistence{
    private static final File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Alunos.csv");
    
    public static void save(Map<String, Aluno> itens) {

        File diretorio = PATH.getParentFile();
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        StringBuilder csvBuilder = new StringBuilder();
        
        for(Aluno aluno : itens.values()){
            csvBuilder.append(aluno.getCpf())
                    .append(",")
                    .append(aluno.getNome())
                    .append(",")
                    .append(aluno.getDataStr())
                    .append(",")
                    .append(aluno.getEmail())
                    .append(",")
                    .append(aluno.getCelular())
                    .append(",")
                    .append(aluno.getRua())
                    .append(",")
                    .append(aluno.getBairro())
                    .append(",")
                    .append(aluno.getCidade())
                    .append(",")
                    .append(aluno.getNumero())
                    .append(",")
                    .append(aluno.getUsuario())
                    .append(",")
                    .append(aluno.getSenha())
                    .append(",")
                    .append(aluno.getMatricula());
        }

        Arquivo.escreve(PATH, csvBuilder.toString());
    }

    public static Map<String, Aluno> findAll() throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException , CidadeException, NumeroException{
        
        Map<String, Aluno> alunos = new HashMap<>();
    
        String csv = Arquivo.leitura(PATH);
        
        try{
            if (!csv.trim().equals("")) {
                String[] linhas = csv.split("\n");

                for (String linha : linhas) {
                    String[] campos = linha.split("\\,");

                    if (campos.length >= 9) {
                        String cpf = campos[0].trim();
                        String nome = campos[1].trim();
                        String data = campos[2].trim();
                        String email = campos[3].trim();
                        String celular = campos[4].trim();
                        String rua = campos[5].trim();
                        String bairro = campos[6].trim();
                        String cidade = campos[7].trim();
                        String numero = campos[8].trim();
                        String user = campos[9].trim();
                        String senha = campos[10].trim();
                        String matricula = campos[11].trim();

                        Aluno aluno = new Aluno(user);
                        
                        aluno.setCpf(cpf);
                        aluno.setNome(nome);
                        aluno.setDataStr(data);
                        aluno.setEmail(email);
                        aluno.setCelular(celular);
                        aluno.setRua(rua);
                        aluno.setBairro(bairro);
                        aluno.setCidade(cidade);
                        aluno.setNumero(numero);
                        aluno.setUsuario(user);
                        aluno.setSenha(senha);
                        aluno.setMatricula(matricula);

                        alunos.put(user, aluno);
                    }
                }
            } else{
                System.out.println("ainda nao ha registros");
            }
        } catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro findAll: " + e.getMessage());
        } catch(DataException | NomeException | EmailException | CpfException | CelularException | RuaException | BairroException | CidadeException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro findAll: " + e.getMessage());
        }

        return alunos;
    }
    
    //insere um aluno
    public static boolean insereAluno(Aluno nova){
        try {
            
            File diretorio = PATH.getParentFile();
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            if (!PATH.exists()) {
                PATH.createNewFile();
            }    
            try (BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH, true))){
                
                String novaLinha = nova.getCpf()+ "," + nova.getNome()+ "," + nova.getDataStr()+ "," + nova.getEmail()+ "," + nova.getCelular() + "," + nova.getRua()+ 
                        "," + nova.getBairro() + "," + nova.getCidade() + "," + nova.getNumero() + "," + nova.getSenha() + "," + nova.getMatricula() + "," + nova.getUsuario();
                
                buffer.write(novaLinha);
                buffer.newLine();
                return true;
            }
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return false;
    }
    
    //recebe chave do aluno a ser removida
    public static boolean removeAluno(String user) throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException, CidadeException, NumeroException{
        
        Map<String, Aluno> map = findAll();
        
        try{    
            if(map.remove(user) == null){
                javax.swing.JOptionPane.showMessageDialog(null, "aluno nao listado");
            }
            return true;
        } catch (UnsupportedOperationException e){
            javax.swing.JOptionPane.showMessageDialog(null, "aluno nao existe");
        }
        
        save(map);
        return false;
    }
    
    //rcebe disciplina ja modificada e muda no arquivo
    public static boolean modificaAluno(Aluno modificada)throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException, CidadeException, NumeroException{
        
        Map<String, Aluno> map = findAll();
        
        try{
           
           map.replace(modificada.getUsuario(), modificada);
           return true;
        } catch (UnsupportedOperationException e){
            javax.swing.JOptionPane.showMessageDialog(null, "nao eh possivel modificar");
        }catch(NullPointerException e){
            javax.swing.JOptionPane.showMessageDialog(null, "chave ou aluno nulos");
        }catch(IllegalArgumentException e){
            javax.swing.JOptionPane.showMessageDialog(null, "nao foi posivel modificar");
        }catch(ClassCastException e){
            javax.swing.JOptionPane.showMessageDialog(null, "tipo do novo valor nao pode ser armazenado");
        }
        
        save(map);
        return false;
    }
}
