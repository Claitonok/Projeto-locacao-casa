package model;

public class Usuarios {
	
   private int id;
   private String nome;
   private String email;
   private String password;
   private String telefone;
   private String source;

   public Usuarios(String nome, String email, String password, String telefone) {
      this.nome = nome;
      this.email = email;
      this.password = password;
      this.telefone = telefone;
   }

   public Usuarios(int id, String nome, String email, String password, String telefone) {
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.password = password;
      this.telefone = telefone;
   }

   public Usuarios(int id, String email, String password) {
      this.id = id;
      this.email = email;
      this.password = password;
   }

   public Usuarios() {
   }

   public Usuarios(int id, String source) {
      this.id = id;
      this.source = source;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getTelefone() {
      return this.telefone;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String source) {
      this.source = source;
   }
}
