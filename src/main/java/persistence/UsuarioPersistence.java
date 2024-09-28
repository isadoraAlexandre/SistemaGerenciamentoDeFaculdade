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
