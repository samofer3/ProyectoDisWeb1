/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author ferna_000
 */
public class LogoutAction extends ActionSupport implements SessionAware{
    private Map<String,Object> session;
    
    @Override
    public void setSession (Map<String,Object> session){
        this.session = session;
    }
    
    @Override
    public String execute(){
        session.remove("user");
        return SUCCESS;
    }
    
}
