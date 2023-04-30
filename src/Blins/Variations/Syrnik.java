package Blins.Variations;

import Blins.Blin;
import Blins.BlinConstants;

public class Syrnik extends Blin {

    protected int creamCheese;

    public Syrnik(int milk, int eggs, int flour, int cC) {
        super(milk, eggs, flour);
        this.creamCheese = cC;
    }

    @Override
    public int calculate() {
        int count = 0;
        int[] ingredients = {flour, eggs, milk, creamCheese};

        while(ingredients[0] > 0 && ingredients[1] > 0  && ingredients[2] > 0 && ingredients[3] > 0){
            if(ingredients[0] - BlinConstants.MIN_FLOUR >= 0
                    && ingredients[1] - BlinConstants.MIN_EGGS >= 0
                    && ingredients[2] - BlinConstants.MIN_MILK >= 0
                    && ingredients[3] - BlinConstants.MIN_CREAMCHEESE >= 0){

                ingredients[0] -= BlinConstants.MIN_FLOUR;
                ingredients[1] -= BlinConstants.MIN_EGGS;
                ingredients[2] -= BlinConstants.MIN_MILK;
                ingredients[3] -= BlinConstants.MIN_CREAMCHEESE;
                count++;
            }
        }
        return count;
    }
}
