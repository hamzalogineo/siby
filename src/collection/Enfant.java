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
public class Enfant {
    private int id;
    private String id_emp;
    private String nom ;
    private String naissance ;
    
    public Enfant(){
        
          }
    
    public Enfant(String nom, String naissance){
        this.nom = nom ;
        this.naissance = naissance ;
    }
    
    public Enfant(Integer id, String id_emp, String nom, String naissance){
        this.id = id ;
        this.id_emp = id_emp ;
        this.nom = nom ;
        this.naissance = naissance ;
    }
    
    public void setNom(String nom){
        this.nom = nom ;
    }
    
    public String getNom(){
        return this.nom ;
    }
    
    public void setNaissance(String naissance){
        this.naissance = naissance ;
    }
    
    public String getNaissance(){
        return this.naissance ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }
    
    
    
}
