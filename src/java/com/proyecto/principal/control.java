/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class control extends ActionSupport{
    Session session;
    private String menu;
    private String contenido;
    private menuAction menuAction = new menuAction(); //GENERA EL MENU DE LA IZQUIERDA
    private contenidoAction contenidoAction = new contenidoAction(); //GENERA EL CONTENIDO DE LOS ARTICULOS
    private String nombreEmpresa;
    private String orientacion;
    
    public String obtenerTitulo(){
        String resultado = "";
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            resultado = session.createQuery("select empresa.nombreEmpresa from Empresa empresa").list().get(0).toString();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return resultado;
    }
    
    public String obtenerOrientacion(){
        String resultado = "";
        session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            resultado = session.createQuery("select empresa.orientacion from Empresa empresa").list().get(0).toString();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return resultado;
    }
    
    
    public String principal(){
        menuAction.generarMenu();
        menu = menuAction.getMenu();
        contenidoAction.generarContenido();
        contenido = contenidoAction.getContenido();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerOrientacion();
        return SUCCESS;
    }
    public String administrar(){
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerOrientacion();
        return SUCCESS;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    
}