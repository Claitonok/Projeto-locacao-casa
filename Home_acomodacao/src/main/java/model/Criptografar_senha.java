package model;

import java.util.Base64;

public class Criptografar_senha {

	/*
	 * criptografar senha
	 * */
   public String criptografar_Bse64_Encode(String senha) {
      return new String(Base64.getEncoder().encodeToString(senha.getBytes()));
   }
   
   /*
    * Desgritografa a senha 
    * */
   public String criptografar_Base64_Decode(String senha) {
      return new String(Base64.getDecoder().decode(senha));
   }
}
