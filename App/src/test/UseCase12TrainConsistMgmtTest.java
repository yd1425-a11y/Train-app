package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsBogie {

    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class UseCase12TrainConsistMgmtTest {

    private boolean isTrainSafe(List<GoodsBogie> bogies) {

        return bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical")
                                || b.cargo.equals("Petroleum"));
    }

    @Test
    void testSafety_AllBogiesValid() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal")
        );

        assertTrue(isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Box", "Coal")
        );

        assertTrue(isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {

        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(isTrainSafe(bogies));
    }
}