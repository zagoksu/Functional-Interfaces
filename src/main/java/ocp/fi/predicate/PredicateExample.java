package ocp.fi.predicate;

import ocp.fi.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    Predicate predicate;

    private static <T> boolean doSomethingWithPredicate(T t, Predicate<T> predicate){
        return predicate.test(t);
    }

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.startsWith("A");
        boolean startsWithA = doSomethingWithPredicate("Aloha", predicate);
        System.out.println(startsWithA);

        Predicate<Integer> predicate1 = s -> s > 0;
        boolean greaterThan0 = doSomethingWithPredicate(7, predicate1);
        System.out.println(greaterThan0);

        Predicate<Lamp> predicate2 = (s) -> s.isOn();

        Lamp lamp = new Lamp();
//        lamp.toggle();

        boolean lampIsOn = doSomethingWithPredicate(lamp, predicate2);
        System.out.println(lampIsOn);

        List<Lamp> lamps = new ArrayList<>();
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));

        List<Lamp> lampsOn = lamps.stream()
                .filter(s -> s.isOn())
                .toList();


        lampsOn.stream().forEach(s -> System.out.println(s.toString()));
    }
}
