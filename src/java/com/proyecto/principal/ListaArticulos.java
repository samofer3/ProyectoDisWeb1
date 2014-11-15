/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
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
    
    public String generarArticulos(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Integer id = Integer.parseInt(request.getParameter("idCategoria"));
        System.out.println("NUMERO ID"+id);
        if (numeroArticulos() != 0) {
            System.out.println("ENTRA A NUMERO ARTICULOS != DE 0");
            listaArticulos = listadoArticulos(id);
            contenidoAction.generarContenido(listaArticulos);
            contenido = contenidoAction.getContenido();
        }

        return SUCCESS;
    }

    public ArrayList<Articulo> listadoArticulos(Integer id) {
        ArrayList<Articulo> nombreLista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (id<0) {
                System.out.println("LISTADOARTICULOS IFTRUE");
                //nombreLista = (ArrayList<Articulo>) session.createQuery("from Articulo where fecha ='" ).list();
            }else{
                System.out.println("LISTADOARTICULOS IFELSE");
                nombreLista = (ArrayList<Articulo>) session.createQuery("from Articulo where categoriaIdCategoria ="+ id).list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreLista;
    }
    
    public int numeroArticulos() {
        System.out.println("METODO NUMEROARTICULOS");
        ArrayList<Articulo> nombreLista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            nombreLista = (ArrayList<Articulo>) session.createQuery("from Articulo").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("VALOR SIZE"+nombreLista.size());
        return nombreLista.size();
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
