package am.opensource.tomcatServletFilters;

import javax.servlet.*;
import java.io.IOException;
// Custom servlet filter written to bypass restrictions applied by tomcat in regards to redeploying a / webapp
public class TomcatManagerFilter implements javax.servlet.Filter {
	public void init(FilterConfig am) throws ServletException {
	}

	public void doFilter(ServletRequest request,
			         ServletResponse response,
				 FilterChain chain)
		throws IOException, ServletException {
		if ( ! ( request.toString().startsWith("manager") || request.toString().equals("lbAccessStatus") ) ) {
		    chain.doFilter(request, response);
		    return;
		}
	}

	public void destroy() {}

}

