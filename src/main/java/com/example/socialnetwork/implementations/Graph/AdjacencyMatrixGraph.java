package com.example.socialnetwork.implementations.Graph;

import java.util.ArrayList;
import java.util.List;

// Implementation of a graph using an adjacency matrix
public class AdjacencyMatrixGraph<V, E> implements Graph<V, E> {
    // Adjacency matrix to represent edges between vertices
    private List<List<E>> adjacencyMatrix;
    // List to store vertices
    private List<V> vertices;

    // Constructor to initialize the adjacency matrix and vertices list
    public AdjacencyMatrixGraph() {
        this.adjacencyMatrix = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    // Method to get the number of vertices in the graph
    @Override
    public int numVertices() {
        return this.vertices.size();
    }

    // Method to get a copy of the list of vertices in the graph
    @Override
    public List<V> vertices() {
        return new ArrayList<>(this.vertices);
    }

    // Method to get the number of edges in the graph
    @Override
    public int numEdges() {
        int count = 0;
        for (List<E> row : this.adjacencyMatrix) {  //traverse
            for (E edge : row) {
                if (edge != null) {
                    count++;
                }
            }
        }
        return count;
    }

    // Method to get a copy of the list of all edges in the graph
    @Override
    public List<E> edges() {
        List<E> allEdges = new ArrayList<>();
        for (List<E> row : this.adjacencyMatrix) {
            allEdges.addAll(row);
        }
        return allEdges;
    }

    // Method to get the edge between two vertices
    @Override
    public E getEdge(V u, V v) {
        int uIndex = this.vertices.indexOf(u);        //get end vertices
        int vIndex = this.vertices.indexOf(v);

        if (uIndex != -1 && vIndex != -1) {
            return this.adjacencyMatrix.get(uIndex).get(vIndex);       //find the edge
        }
        return null;
    }

    // Method to get the end vertices of an edge
    @Override
    public List<V> endVertices(E e) {
        List<V> endVertices = new ArrayList<>();
        for (int i = 0; i < this.adjacencyMatrix.size(); i++) {
            for (int j = 0; j < this.adjacencyMatrix.get(i).size(); j++) {
                if (this.adjacencyMatrix.get(i).get(j) != null && this.adjacencyMatrix.get(i).get(j).equals(e)) {   //find the edge
                    endVertices.add(this.vertices.get(i));      //store vertices
                    endVertices.add(this.vertices.get(j));
                    return endVertices;
                }
            }
        }
        return null;
    }

    // Method to get the opposite vertex of a given vertex along an edge
    @Override
    public V opposite(V v, E e) {
        List<V> endVertices = endVertices(e);      //find edge

        if (endVertices != null) {
            for (V vertex : endVertices) {
                if (!vertex.equals(v)) {        //store the opposite vertex
                    return vertex;
                }
            }
        }
        return null;
    }

    // Method to get the out-degree of a vertex
    @Override
    public int outDegree(V v) {
        int vIndex = this.vertices.indexOf(v);
        if (vIndex != -1) {
            int outDegree = 0;
            for (E edge : this.adjacencyMatrix.get(vIndex)) {      //traverse in edges
                if (edge != null) {
                    outDegree++;
                }
            }
            return outDegree;
        }
        return 0;
    }

    // Method to get the in-degree of a vertex
    @Override
    public int inDegree(V v) {
        int vIndex = this.vertices.indexOf(v);
        if (vIndex != -1) {
            int inDegree = 0;
            for (List<E> row : this.adjacencyMatrix) {      //traverse in rows
                if (row.get(vIndex) != null) {
                    inDegree++;
                }
            }
            return inDegree;
        }
        return 0;
    }

    // Method to get a copy of the list of outgoing edges from a vertex
    @Override
    public List<E> outgoingEdges(V v) {
        int vIndex = this.vertices.indexOf(v);
        if (vIndex != -1) {
            return new ArrayList<>(this.adjacencyMatrix.get(vIndex));
        }
        return null;
    }

    // Method to get a copy of the list of incoming edges to a vertex
    @Override
    public List<E> incomingEdges(V v) {
        int vIndex = this.vertices.indexOf(v);
        if (vIndex != -1) {
            List<E> incomingEdges = new ArrayList<>();
            for (List<E> row : this.adjacencyMatrix) {
                incomingEdges.add(row.get(vIndex));
            }
            return incomingEdges;
        }
        return null;
    }

    // Method to insert a new vertex into the graph
    @Override
    public void insertVertex(V x) {
        if (!this.vertices.contains(x)) {
            this.vertices.add(x);              //add vertex
            for (List<E> row : this.adjacencyMatrix) {
                row.add(null);                             //add null edge in whole of the row
            }
            List<E> newRow = new ArrayList<>(this.vertices.size());   //create a new row

            for (int i = 0; i < this.vertices.size(); i++) {
                newRow.add(null);                               //add null edge in whole of the row
            }
            this.adjacencyMatrix.add(newRow);
        }
    }

    // Method to insert a new edge between two vertices into the graph
    @Override
    public void insertEdge(V u, V v, E x) {
        int uIndex = this.vertices.indexOf(u);   //store indexes
        int vIndex = this.vertices.indexOf(v);
        if (uIndex != -1 && vIndex != -1) {
            this.adjacencyMatrix.get(uIndex).set(vIndex, x);   //add edge
        }
    }

    // Method to remove a vertex from the graph
    @Override
    public void removeVertex(V v) {
        int vIndex = this.vertices.indexOf(v);
        if (vIndex != -1) {
            this.vertices.remove(vIndex);
            this.adjacencyMatrix.remove(vIndex);
            for (List<E> row : this.adjacencyMatrix) {
                row.remove(vIndex);
            }
        }
    }

    // Method to remove an edge from the graph
    @Override
    public void removeEdge(E e) {
        for (List<E> row : this.adjacencyMatrix) {
            row.remove(e);
        }
    }
}
