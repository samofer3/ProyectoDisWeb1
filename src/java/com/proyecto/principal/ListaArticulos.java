/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ListaArticulos extends ActionSupport {

    Session session;
    private String contenido;
    private contenidoAction contenidoAction = new contenidoAction(); //GENERA EL CONTENIDO DE LOS ARTICULOS
    private Articulo articulos = new Articulo();
    private ArrayList<Articulo> listaArticulos;

    public String generarArticulos() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("idCategoria"));
        int numeroArticulos = numeroArticulos();
        if (numeroArticulos != 0) {
            listadoArticulos(id);
            contenidoAction.generarContenido(listaArticulos);
            contenido = contenidoAction.getContenido();
        }

        return SUCCESS;
    }

    public void listadoArticulos(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            if (id == 0) {
                listaArticulos = (ArrayList<Articulo>) session.createQuery("from Articulo").list();
            } else {
                listaArticulos = (ArrayList<Articulo>) session.createQuery("select a from Articulo a, Categoria c where categoriaIdCategoria=idCategoria and categoriaidCategoria = " + id).list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int numeroArticulos() {
        int valor = 0;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            valor = Integer.parseInt(session.createQuery("select count(idArticulo) from Articulo articulo").list().get(0).toString());
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return valor;
    }

    public Articulo getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo articulos) {
        this.articulos = articulos;
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public contenidoAction getContenidoAction() {
        return contenidoAction;
    }

    public void setContenidoAction(contenidoAction contenidoAction) {
        this.contenidoAction = contenidoAction;
    }

}
