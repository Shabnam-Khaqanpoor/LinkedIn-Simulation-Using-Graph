import file.ReadJson;
import usersinfo.User;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            ReadJson.readFromJson();
        } catch (IOException | org.json.simple.parser.ParseException | ParseException e) {
            System.out.println(e.getMessage());
        }

        for (User user : ReadJson.Network.vertices()) {
            int counter=0;
            System.out.println(user.toString());
            System.out.println("--------------------------CONNECTIONS---------------------------+\n\n\n");
            for (User connect: user.getConnections().getUsers()){
                System.out.println(connect.getGeneralInfo().toString());
                System.out.println("------------------------------------------------------------\n");
            }
            System.out.println("--------------------------SUGGESTIONS---------------------------+\n\n\n");
            while (!user.getSuggestions().isEmpty()){
                if (counter==20)break;
                System.out.println(user.getSuggestions().removeMax().getGeneralInfo().toString());
                counter++;
                System.out.println("------------------------------------------------------------\n");
            }
            System.out.println("-------------------------------------------------------------------------------------------\n");
        }
    }
}
