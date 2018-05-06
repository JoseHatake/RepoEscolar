package mx.ipn.escom.repoescolar.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroIndex
 */
public class FiltroIndex implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroIndex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestCast = (HttpServletRequest) request;
		HttpServletResponse responseCast = (HttpServletResponse) response;
		RequestDispatcher rd = request.getRequestDispatcher("Acciones?accion=1&direccion=index.jsp");
		rd.forward(requestCast, responseCast);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro de index inicializado...");
	}

}
