/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allCollection;

/**
 *
 * @author HAMZA
 */
public class ListCommande{
    
    private String description ;
    private String dimension ;
    private Integer prx ;
    private String observation ;
    private String cl ;
    private Integer cb ;
    
    public ListCommande(){
        
    }
    
    public ListCommande(String description, String dimension, Integer prx, String observation){
        this.description = description;
        this.dimension = dimension;
        this.prx = prx;
        this.observation = observation;
    }
    
  
  
   public ListCommande(String description, String dimension, Integer prx, String observation, Integer cb, String cl){
        this.description = description;
        this.dimension = dimension;
        this.prx = prx;
        this.observation = observation;
        this.cb = cb ;
        this.cl = cl ;
    }
    
    
     public ListCommande(String description){
        this.description = description;
         
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getPrx() {
        return prx;
    }

    public void setPrx(Integer prx) {
        this.prx = prx;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

   

   
    public Integer getCb() {
        return cb;
    }

    public void setCb(Integer cb) {
        this.cb = cb;
    }
    
    
    
   
   
    
}
