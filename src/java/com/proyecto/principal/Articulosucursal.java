package com.proyecto.principal;
// Generated 6/11/2014 09:41:35 PM by Hibernate Tools 4.3.1



/**
 * Articulosucursal generated by hbm2java
 */
public class Articulosucursal  implements java.io.Serializable {


     private ArticulosucursalId id;
     private Articulo articulo;
     private Sucursal sucursal;
     private int unidad;

    public Articulosucursal() {
    }

    public Articulosucursal(ArticulosucursalId id, Articulo articulo, Sucursal sucursal, int unidad) {
       this.id = id;
       this.articulo = articulo;
       this.sucursal = sucursal;
       this.unidad = unidad;
    }
   
    public ArticulosucursalId getId() {
        return this.id;
    }
    
    public void setId(ArticulosucursalId id) {
        this.id = id;
    }
    public Articulo getArticulo() {
        return this.articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public int getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }




}


