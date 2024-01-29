package usersinfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneralInfo {
    private int ID;
    private String name;
    private String lastname;
    private LocalDate birth;

    public GeneralInfo(int ID, String name, String lastname, String birth) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        //agr toolesh 10 bashe yani kamle formatesh kamele
        if (birth.length() == 10) {
            formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        }

        else{
            //hala agar 9 taii bashe 2 halat dare ya mahesh 1 raghame ya rozesh
            if (birth.length()==9)
            {
                if (birth.charAt(6)=='/')
                {
                    formatter = DateTimeFormatter.ofPattern("yyyy/M/dd");
                }
                else
                {
                    formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
                }
            }
            //kolan kame khoda zadatesh
            else
            {
                formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
            }
        }
        LocalDate date = LocalDate.parse(birth, formatter);
        this.birth = date;
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

    public void setBirth(LocalDate birth) {
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

    public LocalDate getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "GeneralInfo{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
