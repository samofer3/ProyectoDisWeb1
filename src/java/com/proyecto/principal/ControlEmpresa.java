/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.principal;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ferna_000
 */
public class ControlEmpresa extends ActionSupport implements ServletContextAware{    
    Session session;
    private Empresa empresa = new Empresa();
    private File banner;
    private String bannerContentType;
    private String bannerFileName;
    private String bannerPath;
    private File logo;
    private String logoContentType;
    private String logoFileName;
    private String logoPath;
    private ServletContext context;

    public String agregaDatos() throws Exception{
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            
            tx = session.beginTransaction();
            Empresa vieja = (Empresa)session.createQuery("from Empresa empresa").list().get(0);
            String nombreRespaldo = vieja.getNombreEmpresa();
            String bannerRespaldo = vieja.getBanner();
            String logoRespaldo = vieja.getLogo();
            String fondoRespaldo = vieja.getFondoImagen();
            Empresa employee = (Empresa)session.get(Empresa.class, nombreRespaldo);
            session.delete(employee);
            tx.commit();
            tx = session.beginTransaction();
            if (empresa.getNombreEmpresa().equals("")) {empresa.setNombreEmpresa(nombreRespaldo);}
            if (empresa.getFondoImagen() == null) {empresa.setFondoImagen(fondoRespaldo);}
            if (banner != null) {
                if (bannerContentType.equals("image/jpeg")) {
                    setBannerFileName("Banner.jpg");
                }else{
                    setBannerFileName("Banner.png");
                }
                FilesUtil.saveFile(getBanner(), getBannerFileName(), context.getRealPath("") + File.separator + bannerPath);
                empresa.setBanner(bannerPath + "/" + getBannerFileName());
            }else{
                empresa.setBanner(bannerRespaldo);
            }
            if (logo != null) {
                if (logoContentType.equals("image/jpeg")) {
                    setLogoFileName("Logo.jpg");
                }else{
                    setLogoFileName("Logo.png");
                }
                FilesUtil.saveFile(getLogo(), getLogoFileName(), context.getRealPath("") + File.separator + logoPath);
                empresa.setLogo(logoPath + "/" + getBannerFileName());
            }else{
                empresa.setLogo(logoRespaldo);
            }
            session.save(empresa);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return SUCCESS;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public File getBanner() {
        return banner;
    }

    public void setBanner(File banner) {
        this.banner = banner;
    }

    public String getBannerContentType() {
        return bannerContentType;
    }

    public void setBannerContentType(String bannerContentType) {
        this.bannerContentType = bannerContentType;
    }

    public String getBannerFileName() {
        return bannerFileName;
    }

    public void setBannerFileName(String bannerFileName) {
        this.bannerFileName = bannerFileName;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }
    
    @Override
    public void setServletContext(ServletContext ctx) {
        this.context=ctx;
    }

}
