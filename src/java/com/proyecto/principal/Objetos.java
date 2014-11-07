/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

/**
 *
 * @author ferna_000
 */
public class Objetos {
    private Articulo articulo = new Articulo();
    private Articulosucursal articuloSucursal = new Articulosucursal();
    private ArticulosucursalId articuloSucursalId = new ArticulosucursalId();
    private Categoria categoria = new Categoria();
    private Comentarios comentarios = new Comentarios();
    private Sucursal sucursal = new Sucursal();
    private Usuario usuario = new Usuario();

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Articulosucursal getArticuloSucursal() {
        return articuloSucursal;
    }

    public void setArticuloSucursal(Articulosucursal articuloSucursal) {
        this.articuloSucursal = articuloSucursal;
    }

    public ArticulosucursalId getArticuloSucursalId() {
        return articuloSucursalId;
    }

    public void setArticuloSucursalId(ArticulosucursalId articuloSucursalId) {
        this.articuloSucursalId = articuloSucursalId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentarios comentarios) {
        this.comentarios = comentarios;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
