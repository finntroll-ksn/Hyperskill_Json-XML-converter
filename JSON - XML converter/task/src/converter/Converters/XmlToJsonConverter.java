package converter.Converters;

import converter.Formatters.JsonFormatter;
import converter.Parsers.XmlParser;

public class XmlToJsonConverter extends AbstractConverter {
    public XmlToJsonConverter() {
        super(new XmlParser(), new JsonFormatter());
    }
}
