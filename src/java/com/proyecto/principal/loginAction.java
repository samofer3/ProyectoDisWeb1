package com.proyecto.principal;

import com.opensymphony.xwork2.*;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class loginAction extends ActionSupport implements SessionAware, ModelDriven<User>{
    Session session;
    private User user = new User();
    private char permiso;
    private Map<String,Object> sessionAttributes = null;
    
    @Override
    public String execute(){
            if(isValidUser(user)){
                sessionAttributes.put("user", user);
                return "success";
            } else{
                addFieldError("user","Usuario y/o Password no valido");
                return "input"; 
            }
    }
    
    public boolean isValidUser(User user){
        ArrayList<Usuario> usuario = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            usuario = (ArrayList<Usuario>)session.createQuery("from Usuario").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        for (Usuario usuario1 : usuario) {
            if (usuario1.getNombreUsuario().equals(user.getUser()) && 
                    usuario1.getPassword().equals(user.getPassword())) {
                permiso = usuario1.getPermiso();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void validate(){
        if("".equals(user.getUser())){
            addFieldError("user","Se requiere un usuario");
        }
        
        if("".equals(user.getPassword())){
            addFieldError("pwd","Se requiere un password");
        }
    }
    
    
    public void getSession(Map<String,Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionAttributes = map;
    }

    public Map<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public void setSessionAttributes(Map<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
    
}
