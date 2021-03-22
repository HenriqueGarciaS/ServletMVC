package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuario;
import persistencia.Banco;

public class CriaLogin implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Banco banco = new Banco();
	    Usuario user = new Usuario(request.getParameter("login"),request.getParameter("senha"));
	    
	    banco.adciona(user);
	    
	    
	    
	    return "redirect:UnicaEntrada?acao=FormLogin";
	}

}
