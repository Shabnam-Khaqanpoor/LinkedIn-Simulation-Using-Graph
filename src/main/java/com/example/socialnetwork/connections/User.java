package com.example.socialnetwork.connections;

import java.util.LinkedList;
import java.util.Map;

class User {
    Map<String,String> generalInfo;
    Map<String,String> specializedInfo;
    LinkedList<String> skills;
    LinkedList<Integer> connections;
    LinkedList<Integer> priority;        //for calculating score of people

    //todo: add maxHeap for scores

    public User(Map<String, String> generalInfo, Map<String, String> specializedInfo, LinkedList<String> skills, LinkedList<Integer> connections,LinkedList<Integer> priority) {
        this.generalInfo = generalInfo;
        this.specializedInfo = specializedInfo;
        this.skills = skills;
        this.connections = connections;
        this.priority=priority;
    }
}