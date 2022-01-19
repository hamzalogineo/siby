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
public class Articles {
    private String magasin ;
    private String desi ;
    private long stock ;
    private long prx ;
    private long qte ;
    private long mtt ;
    
    public Articles(){
        
    }

    public Articles(String magasin, String desi, long stock, long prx, long qte, long mtt) {
        this.magasin = magasin;
        this.desi = desi;
        this.stock = stock;
        this.prx = prx;
        this.qte = qte;
        this.mtt = mtt;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public String getDesi() {
        return desi;
    }

    public void setDesi(String desi) {
        this.desi = desi;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getPrx() {
        return prx;
    }

    public void setPrx(long prx) {
        this.prx = prx;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }

    public long getMtt() {
        return mtt;
    }

    public void setMtt(long mtt) {
        this.mtt = mtt;
    }
    
    
            
    
}
