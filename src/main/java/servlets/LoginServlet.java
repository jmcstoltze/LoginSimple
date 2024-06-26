package servlets;

import db.UsuarioDAO;
import db.PersonaDAO;

import models.Persona;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioDAO usuarioDAO;
    private final PersonaDAO personaDAO;
    

    public LoginServlet() {
        super();
        usuarioDAO = new UsuarioDAO();
        personaDAO = new PersonaDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (usuarioDAO.validarCredenciales(username, password)) {
            
            // Obtener datos de la persona asociada al usuario
            String rut = usuarioDAO.obtenerRutPorUsername(username);
            Persona persona = personaDAO.obtenerPersonaPorRut(rut);
            
            // Almacenar datos del usuario en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("persona", persona); // Objeto persona llamado usuario

            // Si las credenciales son válidas, redirige al usuario a la página principal
            request.getRequestDispatcher("views/principal.jsp").forward(request, response);
        } else {
            // Si las credenciales son inválidas, redirige de nuevo a la página de login con un mensaje de error
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet que maneja el inicio de sesión de usuarios.";
    }
}
