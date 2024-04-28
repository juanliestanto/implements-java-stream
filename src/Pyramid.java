import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pyramid {
    public static void main(String[] args) {
        int height = 5;
        String result = StraightPyramid(height);
        System.out.println("Pyramid");
        System.out.println(result);

        String invertedResult = InvertedPyramid(height);
        System.out.println("\nInverted Pyramid");
        System.out.println(invertedResult);
    }
    private static String StraightPyramid(int height){
        Stream<String> pyramidStream = IntStream.rangeClosed(1, height)
                .mapToObj(row -> {
                    Stream<String> spaces = IntStream.rangeClosed(1, height - row)
                            .mapToObj(col -> " ");
                    Stream<String> stars = IntStream.rangeClosed(1, 2 * row - 1)
                            .mapToObj(col -> "*");
                    return Stream.concat(spaces, stars)
                            .collect(Collectors.joining());
                });

        return pyramidStream.collect(Collectors.joining("\n"));
    }

    private static String InvertedPyramid(int height){
        Stream<String> pyramidStream = IntStream.rangeClosed(1, 5)
                .mapToObj(row -> {
                    Stream<String> spaces = IntStream.rangeClosed(1, row - 1)
                            .mapToObj(col -> " ");
                    Stream<String> stars = IntStream.rangeClosed(1, 2 * (height - row) + 1)
                            .mapToObj(col -> "*");
                    return Stream.concat(spaces, stars)
                            .collect(Collectors.joining());
                });

        return pyramidStream.collect(Collectors.joining("\n"));
    }
}
