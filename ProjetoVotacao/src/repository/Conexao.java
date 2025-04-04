package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private Connection con;
    public Conexao() throws Exception{
        // copiar do outro projeto
        //mysql ou sqlserver
        //adicionar o driver na pasta lib
        String url = "jdbc:sqlserver://LAB01-MAQ18:1433;encrypt=false;trustServerCertificate=true;"
                    + "databaseName=Votacao;"
                    + "user=Aluno;"
                    + "password=dba;";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String usuario="Aluno";//do banco
        String senha="dba";
        Class.forName(driver);
        con = DriverManager.getConnection(url, usuario, senha);
   
    }
    public Connection getConexao(){
        return con;
    }
}
