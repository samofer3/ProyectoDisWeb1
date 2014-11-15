package com.proyecto.principal;
// Generated 14/11/2014 11:26:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Articulo generated by hbm2java
 */
public class Articulo  implements java.io.Serializable {


     private Integer idArticulo;
     private Categoria categoria;
     private String nombreArticulo;
     private String descripcion;
     private String direccionImg;
     private float precio;
     private String fecha;
     private Set<Articulosucursal> articulosucursals = new HashSet<Articulosucursal>(0);
     private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);

    public Articulo() {
    }

	
    public Articulo(Categoria categoria, String nombreArticulo, String descripcion, String direccionImg, float precio, String fecha) {
        this.categoria = categoria;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.direccionImg = direccionImg;
        this.precio = precio;
        this.fecha = fecha;
    }
    public Articulo(Categoria categoria, String nombreArticulo, String descripcion, String direccionImg, float precio, String fecha, Set<Articulosucursal> articulosucursals, Set<Comentarios> comentarioses) {
       this.categoria = categoria;
       this.nombreArticulo = nombreArticulo;
       this.descripcion = descripcion;
       this.direccionImg = direccionImg;
       this.precio = precio;
       this.fecha = fecha;
       this.articulosucursals = articulosucursals;
       this.comentarioses = comentarioses;
    }
   
    public Integer getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNombreArticulo() {
        return this.nombreArticulo;
    }
    
    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDireccionImg() {
        return this.direccionImg;
    }
    
    public void setDireccionImg(String direccionImg) {
        this.direccionImg = direccionImg;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Set<Articulosucursal> getArticulosucursals() {
        return this.articulosucursals;
    }
    
    public void setArticulosucursals(Set<Articulosucursal> articulosucursals) {
        this.articulosucursals = articulosucursals;
    }
    public Set<Comentarios> getComentarioses() {
        return this.comentarioses;
    }
    
    public void setComentarioses(Set<Comentarios> comentarioses) {
        this.comentarioses = comentarioses;
    }




}


