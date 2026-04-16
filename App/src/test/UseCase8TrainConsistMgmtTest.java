package test;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Bogie {

    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UseCase8TrainConsistMgmtTest {

    private List<Bogie> createBogieList() {

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("AC Chair", 75));

        return passengerBogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {

        List<Bogie> bogies = createBogieList();

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Test", 60));

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Mini", 40));

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {

        List<Bogie> bogies = createBogieList();

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Mini", 20));
        bogies.add(new Bogie("Mini2", 30));

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 75));

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {

        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> filtered =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {

        List<Bogie> bogies = createBogieList();

        int originalSize = bogies.size();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
    }
}