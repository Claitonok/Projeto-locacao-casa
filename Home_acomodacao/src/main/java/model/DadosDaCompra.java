package model;

public class DadosDaCompra {
	
	private int id;
	   private String checkin;
	   private String checkout;
	   private String cancelamento;
	   private String state;
	   private String city;
	   private Float price;
	   private String dataInicio;
	   private String dataFinal;
	   private String total;
	   private String nome;
	   private String cpf;
	   private String cart;
	   private String dataValid;
	   private String cDSeguran;
	   private String pagamentoPix;
	   private String email;

	   public DadosDaCompra(int id, String checkin, String checkout, String cancelamento, String state, String city, Float price, String dataInicio, String dataFinal, String total, String nome, String cpf, String cart, String dataValid, String cDSeguran, String pagamentoPix, String email) {
	      this.id = id;
	      this.checkin = checkin;
	      this.checkout = checkout;
	      this.cancelamento = cancelamento;
	      this.state = state;
	      this.city = city;
	      this.price = price;
	      this.dataInicio = dataInicio;
	      this.dataFinal = dataFinal;
	      this.total = total;
	      this.nome = nome;
	      this.cpf = cpf;
	      this.cart = cart;
	      this.dataValid = dataValid;
	      this.cDSeguran = cDSeguran;
	      this.pagamentoPix = pagamentoPix;
	      this.email = email;
	   }

	   public DadosDaCompra() {
	   }

	   public int getId() {
	      return this.id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public String getCheckin() {
	      return this.checkin;
	   }

	   public void setCheckin(String checkin) {
	      this.checkin = checkin;
	   }

	   public String getCheckout() {
	      return this.checkout;
	   }

	   public void setCheckout(String checkout) {
	      this.checkout = checkout;
	   }

	   public String getCancelamento() {
	      return this.cancelamento;
	   }

	   public void setCancelamento(String cancelamento) {
	      this.cancelamento = cancelamento;
	   }

	   public String getState() {
	      return this.state;
	   }

	   public void setState(String state) {
	      this.state = state;
	   }

	   public String getCity() {
	      return this.city;
	   }

	   public void setCity(String city) {
	      this.city = city;
	   }

	   public Float getPrice() {
	      return this.price;
	   }

	   public void setPrice(Float price) {
	      this.price = price;
	   }

	   public String getDataInicio() {
	      return this.dataInicio;
	   }

	   public void setDataInicio(String dataInicio) {
	      this.dataInicio = dataInicio;
	   }

	   public String getDataFinal() {
	      return this.dataFinal;
	   }

	   public void setDataFinal(String dataFinal) {
	      this.dataFinal = dataFinal;
	   }

	   public String getTotal() {
	      return this.total;
	   }

	   public void setTotal(String total) {
	      this.total = total;
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

	   public String getCart() {
	      return this.cart;
	   }

	   public void setCart(String cart) {
	      this.cart = cart;
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

	   public String getPagamentoPix() {
	      return this.pagamentoPix;
	   }

	   public void setPagamentoPix(String pagamentoPix) {
	      this.pagamentoPix = pagamentoPix;
	   }

	   public String getEmail() {
	      return this.email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }
	
}
