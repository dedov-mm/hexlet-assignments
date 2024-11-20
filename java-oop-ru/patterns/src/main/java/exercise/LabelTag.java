package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return "<label>" + tag + tagInterface.render() + "</label>";
    }
}
// END
