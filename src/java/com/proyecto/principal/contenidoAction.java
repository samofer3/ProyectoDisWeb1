/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

/**
 *
 * @author ferna_000
 */
public class contenidoAction extends ActionSupport{
    private String contenido = "";

    public void generarContenido(ArrayList<Articulo> articulos){
        contenido = crearContenido(articulos);
    }
    
    public String crearContenido(ArrayList<Articulo> articulos){
        StringBuffer contenido = new StringBuffer();
        
        for (Articulo articulo : articulos) {
            contenido.append((String)"<article>\n");
            contenido.append((String)"\t<h2>" + articulo.getNombreArticulo() + "</h2>\n");
            contenido.append((String)"\t<figure>\n");
            contenido.append((String)"\t\t<img src='img/Logo.png' alt='" + articulo.getNombreArticulo() + "' class='escale'>\n");
            contenido.append((String)"\t</figure>\n");
            contenido.append((String)"\t<div class='a-texto'>\n");
            contenido.append((String)"\t\t<p><strong>Descripción:</strong>" + articulo.getDescripcion() + "</p>\n");
            contenido.append((String)"\t\t<p><strong>Precio:</strong> $" + articulo.getPrecio() + "</p>\n");
            contenido.append((String)"\t\t<p><strong>Disponibilidad:</strong> 120</p>\n");
            contenido.append((String)"\t\t<p><strong>Sucursal:</strong> <a href='#'>Ver sucursales</a></p>\n");
            contenido.append((String)"\t</div>\n");
            contenido.append((String)"</article>\n");
        }
        
        return new String (contenido);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
