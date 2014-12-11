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
        <title>Lista de artículos</title>
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
            <h1>Artículo</h1>
            <div class='<s:property value="displayFormulario"/>'>
                <s:form action="editarArticulo" enctype="multipart/form-data" method="POST">
                    <s:hidden name="articulo.idArticulo" />
                    <s:textfield name="articulo.nombreArticulo" label="Nombre Artículo" required="true" maxlength="45"/>
                    <s:textfield name="articulo.descripcion" label="Descripción del artículo" required="true" maxlength="200"/>
                    <s:file name="direccionImg" label="Imagen (Recomendado 90x120px)" type="image"/>
                    <s:textfield name="articulo.precio" label="Precio" type="number" required="true" min="0" max="99999"/>
                    <s:select name="articulo.categoria.idCategoria" label="Categoria" list="listaCategorias" listKey="idCategoria" listValue="nombreCategoria" value="articulo.categoria.idCategoria" required="true"/>
                    <s:submit value="Registrar"/>
                </s:form>
            </div>
            <h2 class='<s:property value="displayLista"/>'>Lista de artículos registrados</h2>
            <table border="1" id="listaTabla" class='tablaInformativa <s:property value="displayLista"/>'>
                <tr>
                    <td>Nombre</td>
                    <td>Precio</td>
                    <td>Categoría</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <s:iterator value="listaArticulos">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreArticulo"/></td>
                        <td><s:property value="precio"/></td>
                        <td><s:property value="categoria.idCategoria"/></td>
                        <td><s:url id="editarArticulo" action="obtenerArticulo">
                                <s:param name="idArticulo" value="%{idArticulo}"></s:param>
                            </s:url> <s:a href="%{editarArticulo}">Editar</s:a></td>
                        <td><s:url id="eliminarArticulo" action="eliminarArticulo">
                                <s:param name="idArticulo" value="%{idArticulo}"></s:param>
                            </s:url> <s:a href="%{eliminarArticulo}">Eliminar</s:a></td>
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
