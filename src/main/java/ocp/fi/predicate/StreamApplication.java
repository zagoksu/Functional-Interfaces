package ocp.fi.predicate;

import java.util.ArrayList;
import java.util.List;

public class StreamApplication {
    public static void main(String[] args) {
        List<Dj> djs = new ArrayList<>();

        djs.add(new Dj("Kevin", 23));
        djs.add(new Dj("Michael", 34));

        //Use Stream.anyMatch method to test if name 'Kevin' is in the list of Djs
        //You can use the map method also to map the stream of Djs
        // to a stream of Strings(names)

        boolean isKevinIn = djs.stream().anyMatch(n -> n.name.equalsIgnoreCase("Kevin"));

        System.out.println("Is Kevin in: " + isKevinIn);

        boolean isPeteIn = djs.stream().anyMatch(n -> n.name.equalsIgnoreCase("Pete"));
        System.out.println("Is Pete in : " + isPeteIn);


//        boolean isPeteIn2 = djs.stream().map(dj-> dj.getName()).anyMatch(n -> n.equalsIgnoreCase("Pete"));
        boolean isPeteIn2 = djs.stream().map(Dj::getName).anyMatch(n -> n.equalsIgnoreCase("Pete"));

        System.out.println("Is Pete in : " + isPeteIn2);
        System.out.println("Is Kevin In: " + isKevinIn);
    }
}
