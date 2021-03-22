package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/UnicaEntrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		String nomeAcao = request.getParameter("acao");
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo de execução: "+ nomeAcao +" " + (double)(tempoFinal-tempoInicial));
		
		
	}

}
