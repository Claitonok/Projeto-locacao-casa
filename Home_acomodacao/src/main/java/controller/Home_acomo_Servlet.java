package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Criptografar_senha;
import model.DadosDaCompra;
import model.DadosDaCompraDao;
import model.Pedido;
import model.PedidoDao;
import model.QrCode;
import model.SendEmail;
import model.SendMailPagamento;
import model.UsuarioDao;
import model.Usuarios;

@WebServlet("/Home_acomo_Servlet")
@MultipartConfig
public class Home_acomo_Servlet extends HttpServlet {
	
   private static final long serialVersionUID = 1L;
   
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
      String acao = request.getParameter("acao") == null ? "logar" : request.getParameter("acao");
      HttpSession session = request.getSession();
      
     
      if (acao.equals("logar")) {
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
    	  rd.forward(request, response);
        
      } else if (acao.equals("cadastrarUser")) {
    	  
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroUsers.html");
        rd.forward(request, response);
        
      } else if (acao.equals("home")) {
    	  
         response.sendRedirect("http://localhost:8080/Home_acomodacao/");
         
      } else if (acao.equals("logout")) {
    	  
         session.invalidate();
         response.sendRedirect("http://localhost:8080/Home_acomodacao/");
         
      } else if (acao.equals("AlterarSenhaUser")) {
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alterarSenhaUser.jsp");
    	  rd.forward(request, response);
         
      } else if (acao.equals("RedefinirSenha")) {
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/validarEmailUser.jsp");
          rd.forward(request, response);
         
      } else if (acao.equals("mostrarAcomo")) {
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/paginaHomeHospedagem.jsp");
    	  rd.forward(request, response);
         
      } else if (acao.equals("area_de_usuario")) {
    	  
    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/areaUsuario.jsp");
          rd.forward(request, response);
         
      } else if (acao.equals("meus_dados")) {
           int id = Integer.valueOf(request.getParameter("id"));
           
            if (request.getParameter("id") == null) {
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
               rd.forward(request, response);
            }
            System.out.println("Meus Dados, id do usuario: " + id);
            
            UsuarioDao dao = new UsuarioDao();
            List<Usuarios> dadosUsuario = dao.select_usuario_por_id(id);
            
            request.setAttribute("dados", dadosUsuario);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/dadosUsuario.jsp");
            rd.forward(request, response);
            
         } else if (acao.equals("minhasReservas")) {
        	 
            int id = Integer.valueOf(request.getParameter("id"));
            
            System.out.println("id do usuario: " + id);
            PedidoDao dao = new PedidoDao();
         
            List<Pedido> dadosUsuario = dao.mostrarPedido(id);
            request.setAttribute("dadosReservas", dadosUsuario);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/areaUsuario.jsp");
            rd.forward(request, response);
            
         } else if (acao.equals("QrCode")) {
        	 
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/QrCodeJs/GenerateQRCode.html");
            rd.forward(request, response);
         }
      }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   String acao = request.getParameter("acao");
     
      if (acao.equals("login")) {
    	  
    	 String email = request.getParameter("txtemail");
         String senha = request.getParameter("txtsenha");
         
         UsuarioDao usuario = new UsuarioDao();
         
         Criptografar_senha criptografar = new Criptografar_senha();
         String senhaCripitografada = criptografar.criptografar_Bse64_Encode(senha);
         Usuarios resposta = usuario.autentica(email, senhaCripitografada);
         
         if (resposta != null) {
        	 
            System.out.println("E-mail: " + email);
            System.out.println("Senha do usuario: " + senha);
            System.out.println("Senha do usuario Criptografada: " + senhaCripitografada);
            
            HttpSession session = request.getSession();
            
            session.setAttribute("resposta", resposta);
            response.sendRedirect("http://localhost:8080/Home_acomodacao/");
            
//            UsuarioDao dao = new UsuarioDao();
//            List<Usuarios> dadosUsuario = dao.select_usuario_por_id(resposta.getId());
//            
            request.setAttribute("dadosUsuario", resposta);
//            
//            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//            rd.forward(request, response);
            
         } else {
        	 
        	HttpSession session = request.getSession();
        	
            String state = resposta == null ? "E-mail ou senha invalido!!" : "";
            
            System.out.println("Teste: " + state);
            session.setAttribute("validar", state);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
            rd.forward(request, response);
            session.invalidate();
         }
         
      } else if (acao.equals("User_cadastro")) {
        	 
            String nome = request.getParameter("txtnome");
            String email = request.getParameter("txtemail");
            String senha = request.getParameter("txtsenha");
            String telefone = request.getParameter("txtTelefone");
            
            Criptografar_senha criptografar = new Criptografar_senha();
            
            String senhaCrip = criptografar.criptografar_Bse64_Encode(senha);
            
            Usuarios Usuarios = new Usuarios(nome, email, senhaCrip, telefone);
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.cadastrar_Users(Usuarios);
            
            response.sendRedirect("http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=logar");
            
         } else if (acao.equals("AtualizarDados")) {
             
               int id = Integer.valueOf(request.getParameter("txtId"));
               
               String nome = request.getParameter("txtNome");
               String email = request.getParameter("txtEmail");
               String senha = request.getParameter("txtPassword");
               String telefone = request.getParameter("txtTelefone");
               
               Part arquivo = request.getPart("imagem");
               
               UsuarioDao usuarioDao = new UsuarioDao();
               Usuarios usuarios = usuarioDao.selectPorId(id);
               
               if (senha.equals(usuarios.getPassword())) {
            	   
                  Usuarios Usuarios = new Usuarios(id, nome, email, senha, telefone);
                  usuarioDao.alterar_Users(Usuarios);
                  System.out.println("Entrou no senha.equals(usua.getPassword()): \n");
                  
               } else {
            	   
                  System.out.println("Pegou senha no else: " + senha);
                  
                  Criptografar_senha criptografar = new Criptografar_senha();
                  
                  String senhaCritografada = criptografar.criptografar_Bse64_Encode(senha);
                  
                  Usuarios Usuarios = new Usuarios(id, nome, email, senhaCritografada, telefone);
                  usuarioDao.alterar_Users(Usuarios);
               }
               
               if (arquivo != null && arquivo.getSize() > 0) {

            	    String nomeOriginal = arquivo.getSubmittedFileName();
            	    
            	    // Pegar extensão (.jpg, .png...)
            	    String extensao = "";
            	    int i = nomeOriginal.lastIndexOf(".");
            	    if (i > 0) {
            	        extensao = nomeOriginal.substring(i);
            	    }
            	    String novoNome = UUID.randomUUID().toString() + extensao;

            	    String uploadDir = getServletContext().getRealPath("") + File.separator + "FOTO_US";
            	    
            	    System.out.println("Caminho: " + uploadDir + "\n");
            	    
            	    File pasta = new File(uploadDir);

            	    if (!pasta.exists()) {
            	        pasta.mkdirs();
            	        System.out.println(":::Entrou aqui:::");
            	    }

            	    File destino = new File(pasta, novoNome);

            	    try (InputStream input = arquivo.getInputStream();
            	         FileOutputStream output = new FileOutputStream(destino)) {

            	        byte[] buffer = new byte[1024];
            	        int bytesLidos;

            	        while ((bytesLidos = input.read(buffer)) != -1) {
            	            output.write(buffer, 0, bytesLidos);
            	        }
            	    }

            	    Usuarios usuario = new Usuarios(id, novoNome);
            	    usuarioDao.inserir_source(usuario);

            	    System.out.println("Imagem salva com sucesso em: " + destino.getAbsolutePath());
            	    response.getWriter().println("Upload realizado com sucesso!");
            	    response.sendRedirect("http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=area_de_usuario");
            	    
            	} else {
                  System.out.println("Nenhum arquivo enviado.");
                  response.sendRedirect("http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=area_de_usuario");
               }
               
            } else if (acao.equals("Enviar-email")) {
            	
               String email = request.getParameter("txtemail") != null ? request.getParameter("txtemail") : null;
               UsuarioDao usuario = new UsuarioDao();
               Usuarios respoVerifai = usuario.verifica_Users_email(email);
               
               if (respoVerifai != null) {
            	   
            	  HttpSession sessionEmail = request.getSession();
                  String EmailValido = respoVerifai != null ? "E-mail de recuperação foi enviado!!!!" : "";
                  
                  sessionEmail.setAttribute("EmailValido", EmailValido);
                  
                  System.out.println("E-mail: " + email);
                  System.out.println("Senha do usuario: " + respoVerifai.getPassword());

                  try {
                     SendEmail sendmail = new SendEmail();
                     sendmail.envioEmail(email, respoVerifai.getNome());
                     response.sendRedirect("http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=AlterarSenhaUser");
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
                  
               } else {
            	   
            	  HttpSession sessionEmail = request.getSession();
            	   
                  System.out.println("E-mail usuario: " + email);
                  String EmailInvalido = respoVerifai == null ? "E-mail não foi localizado na base de dados!!" : "";
                  sessionEmail.setAttribute("EmailInvalido", EmailInvalido);
                  
                  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/alterarSenhaUser.jsp");
                  rd.forward(request, response);
                  
                  sessionEmail.invalidate();
                  
               }
               
            } else if (acao.equals("User_pagamento")) {
            	
               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pagamentos.jsp");
               rd.forward(request, response);
               
            } else if (acao.equals("conferirPagarPagamento")) {
            	   
                  int id = Integer.valueOf(request.getParameter("txtId"));
                  String email = request.getParameter("txtEmail");
                  
                  System.out.println("ID: " + id);
                  System.out.println("E-mail: " + email);
                  
                  if (request.getParameter("txtId") != null) {
                	 
                     String checkin = request.getParameter("txtCheck-in");
                     String checkout = request.getParameter("txtCheck-out");
                     String cancelamento = request.getParameter("txtCancelamento");
                     String state = request.getParameter("txtState");
                     String city = request.getParameter("txtCity");
                     Float price = Float.valueOf(request.getParameter("txtPrice"));
                     String dataInicio = request.getParameter("txtDataInicio");
                     String dataFinal = request.getParameter("txtDataFinal");
                     String total = request.getParameter("txtTotal");
                     String nome = request.getParameter("txtnome");
                     String cpf = request.getParameter("txtcpf");
                     String pix = request.getParameter("txtAceito");
                     String num_cartao = request.getParameter("txtnCart");
                     String dataValid = request.getParameter("txtdataValid");
                     String cDSeguran = request.getParameter("txtcDSeguran");
                     System.out.println("pix: " + pix);
                     
                     if (pix != null) {
                    	 
                        String chave = "4f7ddc58-901a-4351-b951-a6b1e9476af8";
                        String cidadeRecebedor = "SAO PAULO";
                        String txid = "HOSPEDAGEM_HOME_PAGE";
                        QrCode gerarQrcode = new QrCode();
                        String payloadPix = gerarQrcode.gerarPayload(chave, nome, cidadeRecebedor, txid, total);
                        
                        System.out.println("Chave Pix: " + payloadPix);
                        request.setAttribute("payloadPix", payloadPix);
                     }

                     DadosDaCompraDao compraDao = new DadosDaCompraDao();
                     List<DadosDaCompra> listDadosDaCompra = compraDao.dados(id, checkin, checkout, cancelamento, state, city, price,
                    		 dataInicio, dataFinal, total, nome, cpf, num_cartao, dataValid, cDSeguran, pix, email);
                     request.setAttribute("listDados", listDadosDaCompra);
                     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/conferirPagar.jsp");
                     rd.forward(request, response);
                     
                  } else {
                     response.sendRedirect("http://localhost:8080/Home_acomodacao/");
                  }
                  
               } else if (acao.equals("pagar")) {
            	   
                  String pix = request.getParameter("txtAceito");
                  String email = request.getParameter("txtEmail");
                  
                  Double num_Pedido = Math.random();
                  int id = Integer.valueOf(request.getParameter("txtId"));
                  
                  System.out.println("Compra entrou id do usuario: " + id);
                  System.out.println("Numero do Pedido: " + String.valueOf(num_Pedido));
                  System.out.println("Pagar nosso email do usuario: " + email);
                  
                  String checkin = request.getParameter("txtCheck-in");
                  String checkout = request.getParameter("txtCheck-out");
                  String cancelamento = request.getParameter("txtCancelamento");
                  String state = request.getParameter("txtState");
                  String city = request.getParameter("txtCity");
                  String price = request.getParameter("txtPrice");
                  String dataInicio = request.getParameter("txtDataInicio");
                  String dataFinal = request.getParameter("txtDataFinal");
                  String total = request.getParameter("txtTotal");
                  String nome = request.getParameter("txtnome");
                  String cpf = request.getParameter("txtcpf");
                  String num_cartao = request.getParameter("txtnCart");
                  String dataValid = request.getParameter("txtdataValid");
                  String cDSeguran = request.getParameter("txtcDSeguran");
                  
                  if (pix != null) {
                	  
                     System.out.println("Entrou aqui: " + pix);
                     PedidoDao pedidoDao = new PedidoDao();
                     SendMailPagamento sendMailPagamento = new SendMailPagamento();

                     try {
                        sendMailPagamento.envioEmail(email, checkin, checkout, cancelamento, total, num_Pedido);
                        Pedido pedido = new Pedido(id, num_Pedido, nome, cpf, dataInicio, dataFinal, total, city, state, pix);
                        pedidoDao.pedidoCadastrar(pedido);
                        response.sendRedirect("http://localhost:8080/Home_acomodacao/");
                        
                     } catch (Exception e) {
                        e.printStackTrace();
                     }
                     
                  } else {
                     SendMailPagamento sendMailPagamento = new SendMailPagamento();

                     try {
                        sendMailPagamento.envioEmail(email, checkin, checkout, cancelamento, total, num_Pedido);
                        PedidoDao pedidoDao = new PedidoDao();
                        Pedido pedido = new Pedido(id, num_Pedido, dataInicio, dataFinal, total, city, state, num_cartao, nome, cpf, dataValid, cDSeguran);
                        pedidoDao.pedidoCadastrar(pedido);
                        response.sendRedirect("http://localhost:8080/Home_acomodacao/");
                        
                     } catch (Exception e) {
                        e.printStackTrace();
                     }
                  }
                  
               } else if (acao.equals("RecuperarConta")) {
            	   
                  String email = request.getParameter("txtemail");
                  String senha = request.getParameter("txtsenha");
                  
                  UsuarioDao usuario = new UsuarioDao();
                  
                  Usuarios resposta_users_email = usuario.verifica_Users_email(email);
                  
                  if (resposta_users_email != null) {
                	  
                     int id = resposta_users_email.getId();
                     
                     Criptografar_senha criptografar = new Criptografar_senha();
                     String senhaEncode = criptografar.criptografar_Bse64_Encode(senha);
                     
                     Usuarios usuarios = new Usuarios(id, email, senhaEncode);
                     usuario.recuperarConta(usuarios);
                     
                     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
                     rd.forward(request, response);
                     
                  } else {
                	  
                     HttpSession session_RecuperarConta = request.getSession();
                     
                     String recuperarConta = resposta_users_email == null ? "E-mail não localizado na base de dados!!" : "";
                     
                     System.out.println("xxxx: " + resposta_users_email + "\n");
                     System.out.println("Recuperar Conta: " + recuperarConta);
                     
                     session_RecuperarConta.setAttribute("respostaCconta", recuperarConta);
                     
                     RequestDispatcher rd_RecuperarConta = request.getRequestDispatcher("/WEB-INF/view/validarEmailUser.jsp");
                     rd_RecuperarConta.forward(request, response);
                     session_RecuperarConta.invalidate();
                  }
               }
      
      
    }
         
}
