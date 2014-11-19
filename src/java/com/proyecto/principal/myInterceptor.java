/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.Action;
import static com.opensymphony.xwork2.Action.LOGIN;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author ferna_000
 */
public class myInterceptor implements Interceptor{

    @Override
    public void destroy() {}

    @Override
    public void init() {}

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map<String,Object> sessionAttributes = ai.getInvocationContext().getSession();
        User user = (User) sessionAttributes.get("user");
        if(user == null){
            return LOGIN;
        }
        else{
            Action action=(Action) ai.getAction();
            if(action instanceof UserAware){((UserAware)action).setUser(user);}
            return ai.invoke();
        }
    }
}