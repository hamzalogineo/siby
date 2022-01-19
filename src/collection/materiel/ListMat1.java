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
public class ListMat1 {
    
    private Integer ref ;
    private String materiel ;
    private String dimension ;
    private Integer prix ;
    private Integer qte_c ;
    private Integer prix_c ;
    private Integer nombre ;
    private Integer nombre_dispo ;
    
    public ListMat1(){
        
    }

    public ListMat1(Integer ref, String materiel, String dimension, Integer prix, Integer qte_c, Integer prix_c, Integer nombre, Integer nombre_dispo) {
        this.ref = ref;
        this.materiel = materiel;
        this.dimension = dimension;
        this.prix = prix;
        this.qte_c = qte_c;
        this.prix_c = prix_c;
        this.nombre = nombre;
        this.nombre_dispo = nombre_dispo;
    }

    public Integer getRef() {
        return ref;
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

    public Integer getQte_c() {
        return qte_c;
    }

    public void setQte_c(Integer qte_c) {
        this.qte_c = qte_c;
    }

    public Integer getPrix_c() {
        return prix_c;
    }

    public void setPrix_c(Integer prix_c) {
        this.prix_c = prix_c;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getNombre_dispo() {
        return nombre_dispo;
    }

    public void setNombre_dispo(Integer nombre_dispo) {
        this.nombre_dispo = nombre_dispo;
    }
    
    
    
    
    
}
