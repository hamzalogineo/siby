package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * Pmp generated by hbm2java
 */
public class Pmp  implements java.io.Serializable {


     private Long id;
     private Long idp;
     private String nomp;
     private String cb;
     private String article;
     private Long pa;
     private Long pv;
     private String datec;
     private String admin;
     private Long idmp;
     private Integer idpf;

    public Pmp() {
    }

    public Pmp(Long idp, String nomp, String cb, String article, Long pa, Long pv, String datec, String admin, Long idmp, Integer idpf) {
       this.idp = idp;
       this.nomp = nomp;
       this.cb = cb;
       this.article = article;
       this.pa = pa;
       this.pv = pv;
       this.datec = datec;
       this.admin = admin;
       this.idmp = idmp ;
       this.idpf = idpf ;
    }

    public Pmp(Long id, Long idp, String nomp, String cb, String article, Long pa, Long pv, String datec, String admin, Long idmp, Integer idpf) {
        this.id = id;
        this.idp = idp;
        this.nomp = nomp;
        this.cb = cb;
        this.article = article;
        this.pa = pa;
        this.pv = pv;
        this.datec = datec;
        this.admin = admin;
        this.idmp = idmp ;
        this.idpf = idpf ;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdp() {
        return this.idp;
    }
    
    public void setIdp(Long idp) {
        this.idp = idp;
    }
    public String getNomp() {
        return this.nomp;
    }
    
    public void setNomp(String nomp) {
        this.nomp = nomp;
    }
    public String getCb() {
        return this.cb;
    }
    
    public void setCb(String cb) {
        this.cb = cb;
    }
    public String getArticle() {
        return this.article;
    }
    
    public void setArticle(String article) {
        this.article = article;
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
    public String getDatec() {
        return this.datec;
    }
    
    public void setDatec(String datec) {
        this.datec = datec;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Long getIdmp() {
        return idmp;
    }

    public void setIdmp(Long idmp) {
        this.idmp = idmp;
    }

    public Integer getIdpf() {
        return idpf;
    }

    public void setIdpf(Integer idpf) {
        this.idpf = idpf;
    }




}

