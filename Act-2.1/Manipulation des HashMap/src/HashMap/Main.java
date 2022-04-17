package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> numberMapping = new HashMap<>();
        numberMapping.put("One", 1);
        numberMapping.put("Four", 4);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);
        System.out.println(numberMapping);
        System.out.println("---------------------------------");
        Map<String, String> residenceMapping = new HashMap<>();
        residenceMapping.put("Steve", "London");
        residenceMapping.put("John", "New York");
        residenceMapping.put("Rajeev", "Bengaluru");
        System.out.println(residenceMapping);
        System.out.println(residenceMapping.isEmpty());
        System.out.println(residenceMapping.size());
        System.out.println(residenceMapping.containsKey("Steve"));
        System.out.println(residenceMapping.containsKey("Paul"));
        System.out.println(residenceMapping.containsValue("New York"));
        System.out.println(residenceMapping.containsValue("Toronto"));
        System.out.println(residenceMapping.get("John"));
        System.out.println(residenceMapping.put("Rajeev", "Madrid"));
        System.out.println(residenceMapping);
        System.out.println(residenceMapping.remove("Rajeev"));
        System.out.println(residenceMapping);
        System.out.println(residenceMapping.remove("John", "Paris"));
        System.out.println(residenceMapping.remove("John", "New York"));
        System.out.println(residenceMapping);
    }
}
