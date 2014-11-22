package com.proyecto.principal;
// Generated 21/11/2014 10:23:50 PM by Hibernate Tools 4.3.1



/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private String nombreEmpresa;
     private String fondoImagen;
     private String banner;
     private String logo;
     private String orientacion;

    public Empresa() {
    }

	
    public Empresa(String nombreEmpresa, String orientacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.orientacion = orientacion;
    }
    public Empresa(String nombreEmpresa, String fondoImagen, String banner, String logo, String orientacion) {
       this.nombreEmpresa = nombreEmpresa;
       this.fondoImagen = fondoImagen;
       this.banner = banner;
       this.logo = logo;
       this.orientacion = orientacion;
    }
   
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getFondoImagen() {
        return this.fondoImagen;
    }
    
    public void setFondoImagen(String fondoImagen) {
        this.fondoImagen = fondoImagen;
    }
    public String getBanner() {
        return this.banner;
    }
    
    public void setBanner(String banner) {
        this.banner = banner;
    }
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getOrientacion() {
        return this.orientacion;
    }
    
    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }




}


