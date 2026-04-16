import java.util.HashSet;
import java.util.Set;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        Set<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");

        System.out.println("Unique Bogie IDs in Train Consist:");
        System.out.println(bogieIDs);

        System.out.println("Program continues...");
    }
}