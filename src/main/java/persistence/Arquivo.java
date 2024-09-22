package persistence;

import java.io.*;

public class Arquivo {
    
    //le o conteudo do arquivo 
    public static String leitura(File path) {
        
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return content.toString();
    }
    
    //escreve conteudo de STRING no arquivo, se chamado apaga o conteudo do arquvivo e escreve o novo conteudo
    public static void escreve(File path, String content) {
        
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(path, false));
             PrintWriter escritor = new PrintWriter(buffer);) {
            
            escritor.append(content);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
