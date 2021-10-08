package Model;
import java.sql.*;
public class ClasseConexao {
    //parâmetros para conexão
    private Connection conexao;
    private String banco =
        "jdbc:mysql:/http://localhost/phpmyadmin/db_structure.php?db=cadastro/";
    private String usuario = "root";
    private String senha = "";
    
    //criando a conexão
    public ClasseConexao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(banco, usuario, senha);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //criando um método para acessar a conexão
    public Connection getConexao(){
        return conexao;
    }
}
