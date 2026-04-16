package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UseCase14TrainConsistMgmtTest {

    // Custom Exception
    class InvalidCapacityException extends Exception {

        InvalidCapacityException(String message) {

            super(message);
        }
    }


    // Passenger Bogie class with validation
    class Bogie {

        String type;
        int capacity;

        Bogie(String type, int capacity)
                throws InvalidCapacityException {

            if (capacity <= 0) {

                throw new InvalidCapacityException(
                        "Capacity must be greater than zero"
                );
            }

            this.type = type;
            this.capacity = capacity;
        }
    }


    @Test
    void testException_ValidCapacityCreation()
            throws InvalidCapacityException {

        Bogie b = new Bogie("Sleeper", 72);

        assertNotNull(b);
    }


    @Test
    void testException_NegativeCapacityThrowsException() {

        Exception exception =
                assertThrows(
                        InvalidCapacityException.class,
                        () -> new Bogie("Sleeper", -10)
                );

        assertEquals(
                "Capacity must be greater than zero",
                exception.getMessage()
        );
    }


    @Test
    void testException_ZeroCapacityThrowsException() {

        Exception exception =
                assertThrows(
                        InvalidCapacityException.class,
                        () -> new Bogie("AC Chair", 0)
                );

        assertEquals(
                "Capacity must be greater than zero",
                exception.getMessage()
        );
    }


    @Test
    void testException_ExceptionMessageValidation() {

        Exception exception =
                assertThrows(
                        InvalidCapacityException.class,
                        () -> new Bogie("First Class", 0)
                );

        assertEquals(
                "Capacity must be greater than zero",
                exception.getMessage()
        );
    }


    @Test
    void testException_ObjectIntegrityAfterCreation()
            throws InvalidCapacityException {

        Bogie b = new Bogie("Sleeper", 80);

        assertEquals("Sleeper", b.type);

        assertEquals(80, b.capacity);
    }


    @Test
    void testException_MultipleValidBogiesCreation()
            throws InvalidCapacityException {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        assertEquals(3, bogies.size());
    }
}