/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function ()
{
    var permiso = document.getElementById("permiso");
    permiso.onchange = enviar;

    function enviar() {
        var sucursal = document.getElementById("sucursal");
        if (permiso.value == 3) {
            sucursal.disabled = "true";
        }else{
            sucursal.removeAttribute("disabled");
        }
    }
};