package Blins.Variations;

import Blins.Blin;

public class StrawberryBlin extends Blin {

    protected int strawberries;
    public StrawberryBlin(int milk, int eggs, int flour, int strawberries) {
        super(milk, eggs, flour);
        this.strawberries = strawberries;
    }
}
