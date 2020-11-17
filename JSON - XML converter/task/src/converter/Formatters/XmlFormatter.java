package converter.Formatters;

import converter.abstractions.Element;

import java.util.List;
import java.util.stream.Collectors;

public class XmlFormatter implements Formatter {
    @Override
    public String format(List<Element> elements) {
        if (elements.size() == 1) {
            return format(elements.get(0));
        }

        String children = elements
                .stream()
                .map(this::format)
                .collect(Collectors.joining());

        return String.format("<root>%s</root>", children);
    }

    @Override
    public String format(Element element) {
        StringBuilder result = new StringBuilder();
        result.append('<').append(element.name());
        element
                .getAttributes()
                .forEach(a -> result.append(' ').append(a.getName()).append('=').append(quoted(a.getValue())));

        if (element.getChildren() == null && element.getSingleValue() == null) {
            result.append("/>");

            return result.toString();
        } else {
            result.append('>');
        }

        if (element.getSingleValue() != null) {
            result.append(element.getSingleValue());
        } else {
            element.getChildren()
                    .stream()
                    .map(this::format)
                    .forEach(result::append);
        }

        result.append("</").append(element.name()).append('>');

        return result.toString();
    }

    public String quoted(String s) {
        return s == null ? null : '"' + s + '"';
    }
}
