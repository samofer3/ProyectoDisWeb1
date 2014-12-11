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
public class ControlSucursal extends ActionSupport{  
    Session session;
    private Sucursal sucursal = new Sucursal();
    private String idSucursal;
    private String nombreSucursal;
    private String direccion;
    private String numeroTelefonico;
    private String email;
    private String displayFormulario;
    private String displayLista = "displayTrue";
    private String mensaje = "";

    public String agregaSucursal(){
        mensaje = "";
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setDireccion(direccion);
        int numero = Integer.parseInt(numeroTelefonico);
        sucursal.setNumeroTelefonico(numero);
        sucursal.setEmail(email);
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idSucursal = null;
        try{
            tx = session.beginTransaction();
            idSucursal = (Integer) session.save(getSucursal());
            tx.commit();
            mensaje = "Sucursal añadida con éxito";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }
    
    public String obtenerSucursal(){
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idSucursal"));
            sucursal = (Sucursal)session.get(Sucursal.class, id);
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
    
    public String editarSucursal(){
        mensaje = "";
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(sucursal);
            tx.commit();
            mensaje = "Sucursal modificada con éxito";
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }
    
    public String eliminarSucursal(){
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idSucursal"));
            Sucursal borrar = (Sucursal)session.get(Sucursal.class, id);
            session.delete(borrar);
            tx.commit();
            mensaje = "Sucursal eliminada con éxito";
        }catch (HibernateException e) {
            mensaje = "No se puede eliminar la sucursal ya que tiene artículos en existencias";
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
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
 
    
}
