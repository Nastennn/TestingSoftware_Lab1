import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSin extends Assertions {
    private static final double DELTA = 0.001;

    @Test
    void testPiDots() {
        assertAll(
                ()->assertEquals(0, Sin.sin(0), DELTA),
                ()->assertEquals(0, Sin.sin(-Math.PI), DELTA),
                ()->assertEquals(-1, Sin.sin(-Math.PI/2), DELTA),
                ()->assertEquals(1, Sin.sin(Math.PI/2), DELTA),
                ()->assertEquals(0, Sin.sin(Math.PI), DELTA)
        );
    }


    @Test
    void checkDots() {
        assertAll(
                () -> assertEquals(-0.842, Sin.sin(-2.14), DELTA),
                () -> assertEquals(-0.921, Sin.sin(-1.17), DELTA),
                () -> assertEquals(0.932, Sin.sin(1.2), DELTA),
                () -> assertEquals(0.259, Sin.sin(2.88), DELTA),
                () -> assertEquals(-0.49, Sin.sin(-2.63), DELTA)
        );
    }

}
