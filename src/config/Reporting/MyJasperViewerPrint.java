/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

/**
 *
 * @author HAMZA
 */


import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MyJasperViewerPrint extends JasperViewer {

    public MyJasperViewerPrint(JasperPrint jasperPrint, boolean isExitOnClose) {
        super(jasperPrint, isExitOnClose);

        try {
         // ((JPanel) this.viewer.getComponent(0)).remove(0) ;
            
            // ((JPanel) this.viewer.getComponent(0)).remove(2) ;
            
            ((JPanel) this.viewer.getComponent(0)).remove(1) ;
            
            ((JPanel) this.viewer.getComponent(0)).remove(0) ;
                
            
         // ((JPanel) this.viewer.getComponent(2)).setEnabled(true) ;
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
public class MyJasperViewerPrint {
    
}
*/