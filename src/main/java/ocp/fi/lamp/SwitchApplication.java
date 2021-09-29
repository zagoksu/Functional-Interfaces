package ocp.fi.lamp;

public class SwitchApplication {

    static String name = "Name";

    private static <T> void doSomethingWithLamp(T t, Switcher<T> switcher){
        t = switcher.switchLamp(t);
    }

    public static void main(String[] args) {

        Switcher<Lamp> switcher = b -> {
            b.toggle();
            return b;
        };

        Switcher<String> switcher2 = (b) -> {
            return b;
        };

        Switcher<Lamp> switcher3 = (Lamp l) -> {
            Lamp lamp = new Lamp();
            lamp.toggle();
            return lamp;
        };

        Lamp lamp1 = new Lamp();
//        lamp1.toggle();
        System.out.println(lamp1);
        SwitchApplication.doSomethingWithLamp(lamp1,switcher);
        System.out.println(lamp1);

        SwitchApplication.doSomethingWithLamp("", switcher2);
        System.out.println(lamp1);
    }
}
