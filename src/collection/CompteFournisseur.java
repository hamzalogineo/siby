/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection ;

/**
 *
 * @author HAMZA
 */

public class CompteFournisseur {
    
    // stock element :
    
    private String f;
    private String sf;
    private String unite_m;
    private String cbr;
    private String desi;
    private long pa;
    private long pu;
    private long newStock;
    private String datej;
    private String op;
    private long idpro;
    private long qtest ;
    private String date_expi;
    private String date_expiMoins15;
    private long qte;
    private String fourni;
    private String magasin;
    private Integer id_st ;
    
    // operation ou facture fournisseur :
    
    private Integer cb_fourni;
    private String ref_saisie ;
    private String comt;
    private Integer compte_fourni;
    private String etat;
    // detail element :
    
    private long mtt_detail;
    
    private long ans;
    private long new_s;
    
    
    public CompteFournisseur(){
        
    }

    public CompteFournisseur(String f, String sf, String unite_m, String cbr, String desi, long pa, long pu, long newStock, String datej, String op, long idpro, long qtest, String date_expi, String date_expiMoins15, long qte, String fourni, String magasin, Integer cb_fourni, String ref_saisie, String comt, Integer compte_fourni, String etat, long mtt_detail) {
        this.f = f;
        this.sf = sf;
        this.unite_m = unite_m;
        this.cbr = cbr;
        this.desi = desi;
        this.pa = pa;
        this.pu = pu;
        this.newStock = newStock;
        this.datej = datej;
        this.op = op;
        this.idpro = idpro;
        this.qtest = qtest;
        this.date_expi = date_expi;
        this.date_expiMoins15 = date_expiMoins15;
        this.qte = qte;
        this.fourni = fourni;
        this.magasin = magasin;
        this.cb_fourni = cb_fourni;
        this.ref_saisie = ref_saisie;
        this.comt = comt;
        this.compte_fourni = compte_fourni;
        this.etat = etat;
        this.mtt_detail = mtt_detail;
    }
    
    public CompteFournisseur(String f, String sf, String unite_m, String cbr, String desi, long pa, long pu, long newStock, String datej, String op, long idpro, long qtest, String date_expi, String date_expiMoins15, long qte, String fourni, String magasin, Integer cb_fourni, String ref_saisie, String comt, Integer compte_fourni, String etat, long mtt_detail, long ans, long new_s) {
        this.f = f;
        this.sf = sf;
        this.unite_m = unite_m;
        this.cbr = cbr;
        this.desi = desi;
        this.pa = pa;
        this.pu = pu;
        this.newStock = newStock;
        this.datej = datej;
        this.op = op;
        this.idpro = idpro;
        this.qtest = qtest;
        this.date_expi = date_expi;
        this.date_expiMoins15 = date_expiMoins15;
        this.qte = qte;
        this.fourni = fourni;
        this.magasin = magasin;
        this.cb_fourni = cb_fourni;
        this.ref_saisie = ref_saisie;
        this.comt = comt;
        this.compte_fourni = compte_fourni;
        this.etat = etat;
        this.mtt_detail = mtt_detail;
        this.ans = ans;
        this.new_s = new_s;
    }
    
    public CompteFournisseur(String f, String sf, String unite_m, String cbr, String desi, long pa, long pu, long newStock, String datej, String op, long idpro, long qtest, String date_expi, String date_expiMoins15, long qte, String fourni, String magasin, Integer cb_fourni, String ref_saisie, String comt, Integer compte_fourni, String etat, long mtt_detail, long ans, long new_s, Integer id_st) {
        this.f = f;
        this.sf = sf;
        this.unite_m = unite_m;
        this.cbr = cbr;
        this.desi = desi;
        this.pa = pa;
        this.pu = pu;
        this.newStock = newStock;
        this.datej = datej;
        this.op = op;
        this.idpro = idpro;
        this.qtest = qtest;
        this.date_expi = date_expi;
        this.date_expiMoins15 = date_expiMoins15;
        this.qte = qte;
        this.fourni = fourni;
        this.magasin = magasin;
        this.cb_fourni = cb_fourni;
        this.ref_saisie = ref_saisie;
        this.comt = comt;
        this.compte_fourni = compte_fourni;
        this.etat = etat;
        this.mtt_detail = mtt_detail;
        this.ans = ans;
        this.new_s = new_s;
        this.id_st = id_st ;
        
    }


    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public String getUnite_m() {
        return unite_m;
    }

    public void setUnite_m(String unite_m) {
        this.unite_m = unite_m;
    }

    public String getCbr() {
        return cbr;
    }

    public void setCbr(String cbr) {
        this.cbr = cbr;
    }

    public String getDesi() {
        return desi;
    }

    public void setDesi(String desi) {
        this.desi = desi;
    }

    public long getPa() {
        return pa;
    }

    public void setPa(long pa) {
        this.pa = pa;
    }

    public long getPu() {
        return pu;
    }

    public void setPu(long pu) {
        this.pu = pu;
    }

    public long getNewStock() {
        return newStock;
    }

    public void setNewStock(long newStock) {
        this.newStock = newStock;
    }

    public String getDatej() {
        return datej;
    }

    public void setDatej(String datej) {
        this.datej = datej;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public long getIdpro() {
        return idpro;
    }

    public void setIdpro(long idpro) {
        this.idpro = idpro;
    }

    public long getQtest() {
        return qtest;
    }

    public void setQtest(long qtest) {
        this.qtest = qtest;
    }

    public String getDate_expi() {
        return date_expi;
    }

    public void setDate_expi(String date_expi) {
        this.date_expi = date_expi;
    }

    public String getDate_expiMoins15() {
        return date_expiMoins15;
    }

    public void setDate_expiMoins15(String date_expiMoins15) {
        this.date_expiMoins15 = date_expiMoins15;
    }

    public long getQte() {
        return qte;
    }

    public void setQte(long qte) {
        this.qte = qte;
    }

    public String getFourni() {
        return fourni;
    }

    public void setFourni(String fourni) {
        this.fourni = fourni;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public Integer getCb_fourni() {
        return cb_fourni;
    }

    public void setCb_fourni(Integer cb_fourni) {
        this.cb_fourni = cb_fourni;
    }

    public String getRef_saisie() {
        return ref_saisie;
    }

    public void setRef_saisie(String ref_saisie) {
        this.ref_saisie = ref_saisie;
    }

    public String getComt() {
        return comt;
    }

    public void setComt(String comt) {
        this.comt = comt;
    }

    public Integer getCompte_fourni() {
        return compte_fourni;
    }

    public void setCompte_fourni(Integer compte_fourni) {
        this.compte_fourni = compte_fourni;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public long getMtt_detail() {
        return mtt_detail;
    }

    public void setMtt_detail(long mtt_detail) {
        this.mtt_detail = mtt_detail;
    }

    public long getAns() {
        return ans;
    }

    public void setAns(long ans) {
        this.ans = ans;
    }

    public long getNew_s() {
        return new_s;
    }

    public void setNew_s(long new_s) {
        this.new_s = new_s;
    }

    public Integer getId_st() {
        return id_st;
    }

    public void setId_st(Integer id_st) {
        this.id_st = id_st;
    }
    
    
    
      
    
}
