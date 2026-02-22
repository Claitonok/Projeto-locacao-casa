package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImagemhopDao {

	   public List<Photos> mostrarTodos() {
	      Connection conn = Conexao.obterConexao();
	      List<Photos> list = new ArrayList();
	      String sql = "SELECT * FROM imagemhop";

	      try {
	         PreparedStatement preparador = conn.prepareStatement(sql);
	         ResultSet resultado = preparador.executeQuery();

	         while(resultado.next()) {
	            Photos photos = new Photos();
	            photos.setId(resultado.getInt("id"));
	            photos.setTitle(resultado.getString("title"));
	            photos.setSource(resultado.getString("source"));
	            photos.setDescription(resultado.getString("description"));
	            photos.setCity(resultado.getString("city"));
	            photos.setState(resultado.getString("state"));
	            photos.setPrice(resultado.getString("price"));
	            photos.setRating(resultado.getString("rating"));
	            list.add(photos);
	         }
	      } catch (Exception var7) {
	         var7.printStackTrace();
	      }

	      return list;
	   }

	   public List<Photos> mostrarPorId(int id) {
	      Connection conn = Conexao.obterConexao();
	      List<Photos> listRetorno = new ArrayList();
	      String sql = "SELECT * FROM imagemhop WHERE id=?";

	      try {
	         PreparedStatement preparador = conn.prepareStatement(sql);
	         preparador.setInt(1, id);
	         ResultSet resultado = preparador.executeQuery();

	         while(resultado.next()) {
	            Photos photos = new Photos();
	            photos.setId(resultado.getInt("id"));
	            photos.setTitle(resultado.getString("title"));
	            photos.setSource(resultado.getString("source"));
	            photos.setDescription(resultado.getString("description"));
	            photos.setCity(resultado.getString("city"));
	            photos.setState(resultado.getString("state"));
	            photos.setPrice(resultado.getString("price"));
	            photos.setRating(resultado.getString("rating"));
	            listRetorno.add(photos);
	         }
	      } catch (Exception var8) {
	         var8.printStackTrace();
	      }

	      return listRetorno;
	   }

}
