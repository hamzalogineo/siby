/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

/**
 *
 * @author HAMZA
 */
public class Perso {
    
    Integer id = 0 ;
    String nom ;
    String prenom ;
    String stat = "" ;
    
    public Perso(){
        
    }

    public Perso(Integer id , String nom, String prenom) {
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
     public Perso(Integer id , String nom, String prenom , String stat) {
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom;
        this.stat = stat ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    
    
    
    
    
    public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Perso)) return false;
    Perso o = (Perso) obj;
    return o.id == this.id ;
}
    
    
    
    
}
