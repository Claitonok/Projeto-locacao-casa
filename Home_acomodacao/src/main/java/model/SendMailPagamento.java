package model;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailPagamento {

   public void envioEmail(String to, String checkin, String checkout, String cancelamento, String total, Double num_Pedido) throws Exception {
      String host = "sandbox.smtp.mailtrap.io";
      String port = "587";
      String username = "331d8e06a48ca1";
      String password = "485e41f7a8f9ec";
      String from = "equipeHomePage@equipeHomePage.com";
      String Body = "<!DOCTYPE html>\r\n<html lang=\"pt-BR\">\r\n<head>\r\n<meta charset=\"UTF-8\">\r\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n<title>Informações da sua reserva</title>\r\n<style>\r\n  body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }\r\n  .container { max-width: 600px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; }\r\n  .btn { display: inline-block; padding: 12px 20px; background: #007BFF; color: #fff; text-decoration: none; border-radius: 5px; }\r\n  .footer { font-size: 12px; color: #777; margin-top: 20px; }\r\n</style>\r\n</head>\r\n<body>\r\n<div class=\"container\">\r\n  <h2>Informacoes da sua reserva</h2>\r\n <p>Ola, Recebemos sua solicitação</p>\r\n  <p>Numero do Pedido: " + String.valueOf(num_Pedido) + "</p>\r\n  <p>checkin: " + checkin + "</p>\r\n  <p>checkout: " + checkout + "</p>\r\n  <p>cancelamento: " + cancelamento + "</p>\r\n  <p><a href=\"http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=home\" class=\"btn\">Cancelar reserva</a></p>\r\n  <p>Se voce nao fez essa solicitação, ignore este e-mail.</p>\r\n  <div class=\"footer\">Equipe Hospedagem ♾️ HOME_PAGE</div>\r\n</div>\r\n</body>\r\n</html>\r\n";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", port);
      Session session = Session.getDefaultInstance(props);
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
      message.setSubject("Teste de envio de e-mail");
      message.setContent(Body, "text/html");
      Transport transport = session.getTransport();

      try {
         System.out.println("Sending Email now...standby...");
         transport.connect(host, username, password);
         transport.sendMessage(message, message.getAllRecipients());
         System.out.printf("E-mail enviado com sucesso!");
      } catch (Exception var18) {
         System.err.printf("Erro ao enviar e-mail: " + var18.getMessage(), var18.getLocalizedMessage());
         var18.printStackTrace();
      }

   }
}
