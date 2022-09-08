package projetoATIVIDADE.persist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author: Natã Ferreira
 * @since: 07/09/2022
 * @version: 1.0
 * @description: Classe responsavel por abrir a conexão com o banco de dados
 * */

public class DAO {
    public DAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.err.println("Class not found. Error: " + cnfe.getMessage());
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/db01", "root", "");
    }
}