package entity;
// Generated 26 mai 2019 18:05:50 by Hibernate Tools 4.3.1



/**
 * ComptesU generated by hbm2java
 */
public class ComptesU  implements java.io.Serializable {


     private Integer id;
     private String nomC;
     private String login;
     private String mp;
     private String role;
     private String phone;
     private String status;
     private String datecreat;
     private String admin;

    public ComptesU() {
    }

    public ComptesU(String nomC, String login, String mp, String role, String phone, String status, String datecreat, String admin) {
       this.nomC = nomC;
       this.login = login;
       this.mp = mp;
       this.role = role;
       this.phone = phone;
       this.status = status;
       this.datecreat = datecreat;
       this.admin = admin;
    }

    public ComptesU(Integer id, String nomC, String login, String mp, String role, String phone, String status, String datecreat, String admin) {
        this.id = id;
        this.nomC = nomC;
        this.login = login;
        this.mp = mp;
        this.role = role;
        this.phone = phone;
        this.status = status;
        this.datecreat = datecreat;
        this.admin = admin;
    }
    
    
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomC() {
        return this.nomC;
    }
    
    public void setNomC(String nomC) {
        this.nomC = nomC;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getMp() {
        return this.mp;
    }
    
    public void setMp(String mp) {
        this.mp = mp;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDatecreat() {
        return this.datecreat;
    }
    
    public void setDatecreat(String datecreat) {
        this.datecreat = datecreat;
    }
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(String admin) {
        this.admin = admin;
    }




}


