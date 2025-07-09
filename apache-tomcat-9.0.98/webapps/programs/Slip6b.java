import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip6b extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visits = 1;

        // Get cookies from the request
        Cookie[] cookies = request.getCookies();
        
        // Check if cookies is null
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visits = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create a new cookie to track visit count
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visits));
        response.addCookie(visitCookie);

        // Output the response to the browser
        out.println("<html><body>");
        if (visits == 1) {
            out.println("<h3>Welcome! This is your first visit.</h3>");
        } else {
            out.println("<h3>You have visited this page " + visits + " times.</h3>");
        }
        out.println("</body></html>");
    }
}
