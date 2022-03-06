import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OccurrenceFinderTest {

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
    public void testSorting() {
        char[] input = new char[]{'F', 'B', 'E', 'D', 'A', 'C'};
        char[] expected = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        OccurrenceFinder.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindOccurrences() {
        String inputText = "Race Car";
        String expected =
                "A - 2" + System.lineSeparator() +
                "C - 2" + System.lineSeparator() +
                "E - 1" + System.lineSeparator() +
                "R - 2" + System.lineSeparator();
        OccurrenceFinder.findOccurrences(inputText);
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testIgnoreNonAlphabeticCharacters() {
        String inputText = "Race 69420 Car";
        String expected =
                "A - 2" + System.lineSeparator() +
                        "C - 2" + System.lineSeparator() +
                        "E - 1" + System.lineSeparator() +
                        "R - 2" + System.lineSeparator();
        OccurrenceFinder.findOccurrences(inputText);
        assertEquals(expected, outStream.toString());
    }
}