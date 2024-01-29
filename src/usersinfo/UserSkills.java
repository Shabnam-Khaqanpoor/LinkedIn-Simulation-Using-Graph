package usersinfo;

import java.util.LinkedList;

public class UserSkills {
   private LinkedList<String> skills=new LinkedList<>();

    public UserSkills(LinkedList<String> skills) {
        this.skills = skills;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }
}
