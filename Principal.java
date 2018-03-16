package PiCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Principal {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PiCalculator calc = PiCalculator.getInstance();
        do{
            System.out.print("Method [1-Area compare, 2-Leibniz, 3-Nilakantha]: ");
            int opcion = Integer.parseInt(br.readLine());
            switch(opcion){
                case 1:
                    Random rnd = new Random();
                    
                    System.out.print("Type something due to the randomization seed: ");
                    PiCalculator.calcSeed( br.readLine() );
                    rnd.setSeed(PiCalculator.seed);
                    calc.calcPi(rnd);
                    break;
                case 2:
                    calc.calcPiLeibniz();
                    break;
                case 3:
                    calc.calcPiNilakantha();
                    break;
                default:
                    break;
            }
        }while(true);
    }
}
