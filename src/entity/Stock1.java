package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Stock1 generated by hbm2java
 */
public class Stock1  implements java.io.Serializable {


     private Long id;
     private String f;
     private String sf;
     private String cb;
     private String desi;
     private Long pa;
     private Long pv;
     private Long qteet;
     private Long qtest;
     private Long stock;
     private String four;
     private String maga;
     private String admin;
     private Date datec;
     private Date dateExpi;
     private Date dateExpiMoins15;
     private Long idpro;

    public Stock1() {
    }

    public Stock1(String f, String sf, String cb, String desi, Long pa, Long pv, Long qteet, Long qtest, Long stock, String four, String maga, String admin, Date datec, Date dateExpi, Date dateExpiMoins15, Long idpro) {
       this.f = f;
       this.sf = sf;
       this.cb = cb;
       this.desi = desi;
       this.pa = pa;
       this.pv = pv;
       this.qteet = qteet;
       this.qtest = qtest;
       this.stock = stock;
       this.four = four;
       this.maga = maga;
       this.admin = admin;
       this.datec = datec;
       this.dateExpi = dateExpi;
       this.dateExpiMoins15 = dateExpiMoins15;
       this.idpro = idpro ;
    }

    public Stock1(Long id, String f, String sf, String cb, String desi, Long pa, Long pv, Long qteet, Long qtest, Long stock, String four, String maga, String admin, Date datec, Date dateExpi, Date dateExpiMoins15, Long idpro) {
        this.id = id;
        this.f = f;
        this.sf = sf;
        this.cb = cb;
        this.desi = desi;
        this.pa = pa;
        this.pv = pv;
        this.qteet = qteet;
        this.qtest = qtest;
        this.stock = stock;
        this.four = four;
        this.maga = maga;
        this.admin = admin;
        this.datec = datec;
        this.dateExpi = dateExpi;
        this.dateExpiMoins15 = dateExpiMoins15;
        this.idpro = idpro;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getF() {
        return this.f;
    }
    
    public void setF(String f) {
        this.f = f;
    }
    public String getSf() {
        return this.sf;
    }
    
    public void setSf(String sf) {
        this.sf = sf;
    }
    public String getCb() {
        return this.cb;
    }
    
    public void setCb(String cb) {
        this.cb = cb;
    }
    public String getDesi() {
        return this.desi;
    }
    
    public void setDesi(String desi) {
        this.desi = desi;
    }
    public Long getPa() {
        return this.pa;
    }
    
    public void setPa(Long pa) {
        this.pa = pa;
    }
    public Long getPv() {
        return this.pv;
    }
    
    public void setPv(Long pv) {
        this.pv = pv;
    }
    public Long getQteet() {
        return this.qteet;
    }
    
    public void setQteet(Long qteet) {
        this.qteet = qteet;
    }
    public Long getQtest() {
        return this.qtest;
    }
    
    public void setQtest(Long qtest) {
        this.qtest = qtest;
    }
    public Long getStock() {
        return this.stock;
    }
    
    public void setStock(Long stock) {
        this.stock = stock;
    }
    public String getFour() {
        return this.four;
    }
    
    public void setFour(String four) {
        this.four = four;
    }
    public String getMaga() {
        return this.maga;
    }
    
    public void setMaga(String maga) {
        this.maga = maga;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }
    public Date getDatec() {
        return this.datec;
    }
    
    public void setDatec(Date datec) {
        this.datec = datec;
    }
    public Date getDateExpi() {
        return this.dateExpi;
    }
    
    public void setDateExpi(Date dateExpi) {
        this.dateExpi = dateExpi;
    }
    public Date getDateExpiMoins15() {
        return this.dateExpiMoins15;
    }
    
    public void setDateExpiMoins15(Date dateExpiMoins15) {
        this.dateExpiMoins15 = dateExpiMoins15;
    }

    public Long getIdpro() {
        return idpro;
    }

    public void setIdpro(Long idpro) {
        this.idpro = idpro;
    }




}


