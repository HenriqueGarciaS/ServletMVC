package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/UnicaEntrada")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String ParamAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		boolean acaoProtegida = ParamAcao.equals("CriaLogin") || ParamAcao.equals("Login") || ParamAcao.equals("FormLogin") || ParamAcao.equals("FormUsuario");
		
		
		if(sessao.getAttribute("usuario") == null && !acaoProtegida) {
			if(ParamAcao.equals("FormLogin")) { 
				response.sendRedirect("UnicaEntrada?acao=FormLogin");
				return;
			}
			else {
				response.sendRedirect("UnicaEntrada?acao=FormUsuario");
				return;
			}
				
		}
		chain.doFilter(request, response);
	}


}
