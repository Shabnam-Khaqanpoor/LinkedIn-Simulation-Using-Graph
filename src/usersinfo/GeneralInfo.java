package usersinfo;

import java.util.Date;

public class GeneralInfo {
    private int ID;
    private String name;
    private String lastname;
    private Date birth;

    public GeneralInfo(int ID, String name, String lastname, Date birth) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirth() {
        return birth;
    }
}
