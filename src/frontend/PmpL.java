/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author HAMZA
 */
public class PmpL {
    
    String article ;
    long pa ;
    long pv ;
    
    public PmpL(){}

    public PmpL(String article, long pa, long pv) {
        this.article = article;
        this.pa = pa;
        this.pv = pv;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public long getPa() {
        return pa;
    }

    public void setPa(long pa) {
        this.pa = pa;
    }

    public long getPv() {
        return pv;
    }

    public void setPv(long pv) {
        this.pv = pv;
    }
    
    
    
    
    
}
