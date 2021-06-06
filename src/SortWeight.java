import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SortWeight {

    public static void main(String [] args) {
        String string = "56 65 74 100 99 68 86 180 90";
        sortWeight(string);
    }

    public static String sortWeight(String string) {
        return Arrays.stream(string.split(" "))
                .map(s -> Map.entry(s, s.chars().map(Character::getNumericValue).sum()))
                .sorted(Map.Entry.<String,Integer>comparingByValue().thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));
    }
}
