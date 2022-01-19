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
public class facture_test {
    
    private Integer id ;
    private String rdv_l ;
    private String rdv_r ;
    
    
    
    public facture_test(){
        
        
          }

    public facture_test(Integer id, String rdv_l, String rdv_r) {
        this.id = id;
        this.rdv_l = rdv_l;
        this.rdv_r = rdv_r;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRdv_l() {
        return rdv_l;
    }

    public void setRdv_l(String rdv_l) {
        this.rdv_l = rdv_l;
    }

    public String getRdv_r() {
        return rdv_r;
    }

    public void setRdv_r(String rdv_r) {
        this.rdv_r = rdv_r;
    }
    
    
    
    
    
}
