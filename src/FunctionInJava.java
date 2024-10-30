import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInJava {

    public static void main(String [] args) {

        // 1) Define function; 2) Use function in map of stream;
        Function<Integer, String> convertIntToString = integer -> String.valueOf(integer);
        Function<String, String> makeStringUppercase = string -> string.toUpperCase();
        Function<String, Integer> countLetters = string -> string.length();

        List<Integer> intList = List.of(1, 2, 3);
        List<String> outputStringList = intList.stream()
                .map(convertIntToString)
                .collect(Collectors.toList());
        System.out.println(outputStringList);

        List<String> uppercaseStringList = List.of("Steve", "Neil").stream()
                .map(makeStringUppercase)
                .collect(Collectors.toList());
        System.out.println(uppercaseStringList);

        List<Integer> lettersCountList = List.of("Steve", "Neil").stream()
                .map(countLetters)
                .collect(Collectors.toList());
        System.out.println(lettersCountList);

        // Chain functions. If the function doesn't depend on each other, then order doesn't matter.
        List<Integer> lettersCountList2 = List.of("Steve", "Neil").stream()
                .map(makeStringUppercase)
                .map(countLetters)
                .collect(Collectors.toList());
        System.out.println(lettersCountList2);



    }
}
