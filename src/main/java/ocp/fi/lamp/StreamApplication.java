package ocp.fi.lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApplication {
    private Lamp replaceLamp(Lamp lamp){
        return new Lamp(lamp.isOn(), 100);
    }

    public static void main(String[] args) {
        StreamApplication streamApplication = new StreamApplication();

        // Switcher<Lamp> switcher4 = l -> streamApplication.replaceLamp(l);
        Switcher<Lamp> switcher4 = streamApplication::replaceLamp;

        // First use of the streaming API
        List<Lamp> lamps = new ArrayList<>();
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));

        List<Lamp> lampsOn = lamps.stream()
                .filter(s -> s.isOn())
                .collect(Collectors.toList());

        System.out.println("lamps that are on");
        //Display all lamps that are 'on'
        lampsOn.stream().forEach(s -> System.out.println(s.toString()));

        System.out.println("------------------------------------------");

        List<Lamp> lampsReplaced = lamps.stream()
//                .parallel()
                .map(l -> streamApplication.replaceLamp(l))
                .collect(Collectors.toList());

        System.out.println("lamps that are replaced");
        lampsReplaced.stream().forEach(s -> System.out.println(s.toString()));
    }
}
