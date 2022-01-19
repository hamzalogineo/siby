/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author hp
 */
public class EmployeIndiscipline {
    
    private long id_line;
    private String code_emp;
    
    public EmployeIndiscipline(){}

    public EmployeIndiscipline(long id_line, String code_emp) {
        this.id_line = id_line;
        this.code_emp = code_emp;
    }
    
    
    

    public long getId_line() {
        return id_line;
    }

    public void setId_line(long id_line) {
        this.id_line = id_line;
    }

    public String getCode_emp() {
        return code_emp;
    }

    public void setCode_emp(String code_emp) {
        this.code_emp = code_emp;
    }
    
    
    
    
    
}
