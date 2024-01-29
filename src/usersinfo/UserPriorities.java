package usersinfo;


public class UserPriorities {
    private double generalPriority = 1;
    private double specializedPriority = 3;
    private double skillPriority = 4;
    private double connectionPriority = 2;

    public UserPriorities(double generalPriority, double specializedPriority, double skillPriority, double connectionPriority) {
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

    public double getGeneralPriority() {
        return generalPriority;
    }

    public double getSpecializedPriority() {
        return specializedPriority;
    }

    public double getSkillPriority() {
        return skillPriority;
    }

    public double getConnectionPriority() {
        return connectionPriority;
    }
}
