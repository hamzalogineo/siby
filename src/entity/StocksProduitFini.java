package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * StocksProduitFini generated by hbm2java
 */
public class StocksProduitFini  implements java.io.Serializable {


     private Long id;
     private Long idActivT;
     private String codeBarre;
     private String produitsFini;
     private String uniteMes;
     private Double puV;
     private Double stockDispo;
     private String dateentree;
     private String mois;
     private String annee;
     private String admin;

    public StocksProduitFini() {
    }

    public StocksProduitFini(Long idActivT, String codeBarre, String produitsFini, String uniteMes, Double puV, Double stockDispo, String dateentree, String mois, String annee, String admin) {
       this.idActivT = idActivT;
       this.codeBarre = codeBarre;
       this.produitsFini = produitsFini;
       this.uniteMes = uniteMes;
       this.puV = puV;
       this.stockDispo = stockDispo;
       this.dateentree = dateentree;
       this.mois = mois;
       this.annee = annee;
       this.admin = admin;
    }

    public StocksProduitFini(Long id, Long idActivT, String codeBarre, String produitsFini, String uniteMes, Double puV, Double stockDispo, String dateentree, String mois, String annee, String admin) {
        this.id = id;
        this.idActivT = idActivT;
        this.codeBarre = codeBarre;
        this.produitsFini = produitsFini;
        this.uniteMes = uniteMes;
        this.puV = puV;
        this.stockDispo = stockDispo;
        this.dateentree = dateentree;
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
    public String getCodeBarre() {
        return this.codeBarre;
    }
    
    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }
    public String getProduitsFini() {
        return this.produitsFini;
    }
    
    public void setProduitsFini(String produitsFini) {
        this.produitsFini = produitsFini;
    }
    public String getUniteMes() {
        return this.uniteMes;
    }
    
    public void setUniteMes(String uniteMes) {
        this.uniteMes = uniteMes;
    }
    public Double getPuV() {
        return this.puV;
    }
    
    public void setPuV(Double puV) {
        this.puV = puV;
    }
    public Double getStockDispo() {
        return this.stockDispo;
    }
    
    public void setStockDispo(Double stockDispo) {
        this.stockDispo = stockDispo;
    }
    public String getDateentree() {
        return this.dateentree;
    }
    
    public void setDateentree(String dateentree) {
        this.dateentree = dateentree;
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


