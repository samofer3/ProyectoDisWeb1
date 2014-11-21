/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class contenidoAction extends ActionSupport {

    Session session;
    private String contenido = "";

    public void generarContenido(ArrayList<Articulo> articulos) {
        contenido = crearContenido(articulos);
    }

    public String crearContenido(ArrayList<Articulo> articulos) {
        StringBuffer contenido = new StringBuffer();
        if (articulos.isEmpty()) {
            contenido.append((String) "<h2>No se encuentra registrado ningún artículo</h2>");
        } else {
            for (Articulo articulo : articulos) {
                contenido.append((String) "<article>\n");
                contenido.append((String) "\t<h2>" + articulo.getNombreArticulo() + "</h2>\n");
                contenido.append((String) "\t<figure>\n");
                contenido.append((String) "\t\t<img src='" + articulo.getDireccionImg() + "' alt='" + articulo.getNombreArticulo() + "' class='escale'>\n");
                contenido.append((String) "\t</figure>\n");
                contenido.append((String) "\t<div class='a-texto'>\n");
                contenido.append((String) "\t\t<p><strong>Descripción:</strong>" + articulo.getDescripcion() + "</p>\n");
                contenido.append((String) "\t\t<p><strong>Precio:</strong> $" + articulo.getPrecio() + "</p>\n");
                contenido.append((String) "\t\t<p><strong>Disponibilidad:</strong> 120</p>\n");
                contenido.append((String) "\t\t<p><strong>Sucursal:</strong> <a href='#' target='_blank'>Ver sucursales</a></p>\n");
                contenido.append((String) "\t</div>\n");
                contenido.append((String) "</article>\n");
            }
        }

        return new String(contenido);
    }

    public void generarContenidoAdministrador() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        User user = (User) session.getAttribute("user");
        char permiso = obtenerPermiso(user.getUser());
        contenido = generarContenidoAdministrador(permiso);
    }

    public char obtenerPermiso(String nombre) {
        char nombreLista = '1';

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            nombreLista = (session.createQuery("select usuario.permiso from Usuario usuario where nombreUsuario = '" + nombre + "'").list().get(0).toString().charAt(0));
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreLista;
    }

    public String generarContenidoAdministrador(char permiso) {
        StringBuffer contenido = new StringBuffer();

        contenido.append((String) "<h2><a href='#'>Articulos</a></h2>\n");
        if (permiso == '2') {
            contenido.append((String) "<h2><a href='categoria'>Categorias</a></h2>\n");
        } else if(permiso == '3'){
            contenido.append((String) "<h2><a href='categoria'>Categorias</a></h2>\n");
            contenido.append((String) "<h2><a href='sucursal'>Sucursal</a></h2>\n");
            contenido.append((String) "<h2><a href='usuario'>Usuarios</a></h2>\n");
            contenido.append((String) "<h2><a href='empresa'>Pagina</a></h2>\n");
        }
        contenido.append((String) "<h2><a href='logout' >Salir</a></h2>\n");

        return new String(contenido);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
