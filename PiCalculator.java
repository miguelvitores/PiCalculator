package PiCalculator;

import java.util.Calendar;
import java.util.Random;

public class PiCalculator{
    
    public static double r = 0x3b9ac9ff;
    public static double N = 0xf0650;
    public static double piCalc = 0;
    public static long contCirc = 0;
    public static long contTotal = 0;
    public static long seed = (long)(Calendar.getInstance().getTimeInMillis()*Math.tan(Math.E)
            *4/(7+36));

    public static void main(String args[]){        
        Random rnd = new Random();
        Point p = new Point();
        
        rnd.setSeed(seed);
        
        while(true){
            for (int i=0; i<N; i++){
                p.setLocation( rnd.nextDouble() *(2*r), rnd.nextDouble() * (2*r) );
                if ( p.isInsideCircle(r) )
                    contCirc++;
                contTotal++;
            }
            piCalc = calcPi(contCirc, contTotal);
            System.out.println("Error: "+calcError(piCalc)+
                    "\tCalculado: "+piCalc);
        }

    }
    
    public static double calcPi (long contCirc, long contTotal){
        return 4*(double)contCirc/(double)contTotal;
    }
    
    public static double calcError (double piCalc){
        return Math.abs( piCalc - Math.PI);
    }
}
