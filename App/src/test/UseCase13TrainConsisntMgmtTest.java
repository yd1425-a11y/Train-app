package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    private List<Bogie> createBogies() {

        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 80),
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 75)
        );
    }


    @Test
    void testLoopFilteringLogic() {

        List<Bogie> result = new ArrayList<>();

        for (Bogie b : createBogies()) {

            if (b.capacity > 60) {

                result.add(b);
            }
        }

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }


    @Test
    void testStreamFilteringLogic() {

        List<Bogie> result =
                createBogies().stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }


    @Test
    void testLoopAndStreamResultsMatch() {

        List<Bogie> bogies = createBogies();

        List<Bogie> loopResult = new ArrayList<>();

        for (Bogie b : bogies) {

            if (b.capacity > 60) {

                loopResult.add(b);
            }
        }

        List<Bogie> streamResult =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertEquals(loopResult.size(), streamResult.size());
    }


    @Test
    void testExecutionTimeMeasurement() {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            bogies.add(new Bogie("Sleeper", 72));
        }

        long start = System.nanoTime();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }


    @Test
    void testLargeDatasetProcessing() {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 50000; i++) {

            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 50));
        }

        List<Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.size() > 0);
    }
}