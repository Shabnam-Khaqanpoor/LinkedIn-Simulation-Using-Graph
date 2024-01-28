package com.example.socialnetwork.implementations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph<V, E> implements Graph<V, E> {
    // Maps vertices to a list of incident edges
    private Map<V, List<E>> adjacencyList;

    // Maps edges to a pair of incident vertices
    private Map<E, Pair<V>> incidentVertices;   //shows the o and d vertices and map them to edge


    // Constructor initializes the adjacencyList and incidentVertices maps
    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
        incidentVertices = new HashMap<>();
    }

    // Returns the number of vertices in the graph
    @Override
    public int numVertices() {
        return adjacencyList.size();
    }

    // Returns a list of all vertices in the graph
    @Override
    public List<V> vertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Returns the number of edges in the graph
    @Override
    public int numEdges() {
        return incidentVertices.size();
    }

    // Returns a list of all edges in the graph
    @Override
    public List<E> edges() {
        return new ArrayList<>(incidentVertices.keySet());
    }

    // Returns the edge between vertices u and v, if it exists;if not it returns null
    @Override
    public E getEdge(V u, V v) {
        List<E> edges = adjacencyList.get(u);
        if (edges != null) {
            for (E edge : edges) {
                Pair<V> endVertices = incidentVertices.get(edge);
                if (endVertices != null && (endVertices.origin.equals(v) || endVertices.destination.equals(v))) {
                    return edge;
                }
            }
        }
        return null;
    }

    // Returns a list of the two vertices associated with edge e; else returns null
    @Override
    public List<V> endVertices(E e) {
        Pair<V> endVertices = incidentVertices.get(e);
        if (endVertices != null) return List.of(endVertices.origin, endVertices.destination);
        return null;
    }

    // Returns the vertex opposite to v along edge e; if it doesn't have opposite returns null
    @Override
    public V opposite(V v, E e) {
        Pair<V> endVertices = incidentVertices.get(e);
        if (endVertices != null) {
            if (endVertices.origin.equals(v)) {
                return endVertices.destination;
            } else if (endVertices.destination.equals(v)) {
                return endVertices.origin;
            }
        }
        return null;
    }

    // Returns the out-degree of vertex v; if edge isn't
    @Override
    public int outDegree(V v) {
        List<E> edges = adjacencyList.get(v);
        if (edges != null) return edges.size();
        return 0;
    }

    // Returns the in-degree of vertex v
    @Override
    public int inDegree(V v) {
        int inDegree = 0;
        for (Pair<V> endVertices : incidentVertices.values()) {
            if (endVertices.origin.equals(v) || endVertices.destination.equals(v)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    // Returns a list of outgoing edges from vertex v
    @Override
    public List<E> outgoingEdges(V v) {
        return adjacencyList.get(v);
    }

    // Returns a list of incoming edges to vertex v
    @Override
    public List<E> incomingEdges(V v) {
        List<E> incomingEdges = new ArrayList<>();
        for (Map.Entry<E, Pair<V>> entry : incidentVertices.entrySet()) {
            if (entry.getValue().origin.equals(v) || entry.getValue().destination.equals(v)) {
                incomingEdges.add(entry.getKey());
            }
        }
        return incomingEdges;
    }

    // Inserts a new vertex x into the graph
    @Override
    public void insertVertex(V x) {
        if (!adjacencyList.containsKey(x)) {
            adjacencyList.put(x, new ArrayList<>());
        }
    }

    // Inserts a new edge x between vertices u and v
    @Override
    public void insertEdge(V u, V v, E x) {
        if (adjacencyList.containsKey(u) && adjacencyList.containsKey(v)) {
            List<E> edgesU = adjacencyList.get(u);
            List<E> edgesV = adjacencyList.get(v);

            edgesU.add(x);
            edgesV.add(x);

            incidentVertices.put(x, new Pair<>(u, v));
        }
    }

    // Removes vertex v and its incident edges from the graph
    @Override
    public void removeVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            List<E> edgesToRemove = adjacencyList.get(v);
            for (E edge : edgesToRemove) {
                Pair<V> endVertices = incidentVertices.get(edge);
                if (endVertices != null) {
                    if (endVertices.origin.equals(v)) {
                        endVertices.origin = null;
                    } else if (endVertices.destination.equals(v)) {
                        endVertices.destination = null;
                    }
                    if (endVertices.origin == null && endVertices.destination == null) {
                        incidentVertices.remove(edge);
                    }
                }
            }
            adjacencyList.remove(v);
        }
    }

    // Removes edge e from the graph
    @Override
    public void removeEdge(E e) {
        incidentVertices.remove(e);
        for (List<E> edges : adjacencyList.values()) {
            edges.remove(e);
        }
    }

    // Private helper class to represent a pair of vertices
    //it shows the start and end verices of an edge
    private static class Pair<V> {
        V origin, destination;

        public Pair(V first, V second) {
            this.origin = first;
            this.destination = second;
        }
    }
}
