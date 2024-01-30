package implementations.Heap;

// Interface for the priority queue ADT
interface PriorityQueue<K, V> {
    int size();

    boolean isEmpty();

    Entry<K, V> insert(K key, V value);

    Entry<K, V> min();

    V removeMax();
}