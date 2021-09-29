package ocp.fi.biconsumer;

import ocp.fi.lamp.Lamp;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerExample {

    BiConsumer biConsumer;

    private static <T, U> void doSomethingWithBiConsumer(T t, U u, BiConsumer<T,U> consumer){
        consumer.accept(t,u);
    }

    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a +" " + b);
        doSomethingWithBiConsumer("Two", "String",biConsumer );

        BiConsumer<String, Lamp> biConsumer1 = (s, l) -> {
            System.out.println(s + " " + l);
            l.toggle();
            System.out.println(l.toString());
        };
        doSomethingWithBiConsumer("String and Lamp - ", new Lamp(), biConsumer1);



    }
}
