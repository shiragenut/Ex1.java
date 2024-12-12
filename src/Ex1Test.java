import org.junit.jupiter.api.Test;
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
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
                }
//בטסט המקורי יש גם את הספרות וabB שאמורות לצאת לא תקינות ויוצאות לי תקינות
            String[] not_good = {"b2", "2b2"," BbG" ,"1G3bG", "0bbA", "!@b2","A", "1bb2"};;
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            //tests with valid values
            assertEquals("101b2", Ex1.int2Number(5,2));
            assertEquals("10bA", Ex1.int2Number(10,10));
            assertEquals("A1b16", Ex1.int2Number(161,16));


        }

        @Test
        void maxIndexTest() {
            String[] arr1 = {"1011b2","1bA","111b10","0bF"};
            int expectedIndex1 = 2;
            assertEquals (expectedIndex1, Ex1.maxIndex(arr1), "Failed for arr1");
            String[] arr2 = {"1011b2","1bA","111b10","0bF"};
            int expectedIndex2 = 2;
            assertEquals(expectedIndex2, Ex1.maxIndex(arr2),"Failed for arr2");
            String[] arr3 = {"1011b2","1bA","b2","0bF"};
            int expectedIndex3 = 3;
            assertEquals(expectedIndex3, Ex1.maxIndex(arr3),"Failed for arr3");
            String[] arr4 = {"abB","b2","2b"};
            int expectedIndex4 = -1;
            assertEquals(expectedIndex4, Ex1.maxIndex(arr4),"Failed for arr4");
            String[] arr5 = {"1011b2","1011b2","1011b2"};
            int expectedIndex5 = 0;
            assertEquals(expectedIndex5, Ex1.maxIndex(arr5),"Failed for arr5");
        }
    }
