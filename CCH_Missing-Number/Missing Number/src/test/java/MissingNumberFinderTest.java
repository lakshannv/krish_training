import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MissingNumberFinderTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUpOutStream() {
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void restoreOutStream() {
        System.setOut(System.out);
    }

    @Test
    public void testValidInputs() {
        assertTrue("Valid Inputs must return true", MissingNumberFinder.validateInput("8 1 3 6 5 4 7 9"));
    }

    @Test
    public void testInvalidInputs() {
        assertFalse("Invalid Inputs must return False", MissingNumberFinder.validateInput("8 1 a 6 5 4 7 9"));
    }

    @Test
    public void testSorting() {
        int[] actual = new int[]{8, 1, 3, 6, 5, 4, 7, 9};
        int[] expected = new int[]{1, 3, 4, 5, 6, 7, 8, 9};
        MissingNumberFinder.sort(actual);
        assertArrayEquals("Array should be sorted", expected, actual);
    }

    @Test
    public void testMissingMiddle() {
        int[] input = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
        MissingNumberFinder.findMissingNumber(input);
        assertEquals("Missing number should be 5", "Missing number from 1 to 9 is : 5", outStream.toString().trim());
    }

    @Test
    public void testMissingFirst() {
        int[] input = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        MissingNumberFinder.findMissingNumber(input);
        assertEquals("Missing number should be 1 or 10", "There's no number missing from 2 to 9. Possible missing number is either 1 or 10.", outStream.toString().trim());
    }

    @Test
    public void testMissingLast() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        MissingNumberFinder.findMissingNumber(input);
        assertEquals("Missing number should be 0 or 9", "There's no number missing from 1 to 8. Possible missing number is either 0 or 9.", outStream.toString().trim());
    }

    @Test
    public void testMissingDelimiter() {
        String inputText = "8 1 3 6 54 7 9";
        String[] stringArray = inputText.trim().split(" ");
        int[] inputArray = MissingNumberFinder.getIntArray(stringArray);
        MissingNumberFinder.sort(inputArray);
        MissingNumberFinder.findMissingNumber(inputArray);
        assertEquals("There should be more than one missing number since there is a gap in the series now", "Series contains more than one missing number.", outStream.toString().trim());
    }

    @Test
    public void testMissingMultiple() {
        String inputText = "1 2 3 6 7 8 9";
        String[] stringArray = inputText.trim().split(" ");
        int[] inputArray = MissingNumberFinder.getIntArray(stringArray);
        MissingNumberFinder.sort(inputArray);
        MissingNumberFinder.findMissingNumber(inputArray);
        assertEquals("Message should say that there is more than one missing.", "Series contains more than one missing number.", outStream.toString().trim());
    }

}