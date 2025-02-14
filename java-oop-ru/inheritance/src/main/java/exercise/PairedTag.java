package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private String name;
    private Map<String, String> attributes;
    private String body;
    private List<Tag> children;

    public PairedTag(String name,
                     Map<String, String> attributes,
                     String body,
                     List<Tag> children) {
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attributesString = attributes.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
        String childrenString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return "<" + name + (attributesString.isEmpty() ? "" : " " + attributesString) + ">"
                + body + childrenString + "</" + name + ">";
    }
}
// END
