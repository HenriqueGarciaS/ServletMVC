package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Usuario;
import persistencia.Banco;

public class Login implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		if(banco.Login(request.getParameter("login"),request.getParameter("senha"))) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", new Usuario(request.getParameter("login"),request.getParameter("senha")));
			return "redirect:UnicaEntrada?acao=ListaEmpresas";
		}
		
		return "forward:FormLogin.jsp";
		
	}

}
