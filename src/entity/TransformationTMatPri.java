package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * TransformationTMatPri generated by hbm2java
 */
public class TransformationTMatPri  implements java.io.Serializable {


     private Long id;
     private Long idActivT;
     private String matiereP;
     private Double prxUnitVent;
     private Double qte;
     private Double cout;
     private String unite;
     private String status;
     private String date;
     private String mois;
     private String annee;
     private String admin;

    public TransformationTMatPri() {
    }

    public TransformationTMatPri(Long idActivT, String matiereP, Double prxUnitVent, Double qte, Double cout, String unite, String status, String date, String mois, String annee, String admin) {
       this.idActivT = idActivT;
       this.matiereP = matiereP;
       this.prxUnitVent = prxUnitVent;
       this.qte = qte;
       this.cout = cout;
       this.unite = unite;
       this.status = status;
       this.date = date;
       this.mois = mois;
       this.annee = annee;
       this.admin = admin;
    }

    public TransformationTMatPri(Long id, Long idActivT, String matiereP, Double prxUnitVent, Double qte, Double cout, String unite, String status, String date, String mois, String annee, String admin) {
        this.id = id;
        this.idActivT = idActivT;
        this.matiereP = matiereP;
        this.prxUnitVent = prxUnitVent;
        this.qte = qte;
        this.cout = cout;
        this.unite = unite;
        this.status = status;
        this.date = date;
        this.mois = mois;
        this.annee = annee;
        this.admin = admin;
    }
    
    
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdActivT() {
        return this.idActivT;
    }
    
    public void setIdActivT(Long idActivT) {
        this.idActivT = idActivT;
    }
    public String getMatiereP() {
        return this.matiereP;
    }
    
    public void setMatiereP(String matiereP) {
        this.matiereP = matiereP;
    }
    public Double getPrxUnitVent() {
        return this.prxUnitVent;
    }
    
    public void setPrxUnitVent(Double prxUnitVent) {
        this.prxUnitVent = prxUnitVent;
    }
    public Double getQte() {
        return this.qte;
    }
    
    public void setQte(Double qte) {
        this.qte = qte;
    }
    public Double getCout() {
        return this.cout;
    }
    
    public void setCout(Double cout) {
        this.cout = cout;
    }
    public String getUnite() {
        return this.unite;
    }
    
    public void setUnite(String unite) {
        this.unite = unite;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public String getMois() {
        return this.mois;
    }
    
    public void setMois(String mois) {
        this.mois = mois;
    }
    public String getAnnee() {
        return this.annee;
    }
    
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }




}


