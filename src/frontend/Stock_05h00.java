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
public class Stock_05h00 {
    
    private String mag;
    private String f;
    private String sf;
    private long ref ;
    private String descrip;
    private long stock;
    private long pu;
    private long montant;
    
    public Stock_05h00(){}

    public Stock_05h00(String mag, String f, String sf, long ref, String descrip, long stock, long pu, long montant) {
        this.mag = mag;
        this.f = f;
        this.sf = sf;
        this.ref = ref;
        this.descrip = descrip;
        this.stock = stock;
        this.pu = pu;
        this.montant = montant;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getPu() {
        return pu;
    }

    public void setPu(long pu) {
        this.pu = pu;
    }

    public long getMontant() {
        return montant;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }
    
    
    
}
