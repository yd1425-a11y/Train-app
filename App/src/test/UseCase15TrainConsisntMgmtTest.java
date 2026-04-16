package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    // Custom Runtime Exception
    class CargoSafetyException extends RuntimeException {

        CargoSafetyException(String message) {

            super(message);
        }
    }


    // Goods Bogie Class
    class GoodsBogie {

        String shape;
        String cargo;

        GoodsBogie(String shape) {

            this.shape = shape;
        }


        void assignCargo(String cargo) {

            try {

                if (shape.equals("Rectangular") &&
                        cargo.equals("Petroleum")) {

                    throw new CargoSafetyException(
                            "Petroleum cannot be assigned to Rectangular bogie"
                    );
                }

                this.cargo = cargo;

            }

            catch (CargoSafetyException e) {

                System.out.println("Error: " + e.getMessage());
            }

            finally {

                System.out.println("Cargo assignment attempt completed.");
            }
        }
    }


    @Test
    void testCargo_SafeAssignment() {

        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }


    @Test
    void testCargo_UnsafeAssignmentHandled() {

        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }


    @Test
    void testCargo_CargoNotAssignedAfterFailure() {

        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }


    @Test
    void testCargo_ProgramContinuesAfterException() {

        GoodsBogie bogie1 = new GoodsBogie("Rectangular");

        bogie1.assignCargo("Petroleum");

        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie2.assignCargo("Coal");

        assertEquals("Coal", bogie2.cargo);
    }


    @Test
    void testCargo_FinallyBlockExecution() {

        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() ->
                bogie.assignCargo("Petroleum")
        );
    }
}
