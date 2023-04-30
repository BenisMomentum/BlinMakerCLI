package blinMain;

import Blins.Blin;
import Blins.Variations.StandardBlin;
import Blins.Variations.StrawberryBlin;
import Blins.Variations.Syrnik;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    private final static ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            boolean whileLoop = true;
            label: while(whileLoop){
                String[] s = sc.nextLine().split(" ");

                switch(s[0]){
                    case "exit":
                        whileLoop = false;
                        System.exit(0);
                        break label;

                    case "blin":
                        Blin b = determineBlinCLI(s);

                        if(b == null){
                            System.out.println("Invalid Argument!");
                            break;
                        }

                        Future<Integer> f = executor.submit(b::calculate);

                        try {
                            System.out.printf("You can make: %d blin(s)\n", f.get());
                        } catch (InterruptedException e) {
                            System.out.println("Something went wrong! Interrupted Exception!");
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            System.out.println("Something went wrong! Execution Exception!");
                            e.printStackTrace();
                        }
                    break;

                    default:
                        System.out.println("BlinCalcCLI: Invalid command");
                        break;
                }
            }
        }





    }

    public static Blin determineBlinCLI(String[] s){
        try{
            switch(s[1]){
                case "standard":
                    int m = Integer.parseInt(s[2]);
                    int e = Integer.parseInt(s[3]);
                    int f = Integer.parseInt(s[4]);

                    return new StandardBlin(m,e,f);

                case "strawberry":

                    int m1 = Integer.parseInt(s[2]);
                    int e1 = Integer.parseInt(s[3]);
                    int f1 = Integer.parseInt(s[4]);
                    int straw = Integer.parseInt(s[5]); //Strawberry

                    return new StrawberryBlin(m1,e1,f1,straw);

                case "syrnik":
                    int m2 = Integer.parseInt(s[2]);
                    int e2 = Integer.parseInt(s[3]);
                    int f2 = Integer.parseInt(s[4]);
                    int cheese = Integer.parseInt(s[5]); //Strawberry

                    return new Syrnik(m2,e2,f2,cheese);

                default:
                    return null;
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println("Incorrect argument formation: \" blin [TYPE] [MILK] [EGGS] [FLOUR] [OPTIONALS...]\" ");
        }
        return null;
    }

}
