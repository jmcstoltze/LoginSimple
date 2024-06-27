<%-- 
    Document   : index
    Created on : 24 jun 2024, 8:08:57
    Author     : jmcontreras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
    </head>
    <body>
        <div class="login-form">
            <h2>Inicio de Sesión</h2>
            <form action="LoginServlet" method="post">
                <input type="text" name="username" placeholder="Ingrese nombre de usuario"/>
                <input type="password" name="password" placeholder="Ingrese contraseña"/>
                <input type="submit" value="Iniciar Sesión" href="views/principal.jsp"/>
                <p>¿No tienes una cuenta? <a href="">Regístrate aquí</a></p>
            </form>
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
                <p style="color:red;"><%= errorMessage %></p>
            <%
                }
            %>
        </div>
    </body>
</html>
