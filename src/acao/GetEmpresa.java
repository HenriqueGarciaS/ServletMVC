package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Empresa;
import persistencia.Banco;

public class GetEmpresa implements Acao  {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		int idEmpresa = Integer.parseInt(request.getParameter("id"));
		Empresa empresa = banco.getEmpresa(idEmpresa);
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		
		return "forward:EditaEmpresa.jsp";
		
		
	}

}
