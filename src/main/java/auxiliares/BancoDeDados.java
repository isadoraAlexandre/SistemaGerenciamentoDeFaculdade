package auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
    private Connection conexao;

    public void conectar() throws SQLException {
        try {
            conexao = DriverManager.getConnection("jdbc:sqlite:banco.db");
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            throw e;
        }
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão.");
                throw e;
            }
        }
    }

    public void criarTabelaUsuarios() throws SQLException {
        String sql = """
        CREATE TABLE IF NOT EXISTS usuarios (
            matricula INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            usuario TEXT UNIQUE NOT NULL, 
            senha TEXT NOT NULL,
            tipoUsuario INTEGER NOT NULL,
            cpf TEXT NOT NULL,
            dataNascimento TEXT NOT NULL,
            dataStr TEXT NOT NULL,
            rua TEXT NOT NULL,
            bairro TEXT NOT NULL,
            cidade TEXT NOT NULL,
            numero TEXT NOT NULL,
            email TEXT NOT NULL,
            celular TEXT NOT NULL
        );
    """;
        executarAtualizacao(sql);
    }

    public void inserirUsuario(String nome, String usuario, String senha, int tipoUsuario, String cpf, String dataNascimento, String dataStr, String rua, String bairro, String cidade, String numero, String email, String celular) throws SQLException {
        String sql = """
            INSERT INTO usuarios 
            (nome, usuario, senha, tipoUsuario, cpf, dataNascimento, dataStr, rua, bairro, cidade, numero, email, celular) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
        """;
        
        executarAtualizacaoParametrizada(sql, nome, usuario, senha, tipoUsuario, cpf, dataNascimento, dataStr, rua, bairro, cidade, numero, email, celular);
    }
    

    public int autenticarUsuario(String usuario, String senha) throws SQLException {
        String sql = "SELECT tipoUsuario FROM usuarios WHERE usuario = ? AND senha = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("tipoUsuario"); 
            } else {
                return -1; 
            }
        }
    }


    public void executarAtualizacaoParametrizada(String query, Object... params) throws SQLException {
        try (PreparedStatement pstmt = conexao.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            System.out.println("Atualização executada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao executar atualização.");
            throw e;
        }
    }

    public void executarAtualizacao(String query) throws SQLException {
        try (Statement stmt = conexao.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw e;
        }
    }
}
