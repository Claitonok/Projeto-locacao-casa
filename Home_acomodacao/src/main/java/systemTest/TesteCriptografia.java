package systemTest;

import java.util.Base64;

public class TesteCriptografia {
	
	  public static void main(String[] args) {
		  
	      String textoOriginal = "esta é uma string de teste para serialização/deserialização em Base64";
	      System.out.println("Texto original: " + textoOriginal);
	      
	      System.out.println("\n");
	      
	      String textoSerializado = Base64.getEncoder().encodeToString(textoOriginal.getBytes());
	      System.out.println("Texto em Base64: " + textoSerializado);
	      
	      System.out.println("\n");
	      
	      String textoDeserializado = new String(Base64.getDecoder().decode(textoSerializado));
	      System.out.println("Texto deserializado: " + textoDeserializado);
	   }

}
