import static org.junit.Assert.*; //imports specific junit test tool
import org.junit.*; //imports all of junit

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    public String readFile(String fileName) throws IOException {
        Path filePath1 = Path.of(fileName);
        String contents = Files.readString(filePath1);

        return contents;
    }

    @Test
    public void testFile1() throws IOException {
        String fileToTest = "test-file.md";

        List<String> expected = List.of("https://something.com", "some-page.html");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile2() throws IOException {
        String fileToTest = "test-file2.md";

        List<String> expected = List.of("https://something.com", "some-page.html");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile3() throws IOException {
        String fileToTest = "test-file3.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile4() throws IOException {
        String fileToTest = "test-file4.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile5() throws IOException {
        String fileToTest = "test-file5.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile6() throws IOException {
        String fileToTest = "test-file6.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile7() throws IOException {
        String fileToTest = "test-file7.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testFile8() throws IOException {
        String fileToTest = "test-file8.md";

        List<String> expected = List.of("a link on the first line");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    

    @Test
    public void testBreaking1() throws IOException {
        String fileToTest = "breaking-test.md";

        List<String> expected = List.of("some-page.html");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testBreaking2() throws IOException {
        String fileToTest = "breaking-test2.md";

        List<String> expected = List.of("notanimage.html");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testBreaking3() throws IOException {
        String fileToTest = "breaking-test3.md";

        List<String> expected = List.of("has-tag.html", "randomlink.com");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testBreaking4() throws IOException {
        String fileToTest = "breaking-test4.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testBreaking5() throws IOException {
        String fileToTest = "breaking-test5.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testBreaking6() throws IOException {
        String fileToTest = "breaking-test6.md";

        List<String> expected = List.of();

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testSnippet1() throws IOException {
        String fileToTest = "lab-snippet1.md";

        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testSnippet2() throws IOException {
        String fileToTest = "lab-snippet2.md";

        List<String> expected = List.of("a.com", "a.com(())", "example.com");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    @Test
    public void testSnippet3() throws IOException {
        String fileToTest = "lab-snippet3.md";

        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");

        assertEquals("Check " + fileToTest, expected, MarkdownParse.getLinks(readFile(fileToTest)));
    }

    
}