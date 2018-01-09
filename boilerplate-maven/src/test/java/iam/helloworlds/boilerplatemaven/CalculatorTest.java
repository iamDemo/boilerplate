package iam.helloworlds.boilerplatemaven;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CalculatorTest {
    @Test
    public void valid_case() throws Exception {
        assertTrue(new Calculator().divide(2, 2) == 1);
    }

    @Test
    public void invalid_case() {
        try {
            new Calculator().divide(2, 0);

            fail("it cannot be reached here");
        } catch (Throwable e) {
            assertTrue(e instanceof Exception);
        }
    }
}
