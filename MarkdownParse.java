
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//File reading code into string from: https://stackoverflow.com/questions/12857242/java-create-string-array-from-text-file/56287760

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParse {
    public static ArrayList<String> getLinks(List<String> markdownStrings) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        for (String markdown : markdownStrings) {
            if (markdown.contains("[") && markdown.contains("]") && markdown.contains("(") && markdown.contains(")")) {
                toReturn.add(markdown.substring(markdown.indexOf("(") + 1, markdown.indexOf(")")));
            }
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        List<String> lines = Files.readAllLines(fileName);
        ArrayList<String> links = getLinks(lines);
        System.out.println(links);
    }
}

/*
 * // File reading code from
 * https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 * import java.io.IOException;
 * import java.nio.file.Files;
 * import java.nio.file.Path;
 * import java.util.ArrayList;
 * 
 * public class MarkdownParse {
 * public static ArrayList<String> getLinks(String markdown) {
 * ArrayList<String> toReturn = new ArrayList<>();
 * // find the next [, then find the ], then find the (, then take up to
 * // the next )
 * int currentIndex = 0;
 * while (currentIndex < markdown.length()) {
 * int nextOpenBracket = markdown.indexOf("[", currentIndex);
 * int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
 * int openParen = markdown.indexOf("(", nextCloseBracket);
 * int closeParen = markdown.indexOf(")", openParen);
 * toReturn.add(markdown.substring(openParen + 1, closeParen));
 * currentIndex = closeParen + 1;
 * }
 * return toReturn;
 * }
 * public static void main(String[] args) throws IOException {
 * Path fileName = Path.of(args[0]);
 * String contents = Files.readString(fileName);
 * ArrayList<String> links = getLinks(contents);
 * System.out.println(links);
 * }
 * }
 */