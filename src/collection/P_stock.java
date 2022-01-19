/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author hp
 */
public class P_stock {
    
    private Integer id ;
    private String description ;
    private Integer pv ;
    private Integer seuil ;
    
    public P_stock(){
        
    }

    public P_stock(Integer id, String description, Integer pv, Integer seuil) {
        this.id = id;
        this.description = description;
        this.pv = pv;
        this.seuil = seuil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }
    
    
    
    
    
    
}
