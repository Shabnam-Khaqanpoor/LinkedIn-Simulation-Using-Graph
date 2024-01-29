package com.example.socialnetwork.implementations;

import java.util.*;

// Implementation of a graph using an adjacency map
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    // Map to store vertices and their corresponding adjacency maps
    private Map<V, Map<V, E>> adjacencyMap;

    // Constructor to initialize the adjacency map
    public AdjacencyMapGraph() {
        this.adjacencyMap = new HashMap<>();
    }

    // Method to get the number of vertices in the graph
    @Override
    public int numVertices() {
        return this.adjacencyMap.size();
    }

    // Method to get a copy of the list of vertices in the graph
    @Override
    public List<V> vertices() {
        return new ArrayList<>(this.adjacencyMap.keySet());
    }

    // Method to get the number of edges in the graph
    @Override
    public int numEdges() {
        int count = 0;
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            count += edges.size();
        }
        return count;
    }

    // Method to get a copy of the list of all edges in the graph
    @Override
    public List<E> edges() {
        List<E> allEdges = new ArrayList<>();
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            allEdges.addAll(edges.values());
        }
        return allEdges;
    }

    // Method to get the edge between two vertices
    @Override
    public E getEdge(V u, V v) {
        if (this.adjacencyMap.containsKey(u)) {
            Map<V, E> edgesU = this.adjacencyMap.get(u);
            return edgesU.get(v);
        }
        return null;
    }

    // Method to get the end vertices of an edge
    @Override
    public List<V> endVertices(E e) {
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            for (Map.Entry<V, E> entry : edges.entrySet()) {
                if (entry.getValue().equals(e)) {
                    return List.of(entry.getKey(), getKeyByValue(edges, e));
                }
            }
        }
        return null;
    }

    // Method to get the opposite vertex of a given vertex along an edge
    @Override
    public V opposite(V v, E e) {
        List<V> endVertices = endVertices(e);
        if (endVertices != null) {
            for (V vertex : endVertices) {
                if (!vertex.equals(v)) {
                    return vertex;
                }
            }
        }
        return null;
    }

    // Method to get the out-degree of a vertex
    @Override
    public int outDegree(V v) {
        if (this.adjacencyMap.containsKey(v)) {
            return this.adjacencyMap.get(v).size();
        }
        return 0;
    }

    // Method to get the in-degree of a vertex
    @Override
    public int inDegree(V v) {
        int inDegree = 0;
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            for (V vertex : edges.keySet()) {
                if (vertex.equals(v)) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }

    // Method to get a copy of the list of outgoing edges from a vertex
    @Override
    public List<E> outgoingEdges(V v) {
        if (this.adjacencyMap.containsKey(v)) {
            return new ArrayList<>(this.adjacencyMap.get(v).values());
        }
        return null;
    }

    // Method to get a copy of the list of incoming edges to a vertex
    @Override
    public List<E> incomingEdges(V v) {
        List<E> incomingEdges = new ArrayList<>();
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            for (Map.Entry<V, E> entry : edges.entrySet()) {
                if (entry.getKey().equals(v)) {
                    incomingEdges.add(entry.getValue());
                }
            }
        }
        return incomingEdges;
    }

    // Method to insert a new vertex into the graph
    @Override
    public void insertVertex(V x) {
        if (!this.adjacencyMap.containsKey(x)) {
            this.adjacencyMap.put(x, new HashMap<>());
        }
    }

    // Method to insert a new edge between two vertices into the graph
    @Override
    public void insertEdge(V u, V v, E x) {
        if (this.adjacencyMap.containsKey(u) && this.adjacencyMap.containsKey(v)) {
            this.adjacencyMap.get(u).put(v, x);
        }
    }

    // Method to remove a vertex from the graph
    @Override
    public void removeVertex(V v) {
        if (this.adjacencyMap.containsKey(v)) {
            this.adjacencyMap.remove(v);
            for (Map<V, E> edges : this.adjacencyMap.values()) {
                edges.remove(v);
            }
        }
    }

    // Method to remove an edge from the graph
    @Override
    public void removeEdge(E e) {
        for (Map<V, E> edges : this.adjacencyMap.values()) {
            edges.values().remove(e);
        }
    }

    // Helper method to get the key by value from a map
    private V getKeyByValue(Map<V, E> map, E value) {
        for (Map.Entry<V, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
