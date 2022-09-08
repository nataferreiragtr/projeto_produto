package projetoATIVIDADE.persist;

import projetoATIVIDADE.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO {
    private Connection conn;

    public boolean save(Produto produto) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into produto(nome, marca, codigo, tipo) values (?, ?, ?, ?)");

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setInt(3, produto.getCodigo());
            pstmt.setString(4, produto.getTipo());

            var response = pstmt.executeUpdate();

            if(response != 0)
                return Boolean.TRUE;
            return Boolean.FALSE;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on save produto. Error: " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public List<Produto> findAll() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from produto");
            rs = pstmt.executeQuery();

            var produtos = new ArrayList<Produto>();
            while(rs.next()) {
                var produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setTipo(rs.getString("tipo"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list produtos. Error: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Produto findById(long id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from produto where id = ?");
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            Produto produto = new Produto();
            if(rs.next()){
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setTipo(rs.getString("tipo"));
            }
            return produto;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id produto. Error: " + e.getMessage());
            return new Produto();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public List<Produto> findByName(String nome) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from produto where nome like ?");
            pstmt.setString(1, '%' + nome + '%');
            rs = pstmt.executeQuery();

            var produtos = new ArrayList<Produto>();
            while(rs.next()) {
                var produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setTipo(rs.getString("tipo"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list produtos. Error: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Produto findByCodigo(int codigo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from produto where codigo = ?");
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();

            Produto produto = new Produto();
            if(rs.next()){
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setTipo(rs.getString("tipo"));
            }
            return produto;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id produto. Error: " + e.getMessage());
            return new Produto();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public Produto findByMarca(String marca) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from produto where marca = ?");
            pstmt.setString(1, marca);
            rs = pstmt.executeQuery();

            Produto produto = new Produto();
            if(rs.next()){
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setTipo(rs.getString("tipo"));
            }
            return produto;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id produto. Error: " + e.getMessage());
            return new Produto();
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    //public boolean update(Produto produto) {}

    public boolean deleteById(long id) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("delete from produto where id = ?");
            pstmt.setLong(1, id);

            var response = pstmt.executeUpdate();

            if(response != 0)
                return Boolean.TRUE;
            return Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on delete produto. Error: " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }

    }

    //public boolean deleteAll() {}
}
