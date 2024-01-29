package implementations.Heap;

//Interface for a key-value pair.
interface Entry<K, V> {
    K getKey();

    V getValue();
}