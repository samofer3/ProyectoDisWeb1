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
        System.out.println("CREARCONTENIDO");
        //for (Articulo articulo : articulos) {
        //System.out.println("PRUEBA 0"+articulos.get(0).getNombreArticulo());
        /*
        for(int i = 0; i < articulos.size();i++){
            contenido.append((String)"<article>\n");
            contenido.append((String)"\t<h2>" + articulos.get(i).getNombreArticulo() + "</h2>\n");
            contenido.append((String)"\t<figure>\n");
            contenido.append((String)"\t\t<img src='img/Logo.png' alt='" + articulos.get(i).getNombreArticulo() + "' class='escale'>\n");
            contenido.append((String)"\t</figure>\n");
            contenido.append((String)"\t<div class='a-texto'>\n");
            contenido.append((String)"\t\t<p><strong>Descripción:</strong>" + articulos.get(i).getDescripcion() + "</p>\n");
            contenido.append((String)"\t\t<p><strong>Precio:</strong> $" + articulos.get(i).getPrecio() + "</p>\n");
            contenido.append((String)"\t\t<p><strong>Disponibilidad:</strong> 120</p>\n");
            contenido.append((String)"\t\t<p><strong>Sucursal:</strong> <a href='#'>Ver sucursales</a></p>\n");
            contenido.append((String)"\t</div>\n");
            contenido.append((String)"</article>\n");
                
        }
*/
        return new String (contenido);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
