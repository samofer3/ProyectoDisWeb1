/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class control extends ActionSupport {

    Session session;
    private String menu;
    private menuAction menuAction = new menuAction(); //GENERA EL MENU DE LA IZQUIERDA
    private String nombreEmpresa;
    private String orientacion;
    private String fondoBody;
    private String logoDB;
    private String bannerDB;
    private String idCategoria; //Evitar errores de uso GET
    private String displayFormulario = "displayNone";
    private ArrayList<Sucursal> listaSucursales;
    private ArrayList<Categoria> listaCategorias;
    private ArrayList<Usuario> listaUsuarios;

    public String obtenerTitulo() {
        String resultado = "";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            resultado = session.createQuery("select empresa.nombreEmpresa from Empresa empresa").list().get(0).toString();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultado;
    }

    public Empresa obtenerValoresEmpresa() {
        Empresa resultado = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            resultado = (Empresa)session.createQuery("from Empresa empresa").list().get(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultado;
    }

    public ArrayList<Sucursal> listadoSucursales() {
        ArrayList<Sucursal> nombreLista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            nombreLista = (ArrayList<Sucursal>) session.createQuery("from Sucursal").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreLista;
    }

    public ArrayList<Categoria> listadoCategorias() {
        ArrayList<Categoria> nombreLista = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            nombreLista = (ArrayList<Categoria>) session.createQuery("from Categoria").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreLista;
    }
    
    public ArrayList<Usuario> listadoUsuarios() {
        ArrayList<Usuario> nombreLista = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            nombreLista = (ArrayList<Usuario>) session.createQuery("from Usuario").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nombreLista;
    }

    public String principal() {
        menuAction.generarMenu();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerValoresEmpresa().getOrientacion();
        fondoBody = obtenerValoresEmpresa().getFondoImagen();
        logoDB = obtenerValoresEmpresa().getLogo();
        bannerDB = obtenerValoresEmpresa().getBanner();
        return SUCCESS;
    }

    public String administrar() {
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerValoresEmpresa().getOrientacion();
        fondoBody = obtenerValoresEmpresa().getFondoImagen();
        logoDB = obtenerValoresEmpresa().getLogo();
        bannerDB = obtenerValoresEmpresa().getBanner();
        return SUCCESS;
    }

    public String administrarSucursal() {
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerValoresEmpresa().getOrientacion();
        fondoBody = obtenerValoresEmpresa().getFondoImagen();
        logoDB = obtenerValoresEmpresa().getLogo();
        bannerDB = obtenerValoresEmpresa().getBanner();
        listaSucursales = this.listadoSucursales();
        return SUCCESS;
    }

    public String administrarCategoria() {
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerValoresEmpresa().getOrientacion();
        fondoBody = obtenerValoresEmpresa().getFondoImagen();
        logoDB = obtenerValoresEmpresa().getLogo();
        bannerDB = obtenerValoresEmpresa().getBanner();
        listaCategorias = this.listadoCategorias();
        return SUCCESS;
    }

    public String administrarUsuario() {
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
        nombreEmpresa = obtenerTitulo();
        orientacion = obtenerValoresEmpresa().getOrientacion();
        fondoBody = obtenerValoresEmpresa().getFondoImagen();
        logoDB = obtenerValoresEmpresa().getLogo();
        bannerDB = obtenerValoresEmpresa().getBanner();
        listaSucursales = this.listadoSucursales();
        listaUsuarios = this.listadoUsuarios();
        return SUCCESS;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
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

    public ArrayList<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public menuAction getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(menuAction menuAction) {
        this.menuAction = menuAction;
    }

    public String getDisplayFormulario() {
        return displayFormulario;
    }

    public void setDisplayFormulario(String displayFormulario) {
        this.displayFormulario = displayFormulario;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getFondoBody() {
        return fondoBody;
    }

    public void setFondoBody(String fondoBody) {
        this.fondoBody = fondoBody;
    }

    public String getLogoDB() {
        return logoDB;
    }

    public void setLogoDB(String logoDB) {
        this.logoDB = logoDB;
    }

    public String getBannerDB() {
        return bannerDB;
    }

    public void setBannerDB(String bannerDB) {
        this.bannerDB = bannerDB;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

}
