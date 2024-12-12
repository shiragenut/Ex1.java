import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "abB", " BbG", "1G3bG", "0bbA", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        // Valid test cases
        Object[][] validCases = {
                {0, 2, "0b2"},
                {5, 10, "5bA"},
                {15, 16, "FbG"},
                {255, 16, "FFbG"},
        };
        for (Object[] testCase : validCases) {
            int num = (int) testCase[0];
            int base = (int) testCase[1];
            String expected = (String) testCase[2];
            assertEquals(expected, Ex1.int2Number(num, base));
        }

        // Invalid test cases
        Object[][] invalidCases = {
                {-1, 10, ""},  // Negative number
                {10, 1, ""},   // Base below range
                {10, 17, ""},  // Base above range
                {15, -3, ""}   // Negative base
        };
        for (Object[] testCase : invalidCases) {
            int num = (int) testCase[0];
            int base = (int) testCase[1];
            String expected = (String) testCase[2];
            assertEquals(expected, Ex1.int2Number(num, base));
        }
    }
    @Test
    void maxIndexTest() {
        String[] P = {"1, 2, 5, 10"};
        int ans = 0;
        int tempMax = 0;
        for (int i = 0; i < P.length; i++) {
            int currentNum = Ex1.number2Int(P[i]);
            if (currentNum > tempMax) {
                ans = i;
                tempMax = currentNum;
            }
        }
    }
}
