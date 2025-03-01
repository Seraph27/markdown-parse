import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of());
    }

    @Test
    public void testFile3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of());
    }

    @Test
    public void testFile4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);


        assertEquals(MarkdownParse.getLinks(contents), List.of("https://CSE15L.com"));
    }

    @Test
    public void testFile5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of());
    }

    @Test
    public void testFile6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of("page.com"));
    }

    @Test
    public void testFile7() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);

        assertEquals(MarkdownParse.getLinks(contents), List.of());
    }

    @Test
    public void testFile8() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("a link on the first line"));
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://www.twitter.com",
            "https://ucsd-cse15l-w22.github.io/",
            "https://cse.ucsd.edu/") ,MarkdownParse.getLinks(contents));
    }

    
}

// javac MarkdownParseTest.java
// java MarkdownParseTest

// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest