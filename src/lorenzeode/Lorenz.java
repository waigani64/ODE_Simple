/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lorenzeode;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

/**
 *
 * @author Waigani74
 */
public class Lorenz implements FirstOrderDifferentialEquations{

       private double A;
       private double B;
       private double C;
       private double D;
       //private double E;
    
    
       /* public Lorenz(double A, double B, double C, double D, double E) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        
        }*/
    
    public Lorenz(){
        A = LorenzFrame.jA;
        B = LorenzFrame.jB;
        C = LorenzFrame.jC;
        D = LorenzFrame.jD;
        //E = LorenzFrame.jE;
  
}
public int getDimension(){
return 5;
}

public void computeDerivatives(double t, double[] xyz, double[] xyzDot){
xyzDot[0] = A * (xyz[1] - xyz[0]);
xyzDot[1] = xyz[0] * (B - xyz[2]) - xyz[1];
xyzDot[2] = (xyz[3] * xyz[1]) - (C * xyz[2]);
xyzDot[3] = D * (xyz[0] - xyz[1])-xyz[3]-5*xyz[2];
xyzDot[4] = xyz[1] * (7 - xyz[4]) - xyz[3];

//System.out.println(xyz[2]);
}

}

    

