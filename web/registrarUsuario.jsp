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
        <title>Registrar Usuarios</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/funciones.js"></script>
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
            <h1>Registra un nuevo usuario</h1>
            <s:form action="registrarUsuario">
                <s:textfield name="nombreUsuario" label="Nombre Usuario" required="true"/>
                <s:password name="password" label="Password" required="true"/>
                <s:select name="permiso" label="Permiso" list="#{'1':'Básico Sucursal', '2':'Control Sucursal', '3':'Control Total'}" id="permiso"/>
                <s:select name="sucursal" label="Sucursal" list="listaSucursales" listKey="idSucursal" listValue="nombreSucursal" required="true" id="sucursal"/>
                <s:submit value="Registrar"/>
            </s:form>
            <table border="1" id="listaTabla" class="tablaInformativa">
                <tr>
                    <td>Usuario</td>
                    <td>Permiso</td>
                    <td>Sucursal</td>
                </tr>
                <h2>Lista de usuarios registrados</h2>
                <s:iterator value="listaUsuarios">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreUsuario"/></td>
                        <td><s:property value="permiso"/></td>
                        <td><s:property value="sucursal.idSucursal"/></td>
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
