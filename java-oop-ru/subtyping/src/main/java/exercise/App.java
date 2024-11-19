package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Map<String, String> temp = keyValueStorage.toMap();
        Set<Entry<String, String>> entries = temp.entrySet();
        entries.forEach(entry -> keyValueStorage.unset(entry.getKey()));
        entries.forEach(entry -> keyValueStorage.set(entry.getValue(), entry.getKey()));
    }
}
// END
