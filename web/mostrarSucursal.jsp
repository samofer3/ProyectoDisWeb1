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
            <h1>Sucursales</h1>
            <div class='<s:property value="displayFormulario"/>'>
                <s:form action="editarSucursal">
                    <s:textfield name="sucursal.idSucursal" type="hidden"/>
                    <s:textfield name="sucursal.nombreSucursal" label="Nombre Surcursal" required="true" maxlength="45"/>
                    <s:textfield name="sucursal.direccion" label="Dirección" required="true" maxlength="100"/>
                    <s:textfield name="sucursal.numeroTelefonico" type="number" label="Numero Telefonico (229)" required="true" min="1000000" max="9999999"/>
                    <s:textfield name="sucursal.email" type="email" label="E-mail" required="true" maxlength="45"/>
                    <s:submit value="Actualizar"/>
                </s:form>
            </div>
                <h2 class='<s:property value="displayLista"/>'>Lista de sucursales registradas</h2>
            <table border="1" id="listaTabla" class='tablaInformativa <s:property value="displayLista"/>'>
                <tr>
                    <td>Nombre</td>
                    <td>Dirección</td>
                    <td>Telefono</td>
                    <td>E-mail</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <s:iterator value="listaSucursales">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreSucursal"/></td>
                        <td><s:property value="direccion"/></td>
                        <td><s:property value="numeroTelefonico"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:url id="editSucursal" action="obtenerSucursal">
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
