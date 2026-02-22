package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
   public PedidoDao() {
   }

   public List<Pedido> mostrarPedido(int usuario_id) {
      Connection conn = Conexao.obterConexao();
      List<Pedido> listPedido = new ArrayList();
      String sql = "SELECT * FROM api_db RIGTH JOIN pedido ON api_db_id=?";

      try {
         PreparedStatement preparador = conn.prepareStatement(sql);
         preparador.setInt(1, usuario_id);
         ResultSet resultado = preparador.executeQuery();

         while(resultado.next()) {
            Pedido pedido = new Pedido();
            pedido.setNumero_pedido(resultado.getDouble("numero_pedido"));
            pedido.setData_pedido(resultado.getString("data_pedido"));
            pedido.setNome(resultado.getString("nome"));
            pedido.setCpf(resultado.getString("cpf"));
            pedido.setData_inicio(resultado.getString("data_inicio"));
            pedido.setData_final(resultado.getString("data_final"));
            pedido.setTotal_pedido(resultado.getString("total_pedido"));
            pedido.setCity(resultado.getString("city"));
            pedido.setState(resultado.getString("state"));
            pedido.setNum_cartao(resultado.getString("num_cartao"));
            pedido.setPagamento_pix(resultado.getString("pagamento_pix"));
            pedido.setUsuario_id(resultado.getInt("api_db_id"));
            listPedido.add(pedido);
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return listPedido;
   }

   public void pedidoCadastrar(Pedido pedido) {
      Connection conn = Conexao.obterConexao();
      String sql = "INSERT INTO pedido(api_db_id, numero_pedido, nome, cpf, data_inicio, data_final, total_pedido, city, state, num_cartao, pagamento_pix) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

      try {
         PreparedStatement prep = conn.prepareStatement(sql);
         prep.setInt(1, pedido.getUsuario_id());
         prep.setDouble(2, pedido.getNumero_pedido());
         prep.setString(3, pedido.getNome());
         prep.setString(4, pedido.getCpf());
         prep.setString(5, pedido.getData_inicio());
         prep.setString(6, pedido.getData_final());
         prep.setString(7, pedido.getTotal_pedido());
         prep.setString(8, pedido.getCity());
         prep.setString(9, pedido.getState());
         prep.setString(10, pedido.getNum_cartao());
         prep.setString(11, pedido.getPagamento_pix());
         prep.execute();
         prep.close();
         System.out.println("PEDIDO CADASTRADO COM SUCCESS");
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}
