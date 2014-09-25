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
public class contenidoAction extends ActionSupport{
    private String contenido = "";

    public void generarContenido(){
        for (int i = 1; i < 13; i++) {
            contenido+= "<article>\n";
            contenido+= "\t<h2>Articulo " + i + "</h2>\n";
            contenido+= "\t<figure>\n";
            contenido+= "\t\t<img src='img/Logo.png' alt='Articulo " + i + "' class='escale'>\n";
            contenido+= "\t</figure>\n";
            contenido+= "\t<div class='a-texto'>\n";
            contenido+= "\t\t<p><strong>Descripción:</strong> 128 PAQUETES CON 3 CUBOS DE AZUCAR REFINADA CADA UNO, PESO 1 KG</p>\n";
            contenido+= "\t\t<p><strong>Precio:</strong> $123.45</p>\n";
            contenido+= "\t\t<p><strong>Disponibilidad:</strong> 120</p>\n";
            contenido+= "\t\t<p><strong>Sucursal:</strong> <a href='#'>Ver sucursales</a></p>\n";
            contenido+= "\t</div>\n";
            contenido+= "</article>\n";
        }
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
