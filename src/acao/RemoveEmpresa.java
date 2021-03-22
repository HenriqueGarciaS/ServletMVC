package acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.Banco;

public class RemoveEmpresa implements Acao  {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Banco banco = new Banco();
		int idEmpresa = Integer.parseInt(request.getParameter("id"));
		
		banco.remove(idEmpresa);
		return "redirect:UnicaEntrada?acao=ListaEmpresas";
		
	}

}
