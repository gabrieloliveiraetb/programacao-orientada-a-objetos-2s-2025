package AT3;

import java.sql.*;

public class BibliotecaManager {
    private Connection connection;
    
    public BibliotecaManager() {
        conectarBanco();
        criarTabelas();
    }
    
    private void conectarBanco() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
            System.out.println("Conectado ao banco de dados!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
    
    private void criarTabelas() {
        String sqlLivros = "CREATE TABLE IF NOT EXISTS livros (" +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          "titulo TEXT NOT NULL, " +
                          "autor TEXT NOT NULL, " +
                          "ano INTEGER, " +
                          "disponivel BOOLEAN)";
        
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "nome TEXT NOT NULL, " +
                            "email TEXT NOT NULL, " +
                            "telefone TEXT, " +
                            "endereco TEXT)";
        
        String sqlEmprestimos = "CREATE TABLE IF NOT EXISTS emprestimos (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "livro_id INTEGER, " +
                               "usuario_id INTEGER, " +
                               "data_emprestimo DATE, " +
                               "data_devolucao DATE, " +
                               "FOREIGN KEY(livro_id) REFERENCES livros(id), " +
                               "FOREIGN KEY(usuario_id) REFERENCES usuarios(id))";
        
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlLivros);
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlEmprestimos);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
    
    public void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros(titulo, autor, ano, disponivel) VALUES(?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setBoolean(4, livro.isDisponivel());
            pstmt.executeUpdate();
            System.out.println("Livro cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nome, email, telefone, endereco) VALUES(?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setString(4, usuario.getEndereco());
            pstmt.executeUpdate();
            System.out.println("Usuario cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuario: " + e.getMessage());
        }
    }
    
    public void consultarLivros() {
        String sql = "SELECT * FROM livros";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== LIVROS CADASTRADOS ===");
            while (rs.next()) {
                Livro livro = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano"),
                    rs.getBoolean("disponivel")
                );
                livro.exibirInformacoes();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar livros: " + e.getMessage());
        }
    }
    
    public void consultarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== USUARIOS CADASTRADOS ===");
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
                usuario.exibirInformacoes();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuarios: " + e.getMessage());
        }
    }
    
    public void realizarEmprestimo(int livroId, int usuarioId) {
        try {
            String checkSql = "SELECT disponivel FROM livros WHERE id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setInt(1, livroId);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getBoolean("disponivel")) {
                String updateLivro = "UPDATE livros SET disponivel = false WHERE id = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateLivro);
                updateStmt.setInt(1, livroId);
                updateStmt.executeUpdate();
                
                String insertEmp = "INSERT INTO emprestimos(livro_id, usuario_id, data_emprestimo) VALUES(?, ?, datetime('now'))";
                PreparedStatement empStmt = connection.prepareStatement(insertEmp);
                empStmt.setInt(1, livroId);
                empStmt.setInt(2, usuarioId);
                empStmt.executeUpdate();
                
                System.out.println("Emprestimo realizado com sucesso!");
            } else {
                System.out.println("Livro nao disponivel para emprestimo!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar emprestimo: " + e.getMessage());
        }
    }
    
    public void consultarEmprestimos() {
        String sql = "SELECT e.id, l.titulo, u.nome, e.data_emprestimo " +
                    "FROM emprestimos e " +
                    "JOIN livros l ON e.livro_id = l.id " +
                    "JOIN usuarios u ON e.usuario_id = u.id";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== EMPRESTIMOS ATIVOS ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                 " | Livro: " + rs.getString("titulo") +
                                 " | Usuario: " + rs.getString("nome") +
                                 " | Data: " + rs.getString("data_emprestimo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar emprestimos: " + e.getMessage());
        }
    }
}