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
public class ListChoixCl {
    
    private Integer id_r ;
    private Integer id_sr ;
    private String tb ;
    
    public ListChoixCl(){
        
    }

    public ListChoixCl(Integer id_r, Integer id_sr, String tb) {
        this.id_r = id_r;
        this.id_sr = id_sr;
        this.tb = tb ;
    }

    public Integer getId_r() {
        return id_r;
    }

    public void setId_r(Integer id_r) {
        this.id_r = id_r;
    }

    public Integer getId_sr() {
        return id_sr;
    }

    public void setId_sr(Integer id_sr) {
        this.id_sr = id_sr;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }
    
    
    
    
    
}
