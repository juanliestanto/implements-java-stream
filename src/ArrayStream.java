import java.util.Arrays;

public class ArrayStream {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4, 5, 6};
        Integer sumResult = ArraySum(numbers);
        System.out.println("Sum of All Array Elements :");
        System.out.println(sumResult);

        Long countResult = ArrayCount(numbers);
        System.out.println("\nNumber of Array Elements :");
        System.out.println(countResult);
    }

    private static Integer ArraySum (int [] numbers){
        return Arrays.stream(numbers).sum();
    }

    private static Long ArrayCount (int [] numbers){
        return Arrays.stream(numbers).count();
    }
}
