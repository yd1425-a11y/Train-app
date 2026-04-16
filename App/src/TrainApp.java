import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add passenger bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("\nPassenger bogies after addition:");
        System.out.println(passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        System.out.println("\nPassenger bogies after removal of AC Chair:");
        System.out.println(passengerBogies);

        // Check existence of Sleeper bogie
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train consist.");
        } else {
            System.out.println("\nSleeper bogie does not exist in the train consist.");
        }

        // Final list state
        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogies);

        System.out.println("\nProgram continues...");
    }
}