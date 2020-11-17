package converter;

import converter.Converters.Converter;
import converter.Converters.JsonToXmlConverter;
import converter.Converters.XmlToJsonConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        File file = new File("./test.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                input.append(scanner.nextLine().trim());
            }

            convert(input.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("More general error :v " + e.getMessage());
        }
    }

    public static void convert(String text) {
        Converter converter = null;

        if (text.charAt(0) == '<') {
            converter = new XmlToJsonConverter();
        } else if (text.charAt(0) == '{') {
            converter = new JsonToXmlConverter();
        }

        System.out.println(converter == null ? "" : converter.convert(text));
    }
}
