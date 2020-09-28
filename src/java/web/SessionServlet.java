package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet", urlPatterns = {"/session-servlet"})
public class SessionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        Integer visitas = (Integer) session.getAttribute("visitas");
        
        PrintWriter pw = response.getWriter();
        if (Objects.isNull(visitas)) {
            visitas = 1;
            pw.println("Es mi primer visita...");
        } else {
            visitas++;
            pw.println("Es la visita " + visitas + " ...");
            
        }
        
        session.setAttribute("visitas", visitas);
        
    }

    

}
