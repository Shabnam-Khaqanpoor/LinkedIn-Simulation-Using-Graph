package com.example.socialnetwork.implementations;

import java.util.ArrayList;
import java.util.List;

// Implementation of the graph using an edge list
public class EdgeListGraph<V, E> implements Graph<V, E> {
    private List<V> vertices;               // List to store vertices
    private List<Edge<V, E>> edges;         // List to store edges

    // Constructor to initialize the graph
    public EdgeListGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    // Returns the number of vertices in the graph
    @Override
    public int numVertices() {
        return vertices.size();
    }

    // Returns a list of all vertices in the graph
    @Override
    public List<V> vertices() {
        return new ArrayList<>(vertices);
    }

    // Returns the number of edges in the graph
    @Override
    public int numEdges() {
        return edges.size();
    }

    // Returns a list of all edges in the graph
    @Override
    public List<E> edges() {
        List<E> edgeValues = new ArrayList<>();
        for (Edge<V, E> edge : edges) {
            edgeValues.add(edge.value);
        }
        return edgeValues;
    }

    // Returns the edge object associated with vertices u and v
    @Override
    public E getEdge(V u, V v) {
        for (Edge<V, E> edge : edges) {
            if (edge.source.equals(u) && edge.destination.equals(v)) {
                return edge.value;
            }
        }
        return null;
    }

    // Returns a list of the two endpoint vertices of edge e
    @Override
    public List<V> endVertices(E e) {
        for (Edge<V, E> edge : edges) {
            if (edge.value.equals(e)) {
                return List.of(edge.source, edge.destination);
            }
        }
        return null;
    }

    // Returns the vertex opposite to vertex v on edge e
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

    // Returns the out-degree of vertex v (number of outgoing edges)
    @Override
    public int outDegree(V v) {
        int outDegree = 0;
        for (Edge<V, E> edge : edges) {
            if (edge.source.equals(v)) {
                outDegree++;
            }
        }
        return outDegree;
    }

    // Returns the in-degree of vertex v (number of incoming edges)
    @Override
    public int inDegree(V v) {
        int inDegree = 0;
        for (Edge<V, E> edge : edges) {
            if (edge.destination.equals(v)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    // Returns a list of outgoing edges from vertex v
    @Override
    public List<E> outgoingEdges(V v) {
        List<E> outgoingEdges = new ArrayList<>();
        for (Edge<V, E> edge : edges) {
            if (edge.source.equals(v)) {
                outgoingEdges.add(edge.value);
            }
        }
        return outgoingEdges;
    }

    // Returns a list of incoming edges to vertex v
    @Override
    public List<E> incomingEdges(V v) {
        List<E> incomingEdges = new ArrayList<>();
        for (Edge<V, E> edge : edges) {
            if (edge.destination.equals(v)) {
                incomingEdges.add(edge.value);
            }
        }
        return incomingEdges;
    }

    // Inserts a new vertex with element x into the graph
    @Override
    public void insertVertex(V x) {
        if (!vertices.contains(x)) {
            vertices.add(x);
        }
    }

    // Inserts a new edge with element x connecting vertices u and v into the graph
    @Override
    public void insertEdge(V u, V v, E x) {
        if (vertices.contains(u) && vertices.contains(v)) {
            edges.add(new Edge<>(u, v, x));
        }
    }

    // Removes vertex v from the graph
    @Override
    public void removeVertex(V v) {
        vertices.remove(v);
        edges.removeIf(edge -> edge.source.equals(v) || edge.destination.equals(v));
    }

    // Removes edge e from the graph
    @Override
    public void removeEdge(E e) {
        edges.removeIf(edge -> edge.value.equals(e));
    }

    // Inner class representing an edge
    private static class Edge<V, E> {
        V source;         // Source vertex of the edge
        V destination;    // Destination vertex of the edge
        E value;          // Value associated with the edge

        // Constructor for the edge
        Edge(V source, V destination, E value) {
            this.source = source;
            this.destination = destination;
            this.value = value;
        }
    }
}