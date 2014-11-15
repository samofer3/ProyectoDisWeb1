/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ControlCategoria extends ActionSupport implements ModelDriven<Object>{  
    Session session;
    private Categoria categoria = new Categoria();
    private String displayFormulario;
    private String displayLista = "displayTrue";
    private String mensaje = "";

    public String agregaCategoria(){
        mensaje = "";
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idCategoria = null;
        try{
            tx = session.beginTransaction();
            idCategoria = (Integer) session.save(categoria);
            tx.commit();
            mensaje = "Categoría añadida con éxito";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }
    
    public String obtenerCategoria(){
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idCategoria"));
            categoria = (Categoria)session.get(Categoria.class, id);
            displayFormulario = "displayTrue";
            displayLista = "displayNone";
            tx.commit();
            
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }
    
    public String editarCategoria(){
        mensaje = "";
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(categoria);
            tx.commit();
            mensaje = "Categoría modificada con éxito";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }
    
    public String eliminarCategoria(){
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idCategoria"));
            Categoria borrar = (Categoria)session.get(Categoria.class, id);
            session.delete(borrar);
            tx.commit();
            mensaje = "Categoria eliminada con éxito";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }

    public String getDisplayFormulario() {
        return displayFormulario;
    }

    public void setDisplayFormulario(String displayFormulario) {
        this.displayFormulario = displayFormulario;
    }

    public String getDisplayLista() {
        return displayLista;
    }

    public void setDisplayLista(String displayLista) {
        this.displayLista = displayLista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public Object getModel() {
        return categoria;
    } 
}
