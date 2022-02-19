package ro.fasttrackit.curs18.homework;

public class StringUtils {
    public static String ensureNotEmpty(String word) {
        if (word==null || "".equals(word.trim())) {
            throw new IllegalArgumentException("Null or empty word not accepted");
        } else {
            return word;
        }
    }

    public static int validValue(int value) {
        return Math.max(0, value);
    }
}
