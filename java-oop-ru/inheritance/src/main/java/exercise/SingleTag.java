package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag{
    private String name;
    private Map<String, String> attributes;

    public SingleTag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        String attributesString = attributes.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
        return "<" + name + (attributesString.isEmpty() ? "" : " " + attributesString) + ">";
    }
}
// END
