package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * Facturef generated by hbm2java
 */
public class Facturef  implements java.io.Serializable {


     private Long id;
     private Integer n;
     private String cl;
     private String dtc;
     private Long montant;
     private String util;
     private Integer remise;
     private Long mttr;
     private Long reliqat;
     private String type;

    public Facturef() {
    }

    public Facturef(Integer n, String cl, String dtc, Long montant, String util, Integer remise, Long mttr, Long reliqat, String type) {
       this.n = n;
       this.cl = cl;
       this.dtc = dtc;
       this.montant = montant;
       this.util = util;
       this.remise = remise;
       this.mttr = mttr;
       this.reliqat = reliqat;
       this.type = type;
    }

    public Facturef(Long id, Integer n, String cl, String dtc, Long montant, String util, Integer remise, Long mttr, Long reliqat, String type) {
        this.id = id;
        this.n = n;
        this.cl = cl;
        this.dtc = dtc;
        this.montant = montant;
        this.util = util;
        this.remise = remise;
        this.mttr = mttr;
        this.reliqat = reliqat;
        this.type = type;
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
    public String getDtc() {
        return this.dtc;
    }
    
    public void setDtc(String dtc) {
        this.dtc = dtc;
    }
    public Long getMontant() {
        return this.montant;
    }
    
    public void setMontant(Long montant) {
        this.montant = montant;
    }
    public String getUtil() {
        return this.util;
    }
    
    public void setUtil(String util) {
        this.util = util;
    }
    public Integer getRemise() {
        return this.remise;
    }
    
    public void setRemise(Integer remise) {
        this.remise = remise;
    }
    public Long getMttr() {
        return this.mttr;
    }
    
    public void setMttr(Long mttr) {
        this.mttr = mttr;
    }
    public Long getReliqat() {
        return this.reliqat;
    }
    
    public void setReliqat(Long reliqat) {
        this.reliqat = reliqat;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


