package converter.Converters;

import converter.Formatters.XmlFormatter;
import converter.Parsers.JsonParser;

public class JsonToXmlConverter extends AbstractConverter {
    public JsonToXmlConverter() {
        super(new JsonParser(), new XmlFormatter());
    }
}
