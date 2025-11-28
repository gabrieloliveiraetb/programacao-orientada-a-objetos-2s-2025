import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (tipo, marca, modelo, ano, preco, portas, tipo_combustivel, cilindrada, partida) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                pstmt.setString(1, "Carro");
                pstmt.setString(2, carro.getMarca());
                pstmt.setString(3, carro.getModelo());
                pstmt.setInt(4, carro.getAno());
                pstmt.setDouble(5, carro.getPreco());
                pstmt.setInt(6, carro.getPortas());
                pstmt.setString(7, carro.getTipoCombustivel());
                pstmt.setNull(8, Types.INTEGER);
                pstmt.setNull(9, Types.VARCHAR);
            } else if (veiculo instanceof Moto) {
                Moto moto = (Moto) veiculo;
                pstmt.setString(1, "Moto");
                pstmt.setString(2, moto.getMarca());
                pstmt.setString(3, moto.getModelo());
                pstmt.setInt(4, moto.getAno());
                pstmt.setDouble(5, moto.getPreco());
                pstmt.setNull(6, Types.INTEGER);
                pstmt.setNull(7, Types.VARCHAR);
                pstmt.setInt(8, moto.getCilindrada());
                pstmt.setString(9, moto.getPartida());
            }
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veiculo: " + e.getMessage());
            return false;
        }
    }
    
    public List<Veiculo> consultarTodos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Veiculo veiculo;
                String tipo = rs.getString("tipo");
                
                if ("Carro".equals(tipo)) {
                    Carro carro = new Carro();
                    carro.setId(rs.getInt("id"));
                    carro.setMarca(rs.getString("marca"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setAno(rs.getInt("ano"));
                    carro.setPreco(rs.getDouble("preco"));
                    carro.setPortas(rs.getInt("portas"));
                    carro.setTipoCombustivel(rs.getString("tipo_combustivel"));
                    veiculo = carro;
                } else {
                    Moto moto = new Moto();
                    moto.setId(rs.getInt("id"));
                    moto.setMarca(rs.getString("marca"));
                    moto.setModelo(rs.getString("modelo"));
                    moto.setAno(rs.getInt("ano"));
                    moto.setPreco(rs.getDouble("preco"));
                    moto.setCilindrada(rs.getInt("cilindrada"));
                    moto.setPartida(rs.getString("partida"));
                    veiculo = moto;
                }
                
                veiculos.add(veiculo);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar veiculos: " + e.getMessage());
        }
        
        return veiculos;
    }
    
    public List<Veiculo> consultarPorMarca(String marca) {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos WHERE marca LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + marca + "%");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Veiculo veiculo;
                String tipo = rs.getString("tipo");
                
                if ("Carro".equals(tipo)) {
                    Carro carro = new Carro();
                    carro.setId(rs.getInt("id"));
                    carro.setMarca(rs.getString("marca"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setAno(rs.getInt("ano"));
                    carro.setPreco(rs.getDouble("preco"));
                    carro.setPortas(rs.getInt("portas"));
                    carro.setTipoCombustivel(rs.getString("tipo_combustivel"));
                    veiculo = carro;
                } else {
                    Moto moto = new Moto();
                    moto.setId(rs.getInt("id"));
                    moto.setMarca(rs.getString("marca"));
                    moto.setModelo(rs.getString("modelo"));
                    moto.setAno(rs.getInt("ano"));
                    moto.setPreco(rs.getDouble("preco"));
                    moto.setCilindrada(rs.getInt("cilindrada"));
                    moto.setPartida(rs.getString("partida"));
                    veiculo = moto;
                }
                
                veiculos.add(veiculo);
            }
            
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao consultar veiculos: " + e.getMessage());
        }
        
        return veiculos;
    }
}