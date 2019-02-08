import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletInterface")
public class ServletInterface implements Servlet {

    ServletConfig config = null;

    public void init(ServletConfig config) {
        this.config = config ;
        System.out.println( "Servlet Initialized" );
    }

    public void service( ServletRequest req, ServletResponse res ) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter() ;

        out.print( "<html><body>" );
        out.print( "<h1>Servlet Interface Life Cycles</h1>" );
        out.print( "</body></html>" );

    }

    public void destroy() {
        System.out.println( "Servlet is Destroyed" );
    }

    public ServletConfig getServletConfig(){
        return config;
    }


    public String getServletInfo() {
        return "Shreeji Pedhadiya - 2019" ;
    }

}
