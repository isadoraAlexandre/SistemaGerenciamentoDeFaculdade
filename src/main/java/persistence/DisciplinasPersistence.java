package persistence;

import faculdade.Disciplina;
import exceptions.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DisciplinasPersistence{
    //caminho inteiro onde o arquivo vai ser criado ou acessado
    private static final File PATH = new File(System.getProperty("user.dir") + "/src/main/java/banco_arquivo/DisciplinasgGeral.csv");
    
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
    public static Map<String, Disciplina> findAll(){
        
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

                        Disciplina disciplina = new Disciplina(codigo, nome, horario, professor, parser2(vagas), coordenador, parser2(cargaH));
                        

                        map.put(disciplina.getCodigo(), disciplina);
                    }
                }
            } else{
                //JOptionPane.showMessageDialog(null,"ainda nao ha registros");
            }
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
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
    public static boolean insereDisciplina(Disciplina nova){
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
                return true;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
    //recebe chave d adiciplina a ser removida
    public static boolean removeDisciplina(String codigo) throws CodigoException, HoraException, NomeException, CargaHException{
        Map<String, Disciplina> map = findAll();
        
        try{    
            if(map.remove(codigo) == null){
                //System.out.println("nao ha disciplina");
                return false;
            }
            save(map);
            return true;
        } catch (UnsupportedOperationException e){
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
    //rcebe disciplina ja modificada e muda no arquivo
    public static boolean modificaDisciplina(Disciplina modificada) throws CodigoException, NomeException, HoraException, CargaHException{
        //Map<String, Disciplina> map = findAll();
        
        /*if (modificada == null || modificada.getCodigo() == null || modificada.getCodigo().isEmpty())
            throw new IllegalArgumentException("Código da disciplina não pode ser nulo ou vazio.");

        try{
            if (!map.containsKey(modificada.getCodigo())){
                throw new NullPointerException("Disciplina não encontrada no sistema.");
            }
            
            map.put(modificada.getCodigo(), modificada);
            save(map);
            return map;
            
        } catch (UnsupportedOperationException e){
            System.out.println("nao eh possivel modificar");
        }catch(NullPointerException e){
            System.out.println("chave ou disciplina nulos");
        }catch(IllegalArgumentException e){
            System.out.println("nao foi posivel modificar");
        }catch(ClassCastException e){
            System.out.println("tipo do novo valor nao pode ser armazenado");
        }*/
        
        Map<String, Disciplina> map = findAll();
        
        try{
           map.replace(modificada.getCodigo(), modificada);
           save(map);
           return true;
        } catch (UnsupportedOperationException e){
            System.out.println("nao eh possivel modificar");
        }catch(NullPointerException e){
            System.out.println("chave ou disciplina nulos");
        }catch(IllegalArgumentException e){
            System.out.println("nao foi posivel mod446456ificar");
        }catch(ClassCastException e){
            System.out.println("tipo do novo valor nao pode ser armazenado");
        }
        
        return false;
    }
}
