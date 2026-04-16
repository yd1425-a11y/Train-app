package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    private List<Bogie> createBogies() {

        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {

        int total =
                createBogies().stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertEquals(307, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {

        int total =
                createBogies().stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {

        List<Bogie> bogies =
                List.of(new Bogie("Sleeper", 72));

        int total =
                bogies.stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {

        List<Bogie> bogies = new ArrayList<>();

        int total =
                bogies.stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {

        int total =
                createBogies().stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertEquals(307, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {

        int total =
                createBogies().stream()
                        .map(b -> b.capacity)
                        .reduce(0, Integer::sum);

        assertEquals(307, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {

        List<Bogie> bogies = new ArrayList<>(createBogies());

        int originalSize = bogies.size();

        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}