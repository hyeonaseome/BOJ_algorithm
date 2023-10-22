import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public String solution(String my_string) {
        return Stream.of(my_string.toLowerCase().split(""))
            .sorted()
            .collect(Collectors.joining());
    }
}