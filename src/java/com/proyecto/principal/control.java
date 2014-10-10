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
public class control extends ActionSupport{
    private String menu;
    private String contenido;
    private menuAction menuAction = new menuAction(); //GENERA EL MENU DE LA IZQUIERDA
    private contenidoAction contenidoAction = new contenidoAction(); //GENERA EL CONTENIDO DE LOS ARTICULOS
    public String principal(){
        menuAction.generarMenu();
        menu = menuAction.getMenu();
        contenidoAction.generarContenido();
        contenido = contenidoAction.getContenido();
        return SUCCESS;
    }
    public String administrar(){
        menuAction.generarMenuAdministrador();
        menu = menuAction.getMenu();
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
    
    
}