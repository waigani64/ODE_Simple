/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lorenzeode; 

import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;


public class temp {
 
    FirstOrderIntegrator dp853 = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
    FirstOrderDifferentialEquations ode = new Lorenz();
    double[] xyz = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0};
   
    {
        for (double i = 0; i < LorenzFrame.jTime; i+= 0.01){
            
            
        dp853.integrate(ode, i, xyz, i + 0.1, xyz);
       
        Object[][] data = new Object[][] {
            {i, xyz[0], xyz[1], xyz[2], xyz[3], xyz[4]}
            };
      
            
      String x0String = Double.toString(xyz[0]);
      String x1String = Double.toString(xyz[1]);
      String x2String = Double.toString(xyz[2]);
      String x3String = Double.toString(xyz[3]);
      String x4String = Double.toString(xyz[4]);
      String timeString = Double.toString(i);
      
       DefaultTableModel model = (DefaultTableModel) LorenzFrame.jTableODE.getModel();
       model.addRow(new Object[]{timeString, x0String, x1String, x2String, x3String, x4String});
              
}
}

}




   
    

