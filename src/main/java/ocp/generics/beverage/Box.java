package ocp.generics.beverage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Box <T extends Beverage>{

    private List<T> beverages = new ArrayList<>();
    private Map<Double, T> beveragesMap = new HashMap<>();

    public void addBeverage(T t){
        beverages.add(t);
        System.out.println("Added a beverage with alc. "+ t.getAlcoholPercentage() + " to the " + t.getNameOfBox());
    }
    public void addBeverageToMap(T t){ beveragesMap.put(t.getAlcoholPercentage(), t);}


    public Beverage getElementAtIndex(int index) {
        return this.beverages.get(index);
    }

    public void showContents(){
        for (Beverage beverage: beverages){
            System.out.println(beverage.toString());
        }
    }

}
