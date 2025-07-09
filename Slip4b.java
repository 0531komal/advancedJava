import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip4b extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Client Info</h3>");
        out.println("IP Address: " + request.getRemoteAddr() + "<br>");
        out.println("Browser: " + request.getHeader("User-Agent") + "<br>");
        out.println("<h3>Server Info</h3>");
        out.println("OS: " + System.getProperty("os.name") + "<br>");
        out.println("Servlet Name: " + getServletName() + "<br>");
        out.println("</body></html>");
    }
}
