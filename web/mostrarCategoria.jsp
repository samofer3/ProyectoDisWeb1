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
        <title>Lista de categorías</title>
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
            <h1>Categorías</h1>
            <div class='<s:property value="displayFormulario"/>'>
                <s:form action="editarCategoria">
                    <s:textfield name="categoria.idCategoria" type="hidden"/>
                    <s:textfield name="categoria.nombreCategoria" label="Nombre Categoría" required="true"/>
                    <s:submit value="Actualizar"/>
                </s:form>
            </div>
                <h2 class='<s:property value="displayLista"/>'>Lista de categorías registradas</h2>
            <table border="1" id="listaTabla" class='tablaInformativa <s:property value="displayLista"/>'>
                <tr>
                    <td>Categoría</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <s:iterator value="listaCategorias">
                    <tr class="tablaContenido">
                        <td><s:property value="nombreCategoria"/></td>
                        <td><s:url id="editCategoria" action="obtenerCategoria">
                                <s:param name="idCategoria" value="%{idCategoria}"></s:param>
                            </s:url><s:a href="%{editCategoria}">Editar</s:a></td>
                        <td><s:url id="eliminarCategoria" action="eliminarCategoria">
                                <s:param name="idCategoria" value="%{idCategoria}"></s:param>
                            </s:url> <s:a href="%{eliminarCategoria}">Eliminar</s:a></td>
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
