package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acao.Acao;
import acao.FormEmpresa;
import acao.AlteraEmpresa;
import acao.CriaEmpresa;
import acao.GetEmpresa;
import acao.RemoveEmpresa;
import acao.ListaEmpresas;


/**
 * Servlet implementation class UnicaEntrada
 */
@WebServlet("/UnicaEntrada")
public class UnicaEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String ParamAcao = request.getParameter("acao");
		/*HttpSession sessao = request.getSession();
		
		
		if(sessao.getAttribute("usuario") == null && !(ParamAcao.equals("CriaLogin") || ParamAcao.equals("Login"))) {
			if(ParamAcao.equals("FormUsuario"))
				ParamAcao = "FormUsuario";
			else
			ParamAcao = "FormLogin";
		}*/
		
		String endereco = null;
		String nomeClasse = "acao."+ParamAcao;
		Class classe;
		Object obj;
		try {
		 classe = Class.forName(nomeClasse);
		 obj = classe.newInstance();
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		Acao acao = (Acao) obj;
		endereco = acao.executa(request, response);
		System.out.println(acao);
		
		String[] url = endereco.split(":");
		
		if(url[0].equals("forward")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/"+url[1]);
		rd.forward(request, response);
		}else {
			response.sendRedirect(url[1]);
		}
		
		/*switch(acao){
		case "RemoveEmpresa":
			System.out.println("removendo empresa");
			RemoveEmpresa empresa = new RemoveEmpresa();
			endereco = empresa.executa(request, response);
			break;
			
		case "ListaEmpresa":
			System.out.println("listando empresas");
			ListaEmpresas lista = new ListaEmpresas();
			endereco = lista.listaEmpresas(request,response);
			break;
			
		case "GetEmpresa":
			System.out.println("pegando empresa");
			GetEmpresa editaEmpresa = new GetEmpresa();
			endereco = editaEmpresa.getEmpresa(request, response);
			break;
			
		case "AlteraEmpresa":
			System.out.println("editando empresa");
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			endereco = alteraEmpresa.altera(request, response);
			break;
			
		case "CriaEmpresa":
			System.out.println("criando empresa");
			CriaEmpresa criaEmpresa = new CriaEmpresa();
			endereco = criaEmpresa.cria(request, response);
			break;
			
		case "form":
			endereco = "forward:EmpresaNovaForm.jsp";
		}*/	
	
	}

}
