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
public class Variable_tb {
    
    private long depot ;
    private long retrait ;
    private String nature ;
    
    public Variable_tb(){
        
    }

    public Variable_tb(long depot, long retrait, String nature) {
        this.depot = depot;
        this.retrait = retrait;
        this.nature = nature ;
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
