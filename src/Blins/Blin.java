package Blins;

public abstract class Blin {
    protected int milk;
    protected int eggs;
    protected int flour;

    //=====STANDARD=====//

    public int getMilk() {
        return milk;
    }

    public int getEggs() {
        return eggs;
    }

    public int getFlour() {
        return flour;
    }

    public Blin(int milk, int eggs, int flour) {
        this.milk = Math.max(milk, 0);
        this.eggs = Math.max(eggs, 0);
        this.flour = Math.max(flour,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blin)) return false;

        Blin blin = (Blin) o;

        return (milk == blin.milk) && (flour == blin.flour) && (eggs == blin.eggs);
    }

    @Override
    public int hashCode() {
        int result = milk;
        result = 69 * result + eggs;
        result = 420 * result + flour;
        return result;
    }

    //=====CALCULATION=====//

    public int calculate(){
        int count = 0;
        int[] ingredients = {flour, eggs, milk};

        while(ingredients[0] > 0 && ingredients[1] > 0  && ingredients[2] > 0){
            if(ingredients[0] - BlinConstants.MIN_FLOUR >= 0
                    && ingredients[1] - BlinConstants.MIN_EGGS >= 0
                    && ingredients[2] - BlinConstants.MIN_MILK >= 0){

                ingredients[0] -= BlinConstants.MIN_FLOUR;
                ingredients[1] -= BlinConstants.MIN_EGGS;
                ingredients[2] -= BlinConstants.MIN_MILK;
                count++;
            }
        }
        return count;
    }

}


