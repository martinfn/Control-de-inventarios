
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jarco
 */
public class conectar {
     Connection conect = null;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/rpci_ai", "root", "");
            System.out.println("Conexión establecida.");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexión.");
            JOptionPane.showMessageDialog(null, "Error de conexión." +e);
        }
        return conect;
    }
    
    PreparedStatement preparedStatement(String sql){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}