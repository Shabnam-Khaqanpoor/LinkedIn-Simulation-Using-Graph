package usersinfo;

import java.util.LinkedList;

public class Connections {
    private LinkedList<Integer> users = new LinkedList<>();

    public Connections(LinkedList<Integer> users) {
        this.users = users;
    }

    public LinkedList<Integer> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<Integer> users) {
        this.users = users;
    }
}
