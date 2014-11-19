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
            <h1>Registra una nueva sucursal</h1>
            <s:form action="registrarSucursal">
                <s:textfield name="nombreSucursal" label="Nombre Surcursal" required="true"/>
                <s:textfield name="direccion" label="Dirección" required="true"/>
                <s:textfield name="numeroTelefonico" type="number" label="Numero Telefonico (229)" required="true" maxLength="7"/>
                <s:textfield name="email" type="email" label="E-mail" required="true"/>
                <s:submit value="Registrar"/>
            </s:form>
            <table border="1" id="listaTabla" class="tablaInformativa">
                <tr>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Telefono</td>
                    <td>E-mail</td>
                </tr>
                <h2>Lista de sucursales registradas</h2>
                <s:iterator value="listaSucursales">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreSucursal"/></td>
                        <td><s:property value="direccion"/></td>
                        <td><s:property value="numeroTelefonico"/></td>
                        <td><s:property value="email"/></td>
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
