import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Initialize empty bogie list
        List<String> trainConsist = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial number of bogies attached: " + trainConsist.size());

        // Program continues (foundation for next use cases)
        System.out.println("System ready to add passenger and goods bogies.");
    }
}