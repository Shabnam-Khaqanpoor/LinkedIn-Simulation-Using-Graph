import File.ReadJson;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            ReadJson.readFromJson();
        } catch (IOException | org.json.simple.parser.ParseException | ParseException e) {
            System.out.println(e.getMessage());;
        }
    }
}
