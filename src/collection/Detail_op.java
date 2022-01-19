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
public class Detail_op {
    
    private String description;
    private Integer qte;
    private Integer pu;
    private Integer mtt;
    
    public Detail_op(){
        
    }

    public Detail_op(String description, Integer qte, Integer pu, Integer mtt) {
        this.description = description;
        this.qte = qte;
        this.pu = pu;
        this.mtt = mtt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Integer getPu() {
        return pu;
    }

    public void setPu(Integer pu) {
        this.pu = pu;
    }

    public Integer getMtt() {
        return mtt;
    }

    public void setMtt(Integer mtt) {
        this.mtt = mtt;
    }
    
    
    
    
    
    
}
