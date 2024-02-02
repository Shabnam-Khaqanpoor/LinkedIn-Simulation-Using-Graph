import View.Menu;
import file.NetworkMaker;
import implementations.Heap.MaxHeapPriorityQueue;
import usersinfo.User;

import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            NetworkMaker.readFromJson();
        } catch (IOException | org.json.simple.parser.ParseException | ParseException e) {
            System.out.println(e.getMessage());
        }

        Menu menu = new Menu();
        menu.welcome();
    }
}
