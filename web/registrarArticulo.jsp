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
        <title>Registrar Artículos</title>
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
            <h1>Registra un nuevo artículo</h1>
            <s:form action="registrarArticulo" enctype="multipart/form-data" method="POST">
                <s:textfield name="nombreArticulo" label="Nombre Artículo" required="true"/>
                <s:textfield name="descripcion" label="Descripción del artículo" required="true"/>
                <s:file name="direccionImg" label="Imagen (Recomendado 90x120px)" type="image"/>
                <s:textfield name="precio" label="Precio" type="number" required="true"/>
                <s:select name="categoria" label="Categoria" list="listaCategorias" listKey="idCategoria" listValue="nombreCategoria" required="true" id="categoria"/>
                <s:submit value="Registrar"/>
            </s:form>
            <table border="1" id="listaTabla" class="tablaInformativa">
                <tr>
                    <td>Nombre</td>
                    <td>Precio</td>
                    <td>Categoría</td>
                </tr>
                <h2>Lista de artículos</h2>
                <s:iterator value="listaArticulos">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreArticulo"/></td>
                        <td><s:property value="precio"/></td>
                        <%--<td><s:iterator value="listaCategorias">
                            <s:if test="%{#idCategoria==categoria.idCategoria}"><s:property value="nombreCategoria" /></s:if>
                            </s:iterator></td>--%>
                        <td><s:select list="listaCategorias" listKey="idCategoria" listValue="nombreCategoria" value="categoria.idCategoria" disabled="true" /></td>
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
