package com.example.socialnetwork.implementations.Graph;
import java.util.List;

public interface Graph<V, E> {
    int numVertices();
    List<V> vertices();
    int numEdges();
    List<E> edges();
    E getEdge(V u, V v);
    List<V> endVertices(E e);
    V opposite(V v, E e);
    int outDegree(V v);
    int inDegree(V v);
    List<E> outgoingEdges(V v);
    List<E> incomingEdges(V v);
    void insertVertex(V x);
    void insertEdge(V u, V v, E x);
    void removeVertex(V v);
    void removeEdge(E e);
}
