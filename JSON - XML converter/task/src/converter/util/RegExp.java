package converter.util;

import java.util.regex.Pattern;

public class RegExp {
    public static String spaceToMultispace(String s) {
        return s.replace(" ", "\\s*");
    }

    public static Pattern compileMultispace(String regex) {
        return Pattern.compile(spaceToMultispace(" " + regex + " "));
    }
}
