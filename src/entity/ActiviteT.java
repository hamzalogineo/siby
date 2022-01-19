package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * ActiviteT generated by hbm2java
 */
public class ActiviteT  implements java.io.Serializable {


     private Long id;
     private String libelle;
     private String description;
     private String datedemarrage;
     private String admin;
     private Integer idg ;

    public ActiviteT() {
    }

    public ActiviteT(String libelle, String description, String datedemarrage, String admin,Integer idg) {
       this.libelle = libelle;
       this.description = description;
       this.datedemarrage = datedemarrage;
       this.admin = admin;
       this.idg = idg;
    }

    public ActiviteT(Long id, String libelle, String description, String datedemarrage, String admin , Integer idg) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.datedemarrage = datedemarrage;
        this.admin = admin;
        this.idg = idg ;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getLibelle() {
        return this.libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDatedemarrage() {
        return this.datedemarrage;
    }
    
    public void setDatedemarrage(String datedemarrage) {
        this.datedemarrage = datedemarrage;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Integer getIdg() {
        return idg;
    }

    public void setIdg(Integer idg) {
        this.idg = idg;
    }




}

