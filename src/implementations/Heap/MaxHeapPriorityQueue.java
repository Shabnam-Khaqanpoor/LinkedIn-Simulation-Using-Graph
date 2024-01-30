package implementations.Heap;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /** primary collection of priority queue entries */
    protected ArrayList<Entry<K,V>> heap=new ArrayList<>();

    /**
     * Creates an empty max heap using the given comparator to order keys.
     */
    public MaxHeapPriorityQueue(Comparator<K> c) {
        super(c);
    }

    /**
     * Returns the maximum entry in the max heap (root of the heap).
     */
    @Override
    public Entry<K, V> min() {
        if (getHeap().isEmpty()) {
            return null;
        }
        return getHeap().get(0);
    }

    /**
     * Moves the entry at index 'j' up the heap to restore the heap property.
     */
    protected void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(getHeap().get(j), getHeap().get(p)) <= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    /**
     * Moves the entry at index 'j' down the heap to restore the heap property.
     */
    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int maxChildIndex = leftIndex;

            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(getHeap().get(rightIndex), getHeap().get(leftIndex)) > 0) {
                    maxChildIndex = rightIndex;
                }
            }

            if (compare(getHeap().get(maxChildIndex), getHeap().get(j)) <= 0) {
                break;
            }

            swap(j, maxChildIndex);
            j = maxChildIndex;
        }
    }

    @Override
    public int size() {
        return getHeap().size();
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        getHeap().add(newest);
        upHeap(getHeap().size() - 1);
        return newest;
    }

    /**
     * Removes and returns the maximum entry in the max heap.
     */
    @Override
    public V removeMax() {
        if (getHeap().isEmpty()) {
            return null;
        }
        Entry<K, V> maxEntry = getHeap().get(0);
        swap(0, getHeap().size() - 1);
        getHeap().remove(getHeap().size() - 1);
        downHeap(0);
        return maxEntry.getValue();
    }

    /**
     * Exchanges the entries at indices i and j of the arrayList.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = getHeap().get(i);
        getHeap().set(i, getHeap().get(j));
        getHeap().set(j, temp);
    }

    /**
     * Returns the ArrayList representing the heap.
     */
    public ArrayList<Entry<K, V>> getHeap() {
        return heap;
    }

    /**
     * Sets the ArrayList representing the heap.
     */
    public void setHeap(ArrayList<Entry<K, V>> heap) {
        this.heap = heap;
    }

    /**
     * Returns the index of the parent of the element at index 'j'.
     */
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    /**
     * Returns the index of the left child of the element at index 'j'.
     */
    protected int left(int j) {
        return 2 * j + 1;
    }

    /**
     * Returns the index of the right child of the element at index 'j'.
     */
    protected int right(int j) {
        return 2 * j + 2;
    }

    /**
     * Checks if an element has a left child.
     */
    protected boolean hasLeft(int j) {
        return left(j) < getHeap().size();
    }

    /**
     * Checks if an element has a right child.
     */
    protected boolean hasRight(int j) {
        return right(j) < getHeap().size();
    }
}