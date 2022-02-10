
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdownString) {

        String[] markdownStrings = markdownString.split("\n");

        ArrayList<String> toReturn1 = new ArrayList<>();

        // Checks each line of the file for three things
        /**
         * Whether the string contains [, ], (, )
         * Whether [ comes before ] which comes before ( which comes before }
         * Whether the character
         */
        for (String markdown : markdownStrings) {
            if (markdown.contains("[") && markdown.contains("]") && markdown.contains("(") && markdown.contains(")")) {
                if ((markdown.indexOf("[") < markdown.indexOf("]")) && (markdown.indexOf("]") < markdown
                        .indexOf("(")) && (markdown.indexOf("(") < markdown.indexOf(")"))) {
                    if (!(markdown.indexOf("[") > 0 && markdown.substring(0, 1).equals("!"))) {
                        toReturn1.add(markdown.substring(markdown.indexOf("(") + 1, markdown.indexOf(")")));
                    }
                }
            }
        }
        return toReturn1;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

/*
 * Original code
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