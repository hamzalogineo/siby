/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author IDRIS
 */
public class Bon {
    
    String desi ;
    Long total ;
    int qte ;
    int pu ;
    int montant ;

    public Bon() {
    }

    public Bon(String desi, Long total, int qte, int pu, int montant) {
        this.desi = desi;
        this.total = total;
        this.qte = qte;
        this.pu = pu;
        this.montant = montant;
    }

    public String getDesi() {
        return desi;
    }

    public void setDesi(String desi) {
        this.desi = desi;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    
}
