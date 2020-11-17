package converter.Printers;

import converter.abstractions.Attribute;
import converter.abstractions.Element;

public class ElementsPrinter implements Printer {
    @Override
    public void print(Element element) {
        System.out.println("Element:");
        System.out.println("path = " + element.getPath().stream().reduce((x,y) -> x + ", " + y).map(Object::toString).orElse(""));

        if (element.getChildren() == null) {
            if (element.getSingleValue() != null) {
                System.out.println("value = \"" + element.getSingleValue() + "\"");
            } else {
                System.out.println("value = null");
            }
        }

        if (!element.getAttributes().isEmpty()) {
            System.out.println("attributes:");

            for (Attribute attribute : element.getAttributes()) {
                System.out.println(attribute.getName() +" = \"" + attribute.getValue() + "\"");
            }
        }

        System.out.println();

        if (element.getChildren() != null) {
            for (Element children : element.getChildren()) {
                print(children);
            }
        }
    }
}
