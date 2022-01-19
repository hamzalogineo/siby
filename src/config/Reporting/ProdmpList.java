/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

import java.util.Date;

/**
 *
 * @author HAMZA
 */
public class ProdmpList {
    // nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu
    
    String nom ;
    int n ;
    String article ;
    Long qte ;
    Long pu ;
    Long montant ;
    Date date;
    String admin ;
    String f;
    String sf;
    Long idpro ;
    Long pa ;
    Long profil ;
    Long mu ;
    Long stock ;
    private Long ida;
    private Integer type ;
    
    public ProdmpList(){
        
    }

    public ProdmpList(String nom, int n, String article, Long qte, Long pu, Long montant, Date date, String admin, String f, String sf, Long idpro, Long pa, Long profil, Long mu, Long stock, Long ida) {
        this.nom = nom;
        this.n = n;
        this.article = article;
        this.qte = qte;
        this.pu = pu;
        this.montant = montant;
        this.date = date;
        this.admin = admin;
        this.f = f;
        this.sf = sf;
        this.idpro = idpro;
        this.pa = pa;
        this.profil = profil;
        this.mu = mu;
        this.stock = stock ;
        this.ida = ida;
    }
    
    public ProdmpList(String nom, int n, String article, Long qte, Long pu, Long montant, Date date, String admin, String f, String sf, Long idpro, Long pa, Long profil, Long mu, Long stock, Long ida , Integer type){
        this.nom = nom;
        this.n = n;
        this.article = article;
        this.qte = qte;
        this.pu = pu;
        this.montant = montant;
        this.date = date;
        this.admin = admin;
        this.f = f;
        this.sf = sf;
        this.idpro = idpro;
        this.pa = pa;
        this.profil = profil;
        this.mu = mu;
        this.stock = stock ;
        this.ida = ida;
        this.type = type ;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Long getQte() {
        return qte;
    }

    public void setQte(Long qte) {
        this.qte = qte;
    }

    public Long getPu() {
        return pu;
    }

    public void setPu(Long pu) {
        this.pu = pu;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date ;
    }

    public String getAdmin() {
        return admin ;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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

    public Long getIdpro() {
        return idpro;
    }

    public void setIdpro(Long idpro) {
        this.idpro = idpro;
    }

    public Long getPa() {
        return pa;
    }

    public void setPa(Long pa) {
        this.pa = pa;
    }

    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    public Long getMu() {
        return mu;
    }

    public void setMu(Long mu) {
        this.mu = mu;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    
    
    
}
