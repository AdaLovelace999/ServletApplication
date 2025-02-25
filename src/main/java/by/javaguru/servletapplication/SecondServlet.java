package by.javaguru.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param1 = req.getParameter("param1");
        var writer = resp.getWriter();
        writer.write("<h2>"+ param1 +"</h2>");

        Map<String, String[]> parametrMap = req.getParameterMap();
        parametrMap.entrySet().
                forEach(e -> writer.println("<h3>" + e.getKey() + " = " + Arrays.toString(e.getValue()) + "</h3>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<h2>Second</h2>");
        writer.write("<a href=\"firstpost.html\">first servlet</a>");
    }
}
