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
public class menuAction extends ActionSupport {
    Session session;
    private String menu;
    private ArrayList<Categoria> listaCategorias;

    public void generarMenuAdministrador() {
        menu = crearMenuAdministrador();
    }

    public String crearMenuAdministrador() {
        StringBuffer menu = new StringBuffer();

        menu.append((String) "<li><a href='index'>Inicio</a></li>\n");
        menu.append((String) "\t\t\t\t<li><a href='sucursal'>Administrar Sucursal</a></li>\n");
        menu.append((String) "\t\t\t\t<li><a href='#'>Administrar Articulos</a></li>\n");
        menu.append((String) "\t\t\t\t<li><a href='categoria'>Administrar Categorias</a></li>\n");
        menu.append((String) "\t\t\t\t<li><a href='empresa'>Administrar Pagina</a></li>\n");
        menu.append((String) "\t\t\t\t<li><a href='#'>Administrar Usuarios</a></li>\n");
        menu.append((String) "\t\t\t\t</br>\n");
        menu.append((String) "\t\t\t\t</br>\n");
        menu.append((String) "\t\t\t\t<li class='center'><a href='logout' >Salir</a></li>\n");

        return new String(menu);
    }

    public void generarMenu() {
        menu = crearMenu();
    }

    public String crearMenu() {
        StringBuffer menu = new StringBuffer();

        menu.append((String) "<li><a href='articulos.action?idCategoria=-1'>Recientes</a></li>\n");
        listaCategorias = listadoCategorias();
        for (Categoria listaCategoria : listaCategorias) {
            menu.append((String) "\t\t\t\t<li><a href='articulos.action?idCategoria="
                    + listaCategoria.getIdCategoria() + "'>"
                    + listaCategoria.getNombreCategoria() + "</a></li>\n");
        }
        menu.append((String) "\t\t\t\t</br>\n");
        menu.append((String) "\t\t\t\t</br>\n");
        menu.append((String) "\t\t\t\t<li class='center'><a href='login' >Administrar</a></li>\n");

        return new String(menu);
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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
