/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import exceptions.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import usuarios.Usuario;

/**
 *
 * @author isinha
 */
public class Separador {
    private static final File PATH_A = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Alunos.csv");
    private static final File PATH_P = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Professores.csv");
    private static final File PATH_C = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Coordenadores.csv");
    
    public static Map<String, Usuario> findAll(int typeUser) throws CpfException, NomeException, DataException, EmailException, 
            CelularException, RuaException, BairroException , CidadeException, NumeroException{
        
        Map<String, Usuario> users = new HashMap<>();
        String csv;
        
        if(typeUser == 0)
            csv = Arquivo.leitura(PATH_A);
        if(typeUser == 1)
            csv = Arquivo.leitura(PATH_P);
        if(typeUser == 2)
            csv = Arquivo.leitura(PATH_C);
        else
            return null;
        
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
                        Usuario.setTipoUsuario(Integer.parseInt(type));
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
}
