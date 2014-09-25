package com.proyecto.principal;

import com.opensymphony.xwork2.*;
public class loginAction extends ActionSupport{
    private String user;
    private String password;
    
    @Override
    public String execute(){
        if((user.equals("usuario")&& password.equals("12345")) ||
                (user.equals("admin")&& password.equals("amin")) ||
                (user.equals("usuario")&& password.equals("password")) || 
                user.equals("vanessa")&& password.equals("root") ||
                user.equals("ceo")&& password.equals("ceo")
                ){
            return SUCCESS;//"success"
        
        } else{
            addFieldError("user","Usuario no valido");
            addFieldError("password","Y/O password no valido");            
            return INPUT;//"error" ERROR 
        }
    }
    @Override
    public void validate(){
        if(user.equals("")){
            addFieldError("user","El campo usuario no debe estar vacio");
        }
        if(password.equals("")){
            addFieldError("password","Digite password por favor");
        }
    }
    

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pwd
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the pwd to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
