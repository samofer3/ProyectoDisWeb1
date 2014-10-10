/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ControlSucursal extends ActionSupport implements ModelDriven<Object>{    
    Session session;
    private Sucursal sucursal = new Sucursal();
    
    public String agregaSucursal(){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer sucursalidSucursal = null;
        try{
            tx = session.beginTransaction();
            sucursalidSucursal = (Integer) session.save(getSucursal());
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public Object getModel() {
        return sucursal;
    }
}
