package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

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
    void testGrouping_BogiesGroupedByType() {

        Map<String, List<Bogie>> grouped =
                createBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {

        Map<String, List<Bogie>> grouped =
                createBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {

        Map<String, List<Bogie>> grouped =
                createBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(3, grouped.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {

        Map<String, List<Bogie>> grouped =
                new ArrayList<Bogie>().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {

        List<Bogie> bogies =
                List.of(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {

        Map<String, List<Bogie>> grouped =
                createBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {

        Map<String, List<Bogie>> grouped =
                createBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {

        List<Bogie> bogies = new ArrayList<>(createBogies());

        int originalSize = bogies.size();

        bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(originalSize, bogies.size());
    }
}