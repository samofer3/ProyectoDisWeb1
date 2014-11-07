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
        <title>Lista de sucursales</title>
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
        <nav class='<s:property value="orientacion"/>'>
            <ul>
                <s:property value="menu" escapeHtml="false"/>
            </ul>
        </nav>
        <section id="login">
            <h1>Sucursales</h1>
            <table border="1" id="listaSucursales" class="tablaInformativa">
                <tr>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Telefono</td>
                    <td>E-mail</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <h2>Lista de sucursales registradas</h2>
                <s:iterator value="listaSucursales">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreSucursal"/></td>
                        <td><s:property value="direccion"/></td>
                        <td><s:property value="numeroTelefonico"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:url id="editSucursal" action="editarSucursal">
                                <s:param name="idSucursal" value="%{idSucursal}"></s:param>
                            </s:url><s:a href="%{editSucursal}">Editar</s:a></td>
                        <td><s:url id="eliminarSucursal" action="eliminarSucursal">
                                <s:param name="idSucursal" value="%{idSucursal}"></s:param>
                            </s:url> <s:a href="%{eliminarSucursal}">Eliminar</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </section>
        <footer>
            <p>Varios colaboradores</p>
            <p><s:property value="nombreEmpresa"/></p>
            <p>Arquitecturas de Desarrollo Web</p>
        </footer>
    </body>
</html>
