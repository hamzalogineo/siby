/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author HAMZA
 */
public class Tableau_Bord_obj {
    private String groupe;
    private String rubrique;
    private String srub;
    private long depot;
    private long retrait;
    private String nature ;
    
    public Tableau_Bord_obj(){
        
    }

    public Tableau_Bord_obj(String groupe, String rubrique, String srub, long depot, long retrait , String nature) {
        this.groupe = groupe;
        this.rubrique = rubrique;
        this.srub = srub;
        this.depot = depot;
        this.retrait = retrait;
        this.nature = nature ;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }

    public String getSrub() {
        return srub;
    }

    public void setSrub(String srub) {
        this.srub = srub;
    }

    public long getDepot() {
        return depot;
    }

    public void setDepot(long depot) {
        this.depot = depot;
    }

    public long getRetrait() {
        return retrait;
    }

    public void setRetrait(long retrait) {
        this.retrait = retrait;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
    
    
    
    
}
