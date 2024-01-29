package connections;

import implementations.Heap.MaxHeapPriorityQueue;

import java.io.File;
import java.security.Key;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

class User {
    Map<String, String> generalInfo;
    Map<String, String> specializedInfo;
    LinkedList<String> skills;
    LinkedList<Integer> connections;
    LinkedList<Integer> priority;        //for calculating score of people

    MaxHeapPriorityQueue<Integer, User> suggestions;
    //key:ID  value:score


    public User(Map<String, String> generalInfo, Map<String, String> specializedInfo, LinkedList<String> skills, LinkedList<Integer> connections, LinkedList<Integer> priority,LinkedList<User> users) {
        this.generalInfo = generalInfo;
        this.specializedInfo = specializedInfo;
        this.skills = skills;
        this.connections = connections;
        this.priority = priority;
//        this.suggestions=new MaxHeapPriorityQueue<Integer,User>();


        for (User user:users){
            findSuggestions(user);
            if (this.suggestions.size()==20)break;
        }

    }

    int generalCalculate(User user) {
        int counter = 0;
        for (String general : this.generalInfo.values()) {          //calculate generalInfo;
            if (user.generalInfo.containsValue(general)) {
                counter++;
            }
        }
        return (this.priority.get(0) * counter);
    }
    int specializedCalculate(User user) {
        int counter = 0;
        for (String specialized : this.specializedInfo.values()) {          //calculate specializedInfo;
            if (user.specializedInfo.containsValue(specialized)) {
                counter++;
            }
        }
        return (this.priority.get(1) * counter);
    }
    int skillsCalculate(User user) {
        int counter = 0;
        for (String skill : this.skills) {          //calculate skills;
            if (user.skills.contains(skill)) {
                counter++;
            }
        }
        return (this.priority.get(2) * counter);
    }
    int connectionsCalculate(User user) {
        int counter = 0;
        for (int connection : this.connections) {          //calculate connections;
            if (user.connections.contains(connection)) {
                counter++;
            }
        }
        return (this.priority.get(3) * counter);
    }

    void findSuggestions(User user) {
        int score= generalCalculate(user)+specializedCalculate(user)+skillsCalculate(user)+connectionsCalculate(user);   //sum all scores
        this.suggestions.insert(score,user);
    }

    public MaxHeapPriorityQueue<Integer, User> getSuggestions() {
        return suggestions;
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