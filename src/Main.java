import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        List<String> newList = new ArrayList<>();

        // [1] Procedure Programming
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i).toUpperCase());
        }
        System.out.println(newList);

        // [2] Functional Programming
        List<String> newList2 = list.stream() // Stream initialisation
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList()); // Stream collection
        System.out.println(newList2);

        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,9);
        // Expected output: (300, 600, 900)
        // V1
        long startTime = System.currentTimeMillis();

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();// Run the garbage collector to get a clean memory snapshot
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();// Record memory usage before the code snippet

        List<Integer> newIntList1 = intList.stream()
                .map(item -> item * 100)
                .filter(item -> item % 3 == 0)
                .collect(Collectors.toList());
        System.out.println("[Method1]: Map First, Then Filter - less memory efficient but faster");
        System.out.println(newIntList1);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.printf("Elapsed time in seconds:  %.3f [second]\n", estimatedTime/1000.0);

        // Record memory usage after the code snippet
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;// Calculate memory used by the code snippet in bytes
        double memoryUsedInKB = memoryUsed / 1024.0;// Convert to kilobytes (optional)
        // Print memory usage
        System.out.printf("Memory used by code snippet: %.3f KB\n\n", memoryUsedInKB);

        // ----
        // V2: Filter first, then Map. Because map is a memory expensive operation (because mapped values must be
        // retained until they’re filtered), after filtering, the
        // number of variables to be processed is less, saving memory.
        long startTime2 = System.currentTimeMillis();

        // Get the Java runtime
        Runtime runtime2 = Runtime.getRuntime();
        runtime2.gc();// Run the garbage collector to get a clean memory snapshot
        long memoryBefore2 = runtime.totalMemory() - runtime.freeMemory();// Record memory usage before the code snippet

        List<Integer> newIntList2 = intList.stream()
                .filter(item -> item % 3 == 0)
                .map(item -> item * 100)
                .collect(Collectors.toList());
        System.out.println("[Method2]: Filter First, Then Map - Slower, but more memory efficient");
        System.out.println(newIntList2);
        long estimatedTime2 = System.currentTimeMillis() - startTime2;
        System.out.printf("Elapsed time in seconds:  %.3f [second]\n", estimatedTime2/1000.0);

        // Record memory usage after the code snippet
        long memoryAfter2 = runtime2.totalMemory() - runtime2.freeMemory();
        long memoryUsed2 = memoryAfter2 - memoryBefore2;// Calculate memory used by the code snippet in bytes
        double memoryUsedInKB2 = memoryUsed2 / 1024.0;// Convert to kilobytes (optional)
        // Print memory usage
        System.out.printf("Memory used by code snippet: %.3f KB\n", memoryUsedInKB2);

        /*
        * [Time Efficiency]: Method 2 is faster than Method 1 because it filters out unnecessary elements before mapping, reducing the number of operations.
        * [Space Efficiency]: Method 2 is slightly more space-efficient than Method 1 due to reduced intermediate storage needs.
        *
        * Thus, Method 2 is both time-efficient and space-efficient compared to Method 1 in this case.
        * */

        /*
         * 1. mapping: transforms the type of an item in stream into another type (e.g. int -> string, string -> string)
         * 2. flat mapping
         * 3. filtering: select items in the stream that matches a test
         * */

    }
}