package Blins.Variations;

import Blins.Blin;
import Blins.BlinConstants;

public class Crepes extends Blin {

    private static int CREPES_MINFLOUR = 150;

    public Crepes(int milk, int eggs, int flour) {
        super(milk, eggs, flour);
    }

    @Override
    public int calculate() {
        int count = 0;
        int[] ingredients = {flour, eggs, milk};

        while(ingredients[0] > 0 && ingredients[1] > 0  && ingredients[2] > 0){
            if(ingredients[0] - CREPES_MINFLOUR >= 0
                    && ingredients[1] - BlinConstants.MIN_EGGS >= 0
                    && ingredients[2] - BlinConstants.MIN_MILK >= 0){

                ingredients[0] -= CREPES_MINFLOUR;
                ingredients[1] -= BlinConstants.MIN_EGGS;
                ingredients[2] -= BlinConstants.MIN_MILK;
                count++;
            }
        }
        return count;
    }
}
