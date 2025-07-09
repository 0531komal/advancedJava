//simplest servlet program to display welcome message the first time user visits a page and the no. of times when the user vists the page, use cookie?
package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WelcomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("count")) {
                    int count = Integer.parseInt(cookie.getValue());
                    out.println("<h1>Welcome to our website. You have visited us " + count + "
                    ");
                    cookie.setMaxAge(60 * 60 * 24 * 365); // 1 year
                    response.addCookie(cookie);
                    break;
                    }
                    }
                    } else {
                        out.println("<h1>Welcome to our website. You have visited us 1 time.</h
                        ");
                        Cookie cookie = new Cookie("count", "1");
                        cookie.setMaxAge(60 * 60 * 24 * 365); // 1 year
                        response.addCookie(cookie);
                    }
                    out.close();
        }
    }
            

