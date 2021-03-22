package acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Empresa;
import persistencia.Banco;

public class CriaEmpresa implements Acao  {


	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		String NomeEmpresa = request.getParameter("nome");
		String dataAbertura = this.formatData(request.getParameter("dataAbertura"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			 data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(NomeEmpresa,data);
		banco.adciona(empresa);
		
		return "redirect:UnicaEntrada?acao=ListaEmpresas";
		
	}
	
	private String formatData(String data) {
		String [] dataBreak = data.split("-");
		return dataBreak[2]+"/"+dataBreak[1]+"/"+dataBreak[0];
	}
}
