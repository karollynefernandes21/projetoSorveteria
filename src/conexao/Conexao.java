
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection connectDB() {
        
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/sorveteria_ice_vanilla";
            String user = "root";
            String password = "Klf1234@";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + erro.getMessage());
        }
        return conn;
    }

}
