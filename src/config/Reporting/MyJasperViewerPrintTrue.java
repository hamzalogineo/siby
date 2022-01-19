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

public class MyJasperViewerPrintTrue extends JasperViewer {

    public MyJasperViewerPrintTrue(JasperPrint jasperPrint, boolean isExitOnClose) {
        super(jasperPrint, isExitOnClose);

        try {
            ((JPanel) this.viewer.getComponent(1)).setEnabled(true); 
             ((JPanel) this.viewer.getComponent(2)).setEnabled(true) ;
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
public class MyJasperViewerPrint {
    
}
*/

/*
public class MyJasperViewerPrintTrue {
    
}
*/