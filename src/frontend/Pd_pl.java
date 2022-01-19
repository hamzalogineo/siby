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
public class Pd_pl {
    
    String arriver ;
    String description ;
    float pu_p ;
    int qte ;
    
    public Pd_pl(){
        
    }

    public Pd_pl(String arriver, String description, float pu_p, int qte) {
        this.arriver = arriver;
        this.description = description;
        this.pu_p = pu_p;
        this.qte = qte;
    }

    public String getArriver() {
        return arriver;
    }

    public void setArriver(String arriver) {
        this.arriver = arriver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPu_p() {
        return pu_p;
    }

    public void setPu_p(float pu_p) {
        this.pu_p = pu_p;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    
    
    
    
    
}
