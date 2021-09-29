package ocp.generics.beverage;

public class Application {

    public static void main(String[] args) {

        Box<Beer> beerBox = new Box<>();
        beerBox.addBeverage(new Beer("Carslberg", 5.3));
        Box<Wine> wineBox = new Box<>();
        wineBox.addBeverage(new Wine("Antinori Tignanello", 17.2));

        Box<Beverage> beverageBox = new Box();
        beverageBox.addBeverage(new Wine("Chateau Margaux", 14.1));
        beverageBox.addBeverage(new Beer("Heineken", 5.1));
        beverageBox.showContents();


        // Make Box a generic class so that you can add beers OR Wines:
        // i.e.
        // Box<Beer> beerBox = new Box<>();
        // beerBox.add( new Beer(....));
        // add multiple beers
        // Do the same for Wines


        // Also try
        // Box<Beverage> beverageBox = new Box<>();
        // and add beers AND wines in the same box


    }
}
