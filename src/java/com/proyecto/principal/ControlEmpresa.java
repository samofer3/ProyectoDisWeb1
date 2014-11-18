/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ControlEmpresa extends ActionSupport implements ModelDriven<Object>{    
    Session session;
    private Empresa empresa = new Empresa();
    /*
    private File fondoImagen;
    private String fondoImagenFileName;
    private String fondoImagenContentType;
    */
    /*
    public String uploadFile() throws Exception{
        System.out.println("Almacenando archivo");
        
        System.out.println("PRUEBA" + savedFile.getAbsolutePath() + " - " + savedFile.getName() + " - " + savedFile.getPath());
        System.out.println("Archivo almacenado");
        return SUCCESS;
    */
    public String agregaDatos() throws Exception{
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            
            tx = session.beginTransaction();
            /*
            //INICIO DE SUBIR IMAGEN
            
            ServletContext servletContext = ServletActionContext.getServletContext();
            String directorio = servletContext.getRealPath("/img");
            File savedFile = new File(directorio,getFondoImagenFileName());
            getFondoImagen().renameTo(savedFile);
            FileUtils.copyFile(this.getFondoImagen(), savedFile);
            //FIN DE SUBIR IMAGEN +savedFile.getName()
            */
            //if (empresa.getFondoColor() == null) {
            //empresa.setFondoImagen("img/");
            //}else{
                //empresa.setFondoImagen(null);
            //}
            String borrar = session.createQuery("select empresa.nombreEmpresa from Empresa empresa").list().get(0).toString();
            Empresa employee = (Empresa)session.get(Empresa.class, borrar);
            session.delete(employee);
            tx.commit();
            tx = session.beginTransaction();
            session.save(getEmpresa());
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
   
    @Override
    public Object getModel() {
        return empresa;
    }
    
}
