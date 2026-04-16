package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    // Search method with state validation
    private boolean searchBogie(String[] bogieIDs, String key) {

        // fail-fast validation
        if (bogieIDs.length == 0) {

            throw new IllegalStateException(
                    "No bogies available for search"
            );
        }

        // linear search logic after validation
        for (String id : bogieIDs) {

            if (id.equals(key)) {

                return true;
            }
        }

        return false;
    }


    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {

        String[] bogieIDs = {};

        assertThrows(
                IllegalStateException.class,
                () -> searchBogie(bogieIDs, "BG101")
        );
    }


    @Test
    void testSearch_AllowsSearchWhenDataExists() {

        String[] bogieIDs =
                {"BG101","BG205"};

        assertDoesNotThrow(
                () -> searchBogie(bogieIDs, "BG101")
        );
    }


    @Test
    void testSearch_BogieFoundAfterValidation() {

        String[] bogieIDs =
                {"BG101","BG205","BG309"};

        assertTrue(
                searchBogie(bogieIDs, "BG205")
        );
    }


    @Test
    void testSearch_BogieNotFoundAfterValidation() {

        String[] bogieIDs =
                {"BG101","BG205","BG309"};

        assertFalse(
                searchBogie(bogieIDs, "BG999")
        );
    }


    @Test
    void testSearch_SingleElementValidCase() {

        String[] bogieIDs =
                {"BG101"};

        assertTrue(
                searchBogie(bogieIDs, "BG101")
        );
    }
}