import java.util.function.Consumer;

public class ConsumerInJava {

    // What is a Consumer? It represents a function which takes in one argument
    // and produces a result. However, these kind of functions don’t return any value
    public static void main(String[] args) {

        // Similar to a 'void' function, will perform some actions but nothing returned.
        Consumer<Integer> consumer = integer -> System.out.println(integer);
        // Function<Integer, Void>

        consumer.accept(10);
    }
}
