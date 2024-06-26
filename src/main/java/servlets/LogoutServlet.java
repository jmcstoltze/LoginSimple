package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Obtenemos la sesión actual, si existe
        
        if (session != null) {
            session.invalidate(); // Invalidamos la sesión (cerramos sesión)
        }
        
        // Redirigimos al usuario de vuelta al inicio de sesión (o a donde prefieras)
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para cerrar sesión de usuario";
    }
}
