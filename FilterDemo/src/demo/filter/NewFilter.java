package demo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class NewFilter
 */
//@WebFilter(description = "DemoFilter", urlPatterns = { "/NewFilter" })
public class NewFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NewFilter() {
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
		// IP address of the client machine
		String remoteAddress = request.getRemoteAddr();
		
		// Returns the remote address
		System.out.println("Remote Internet Protocol Address:" + remoteAddress);
		
		PrintWriter out = response.getWriter();
		out.println("Remote Internet Protocol Address:" + remoteAddress);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
    	// init parameter
    	String value = fConfig.getInitParameter("newParam");
    	
    	// displayin init parameter value
    	System.out.println("The Parameter value: " + value);
	}

}
