package PiCalculator;

import java.util.Calendar;
import java.util.Random;

public class PiCalculator{
    
    
    public static double r = 0x3b9ac9ff;
    public static double N = 1;//refresh time
    private double piCalc;
    private long contCirc;
    private long contTotal;
    private Point p;
    private long leibnizNum;
    private long nilakanthaNum;
    
    public static long seed;
    private static PiCalculator instance = null;
    
    
    public static PiCalculator getInstance (String str){
        if (instance == null)
            instance = new PiCalculator(str);
        return instance;
    }

    private PiCalculator(String str) {
        p = new Point();
        seed = calcSeed(str);
        leibnizNum = 1;
        nilakanthaNum = 2;
    }
    
    
    public static long calcSeed (String str){
        long string=0;
        for (char c : str.toCharArray()){
            string += (long)c;
        }
        return string*Calendar.getInstance().getTimeInMillis();
    }
    
    
    public void calcPi (Random rnd){
        while(true){
            for (int i=0; i<N; i++){
                p.setLocation( rnd.nextDouble() *(2*r), rnd.nextDouble() * (2*r) );
                if ( p.isInsideCircle(r) )
                    contCirc++;
                contTotal++;
            }
            piCalc = 4*(double)contCirc/(double)contTotal;
            System.out.println("Error: "+calcError(piCalc)+
                    "\tCalculado: "+piCalc);
        }
    }
    
    public void calcPiLeibniz  (Random rnd){
        while(true){
            for (int i=0; i<N; i++){
                piCalc += 4/(double)leibnizNum - 4/(double)(leibnizNum+2);
                leibnizNum += 4;
            }
            System.out.println("Error: "+calcError(piCalc)+
                    "\tCalculado: "+piCalc);
        }
    }
    
    public void calcPiNilakantha (Random rnd){
        piCalc = 3;
        while(true){
            for (int i=0; i<N; i++){
                piCalc += 4/(double)((nilakanthaNum)*(nilakanthaNum+1)*(nilakanthaNum+2)) - 
                        4/(double)((nilakanthaNum+2)*(nilakanthaNum+3)*(nilakanthaNum+4));
                nilakanthaNum += 4;
            }
            System.out.println("Error: "+calcError(piCalc)+
                    "\tCalculado: "+piCalc);
        }
    }
    
    public double calcError (double piCalc){
        return Math.abs( piCalc - Math.PI);
    }
}
