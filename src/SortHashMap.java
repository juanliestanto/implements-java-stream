import java.util.*;

public class SortHashMap {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>(Map.of(
                "x", 10,
                "y", 11,
                "z", 9
        ));

        printHashMap("HashMap before sorting by value :", hashMap);

        HashMap<String, Integer> sortedMap = sortByValue(hashMap);

        printHashMap("\nHashMap after sorting by value :", sortedMap);
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashMap){
        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();

        hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedHashMap.put(entry.getKey(), entry.getValue()));

        return sortedHashMap;
    }

    private static <key, value> void printHashMap(String message, HashMap<key, value> hashMap) {
        System.out.println(message);
        hashMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
