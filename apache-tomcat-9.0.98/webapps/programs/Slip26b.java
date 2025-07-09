import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip26b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get hobby from request
        String hobby = request.getParameter("hobby");

        // Check for existing cookie
        boolean exists = false;
        if (hobby != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("hobby") && c.getValue().equals(hobby)) {
                        exists = true;
                        break;
                    }
                }
            }

            // Add cookie only if not already added
            if (!exists) {
                Cookie hobbyCookie = new Cookie("hobby", hobby);
                response.addCookie(hobbyCookie);
            }
        }

        // HTML Form
        out.println("<html><body>");
        out.println("<h2>Select Your Hobby</h2>");
        out.println("<form method='get'>");
        out.println("<input type='radio' name='hobby' value='Painting'>Painting<br>");
        out.println("<input type='radio' name='hobby' value='Drawing'>Drawing<br>");
        out.println("<input type='radio' name='hobby' value='Singing'>Singing<br>");
        out.println("<input type='radio' name='hobby' value='Swimming'>Swimming<br><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("<input type='reset' value='Reset'>");
        out.println("</form>");

        if (hobby != null) {
            if (exists) {
                out.println("<p style='color: red;'>Hobby already stored as cookie!</p>");
            } else {
                out.println("<p style='color: green;'>Hobby stored successfully: " + hobby + "</p>");
            }
        }

        out.println("</body></html>");
    }
}

// main sirf tumse pyaar nahi karta main tumhari izzat bhi karta hoon
// apna waqt joh dete ho tum mujhko main uski kadar bhi karta hoon
// tumhe mang leta hu khuda se phir uspar sabar bhi karta hoon
// main udaas bhi ho jata hu tere liye sath mein teri fikar bhi karta hoon
// koi gair ladki jab samne aati hain apni nichi nazar bhi kartaa hoon
// abh toh itni mohabbat hain tujhse maa se teri zikar bhi karta hoon
// choom bhi leta hu teri tasviron ko aur unse guftagoo bhi karta hoon
// MAIN SIRF TUMSE PYAAR KARTA HU