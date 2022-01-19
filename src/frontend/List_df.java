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
public class List_df {
    private String desi;
    private long qte;
    
    public List_df(){
        
    }
    
    public List_df(String desi, long qte){
        this.desi = desi;
        this.qte = qte;
    }
    
    public String getDesi(){
        return this.desi ;
       
    }
    
    public void setDesi(String desi){
        this.desi = desi ;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }
    
    
    
    
    
}
