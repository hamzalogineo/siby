/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author IDRIS
 */
public class Stock {
    
    private String cb;
    private String desi;
    private int stock;
    private String date_expi;

    public Stock() {
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getDesi() {
        return desi;
    }

    public void setDesi(String desi) {
        this.desi = desi;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDate_expi() {
        return date_expi;
    }

    public void setDate_expi(String date_expi) {
        this.date_expi = date_expi;
    }
    
    
    
}
