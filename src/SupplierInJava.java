import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierInJava {

    // What is supplier? It takes no input argument, will perform actions and return some output.

    public static void main(String[] args) {
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        // Function<Void, LocalDateTime>

        LocalDateTime time = supplier.get();
        System.out.println(time);
    }
}
