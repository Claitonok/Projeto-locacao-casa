package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
   public Conexao() {
   }

   public static Connection obterConexao() {
      Connection conn = null;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost/db_database?useSSL=false", "root", "");
      } catch (ClassNotFoundException | SQLException var2) {
         System.err.println("NÃO FOI POSSIVEL CONECTAR AO BANCO DE DADOS");
         var2.printStackTrace();
      }

      return conn;
   }
}
