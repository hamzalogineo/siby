/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection.materiel;

/**
 *
 * @author hp
 */
public class List_com {
    
    private Integer ref ;
    private String materiel ;
    private String dimension ;
    private Integer prix ;
    private Integer qte ;
    private Integer jour ;
    private Integer mtt ;
 
    public List_com(){
        
        
    }

    public List_com(Integer ref, String materiel, String dimension, Integer prix, Integer qte, Integer jour, Integer mtt) {
        this.ref = ref ;
        this.materiel = materiel ;
        this.dimension = dimension ;
        this.prix = prix ;
        this.qte = qte ;
        this.jour = jour ;
        this.mtt = mtt ;
    }

    public Integer getRef(){
        return ref ;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public Integer getMtt() {
        return mtt;
    }

    public void setMtt(Integer mtt) {
        this.mtt = mtt;
    }
    
    
    
    
    
}
