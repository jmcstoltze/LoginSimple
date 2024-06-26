<%-- 
    Document   : principal
    Created on : 24 jun 2024, 8:09:26
    Author     : jmcontreras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/styles2.css">
    </head>
    <body>
        <div class="navbar">
            <div class="navbar-left">
                
                <a href="#">Inicio</a>
                <a href="#">Productos</a>
                <a href="#">Contacto</a>
            </div>
            <div class="navbar-right">
                <form action="LogoutServlet" method="post">
                    <input type="submit" value="Cerrar Sesión"/>
                </form>
            </div>
        </div>
        
        <div class="container">
            <div class="welcome-message">
                <%-- Mostrar mensaje de bienvenida --%>                
                Bienvenid@, ${persona.nombres} ${persona.apellidoPaterno}               
            </div>
            
            <div class="user-info">
                <%-- Mostrar información del usuario --%>                
                <p><strong>Rut:</strong> ${persona.rut}</p>
                <p><strong>Nombres:</strong> ${persona.nombres}</p>
                <p><strong>Apellido Paterno:</strong> ${persona.apellidoPaterno}</p>
                <p><strong>Apellido Materno:</strong> ${persona.apellidoMaterno}</p>
                <p><strong>Teléfono:</strong> ${persona.telefono}</p>
                <p><strong>Fecha de Ingreso:</strong> ${persona.fechaIngreso}</p>                
            </div>
        </div>
    </body>
</html>
