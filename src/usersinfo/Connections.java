package usersinfo;

import file.ReadJson;

import java.util.LinkedList;

public class Connections {
    private LinkedList<Integer> usersID ;
    private LinkedList<User> users;

    public Connections(LinkedList<Integer> users) {
        this.usersID = users;
        this.users=new LinkedList<>();
        findUsers();
    }

    public LinkedList<Integer> getUsersID() {
        return this.usersID;
    }

    private void findUsers(){
        for (Integer ID:this.usersID){
            for (User user: ReadJson.Network.vertices()){
                if (user.getGeneralInfo().getID()==ID){
                    this.users.add(user);
                }
            }
        }
    }

    public LinkedList<User> getUsers() {
        return users;
    }
}
