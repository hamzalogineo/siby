/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

/**
 *
 * @author HAMZA
 */
public class FactElem {
    
    private String description ;
    private long qte;
    
    public FactElem(){
        
    }

    public FactElem(String description, long qte) {
        this.description = description;
        this.qte = qte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }
    
    
    
    
}
