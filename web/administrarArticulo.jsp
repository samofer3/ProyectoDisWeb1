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
        <title>Menú Artículos</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/prefixfree.js"></script>
    </head>
    <body background='<s:property value="fondoBody"/>'>
        <header>
            <figure id="logo">
                <img src='<s:property value="logoDB" />' alt="Logo" height="80px">
            </figure>
            <figure id="banner">
                <img src='<s:property value="bannerDB" />' alt="Banner" height="80px">
            </figure>
        </header>
        <nav class='<s:property value="orientacion"/>'>
            <ul>
                <s:property value="menu" escapeHtml="false"/>
            </ul>
        </nav>
        <section id="login">
            <h1>Menú</h1>
            <h2><s:property value="mensaje"/></h2>
            <div id="enlacesSection" class="enlacesArticulos">
                <a href='mostrarArticulos'>Lista de artículos</a>
                <a href='anadirArticulo'>Registrar artículos</a>
                <a href='<s:property value="existenciasArticulo" />'>Editar existencias artículos</a>
            </div>
        </section>
        <footer>
            <p>Varios colaboradores</p>
            <p><s:property value="nombreEmpresa"/></p>
            <p>Arquitecturas de Desarrollo Web</p>
        </footer>
    </body>
</html>
