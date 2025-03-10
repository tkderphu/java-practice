package design_pattern.behavioral.mediator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4, 5};
        Arrays.stream(values)
                .skip(3)
                .limit(3)
                .forEach((e) -> System.out.println(e) );
    }
}
