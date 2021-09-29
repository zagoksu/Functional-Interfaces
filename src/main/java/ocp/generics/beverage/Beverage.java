package ocp.generics.beverage;

public abstract class Beverage {

    double alcoholPercentage;

    public Beverage() {
    }

    public abstract String getNameOfBox();

    public Beverage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

}
