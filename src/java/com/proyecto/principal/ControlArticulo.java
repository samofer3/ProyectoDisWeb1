/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ControlArticulo extends ActionSupport implements ServletContextAware{

    Session session;
    private Articulo articulo = new Articulo();
    private Categoria categoriaObjeto = new Categoria();
    private String nombreArticulo;
    private String descripcion;
    private File direccionImg;
    private String direccionImgContentType;
    private String direccionImgFileName;
    private String direccionImgPath;
    private float precio;
    private String categoria;
    private String displayFormulario;
    private String displayLista = "displayTrue";
    private String mensaje = "";
    private ServletContext context;

    public String agregaArticulo() throws Exception{
        mensaje = "";
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcion(descripcion);
        articulo.setPrecio(precio);
        int idCat = Integer.parseInt(categoria);
        categoriaObjeto.setIdCategoria(idCat);
        articulo.setCategoria(categoriaObjeto);

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (direccionImgContentType.equals("image/jpeg")) {
                    setDireccionImgFileName(articulo.getIdArticulo()+".jpg");
                }else{
                    setDireccionImgFileName(articulo.getIdArticulo()+".png");
                }
                FilesUtil.saveFile(getDireccionImg(), getDireccionImgFileName(), context.getRealPath("") + File.separator + direccionImgPath);
                articulo.setDireccionImg(direccionImgPath + "/" + getDireccionImgFileName());
            session.save(articulo);
            tx.commit();
            mensaje = "Articulo añadido con éxito";
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

    public String obtenerArticulo() {
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idArticulo"));
            articulo = (Articulo) session.get(Articulo.class, id);
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

    public String editarArticulo() throws Exception{
        mensaje = "";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Articulo viejo = (Articulo)session.createQuery("from Articulo articulo where idArticulo ='" + articulo.getIdArticulo() + "'").list().get(0);
            session.clear();
            String direcionImgRespaldo = viejo.getDireccionImg();
            System.out.println("RECUPERANDO DATOS --"+direcionImgRespaldo);
            if (direccionImg != null) {
                System.out.println("Diferente de null");
                if (direccionImgContentType.equals("image/jpeg")) {
                    setDireccionImgFileName(articulo.getIdArticulo()+".jpg");
                }else{
                    setDireccionImgFileName(articulo.getIdArticulo()+".png");
                }
                FilesUtil.saveFile(getDireccionImg(), getDireccionImgFileName(), context.getRealPath("") + File.separator + direccionImgPath);
                articulo.setDireccionImg(direccionImgPath + "/" + getDireccionImgFileName());
            }else{
                System.out.println("Igual a null");
                articulo.setDireccionImg(direcionImgRespaldo);
            }
            System.out.println("ANTES DEL UPDATE"+articulo.getIdArticulo());
            System.out.println(""+articulo.getDescripcion());
            System.out.println(""+articulo.getNombreArticulo());
            System.out.println(""+articulo.getPrecio());
            System.out.println(""+articulo.getDireccionImg());
            System.out.println(""+articulo.getCategoria().getIdCategoria());
            session.update(articulo);
            tx.commit();
            mensaje = "Artículo modificado con éxito";
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

    public String eliminarArticulo() {
        mensaje = "";
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Integer id = Integer.parseInt(request.getParameter("idArticulo"));
            Articulo borrar = (Articulo) session.get(Articulo.class, id);
            session.delete(borrar);
            tx.commit();
            mensaje = "Articulo eliminado con éxito";
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Categoria getCategoriaObjeto() {
        return categoriaObjeto;
    }

    public void setCategoriaObjeto(Categoria categoriaObjeto) {
        this.categoriaObjeto = categoriaObjeto;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public File getDireccionImg() {
        return direccionImg;
    }

    public void setDireccionImg(File direccionImg) {
        this.direccionImg = direccionImg;
    }

    public String getDireccionImgContentType() {
        return direccionImgContentType;
    }

    public void setDireccionImgContentType(String direccionImgContentType) {
        this.direccionImgContentType = direccionImgContentType;
    }

    public String getDireccionImgFileName() {
        return direccionImgFileName;
    }

    public void setDireccionImgFileName(String direccionImgFileName) {
        this.direccionImgFileName = direccionImgFileName;
    }

    public String getDireccionImgPath() {
        return direccionImgPath;
    }

    public void setDireccionImgPath(String direccionImgPath) {
        this.direccionImgPath = direccionImgPath;
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public void setServletContext(ServletContext ctx) {
        this.context=ctx;
    }

}
