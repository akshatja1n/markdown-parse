import static org.junit.Assert.*; //imports specific junit test tool
import org.junit.*; //imports all of junit

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    public String readFile(String fileName) throws IOException {
        Path filePath = Path.of("test-file.md");
        String contents = Files.readString(filePath);

        return contents;
    }

    @Test // identifies this method as a test
    public void addition() { // test method header
        assertEquals(2, 1 + 1); // actual test that compares the two values
    }

    @Test
    public void addition2() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFileOne() throws IOException {
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("https://something.com");
        expectedOutput.add("some-page.html");

        String file = readFile("test-file.md");

        assertEquals("Check test-file.md", expectedOutput, MarkdownParse.getLinks(file));

    }

}