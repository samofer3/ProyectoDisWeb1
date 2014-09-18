<%-- 
    Document   : login
    Created on : 17/09/2014, 10:08:54 PM
    Author     : ferna_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Sistema de control de inventario" />
        <title>Inicio</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/prefixfree.js"></script>
    </head>
    <body>
        <body>
        <header>
            <figure id="logo">
                <img src="img/Logo.png" alt="Logo" height="80px">
            </figure>
            <figure id="banner">
                <img src="img/Banner.png" alt="Banner" height="80px">
            </figure>
        </header>
        <nav>
            <ul>
                <li><a href="index">Inicio</a></li>
                <li><a href="#">Opcion 1</a></li>
                <li><a href="#">Opcion 2</a></li>
                <li><a href="#">Opcion 3</a></li>
                <li><a href="#">Opcion 4</a></li>
                <li><a href="#">Opcion 5</a></li>
                <li><a href="#">Opcion 6</a></li>
                <li><a href="#">Opcion 7</a></li>
                <li><a href="#">Opcion 8</a></li>
                <li><a href="#">Opcion 9</a></li>
                </br>
                </br>
                <li class="center"><a href="login" >Administrar</a></li>
            </ul>
        </nav>
        <section id="login">
            <s:form action="loguear">
                <s:textfield name="user" label="Usuario" />
                <s:password name="password" label="Password" />
                <s:submit value="Enviar"/>
            </s:form>
        </section>
        <footer>
            <p>Varios colaboradores</p>
            <p>Proyecto 2014</p>
            <p>Arquitecturas de Desarrollo Web</p>
        </footer>
    </body>
    </body>
</html>
