package com.proyecto.principal;

import com.opensymphony.xwork2.*;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class loginAction extends ActionSupport implements SessionAware, ModelDriven<User>{
    private User user = new User();
    private Map<String,Object> sessionAttributes = null;
    
    @Override
    public String execute(){
            if("usuario".equals(user.getUser()) && "12345".equals(user.getPassword()) ||
                "admin".equals(user.getUser()) && "admin".equals(user.getPassword()) ||
                "usuario".equals(user.getUser()) && "password".equals(user.getPassword()) ||
                "vanessa".equals(user.getUser()) && "root".equals(user.getPassword()) ||
                "ceo".equals(user.getUser()) && "ceo".equals(user.getPassword())){
                sessionAttributes.put("USER", user);
                return "success";
            } else{
                addFieldError("user","Usuario y/o Password no valido");
                return "input"; 
            }
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
    
}
