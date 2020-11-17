package converter.abstractions;

import java.util.List;

public class Element {
    private final List<Attribute> attributes;
    private final List<Element> children;
    private final List<String> path;
    private final String singleValue;

    public Element(List<Attribute> attributes, List<Element> children, String singleValue, List<String> path) {
        this.attributes = attributes;
        this.children = children;
        this.singleValue = singleValue;
        this.path = path;
    }

    public static Element singleElement(List<Attribute> attributes, String value, List<String> path) {
        return new Element(attributes, null, value, path);
    }

    public static Element withChildren(List<Attribute> attributes, List<Element> children, List<String> path) {
        return new Element(attributes, children, null, path);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Element> getChildren() {
        return children;
    }

    public String getSingleValue() {
        return singleValue;
    }

    public boolean isArray() {
        return attributes.isEmpty() && isContentArray();
    }

    public boolean isContentArray() {
        return children != null &&
                children.size() >= 2 &&
                children.stream().map(Element::name).distinct().count() == 1;
    }

    public String name() {
        return path.get(path.size() - 1);
    }

    public List<String> getPath() {
        return path;
    }
}
