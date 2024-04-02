import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    @Test
    public void testCountOf_emptyArray() {
        int[] x = {};
        int target = 5;
        int expected = 0;
        int actual = ArrayUtils.countOf(x, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountOf_noElementsEqualToTarget() {
        int[] x = {1, 2, 3, 4};
        int target = 5;
        int expected = 0;
        int actual = ArrayUtils.countOf(x, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountOf_oneElementEqualToTarget() {
        int[] x = {1, 2, 3, 4, 5};
        int target = 5;
        int expected = 1;
        int actual = ArrayUtils.countOf(x, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountOf_multipleElementsEqualToTarget() {
        int[] x = {1, 2, 5, 3, 5, 4, 5};
        int target = 5;
        int expected = 3;
        int actual = ArrayUtils.countOf(x, target);
        assertEquals(expected, actual);
    }
}