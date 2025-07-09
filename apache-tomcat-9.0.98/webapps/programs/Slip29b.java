import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip29b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create or get existing session
        HttpSession session = request.getSession(true);

        // Set session timeout (e.g., 120 seconds = 2 minutes)
        session.setMaxInactiveInterval(120); // timeout in seconds

        out.println("<html><body>");
        out.println("<h2>Session Timeout Example</h2>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Timeout interval set to: " + session.getMaxInactiveInterval() + " seconds");
        out.println("</body></html>");
    }
}
