package file;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import usersinfo.User;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInJson {

    public void writeNewUserInJson(User user)
    {
        // Data to be written to the JSON file
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", user.getGeneralInfo().getID());
        jsonObject.put("name", user.getGeneralInfo().getName()+" "+user.getGeneralInfo().getLastname());
        jsonObject.put("dateOfBirth",user.getGeneralInfo().getBirth());
        jsonObject.put("universityLocation", user.getSpecializedInfo().getUniversity());
        jsonObject.put("field", user.getSpecializedInfo().getFieldOfStudy());
        jsonObject.put("workplace", user.getSpecializedInfo().getWorkPlace());

        // Specify the file path
        String filePath = "users.json";

        // Create a JSONArray for "connectionId"
        JSONArray specialties = new JSONArray();
        specialties.add(user.getSkills());

        JSONArray connectionIdArray=new JSONArray();
        connectionIdArray.add(user.getConnections().getUsersID());

        // Put the JSONArray into the JSONObject
        jsonObject.put("specialties", specialties);
        jsonObject.put("connectionId", connectionIdArray);


        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write the data to the file
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
