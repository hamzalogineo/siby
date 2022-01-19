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
public class PlacementList {
    
      
  //  private Integer cb ;
      private String  date1 ;
      private String  depart ;
      private String  arriver ;
      private String  perso ;
      private String  motif ;
      private String  etat ;
      private String  admin ;
      private String  description ;
      private long    qte ;
      private float   pu ;
      private long    mtt ;
      private long    ndep ;
      private long    nariv ;
      private long    portions ;
      private String  magasin_depart ;
      private String  magasin_arriver ;
      private long    new_stock_depart ;
      private long    new_stock_arriver ;
      private float   new_prx_depart ;
      private float   new_prx_arriver ;
      private long    nderiver ;
      private float   p_m_d ;
      private long ans ;
      private long av ;
      
      public PlacementList(){
          
      }

    public PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat, String admin, String description, long qte, float pu, long mtt, long ndep, long nariv, long portions, float p_m_d) {
     // this.cb = cb;
        this.date1 = date1;
        this.depart = depart;
        this.arriver = arriver;
        this.perso = perso;
        this.motif = motif;
        this.etat = etat;
        this.admin = admin;
        this.description = description;
        this.qte = qte;
        this.pu = pu;
        this.mtt = mtt;
        this.ndep = ndep;
        this.nariv = nariv;
        this.portions = portions;
        this.p_m_d = p_m_d ;
    }

    public PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat, String admin, String description, long qte, float pu, long mtt, long ndep, long nariv, long portions, String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver, float new_prx_depart, float new_prx_arriver, long nderiver, float p_m_d) {
        this.date1 = date1;
        this.depart = depart;
        this.arriver = arriver;
        this.perso = perso;
        this.motif = motif;
        this.etat = etat;
        this.admin = admin;
        this.description = description;
        this.qte = qte;
        this.pu = pu;
        this.mtt = mtt;
        this.ndep = ndep;
        this.nariv = nariv;
        this.portions = portions;
        this.magasin_depart = magasin_depart;
        this.magasin_arriver = magasin_arriver;
        this.new_stock_depart = new_stock_depart;
        this.new_stock_arriver = new_stock_arriver;
        this.new_prx_depart = new_prx_depart;
        this.new_prx_arriver = new_prx_arriver;
        this.nderiver = nderiver;
        this.p_m_d = p_m_d ;
    }
    
    
    public PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat, String admin, String description, long qte, float pu, long mtt, long ndep, long nariv, long portions, String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver, float new_prx_depart, float new_prx_arriver, long nderiver, float p_m_d,long ans,long av) {
        this.date1 = date1;
        this.depart = depart;
        this.arriver = arriver;
        this.perso = perso;
        this.motif = motif;
        this.etat = etat;
        this.admin = admin;
        this.description = description;
        this.qte = qte;
        this.pu = pu;
        this.mtt = mtt;
        this.ndep = ndep;
        this.nariv = nariv;
        this.portions = portions;
        this.magasin_depart = magasin_depart;
        this.magasin_arriver = magasin_arriver;
        this.new_stock_depart = new_stock_depart;
        this.new_stock_arriver = new_stock_arriver;
        this.new_prx_depart = new_prx_depart;
        this.new_prx_arriver = new_prx_arriver;
        this.nderiver = nderiver;
        this.p_m_d = p_m_d ;
        this.ans = ans;
        this.av = av ;
    }
    

 

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArriver() {
        return arriver;
    }

    public void setArriver(String arriver) {
        this.arriver = arriver;
    }

    public String getPerso() {
        return perso;
    }

    public void setPerso(String perso) {
        this.perso = perso;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }

    public float getPu() {
        return pu;
    }

    public void setPu(long pu) {
        this.pu = pu;
    }

    public long getMtt() {
        return mtt;
    }

    public void setMtt(long mtt) {
        this.mtt = mtt;
    }

    public long getNdep() {
        return ndep;
    }

    public void setNdep(long ndep) {
        this.ndep = ndep;
    }

    public long getNariv() {
        return nariv;
    }

    public void setNariv(long nariv) {
        this.nariv = nariv;
    }

    public long getPortions() {
        return portions;
    }

    public void setPortions(long portions) {
        this.portions = portions;
    }

    public String getMagasin_depart() {
        return magasin_depart;
    }

    public void setMagasin_depart(String magasin_depart) {
        this.magasin_depart = magasin_depart;
    }

    public String getMagasin_arriver() {
        return magasin_arriver;
    }

    public void setMagasin_arriver(String magasin_arriver) {
        this.magasin_arriver = magasin_arriver;
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

    public float getNew_prx_depart() {
        return new_prx_depart;
    }

    public void setNew_prx_depart(long new_prx_depart) {
        this.new_prx_depart = new_prx_depart;
    }

    public float getNew_prx_arriver() {
        return new_prx_arriver;
    }

    public void setNew_prx_arriver(long new_prx_arriver) {
        this.new_prx_arriver = new_prx_arriver;
    }

    public long getNderiver() {
        return nderiver;
    }

    public void setNderiver(long nderiver) {
        this.nderiver = nderiver;
    }

    public float getP_m_d() {
        return p_m_d;
    }

    public void setP_m_d(float p_m_d) {
        this.p_m_d = p_m_d;
    }

    public long getAns() {
        return ans;
    }

    public void setAns(long ans) {
        this.ans = ans;
    }

    public long getAv() {
        return av;
    }

    public void setAv(long av) {
        this.av = av;
    }
      
      
    
      
    
}
