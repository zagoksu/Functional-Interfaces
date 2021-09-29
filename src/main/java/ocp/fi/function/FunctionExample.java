package ocp.fi.function;

import ocp.fi.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    Function function;

    private <T, R> R useFunction(T t, Function<T, R> function){
        return function.apply(t);
    }

    private <T> Boolean useFunction2(T t, Function<T, Boolean> function){
        return function.apply(t);
    }

    private Boolean useFunction3(Lamp l, Function<Lamp, Boolean> function){
        return function.apply(l);
    }

    public static void main(String[] args) {
        FunctionExample functionExample = new FunctionExample();

        Function<Integer, Integer> function = (x) -> 3 * x;

        Function<Lamp, String> function2 = (x) -> "Lamp: " + x;

        final String message = "Hallo";
        final Lamp flamp = new Lamp(true, 150);


        Function<Integer, List<Lamp>> function3 = (x) -> {
            List<Lamp> lamps = new ArrayList<>();
            flamp.toggle();
//            flamp = new Lamp(true, 90);
            System.out.println(message);
//            message = "Hello";
            for(int i = 0; i < x; i++){
                lamps.add(new Lamp(true, 70));
            }
            return lamps;
        };

        Integer result1 = functionExample.useFunction(5, function);
        System.out.println(result1);

        String result2 = functionExample.useFunction(new Lamp(false, 120), function2);
        System.out.println(result2);

        List<Lamp> lamps = functionExample.useFunction(34, function3);
        System.out.println(lamps);

        MyFunction<String,String,String,String,String> myFunction = (a, b, c, d) -> a + b + c + d;
    }
}
