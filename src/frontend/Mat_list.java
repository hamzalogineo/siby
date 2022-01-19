/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author hp
 */
public class Mat_list {
    
    private Integer id ;
    private Integer qte ;
    
    public Mat_list(){
        
    }

    public Mat_list(Integer id, Integer qte) {
        this.id = id;
        this.qte = qte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
    
    
    
  }
