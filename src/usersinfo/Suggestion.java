package usersinfo;

import file.NetworkMaker;
import implementations.Heap.MaxHeapPriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;


public class Suggestion {
    private User account;

    private MaxHeapPriorityQueue<Double, User> suggestions=new MaxHeapPriorityQueue<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o1.compareTo(o2);
        }
    });

    public Suggestion(User account) {
            this.account = account;

            if (account.getConnections().getUsers().size()>0) {
                setSuggestions(this.account.getConnections().getUsers());
            }
            else
            {
                suggestForNewUsers();
            }

    }

    void setSuggestions(LinkedList<User>connections) {       //suggest till 5 degree

        for (User neighbor : connections) {
            findSuggestionsRecursive(neighbor, 1);
        }
    }

    void findSuggestionsRecursive(User user, int degree) {
        if (degree > 5) {
            return;
        }

        for (User suggest : user.getConnections().getUsers()) {
            findSuggestions(suggest);
            findSuggestionsRecursive(suggest, degree + 1);
        }
    }

    double generalCalculate(User oppositeUser) {
        int counter = 0;
        //calculate generalInfo;
        if (this.account.getGeneralInfo().getLastname().equals(oppositeUser.getGeneralInfo().getLastname())) counter++;
        if (this.account.getGeneralInfo().getBirth().getYear() == oppositeUser.getGeneralInfo().getBirth().getYear())
            counter++;

        return (Math.pow(100, this.account.getPriority().getGeneralPriority()) * counter);
    }

    double specializedCalculate(User oppositeUser) {
        int counter = 0;
        //calculate specializedInfo;

        if (this.account.getSpecializedInfo().getFieldOfStudy().equals(oppositeUser.getSpecializedInfo().getFieldOfStudy()))
            counter++;
        if (this.account.getSpecializedInfo().getUniversity().equals(oppositeUser.getSpecializedInfo().getUniversity()))
            counter++;
        if (this.account.getSpecializedInfo().getWorkPlace().equals(oppositeUser.getSpecializedInfo().getWorkPlace()))
            counter++;

        return (Math.pow(100, this.account.getPriority().getSpecializedPriority()) * counter);
    }

    double skillsCalculate(User oppositeUser) {
        int counter = 0;
        //calculate skills;
        for (String skill : this.account.getSkills().getSkills()) {
            if (oppositeUser.getSkills().getSkills().contains(skill)) counter++;
        }

        return (Math.pow(100, this.account.getPriority().getSkillPriority()) * counter);
    }

    double connectionsCalculate(User oppositeUser) {
        int counter = 0;
        //calculate connections;
        if (this.account.getConnections().getUsers().size()>0)
        {
            for (int connection : this.account.getConnections().getUsersID()) {
                if (oppositeUser.getConnections().getUsersID().contains(connection)) {
                    counter++;
                }
            }
        }

        return (Math.pow(100, this.account.getPriority().getConnectionPriority()) * counter);
    }

    public void findSuggestions(User oppositeUser) {
        double score = generalCalculate(oppositeUser) + specializedCalculate(oppositeUser) + skillsCalculate(oppositeUser) + connectionsCalculate(oppositeUser);   //sum all scores
        this.suggestions.insert(score, oppositeUser);
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public MaxHeapPriorityQueue<Double, User> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(MaxHeapPriorityQueue<Double, User> suggestions) {
        this.suggestions = suggestions;
    }

    public void suggestForNewUsers()
    {
        for (User neighbor : NetworkMaker.network.vertices()) {   //if neighbor is not her/his self and is not in her/his connections
            if (!neighbor.equals(this.account)) findSuggestions(neighbor);
        }
    }
}
