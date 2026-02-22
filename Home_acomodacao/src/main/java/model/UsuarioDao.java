package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

   public void cadastrar_Users(Usuarios usuario) {
      Connection conn = Conexao.obterConexao();
      String sql = "INSERT INTO api_db(nome, email, password, telefone) VALUES (?,?,?,?)";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, usuario.getNome());
         preparador.setString(2, usuario.getEmail());
         preparador.setString(3, usuario.getPassword());
         preparador.setString(4, usuario.getTelefone());
         preparador.execute();
         preparador.close();
         System.out.println("USUARIO CADASTRADO COM SUCCESS");
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void alterar_Users(Usuarios usuario) {
      Connection conn = Conexao.obterConexao();
      String sql = "UPDATE api_db SET nome=?, email=?, password=?, telefone=? WHERE id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, usuario.getNome());
         preparador.setString(2, usuario.getEmail());
         preparador.setString(3, usuario.getPassword());
         preparador.setString(4, usuario.getTelefone());
         preparador.setInt(5, usuario.getId());
         preparador.execute();
         preparador.close();
         System.out.println("USUARIO ALTERADO COM SUCCESS");
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void recuperarConta(Usuarios usuario) {
      Connection conn = Conexao.obterConexao();
      String sql = "UPDATE api_db SET email=?, password=? WHERE id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, usuario.getEmail());
         preparador.setString(2, usuario.getPassword());
         preparador.setInt(3, usuario.getId());
         preparador.execute();
         preparador.close();
         System.out.println("Conta Recuperada!!");
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void inserir_source(Usuarios usuario) {
      Connection conn = Conexao.obterConexao();
      String sql = "UPDATE api_db SET source=? WHERE id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, usuario.getSource());
         preparador.setInt(2, usuario.getId());
         preparador.execute();
         preparador.close();
         System.out.println("Source inserido!!");
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void excluirPorId(int id) {
      Connection conn = Conexao.obterConexao();
      String sql = "DELETE FROM api_db WHERE id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setInt(1, id);
         preparador.execute();
         preparador.close();
         System.out.println("USUARIO EXCLUIDOS COM SUCCESS");
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public Usuarios autentica(String email, String senha) {
      Connection conn = Conexao.obterConexao();
      Usuarios usuario = null;
      String sql = "SELECT * FROM api_db WHERE email=? and password=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, email);
         preparador.setString(2, senha);
         ResultSet resultado = preparador.executeQuery();
         if (resultado.next()) {
            usuario = new Usuarios();
            usuario.setId(resultado.getInt("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setSource(resultado.getString("source"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return usuario;
   }

   public List<Usuarios> select_usuario_por_id(int id) {
      Connection conn = Conexao.obterConexao();
      String sql = "SELECT * FROM api_db WHERE id=?";
      List<Usuarios> listselectPorId = new ArrayList<>();

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setInt(1, id);
         ResultSet resultado = preparador.executeQuery();

         while(resultado.next()) {
            Usuarios selectPorId = new Usuarios();
            selectPorId.setId(resultado.getInt("id"));
            selectPorId.setNome(resultado.getString("nome"));
            selectPorId.setEmail(resultado.getString("email"));
            selectPorId.setPassword(resultado.getString("password"));
            selectPorId.setTelefone(resultado.getString("telefone"));
            selectPorId.setSource(resultado.getString("source"));
            listselectPorId.add(selectPorId);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return listselectPorId;
   }

   public Usuarios selectPorId(int id) {
      Connection conn = Conexao.obterConexao();
      Usuarios usu = null;
      String sql = "SELECT * FROM api_db WHERE id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setInt(1, id);
         ResultSet resultado = preparador.executeQuery();

         while(resultado.next()) {
            usu = new Usuarios();
            usu.setId(resultado.getInt("id"));
            usu.setNome(resultado.getString("nome"));
            usu.setEmail(resultado.getString("email"));
            usu.setPassword(resultado.getString("password"));
            usu.setTelefone(resultado.getString("telefone"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return usu;
   }

   public Usuarios verifica_Users_email(String email) {
      Connection conn = Conexao.obterConexao();
      Usuarios usuario = null;
      String sql = "SELECT * FROM api_db WHERE email=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setString(1, email);
         ResultSet resultado = preparador.executeQuery();
         if (resultado.next()) {
            usuario = new Usuarios();
            usuario.setNome(resultado.getString("nome"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setId(resultado.getInt("id"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return usuario;
   }
}
