/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author HAMZA
 */
public class Exec_list_group_test {
    
    public static void main(String[] AMZA){
        
        List<Stock_05h00> list = new ArrayList<>() ;
        
        Stock_05h00 st = new Stock_05h00() ;
                    st.setMag("CHAMBRE");
                    st.setF("f");
                    st.setSf("sf");
                    st.setRef(1);
                    st.setDescrip("foix coeur boeuf") ;
                    st.setStock(2000);
                    st.setPu(1000);
                    st.setMontant(2000) ;
                      
                     list.add(st) ;
                     
                    Stock_05h00 st1 = new Stock_05h00() ;
                    st1.setMag("CHAMBRE");
                    st1.setF("f");
                    st1.setSf("sf");
                    st1.setRef(2);
                    st1.setDescrip("viande noix boeuf") ;
                    st1.setStock(2000);
                    st1.setPu(1000);
                    st1.setMontant(2000) ;
                      
                     list.add(st1) ;
                     
               Stock_05h00 st2 = new Stock_05h00() ;
                    st2.setMag("FAST FOOD");
                    st2.setF("f");
                    st2.setSf("sf");
                    st2.setRef(3);
                    st2.setDescrip("CROISSANT AMANDE") ;
                    st2.setStock(3);
                    st2.setPu(3000);
                    st2.setMontant(9000) ;
                      
                     list.add(st2) ;
                     // 
                     
                     Map<String, List<Stock_05h00>> groupList = list.stream().collect(Collectors.
                             groupingBy(Stock_05h00::getMag)) ;
                     
                     System.out.println("WE HAVE : "+groupList);
        
    }
    
}
