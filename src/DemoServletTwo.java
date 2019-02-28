import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;

@WebServlet(name = "DemoServletTwo")
public class DemoServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        ServletContext context = getServletContext();

        String driverName = context.getInitParameter("dname");

        pw.println("Driver name is = "+ driverName);

        pw.close();

    }
}
