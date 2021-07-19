package com.usha.filter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidateFilter
 */
public class ValidateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateFilter() {
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
		System.out.println("Hello");
		String pan=request.getParameter("pan");
		if(pan==null||!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			request.getRequestDispatcher("Registration.jsp").include(request, response);
			out.println("<h4>Invalid PAN number</h4>");
		}else {
			request.setAttribute("pan", pan);
		}
			

		chain.doFilter(request, response);
}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
