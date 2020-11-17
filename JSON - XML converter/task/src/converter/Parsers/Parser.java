package converter.Parsers;

import converter.abstractions.Element;

import java.util.List;

public interface Parser {
    List<Element> parse(String s);
}
