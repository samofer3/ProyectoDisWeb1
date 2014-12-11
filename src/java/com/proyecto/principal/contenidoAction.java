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

    public void generarContenidoInfo(ArrayList<Articulosucursal> articulos) {
        contenido = crearContenidoInfo(articulos);
    }

    public String crearContenidoInfo(ArrayList<Articulosucursal> articulos) {
        StringBuffer contenido = new StringBuffer();
        contenido.append((String) "\t<div class='center'>\n");
        contenido.append((String) "<article id='articleUnico' class='center'>\n");
        if (articulos.isEmpty()) {
            contenido.append((String) "<h2>Este artículo no se encuentra en ninguna sucursal</h2>");
            contenido.append((String) "\t<br/>\n");
            contenido.append((String) "\t<div class='center'><input name='button' type='button' onclick='window.close();' value='Cerrar esta pestaña' /></div>\n");
            contenido.append((String) "\t<br/><br/><br/><br/><br/><br/><br/><br/><br/>\n");
        } else {
            contenido.append((String) "\t<h2>" + obtenerNombreArticulo(articulos.get(0).getArticulo()).get(0).getNombreArticulo() + "</h2>\n");
            contenido.append((String) "\t<figure>\n");
            contenido.append((String) "\t\t<img src='" + obtenerNombreArticulo(articulos.get(0).getArticulo()).get(0).getDireccionImg() + "' alt='" + obtenerNombreArticulo(articulos.get(0).getArticulo()).get(0).getNombreArticulo() + "' class='escale'>\n");
            contenido.append((String) "\t</figure>\n");
            contenido.append((String) "\t<div class='a-texto'>\n");
            for (Articulosucursal articulo : articulos) {
                contenido.append((String) "\t\t<p><strong>Sucursal:</strong>" + obtenerSucursal(articulo.getSucursal().getIdSucursal()).getNombreSucursal() + "<br/>");
                contenido.append((String) "\t\t<strong>Dirección:</strong>" + obtenerSucursal(articulo.getSucursal().getIdSucursal()).getDireccion() + "<br/>");
                contenido.append((String) "\t\t<strong>Telefono:</strong> 229" + obtenerSucursal(articulo.getSucursal().getIdSucursal()).getNumeroTelefonico() + "<br/>");
                contenido.append((String) "\t\t<strong>Cantidad:</strong>" + articulo.getUnidad() + "<br/>");
                contenido.append((String) "\t\t<hr></p>\n");
            }
            contenido.append((String) "\t<input name='button' type='button' onclick='window.close();' value='Cerrar esta pestaña' />\n");
            contenido.append((String) "\t</div>\n");

        }
        contenido.append((String) "</article>\n");
        contenido.append((String) "</div>\n");
        return new String(contenido);
    }

    public Sucursal obtenerSucursal(int id) {
        Sucursal sucursal = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            sucursal = ((Sucursal) (session.createQuery("from Sucursal sucursal where idSucursal = " + id).list().get(0)));
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sucursal;
    }

    public ArrayList<Articulo> obtenerNombreArticulo(Articulo articulo) {
        ArrayList<Articulo> nombreArticulo = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            nombreArticulo = (ArrayList<Articulo>) (session.createQuery("from Articulo articulo where idArticulo = " + articulo.getIdArticulo()).list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreArticulo;
    }

    public String crearContenido(ArrayList<Articulo> articulos) {
        StringBuffer contenido = new StringBuffer();
        if (articulos.isEmpty()) {
            contenido.append((String) "<div class='center'><article><h2>No se encuentra registrado ningún artículo</h2></article></div>");
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
                contenido.append((String) "\t\t<p><strong>Disponibilidad:</strong> " + cambiarNull(obtenerDisponibilidad(articulo)) + "</p>\n");
                contenido.append((String) "\t\t<p><strong>Sucursal:</strong> <a href='articuloSucursal.action?idArticulo=" + articulo.getIdArticulo() + "' target='_blank'>Ver sucursales</a></p>\n");
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

    public String obtenerDisponibilidad(Articulo articulo) {
        String cantidad = "";

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            cantidad = "" + session.createQuery("select sum(unidad) from Articulosucursal a where articulo = " + articulo.getIdArticulo()).list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cantidad;
    }

    public String cambiarNull(String cadena) {
        if (cadena.equals("null")) {
            return "0";
        }
        return cadena;
    }

    public String generarContenidoAdministrador(char permiso) {
        StringBuffer contenido = new StringBuffer();

        contenido.append((String) "<div class='center'>\n");
        contenido.append((String) "<a href='articulo'><img src='img/Articulos.png' class='imgMenuAdm'/></a>\n");
        if (permiso == '2') {
            contenido.append((String) "<a href='categoria'><img src='img/Categorias.png' class='imgMenuAdm'/></a>\n");
        } else if (permiso == '3') {
            contenido.append((String) "<a href='categoria'><img src='img/Categorias.png' class='imgMenuAdm'/></a>\n");
            contenido.append((String) "<a href='sucursal'><img src='img/Sucursales.png' class='imgMenuAdm'/></a>\n");
            contenido.append((String) "<a href='usuario'><img src='img/Usuarios.png' class='imgMenuAdm'/></a>\n");
            contenido.append((String) "<a href='empresa'><img src='img/Pagina.png' class='imgMenuAdm'/></a>\n");
        }
        contenido.append((String) "<a href='logout'><img src='img/Salir.png' class='imgMenuAdm'/></a>\n");
        contenido.append((String) "<div/><br/>\n");
        return new String(contenido);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
