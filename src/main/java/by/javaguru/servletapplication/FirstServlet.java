package by.javaguru.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        resp.setHeader("MY_HEADER", "HI");
        writer.write("<h1>Hello First Servlet !!! !!</h1>");
        String header = req.getHeader("user-agent");
        writer.write("<h2>"+ header +"</h2>");
        Enumeration<String> headerNames= req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            writer.write("<h3>" + s + " : " + req.getHeader(s) + "</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");

        /*resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<h2>" + req.getParameter("login") + "</h2>");
        writer.println("<h2>" + req.getParameter("pwd") + "</h2>");

        writer.println("<form action=\"second\" method=\"POST\">");
        writer.println("<p>КУРС:</p><input type=\"text\" name=\"name\">\n" + "<br/>");
        writer.println("<p>УСПЕВАЕМОСТЬ:</p><input type=\"text\" name=\"name\">\n" + "<br/>");
        writer.println("<input type=\"submit\" value=\"ОТПРАВИТЬ\" />");
        writer.println("</form></body></html>");*/
    }

    @Override
    public void destroy() {
        System.out.println("DESTROY");
    }
}
