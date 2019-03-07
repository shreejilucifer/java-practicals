import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.net.InetAddress;

@WebFilter(filterName = "IPFilter")
public class IPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        System.out.println( req.getRemoteHost() );

        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
