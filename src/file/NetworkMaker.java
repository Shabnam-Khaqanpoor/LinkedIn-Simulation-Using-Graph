package file;

import implementations.Graph.AdjacencyMapGraph;
import implementations.Heap.MaxHeapPriorityQueue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import usersinfo.*;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class NetworkMaker {

    public static AdjacencyMapGraph<User, Integer> network = new AdjacencyMapGraph<User, Integer>();
    public static void readFromJson() throws IOException, ParseException, org.json.simple.parser.ParseException {


        //اینجا که کد عادیشه که با تقلا کردن در آوردم
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("users.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Iterate through each entry in the JSON array
        Iterator<JSONObject> iterator = jsonArray.iterator();

        //حلقه برای اینکه بره تا اخر فایل
        while (iterator.hasNext()) {
            //ورودی بعدی رو میگیره
            JSONObject entry = iterator.next();

            //chon name 2 ghesmat dare last va first spilit kardam

            String[] name = ((String) entry.get("name")).split(" ");

            //nahve vorodi gereftane json entry hast injasham ke vazehe mige vorodi ro onjaii ke mal id masalan bede

            GeneralInfo generalInfo = new GeneralInfo(Integer.parseInt((String) entry.get("id")), name[0], name[1], (String) entry.get("dateOfBirth"));
            UserSpecializedInfo userSpecializedInfo = new UserSpecializedInfo((String) entry.get("universityLocation"), (String) entry.get("field"), (String) entry.get("workplace"));

            //in chon specialties haye ziadi bodan miad tabdil be JsonArr mikone va ba halghe onaro be linkedlist ezafe kardam

            JSONArray specialtiesArray = (JSONArray) entry.get("specialties");
            LinkedList<String> specialtiesList = new LinkedList<>();
            for (Object specialty : specialtiesArray) {
                specialtiesList.add((String) specialty);
            }
            UserSkills userSkills = new UserSkills(specialtiesList);

            //inam hamintor int bood cast kardam

            JSONArray connectionIdsArray = (JSONArray) entry.get("connectionId");
            LinkedList<Integer> connectionIdsList = new LinkedList<>();
            for (Object connectionId : connectionIdsArray) {
                connectionIdsList.add(Integer.valueOf((String) connectionId));
            }
             Connections connections = new Connections(connectionIdsList);
            UserPriorities userPriorities = new UserPriorities();

            //add vertex with above attribute to  my graph
            network.insertVertex(new User(generalInfo, userSpecializedInfo, userSkills, connections, userPriorities));
        }

        for (User user: network.vertices()){          //set suggestions by calculate scores
           user.setSuggestions(new Suggestion(user));
        }
        //creating edges
        createEdges();
    }
    //Create edges-------------------------------------------------------------
    public static void createEdges()
    {
        int edge=0;
        for (User user: network.vertices())
        {
            for (User follower:user.getConnections().getUsers())
            {
                network.insertEdge(user,follower,edge++);
            }
        }
    }

    //Get Popular User---------------------------------------------------------------------------------
    public static MaxHeapPriorityQueue<Integer,User> getPopularUser()
    {
        MaxHeapPriorityQueue<Integer,User>myHeap=new MaxHeapPriorityQueue<Integer,User>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return   o1.compareTo(o2);
            }
        });

        for (User user:NetworkMaker.network.vertices())
        {
            myHeap.insert(NetworkMaker.network.outDegree(user),user);
        }
        //return heap of all users popularity
        return myHeap;
    }
}