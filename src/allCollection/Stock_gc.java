/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allCollection;


public class Stock_gc {
    
    
    private int id ;
    private String cb ;
    private String description ;
    private int pa ;
    private int qte ;
    private double mtt ;
    
    public Stock_gc(){}
    
    public Stock_gc(int id, String cb, String description, int pa, int qte, double mtt){
        this.id = id ;
        this.cb = cb ;
        this.description = description ;
        this.pa = pa ;
        this.qte = qte ;
        this.mtt = mtt ;
        
    }
    
    
    public void setId(int id){
        this.id = id ;
    }
    
    public int getId(){
        return this.id ;
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

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getMtt() {
        return mtt;
    }

    public void setMtt(double mtt) {
        this.mtt = mtt;
    }
    
    
    
    
    
}
