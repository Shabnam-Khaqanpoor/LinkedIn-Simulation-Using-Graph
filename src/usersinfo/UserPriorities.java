package usersinfo;


public class UserPriorities {
    private int generalPriority = 1;
    private int specializedPriority = 3;
    private int skillPriority = 4;
    private int connectionPriority = 2;

    public UserPriorities(int generalPriority, int specializedPriority, int skillPriority, int connectionPriority) {
        this.generalPriority = generalPriority;
        this.specializedPriority = specializedPriority;
        this.skillPriority = skillPriority;
        this.connectionPriority = connectionPriority;
    }

    public UserPriorities() {
    }

    public void setGeneralPriority(int generalPriority) {
        this.generalPriority = generalPriority;
    }

    public void setSpecializedPriority(int specializedPriority) {
        this.specializedPriority = specializedPriority;
    }

    public void setSkillPriority(int skillPriority) {
        this.skillPriority = skillPriority;
    }

    public void setConnectionPriority(int connectionPriority) {
        this.connectionPriority = connectionPriority;
    }

    public int getGeneralPriority() {
        return generalPriority;
    }

    public int getSpecializedPriority() {
        return specializedPriority;
    }

    public int getSkillPriority() {
        return skillPriority;
    }

    public int getConnectionPriority() {
        return connectionPriority;
    }
}
