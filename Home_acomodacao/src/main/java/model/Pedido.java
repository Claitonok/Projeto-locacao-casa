package model;

public class Pedido {
   private int usuario_id;
   private int id;
   private Double numero_pedido;
   private String data_pedido;
   private String data_inicio;
   private String data_final;
   private String total_pedido;
   private String city;
   private String state;
   private String num_cartao;
   private String pagamento_pix;
   private String nome;
   private String cpf;
   private String dataValid;
   private String cDSeguran;

   public Pedido(int usuario_id, Double numero_pedido, String nome, String cpf, String data_inicio, String data_final, String total_pedido, String city, String state, String pagamento_pix) {
      this.usuario_id = usuario_id;
      this.numero_pedido = numero_pedido;
      this.nome = nome;
      this.cpf = cpf;
      this.data_inicio = data_inicio;
      this.data_final = data_final;
      this.total_pedido = total_pedido;
      this.city = city;
      this.state = state;
      this.pagamento_pix = pagamento_pix;
   }

   public Pedido(int usuario_id, Double numero_pedido, String data_inicio, String data_final, String total_pedido, String city, String state, String num_cartao, String nome, String cpf, String dataValid, String cDSeguran) {
      this.usuario_id = usuario_id;
      this.numero_pedido = numero_pedido;
      this.data_inicio = data_inicio;
      this.data_final = data_final;
      this.total_pedido = total_pedido;
      this.city = city;
      this.state = state;
      this.num_cartao = num_cartao;
      this.nome = nome;
      this.cpf = cpf;
      this.dataValid = dataValid;
      this.cDSeguran = cDSeguran;
   }

   public Pedido() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Double getNumero_pedido() {
      return this.numero_pedido;
   }

   public void setNumero_pedido(Double numero_pedido) {
      this.numero_pedido = numero_pedido;
   }

   public String getData_pedido() {
      return this.data_pedido;
   }

   public void setData_pedido(String data_pedido) {
      this.data_pedido = data_pedido;
   }

   public String getData_inicio() {
      return this.data_inicio;
   }

   public void setData_inicio(String data_inicio) {
      this.data_inicio = data_inicio;
   }

   public String getData_final() {
      return this.data_final;
   }

   public void setData_final(String data_final) {
      this.data_final = data_final;
   }

   public String getTotal_pedido() {
      return this.total_pedido;
   }

   public void setTotal_pedido(String total_pedido) {
      this.total_pedido = total_pedido;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getNum_cartao() {
      return this.num_cartao;
   }

   public void setNum_cartao(String num_cartao) {
      this.num_cartao = num_cartao;
   }

   public String getPagamento_pix() {
      return this.pagamento_pix;
   }

   public void setPagamento_pix(String pagamento_pix) {
      this.pagamento_pix = pagamento_pix;
   }

   public int getUsuario_id() {
      return this.usuario_id;
   }

   public void setUsuario_id(int usuario_id) {
      this.usuario_id = usuario_id;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return this.cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getDataValid() {
      return this.dataValid;
   }

   public void setDataValid(String dataValid) {
      this.dataValid = dataValid;
   }

   public String getcDSeguran() {
      return this.cDSeguran;
   }

   public void setcDSeguran(String cDSeguran) {
      this.cDSeguran = cDSeguran;
   }
}
