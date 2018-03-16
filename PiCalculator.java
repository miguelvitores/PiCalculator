package PiCalculator;

import java.util.Calendar;
import java.util.Random;

public class PiCalculator{
    
    
    public static double r = 0x3b9ac9ff;
    public static double N = 5000000;//refresh time
    private double piCalc;
    private long contCirc;
    private long contTotal;
    private Point p;
    private long leibnizNum;
    private long nilakanthaNum;
    
    public static long seed;
    private static PiCalculator instance = null;
    
    
    public static PiCalculator getInstance (){
        if (instance == null)
            instance = new PiCalculator();
        return instance;
    }

    private PiCalculator() {
        p = new Point();
        leibnizNum = 1;
        nilakanthaNum = 2;
    }

    public static void setSeed(long seed) {
        PiCalculator.seed = seed;
    }
    
    
    public static void calcSeed (String str){
        long string=0;
        for (char c : str.toCharArray()){
            string += (long)c;
        }
        setSeed( string*Calendar.getInstance().getTimeInMillis() );
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
    
    public void calcPiLeibniz(){
        while(true){
            for (int i=0; i<N; i++){
                piCalc += 4/(double)leibnizNum - 4/(double)(leibnizNum+2);
                leibnizNum += 4;
            }
            System.out.println("Error: "+calcError(piCalc)+
                    "\tCalculado: "+piCalc);
        }
    }
    
    public void calcPiNilakantha(){
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
