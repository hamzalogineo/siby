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
public class BeansEmploye {
    private String id;
    private String nom;
    private String poste;
    private int    salaire;
    
    public BeansEmploye(){
        
    }

    public BeansEmploye(String id, String nom, String poste, int salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
    
    
}
