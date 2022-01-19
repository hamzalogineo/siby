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
public class Transaction_pl {
    
    
       
       private long mtt ;
      
       private String description ;
       private long old_stock_depart ;
       private long old_stock_arriver ;
       private long new_stock_depart ;
       private long new_stock_arriver ;
       private String p_depart ;
       private String p_arriver ;
       private String comm_ ;
       private String motif_ ;
       private long qte_ ;
       private String comt_ ;
       private float pm_depart ;
       private float pm_arriver ;
       private String etat ;
       private Integer id_st ;
       private Integer id_st_d;
       
       public Transaction_pl(){
           
       }

    public Transaction_pl(long mtt, String description, long old_stock_depart, long old_stock_arriver, long new_stock_depart, long new_stock_arriver, String p_depart, String p_arriver, String comm_, String motif_, long qte_, String comt_, float pm_depart, float pm_arriver , String etat) {
        this.mtt = mtt;
        this.description = description;
        this.old_stock_depart = old_stock_depart;
        this.old_stock_arriver = old_stock_arriver;
        this.new_stock_depart = new_stock_depart;
        this.new_stock_arriver = new_stock_arriver;
        this.p_depart = p_depart;
        this.p_arriver = p_arriver;
        this.comm_ = comm_;
        this.motif_ = motif_;
        this.qte_ = qte_;
        this.comt_ = comt_;
        this.pm_depart = pm_depart;
        this.pm_arriver = pm_arriver;
        this.etat = etat ;
    }
    
     public Transaction_pl(long mtt, String description, long old_stock_depart, long old_stock_arriver, long new_stock_depart, long new_stock_arriver, String p_depart, String p_arriver, String comm_, String motif_, long qte_, String comt_, float pm_depart, float pm_arriver , String etat, Integer id_st) {
        this.mtt = mtt;
        this.description = description;
        this.old_stock_depart = old_stock_depart;
        this.old_stock_arriver = old_stock_arriver;
        this.new_stock_depart = new_stock_depart;
        this.new_stock_arriver = new_stock_arriver;
        this.p_depart = p_depart;
        this.p_arriver = p_arriver;
        this.comm_ = comm_;
        this.motif_ = motif_;
        this.qte_ = qte_;
        this.comt_ = comt_;
        this.pm_depart = pm_depart;
        this.pm_arriver = pm_arriver;
        this.etat = etat ;
        this.id_st = id_st;
    }
     
    public Transaction_pl(long mtt, String description, long old_stock_depart, long old_stock_arriver, long new_stock_depart, long new_stock_arriver, String p_depart, String p_arriver, String comm_, String motif_, long qte_, String comt_, float pm_depart, float pm_arriver , String etat, Integer id_st, Integer id_st_d) {
        this.mtt = mtt;
        this.description = description;
        this.old_stock_depart = old_stock_depart;
        this.old_stock_arriver = old_stock_arriver;
        this.new_stock_depart = new_stock_depart;
        this.new_stock_arriver = new_stock_arriver;
        this.p_depart = p_depart;
        this.p_arriver = p_arriver;
        this.comm_ = comm_;
        this.motif_ = motif_;
        this.qte_ = qte_;
        this.comt_ = comt_;
        this.pm_depart = pm_depart;
        this.pm_arriver = pm_arriver;
        this.etat = etat ;
        this.id_st = id_st;
        this.id_st_d = id_st_d ;
        
    }  

    public long getMtt() {
        return mtt;
    }

    public void setMtt(long mtt) {
        this.mtt = mtt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOld_stock_depart() {
        return old_stock_depart;
    }

    public void setOld_stock_depart(long old_stock_depart) {
        this.old_stock_depart = old_stock_depart;
    }

    public long getOld_stock_arriver() {
        return old_stock_arriver;
    }

    public void setOld_stock_arriver(long old_stock_arriver) {
        this.old_stock_arriver = old_stock_arriver;
    }

    public long getNew_stock_depart() {
        return new_stock_depart;
    }

    public void setNew_stock_depart(long new_stock_depart) {
        this.new_stock_depart = new_stock_depart;
    }

    public long getNew_stock_arriver() {
        return new_stock_arriver;
    }

    public void setNew_stock_arriver(long new_stock_arriver) {
        this.new_stock_arriver = new_stock_arriver;
    }

    public String getP_depart() {
        return p_depart;
    }

    public void setP_depart(String p_depart) {
        this.p_depart = p_depart;
    }

    public String getP_arriver() {
        return p_arriver;
    }

    public void setP_arriver(String p_arriver) {
        this.p_arriver = p_arriver;
    }

    public String getComm_() {
        return comm_;
    }

    public void setComm_(String comm_) {
        this.comm_ = comm_;
    }

    public String getMotif_() {
        return motif_;
    }

    public void setMotif_(String motif_) {
        this.motif_ = motif_;
    }

    public long getQte_() {
        return qte_;
    }

    public void setQte_(long qte_) {
        this.qte_ = qte_;
    }

    public String getComt_() {
        return comt_;
    }

    public void setComt_(String comt_) {
        this.comt_ = comt_;
    }

    public float getPm_depart() {
        return pm_depart;
    }

    public void setPm_depart(float pm_depart) {
        this.pm_depart = pm_depart;
    }

    public float getPm_arriver() {
        return pm_arriver;
    }

    public void setPm_arriver(float pm_arriver) {
        this.pm_arriver = pm_arriver;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getId_st() {
        return this.id_st ; 
    }

    public void setId_st(Integer id_st) {
        this.id_st = id_st;
    }

    public Integer getId_st_d() {
        return id_st_d;
    }

    public void setId_st_d(Integer id_st_d) {
        this.id_st_d = id_st_d;
    }
       
       
      
    
    
}
