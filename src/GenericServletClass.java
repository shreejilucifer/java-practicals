import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenericServletClass")
public class GenericServletClass extends GenericServlet {

    ServletConfig config = null ;

    public void init( ServletConfig config ) {
        this.config = config ;
    }

    public void service( ServletRequest req, ServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.print( "<html><body>" );
        out.print( "<h1>Generic Abstract Class</h1>" );
        out.print( "</body></html>" );

    }

    public void destroy(){
        System.out.println( "GenericServletClass Servlet Destroyed !" );
    }


}
