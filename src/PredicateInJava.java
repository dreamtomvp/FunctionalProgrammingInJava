import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInJava {

    // What is a predicate? It is function with one argument that return a boolean value.
    public static void main(String[] args) {
        Predicate<String> hasEvenLetterCount = string -> string.length() % 2 == 0;
        // Function<String, Boolean>

        List<String> stringsWithEvenLetterCount = List.of("Steve", "Neil", "Nick").stream()
                .filter(hasEvenLetterCount)
                .collect(Collectors.toList());
        System.out.println(stringsWithEvenLetterCount);
    }
}