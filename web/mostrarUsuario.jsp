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
        <title>Lista de usuarios</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilos.css">
        <script src="js/funciones.js"></script>
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
            <h1>Usuario</h1>
            <div class='<s:property value="displayFormulario"/>'>
                <s:form action="editarUsuario">
                    <s:hidden name="usuario.idUsuario" />
                    <s:textfield name="usuario.nombreUsuario" label="Nombre Usuario" required="true" maxlength="40"/>
                    <s:password name="usuario.password" label="Password" required="true" placeholder="Introduzca password" maxlength="20"/>
                    <s:select name="usuario.permiso" label="Permiso" list="#{'1':'Básico Sucursal', '2':'Control Sucursal', '3':'Control Total'}" value="usuario.permiso" id="permiso"/>
                    <s:select name="usuario.sucursal.idSucursal" label="Sucursal" list="listaSucursales" listKey="idSucursal" listValue="nombreSucursal" value="usuario.sucursal.idSucursal" required="true" id="sucursal"/>
                    <s:submit value="Registrar"/>
                </s:form>
            </div>
            <h2 class='<s:property value="displayLista"/>'>Lista de usuarios registrados</h2>
            <table border="1" id="listaTabla" class='tablaInformativa <s:property value="displayLista"/>'>
                <tr>
                    <td>Nombre</td>
                    <td>Permiso</td>
                    <td>Sucursal</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <s:iterator value="listaUsuarios">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreUsuario"/></td>
                        <td><s:property value="permiso"/></td>
                        <td><s:property value="sucursal.idSucursal"/></td>
                        <td><s:url id="editarUsuario" action="obtenerUsuario">
                                <s:param name="idUsuario" value="%{idUsuario}"></s:param>
                            </s:url> <s:a href="%{editarUsuario}">Editar</s:a></td>
                        <td><s:url id="eliminarUsuario" action="eliminarUsuario">
                                <s:param name="idUsuario" value="%{idUsuario}"></s:param>
                            </s:url> <s:a href="%{eliminarUsuario}">Eliminar</s:a></td>
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
