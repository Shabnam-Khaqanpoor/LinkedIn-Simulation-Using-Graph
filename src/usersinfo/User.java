package usersinfo;

import implementations.Heap.MaxHeapPriorityQueue;

public class User {
    private GeneralInfo generalInfo;
    private UserSpecializedInfo specializedInfo;
    private UserSkills skills;
    private Connections connections;
    private UserPriorities priority;        //for calculating score of people
    private Suggestion suggestions;


    public User(GeneralInfo generalInfo, UserSpecializedInfo specializedInfo, UserSkills skills, Connections connections, UserPriorities priority) {
        this.generalInfo = generalInfo;
        this.specializedInfo = specializedInfo;
        this.skills = skills;
        this.connections = connections;
        this.priority = priority;
    }


    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public UserSpecializedInfo getSpecializedInfo() {
        return specializedInfo;
    }

    public void setSpecializedInfo(UserSpecializedInfo specializedInfo) {
        this.specializedInfo = specializedInfo;
    }

    public UserSkills getSkills() {
        return skills;
    }

    public void setSkills(UserSkills skills) {
        this.skills = skills;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public UserPriorities getPriority() {
        return priority;
    }

    public void setPriority(UserPriorities priority) {
        this.priority = priority;
    }

    public MaxHeapPriorityQueue<Double, User> getSuggestions() {
        return this.suggestions.getSuggestions();
    }

    public void setSuggestions(Suggestion suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return
                generalInfo.toString() + "\n" +
                        "SpecializedInfo:\n" + specializedInfo.toString() + "\n" +
                        "Skills:\n" + skills.toString() + "\n" +
                        "\n"+priority.toString() + "\n";
    }
}