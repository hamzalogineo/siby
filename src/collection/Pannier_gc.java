/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author hp
 */
public class Pannier_gc {
    
    private Integer id_p;
    private String cb ;
    private String description ;
    private double qte;
    private Integer pu;
    private double mtt ;
    private String cl ;
    
    public Pannier_gc(){}
    
    public Pannier_gc(Integer id_p, String cb, String description, double qte, Integer pu, double mtt, String cl){
        
        this.id_p = id_p ;
        this.cb = cb ;
        this.description = description ;
        this.qte = qte;
        this.pu = pu ;
        this.mtt = mtt ;
        this.cl = cl ;
        
        }
    
    
    public Integer getId_p(){
        return this.id_p ;
    }
    
    public void setId_p(Integer id_p){
        this.id_p = id_p ;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public Integer getPu() {
        return pu;
    }

    public void setPu(Integer pu) {
        this.pu = pu;
    }

    public double getMtt() {
        return mtt;
    }

    public void setMtt(double mtt) {
        this.mtt = mtt;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }
    
    
    
    
    
    
    
    
    
}
