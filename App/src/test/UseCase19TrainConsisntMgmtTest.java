package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmtTest {

    // Binary Search Method
    private boolean binarySearch(String[] bogieIDs, String key) {

        if (bogieIDs.length == 0) {
            return false;
        }

        // ensure sorted before search
        Arrays.sort(bogieIDs);

        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(bogieIDs[mid]);

            if (comparison == 0) {

                return true;
            }

            else if (comparison < 0) {

                high = mid - 1;
            }

            else {

                low = mid + 1;
            }
        }

        return false;
    }


    @Test
    void testBinarySearch_BogieFound() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                binarySearch(bogieIDs, "BG309")
        );
    }


    @Test
    void testBinarySearch_BogieNotFound() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(
                binarySearch(bogieIDs, "BG999")
        );
    }


    @Test
    void testBinarySearch_FirstElementMatch() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                binarySearch(bogieIDs, "BG101")
        );
    }


    @Test
    void testBinarySearch_LastElementMatch() {

        String[] bogieIDs =
                {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(
                binarySearch(bogieIDs, "BG550")
        );
    }


    @Test
    void testBinarySearch_SingleElementArray() {

        String[] bogieIDs =
                {"BG101"};

        assertTrue(
                binarySearch(bogieIDs, "BG101")
        );
    }


    @Test
    void testBinarySearch_EmptyArray() {

        String[] bogieIDs = {};

        assertFalse(
                binarySearch(bogieIDs, "BG101")
        );
    }


    @Test
    void testBinarySearch_UnsortedInputHandled() {

        String[] bogieIDs =
                {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(
                binarySearch(bogieIDs, "BG205")
        );
    }
}