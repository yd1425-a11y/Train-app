import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {

    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("Passenger bogies sorted by seating capacity:");

        for (Bogie b : passengerBogies) {
            System.out.println(b.name + " -> Capacity: " + b.capacity);
        }

        System.out.println("Program continues...");
    }
}