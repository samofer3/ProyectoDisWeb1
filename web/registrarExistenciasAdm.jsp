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
        <title>Registrar Existencias</title>
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
            <h1>Registra existencias a un artículo</h1>
            <s:form action="registrarExistencias">
                <s:select name="articuloIdArticulo" label="Artículo" list="listaArticulos" listKey="idArticulo" listValue="nombreArticulo" />
                <s:select name="sucursalIdSucursal" label="Sucursal" list="listaSucursales" listKey="idSucursal" listValue="nombreSucursal" />
                <s:textfield name="unidad" label="Unidades" required="true" type="number" min="0" max="9999999"/>
                <s:submit value="Registrar"/>
            </s:form>
            <table border="1" id="listaTabla" class="tablaInformativa">
                <tr>
                    <td>Existencias</td>
                    <td>Artículo</td>
                    <td>Sucursal</td>
                </tr>
                <h2>Lista de categorías registradas</h2>
                <s:iterator value="listaUnidades">
                    <tr class="tablaContenido">
                        <td><s:property value="unidad"/></td>
                        <td><s:iterator value="listaArticulos">
                            <s:if test="idArticulo==articulo.idArticulo"><s:property value="nombreArticulo" /></s:if>
                            </s:iterator></td>
                        <td><s:iterator value="listaSucursales">
                            <s:if test="idSucursal==sucursal.idSucursal"><s:property value="nombreSucursal" /></s:if>
                            </s:iterator></td>
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
