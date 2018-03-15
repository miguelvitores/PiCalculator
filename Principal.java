package PiCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Principal {
    public static void main(String args[]) throws IOException{        
        Random rnd = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Type something due to the randomization seed: ");
        PiCalculator calc = PiCalculator.getInstance(br.readLine());
        
        rnd.setSeed(PiCalculator.seed);
        
        do{
            System.out.print("Method [1-Area compare, 2-Leibniz, 3-Nilakantha]: ");
            int opcion = Integer.parseInt(br.readLine());
            switch(opcion){
                case 1:
                    calc.calcPi(rnd);
                    break;
                case 2:
                    calc.calcPiLeibniz(rnd);
                    break;
                case 3:
                    calc.calcPiNilakantha(rnd);
                    break;
                default:
                    break;
            }
        }while(true);
    }
}
