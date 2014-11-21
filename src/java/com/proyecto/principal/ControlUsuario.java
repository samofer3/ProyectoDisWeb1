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
public class ControlUsuario extends ActionSupport {

    Session session;
    private Usuario usuario = new Usuario();
    private Sucursal sucursalObjeto = new Sucursal();
    private String nombreUsuario;
    private String password;
    private String permiso;
    private String sucursal;
    private String displayFormulario;
    private String displayLista = "displayTrue";
    private String mensaje = "";
    private String idUsuario; //Evitar errores de uso GET

    public String agregaUsuario() {
        mensaje = "";
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuario.setPermiso(permiso.charAt(0));
        if (sucursal != null) {
            int idSuc = Integer.parseInt(sucursal);
            sucursalObjeto.setIdSucursal(idSuc);
            usuario.setSucursal(sucursalObjeto);
        }
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(getUsuario());
            tx.commit();
            mensaje = "Usuario añadido con éxito";
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return SUCCESS;
    }

    public String obtenerUsuario() {
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idUsuario"));
            usuario = (Usuario) session.get(Usuario.class, id);
            displayFormulario = "displayTrue";
            displayLista = "displayNone";
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return SUCCESS;
    }

    public String editarUsuario() {
        mensaje = "";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();
            mensaje = "Usuario modificado con éxito";
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return SUCCESS;
    }

    public String eliminarUsuario() {
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idUsuario"));
            Usuario borrar = (Usuario) session.get(Usuario.class, id);
            session.delete(borrar);
            tx.commit();
            mensaje = "Usuario eliminado con éxito";
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return SUCCESS;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
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

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
