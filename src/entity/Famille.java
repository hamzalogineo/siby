package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * Famille generated by hbm2java
 */
public class Famille  implements java.io.Serializable {


     private Long id;
     private String nom;
     private String dtc;
     private String admin;

    public Famille() {
    }

    public Famille(String nom, String dtc, String admin) {
       this.nom = nom;
       this.dtc = dtc;
       this.admin = admin;
    }

    public Famille(Long id, String nom, String dtc, String admin) {
        this.id = id;
        this.nom = nom;
        this.dtc = dtc;
        this.admin = admin;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDtc() {
        return this.dtc;
    }
    
    public void setDtc(String dtc) {
        this.dtc = dtc;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }




}


