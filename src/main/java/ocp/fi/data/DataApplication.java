package ocp.fi.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DataApplication {

    public static void main(String[] args) throws IOException {

        DataApplication dataApplication = new DataApplication();

        Stream<Path> pathStream = Files.list(Paths.get("C:/Temp/data"));

//        pathStream.forEach(f -> System.out.println(f.getFileName()));

        pathStream = Files.list(Paths.get("C:/Temp/data"));

        long start = System.currentTimeMillis();

        Optional<String> s = pathStream
                .parallel()
                //.filter(f -> !f.toFile().isDirectory())
                //.filter(f -> !f.getFileName().endsWith(".txt"))
                .flatMap(f -> dataApplication.getAllLines(f))
//                .peek(l -> System.out.println(l))
                .filter(l -> l.contains("34567899999999876543"))
                .findFirst();

        System.out.println("Execution time: " + (System.currentTimeMillis() -start) );
        System.out.println(s);
    }

    private Stream<String> getAllLines(Path path){
            List<String> lines = new ArrayList<>();
            try{
                lines = Files.readAllLines(path, Charset.defaultCharset());
            }catch (IOException e){
                e.printStackTrace();
            }
            return lines.stream();
    }


}
