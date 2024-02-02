package View;

import file.NetworkMaker;
import file.WriteInJson;
import implementations.Heap.MaxHeapPriorityQueue;
import usersinfo.*;

import java.util.*;

public class Menu {

    User signedIn;
    Scanner sc = new Scanner(System.in);

    public void welcome() {

        System.out.println("Welcome To Es Network!");

        boolean finish = false;
        while (!finish) {
            System.out.println("What do you want to do??");
            System.out.println("1_SignUp\n2_See The Most Popular Users\n3_See all Users\n4_Exit");
            int answer = sc.nextInt();

            switch (answer) {
                case 1 -> signUp();
                case 2 -> popular();
                case 3 -> allUsers();
                case 4 -> finish = true;
            }

        }
    }

    //Sign Up---------------------------------------------------------------------------------------
    public void signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your First Name:");
        String name = sc.nextLine();
        System.out.println("Enter Your Last Name:");
        String lastname = sc.nextLine();
        System.out.println("Enter Your BirthDate:");
        String Birth = sc.nextLine();
        System.out.println("Enter Your UniversityName:");
        String university = sc.nextLine();
        System.out.println("Enter Your FieldOfStudy:");
        String fieldOfStudy = sc.nextLine();
        System.out.println("Enter Your WorkPlace:");
        String workPlace = sc.nextLine();
        System.out.println("Enter Your Skills:");
        String skills = sc.nextLine();
        System.out.println("Enter Your generalPriority(1-4):");
        double generalPr = sc.nextDouble();
        System.out.println("Enter Your specializedPriority(1-4):");
        double specialPr = sc.nextDouble();
        System.out.println("Enter Your skillPriority(1-4):");
        double SkillsPr = sc.nextDouble();
        System.out.println("Enter Your connectionPriority(1-4):");
        double connectPr = sc.nextDouble();

        //splitting the skills--------------------------------------------------
        String[] skill = skills.split(" ");

        LinkedList<String> temp = new LinkedList<>(Arrays.asList(skill));

        //creating User----------------------------------------------------------

        GeneralInfo generalInfo = new GeneralInfo(NetworkMaker.network.numVertices() + 1, name, lastname, Birth);
        UserSpecializedInfo userSpecializedInfo = new UserSpecializedInfo(university, fieldOfStudy, workPlace);
        UserSkills userSkills = new UserSkills(temp);
        UserPriorities userPriorities = new UserPriorities(generalPr, specialPr, SkillsPr, connectPr);
        Connections connections = new Connections(null);
        signedIn = new User(generalInfo, userSpecializedInfo, userSkills, connections, userPriorities);

        //add this poor user to Network-------------------------------------------
        NetworkMaker.network.insertVertex(signedIn);
        //WriteInJson writeInJson = new WriteInJson();

        //writeInJson.writeNewUserInJson(signedIn);
        //show the user suggestions-----------------------------------------------
        showSuggestions();

        //show user menu----------------------------------------------------------
        userMenu();

    }

    //The Most Popular---------------------------------------------------------------------------------------
    public void popular() {
        System.out.println("Showing The Most 10 Popular Users---------------------------------------------------\n");
        //Show the most popular users---------------------------
        MaxHeapPriorityQueue<Integer, User> tempHeap = NetworkMaker.getPopularUser();
        for (int i = 0; i < 10; i++) {
            User temp = tempHeap.removeMax();
            System.out.println(temp);
            System.out.println("-----------------------CONNECTIONS NUMBER: "+temp.getNumberOfConnection());
        }
    }

    //all Users---------------------------------------------------------------------------------------
    public void allUsers() {
        for (User user : NetworkMaker.network.vertices()) {

            System.out.println(user.toString());
            System.out.println("--------------------------CONNECTIONS---------------------------+\n\n\n");
            for (User connect : user.getConnections().getUsers()) {
                System.out.println(connect.getGeneralInfo().toString());
                System.out.println("----------------------------------------------------------------\n");
            }
        }

    }

    //follow or etc--------------------------------------------------------------------------------
    public void follow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Id Of user you want to follow:\n");
        int id = sc.nextInt();

        for (User user : NetworkMaker.network.vertices()) {
            if (user.getGeneralInfo().getID() == id) {
                NetworkMaker.network.insertEdge(signedIn, user, NetworkMaker.network.numEdges() + 1);
                signedIn.getConnections().getUsers().add(user);
                user.getConnections().getUsers().add(signedIn);
                break;
            }
        }

        System.out.println("You have followed the User with ID " + id);
    }

    //show the user suggestions--------------------------------------------------------------------
    public void showSuggestions() {

        Suggestion suggestion=new Suggestion(signedIn);
        signedIn.setSuggestions(suggestion);
        int counter=0;
        System.out.println("--------------------------SUGGESTIONS---------------------------+\n\n\n");
        MaxHeapPriorityQueue<Double, User> suggestions = signedIn.getSuggestions();
        while (!suggestions.isEmpty()) {
            if (counter == 20) break;
            System.out.println(suggestions.removeMax().getGeneralInfo().toString());
            counter++;
            System.out.println("------------------------------------------------------------------\n");
        }

    }

    //User Menu------------------------------------------------------------------------------------

    public void userMenu()
    {

        boolean finish = false;
        while (!finish) {
            System.out.println("What do you want to do??");
            System.out.println("1_Follow SomeBody\n2_See The Most Popular Users\n3_See all Users\n4_Show my connections\n5_Exit");
            int answer = sc.nextInt();

            switch (answer) {
                case 1 -> follow();
                case 2 -> popular();
                case 3 -> allUsers();
                case 4 -> showConnections();
                case 5 -> finish = true;
            }

        }
    }

    //show connections--------------------------------------------------------------------------------
    public void showConnections()
    {
        System.out.println("Numbers of Connections: "+signedIn.getConnections().getUsers().size());
        for (User user:signedIn.getConnections().getUsers())
        {
            System.out.println(user.getGeneralInfo().toString());
            System.out.println("----------------------------------------------------");
        }
    }
}
