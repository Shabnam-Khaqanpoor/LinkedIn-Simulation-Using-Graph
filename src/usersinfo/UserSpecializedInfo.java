package usersinfo;

public class UserSpecializedInfo {
    private String university;
    private String fieldOfStudy;
    private String workPlace;

    public UserSpecializedInfo(String university, String fieldOfStudy, String workPlace) {
        this.university = university;
        this.fieldOfStudy = fieldOfStudy;
        this.workPlace = workPlace;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Override
    public String toString() {
        return "UserSpecializedInfo{" +
                "university='" + university + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", workPlace='" + workPlace + '\'' +
                '}';
    }
}
