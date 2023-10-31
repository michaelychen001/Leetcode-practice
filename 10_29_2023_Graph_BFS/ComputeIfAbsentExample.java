import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeIfAbsentExample {

    public static void main(String[] args){
        Map<String, List<String>> wordCount = new HashMap<>();

        // Adding some initial data to the map
        List l1 = new ArrayList<>();
        l1.add("1");
        wordCount.put("apple", l1);
        List l2 = new ArrayList<>();
        l2.add("2");
        wordCount.put("banana", l2);

        // Using computeIfAbsent to add a new key-value pair
        System.out.println(wordCount.computeIfAbsent("cherry", key -> new ArrayList<>()).add("3"));

        // Using computeIfAbsent to update an existing key
//        Integer appleValue = wordCount.computeIfAbsent("apple", key -> wordCount.get(key) + 1);
//        System.out.println("appleValue: " + appleValue);
    }
}
