import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FindText {
    public static void main(String[] args) {
        String filePath = "src/text.txt";
        String findString = "Juan";

        findStringFile(filePath, findString, true);
    }

    private static void findStringFile(String filePath, String findString, Boolean isCaseSensitive){
        File file = new File(filePath);

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            AtomicInteger lineNumber = new AtomicInteger(0);
            bufferedReader.lines()
                    .filter(line -> {
                        lineNumber.incrementAndGet();
                        return isCaseSensitive ? line.contains(findString) : line.toUpperCase().contains(findString.toUpperCase());
                    })
                    .forEach(line -> System.out.printf("The string %s is found on line %d: %s%n", findString, lineNumber.get(), line));

            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
