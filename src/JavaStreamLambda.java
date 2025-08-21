import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.toUpperCase;

public class JavaStreamLambda {

    // @Test
    public void regular() {
//store elements in the list.
        // no. of elements ,find all elements stored start with 'A"
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Abhilasha");
        names.add("Sam");
        names.add("Abhisheik");
        names.add("Anshika");

        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (names.get(i).startsWith("A")) {
                count++;
            }
        }
        System.out.println("No of elements start with A are " + count);
    }

    //@Test
    public void StreamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Abhilasha");
        names.add("Sam");
        names.add("Abhisheik");
        names.add("Anshika");

        long a = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(a);

        long d = Stream.of("Abhisheik", "Abhigya", "Tanya", "Anu").filter(s ->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        // names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));
    }


    public void streamMap() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Man");
        names.add("WoMen");
        names.add("Don");

        //print name which have first letter as "a" with uppercase
        Stream.of("Abhijeet", "Abhigya", "Tanya", "Anu", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        //print names which have last letter as a with uppercase and sorted
        List<String> name1 = Arrays.asList("Abhijeet", "Abhigya", "Tanya", "Anu", "Rama");

        Stream.of("Abhisheik", "Abhigya", "Tanya", "Anu", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        name1.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Merging 2 diiferent lists
        Stream<String> newStream = Stream.concat(names.stream(), name1.stream());
        newStream.forEach(s -> System.out.println(s));


    }


    // @Test

    public void streamCollect() {
        List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(1));
    }

    @Test

    public void Assign() {
        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        //print unique number from this array
        //sort the array

        values.stream().distinct().sorted().forEach(s -> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(5));
    }
}