package usersinfo;

import file.NetworkMaker;

import java.util.LinkedList;


public class Connections {
    private LinkedList<Integer> usersID ;
    private LinkedList<User> users;

    public Connections(LinkedList<Integer> users) {
        this.usersID = users;
        this.users=new LinkedList<>();

        if (users!=null)
        {
            findUsers();
        }
    }

    public LinkedList<Integer> getUsersID() {
        return this.usersID;
    }

    private void findUsers(){  //find user with ID
        for (Integer ID:this.usersID){
            for (User user: NetworkMaker.network.vertices()){
                if (user.getGeneralInfo().getID()==ID){
                    this.users.add(user);
                }
            }
        }
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsersID(LinkedList<Integer> usersID) {
        this.usersID = usersID;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
