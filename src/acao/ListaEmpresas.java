package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Empresa;
import persistencia.Banco;

public class ListaEmpresas implements Acao  {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresas");
		Banco banco = new Banco();
		
		
		
		List<Empresa> empresas = banco.getEmpresas();
		
		request.setAttribute("empresas", empresas);
		
		return "forward:ListaEmpresas.jsp";
		
	}

}
