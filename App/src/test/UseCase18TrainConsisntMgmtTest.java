package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    // Linear Search Method
    private boolean linearSearch(String[] bogieIDs, String key) {

        for (String id : bogieIDs) {

            if (id.equals(key)) {

                return true; // early termination
            }
        }

        return false;
    }


    @Test
    void testSearch_BogieFound() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                linearSearch(bogieIDs, "BG309")
        );
    }


    @Test
    void testSearch_BogieNotFound() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(
                linearSearch(bogieIDs, "BG999")
        );
    }


    @Test
    void testSearch_FirstElementMatch() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                linearSearch(bogieIDs, "BG101")
        );
    }


    @Test
    void testSearch_LastElementMatch() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                linearSearch(bogieIDs, "BG550")
        );
    }


    @Test
    void testSearch_SingleElementArray() {

        String[] bogieIDs =
                {"BG101"};

        assertTrue(
                linearSearch(bogieIDs, "BG101")
        );
    }
}