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
        <title>Modificar Empresa</title>
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
            <h1>Modificar Empresa</h1>
            <s:form action="modificarEmpresa" enctype="multipart/form-data" method="POST">
                <s:textfield name="empresa.nombreEmpresa" label="Nombre Empresa" placeholder="Introduzca un nuevo nombre"/>
                <s:radio name="empresa.fondoImagen" label="Imagen" list="#{'img/Fondo1.png':'Gris', 'img/Fondo2.png':'Azul', 'img/Fondo3.png':'Verde', 'img/Fondo4.png':'Amarillo', 'img/Fondo5.png':'Violeta', 'img/Fondo6.png':'Rojo'}" />
                <s:file name="banner" label="Banner(Recomendado 1000x120px)" type="image"/>
                <s:file name="logo" label="Logo(Recomendado 90x120px)" type="image"/>
                <s:select name="empresa.orientacion" label="Posicion del menu" list="#{'left':'Izquierda', 'right':'Derecha'}"/>
                <s:submit value="Registrar"/>
            </s:form>
        </section>
        <footer>
            <p>Varios colaboradores</p>
            <p><s:property value="nombreEmpresa"/></p>
            <p>Arquitecturas de Desarrollo Web</p>
        </footer>
    </body>
</html>
