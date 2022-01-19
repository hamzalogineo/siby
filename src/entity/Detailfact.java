package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * Detailfact generated by hbm2java
 */
public class Detailfact  implements java.io.Serializable {


     private Long id;
     private Integer n;
     private String cl;
     private String desi;
     private Long qte;
     private Long pu;
     private Long montant;
     private Integer reprise;

    public Detailfact() {
    }

    public Detailfact(Integer n, String cl, String desi, Long qte, Long pu, Long montant, Integer reprise) {
       this.n = n;
       this.cl = cl;
       this.desi = desi;
       this.qte = qte;
       this.pu = pu;
       this.montant = montant;
       this.reprise = reprise;
    }

    public Detailfact(Long id, Integer n, String cl, String desi, Long qte, Long pu, Long montant, Integer reprise) {
        this.id = id;
        this.n = n;
        this.cl = cl;
        this.desi = desi;
        this.qte = qte;
        this.pu = pu;
        this.montant = montant;
        this.reprise = reprise;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getN() {
        return this.n;
    }
    
    public void setN(Integer n) {
        this.n = n;
    }
    public String getCl() {
        return this.cl;
    }
    
    public void setCl(String cl) {
        this.cl = cl;
    }
    public String getDesi() {
        return this.desi;
    }
    
    public void setDesi(String desi) {
        this.desi = desi;
    }
    public Long getQte() {
        return this.qte;
    }
    
    public void setQte(Long qte) {
        this.qte = qte;
    }
    public Long getPu() {
        return this.pu;
    }
    
    public void setPu(Long pu) {
        this.pu = pu;
    }
    public Long getMontant() {
        return this.montant;
    }
    
    public void setMontant(Long montant) {
        this.montant = montant;
    }
    public Integer getReprise() {
        return this.reprise;
    }
    
    public void setReprise(Integer reprise) {
        this.reprise = reprise;
    }




}


