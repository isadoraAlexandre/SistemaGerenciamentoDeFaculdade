package persistence;

import exceptions.*;
import faculdade.Disciplina;
import java.io.*;
import java.util.*;

public class DisciplinasPersistence{
    //caminho inteiro onde o arquivo vai ser criado ou acessado
    private static final File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/Disciplinas.csv");
    
    //salva no arquivo um map de disciplinas, se o aruivo nao existir cria um novo
    public static void save(Map<String, Disciplina> itens) {
        
        File diretorio = PATH.getParentFile();
        if(!diretorio.exists())
            diretorio.mkdirs();
        
        StringBuilder csvBuilder = new StringBuilder();
        
        for (Disciplina disciplina : itens.values()) {
            csvBuilder.append(disciplina.getCodigo())
                    .append(",")
                    .append(disciplina.getNome())
                    .append(",")
                    .append(disciplina.getProfessor())
                    .append(",")
                    .append(disciplina.getCoordenador())
                    .append(",")
                    .append(disciplina.getHorarioAula())
                    .append(",")
                    .append(disciplina.getCargaHoraria())
                    .append(",")
                    .append(disciplina.getQtdVagas())
                    .append(System.lineSeparator());
        }
        Arquivo.escreve(PATH, csvBuilder.toString());
    }
    
    //retorna lista com todos as disciplinas no arquivo
    public static Map<String, Disciplina> findAll() throws HoraException, NomeException {
        
        Map<String, Disciplina> map = new HashMap<>();
    
        String csv = Arquivo.leitura(PATH);
        
        try{
            if(!csv.trim().equals("")){
                String[] linhas = csv.split("\n");

                for(String linha : linhas){
                    String[] campos = linha.split("\\,");

                    if(campos.length >= 7){
                        String codigo = campos[0].trim();
                        String nome = campos[1].trim();
                        String professor = campos[2].trim();
                        String coordenador = campos[3].trim();
                        String horario = campos[4].trim();
                        String cargaH = campos[5].trim();
                        String vagas = campos[6].trim();

                        Disciplina disciplina = new Disciplina();
                        disciplina.setCodigo(codigo);
                        disciplina.setNome(nome);
                        disciplina.setProfessor(professor);
                        disciplina.setHorarioAula(horario);
                        disciplina.setCargaHoraria(parser(cargaH));
                        disciplina.setCoordenador(coordenador);
                        disciplina.setQtdVagas(parser2(vagas));

                        map.put(disciplina.getCodigo(), disciplina);
                    }
                }
            } else{
                System.out.println("ainda nao ha registros");
            }
        } catch(NullPointerException e){
            System.out.println("Erro: " + e.getMessage());
        } catch (CodigoException | HoraException | NomeException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro findAll: " + e.getMessage());
        }
        
        return map;
    }
    
    //talvez criar uma classe de parsers? pq vai usar quase em tudo
    public static float parser(String input){
        return Float.parseFloat(input);
    }
    public static int parser2(String input){
        return Integer.parseInt(input);
    }
    
    //todas insercoes/modificaoes/remocoes no seguem essa estrutura, so mudar o nome do objeto
    //insere uma disciplina
    public static void insereDisciplina(Disciplina nova){
        try {
            
            File diretorio = PATH.getParentFile();
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            if (!PATH.exists()) {
                PATH.createNewFile();
            }    
            try (BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH, true))){
                String novaLinha = nova.getCodigo() + "," + nova.getNome()+ "," + nova.getProfessor()+ "," + nova.getCoordenador() + "," 
                        + nova.getHorarioAula() + "," + nova.getCargaHoraria() + "," + nova.getQtdVagas();
                buffer.write(novaLinha);
                buffer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    //recebe chave d adiciplina a ser removida
    public static void removeDisciplina(String codigo) throws HoraException, NomeException{
        Map<String, Disciplina> map = findAll();
        
        try{    
            if(map.remove(codigo) == null){
                System.out.println("nao ha disciplina");
                return;
            }
        } catch (UnsupportedOperationException e){
            System.out.println("nao eh possivel remover");
        }
        
        save(map);
    }
    
    //rcebe disciplina ja modificada e muda no arquivo
    public static void modificaDisciplina(Disciplina modificada) throws HoraException, NomeException{
        Map<String, Disciplina> map = findAll();
        
        try{
           map.replace(modificada.getCodigo(), modificada); 
        } catch (UnsupportedOperationException e){
            System.out.println("nao eh possivel modificar");
        }catch(NullPointerException e){
            System.out.println("chave ou disciplina nulos");
        }catch(IllegalArgumentException e){
            System.out.println("nao foi posivel modificar");
        }catch(ClassCastException e){
            System.out.println("tipo do novo valor nao pode ser armazenado");
        }
        
        save(map);
    }
}
