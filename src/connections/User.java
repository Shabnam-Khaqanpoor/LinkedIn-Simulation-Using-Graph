package connections;

import java.util.LinkedList;
import java.util.Map;

class User {
    Map<String,String> generalInfo;
    Map<String,String> specializedInfo;
    LinkedList<String> skills;
    LinkedList<Integer> connections;
    LinkedList<Integer> priority;        //for calculating score of people

    //todo: implementation of heap for calculating score

    public User(Map<String, String> generalInfo, Map<String, String> specializedInfo, LinkedList<String> skills, LinkedList<Integer> connections,LinkedList<Integer> priority) {
        this.generalInfo = generalInfo;
        this.specializedInfo = specializedInfo;
        this.skills = skills;
        this.connections = connections;
        this.priority=priority;
    }

    public void setGeneralInfo(Map<String, String> generalInfo) {
        this.generalInfo = generalInfo;
    }

    public void setSpecializedInfo(Map<String, String> specializedInfo) {
        this.specializedInfo = specializedInfo;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }

    public void setConnections(LinkedList<Integer> connections) {
        this.connections = connections;
    }

    public void setPriority(LinkedList<Integer> priority) {
        this.priority = priority;
    }

    public Map<String, String> getGeneralInfo() {
        return generalInfo;
    }

    public Map<String, String> getSpecializedInfo() {
        return specializedInfo;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public LinkedList<Integer> getConnections() {
        return connections;
    }

    public LinkedList<Integer> getPriority() {
        return priority;
    }
}