<%-- 
    Document   : registrarSucursal
    Created on : 8/10/2014, 10:14:41 PM
    Author     : ferna_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Sistema de control de inventario" />
        <title>Registrar Sucursal</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/prefixfree.js"></script>
    </head>
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
                <s:property value="menu" escapeHtml="false"/>
            </ul>
        </nav>
        <section id="login">
            <h1>Registra una nueva sucursal</h1>
            <s:form action="registrarSucursal" method="post">
                <s:textfield name="id_sucursal" type="hidden"/>
                <s:textfield name="nombre_sucursal" label="Nombre Surcursal" required="true"/>
                <s:textfield name="direccion" label="Dirección" required="true"/>
                <s:textfield name="numero_telefonico" type="number" label="Numero Telefonico" required="true"/>
                <s:textfield name="email" type="email" label="E-mail" required="true"/>
                <s:submit value="Registrar"/>
            </s:form>
        </section>
        <footer>
            <p>Varios colaboradores</p>
            <p>Proyecto 2014</p>
            <p>Arquitecturas de Desarrollo Web</p>
        </footer>
    </body>
</html>
