/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author ferna_000
 */
public class menuAction extends ActionSupport{
    private String menu ="";
    
    public void generarMenuAdministrador() {
        menu= "";
        menu += "<li><a href='index'>Inicio</a></li>\n";
        menu += "\t\t\t\t<li><a href='sucursal'>Administrar Sucursal</a></li>\n";
        menu += "\t\t\t\t<li><a href='#'>Administrar Articulos</a></li>\n";
        menu += "\t\t\t\t<li><a href='#'>Administrar Categorias</a></li>\n";
        menu += "\t\t\t\t<li><a href='empresa'>Administrar Pagina</a></li>\n";
        menu += "\t\t\t\t<li><a href='#'>Administrar Usuarios</a></li>\n";
        menu += "\t\t\t\t</br>\n";
        menu += "\t\t\t\t</br>\n";
        menu += "\t\t\t\t<li class='center'><a href='logout' >Salir</a></li>\n";
    }
    

    public void generarMenu() {
        menu = "";
        menu += "<li><a href='index'>Inicio</a></li>\n";
        for (int i = 1; i < 11; i++) {
            menu += "\t\t\t\t<li><a href='#'>Opcion "+ i +"</a></li>\n";
        }
        menu += "\t\t\t\t</br>\n";
        menu += "\t\t\t\t</br>\n";
        menu += "\t\t\t\t<li class='center'><a href='login' >Administrar</a></li>\n";
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
