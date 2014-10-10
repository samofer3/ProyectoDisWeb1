package com.proyecto.principal;
// Generated 9/10/2014 09:43:16 PM by Hibernate Tools 4.3.1



/**
 * ArticulosucursalId generated by hbm2java
 */
public class ArticulosucursalId  implements java.io.Serializable {


     private int articuloIdArticulo;
     private int sucursalIdSucursal;

    public ArticulosucursalId() {
    }

    public ArticulosucursalId(int articuloIdArticulo, int sucursalIdSucursal) {
       this.articuloIdArticulo = articuloIdArticulo;
       this.sucursalIdSucursal = sucursalIdSucursal;
    }
   
    public int getArticuloIdArticulo() {
        return this.articuloIdArticulo;
    }
    
    public void setArticuloIdArticulo(int articuloIdArticulo) {
        this.articuloIdArticulo = articuloIdArticulo;
    }
    public int getSucursalIdSucursal() {
        return this.sucursalIdSucursal;
    }
    
    public void setSucursalIdSucursal(int sucursalIdSucursal) {
        this.sucursalIdSucursal = sucursalIdSucursal;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ArticulosucursalId) ) return false;
		 ArticulosucursalId castOther = ( ArticulosucursalId ) other; 
         
		 return (this.getArticuloIdArticulo()==castOther.getArticuloIdArticulo())
 && (this.getSucursalIdSucursal()==castOther.getSucursalIdSucursal());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getArticuloIdArticulo();
         result = 37 * result + this.getSucursalIdSucursal();
         return result;
   }   


}


