package tad_fila_prioridade_heap;
import tad_lista_de_nodos.*;
import java.util.Comparator;
import arvore_binaria_completa.*;
import baseado_em_lista.*;
import exception.*;

public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected CompleteBinaryTree<Entry<K, V>> heap;
    protected Comparator<K> comp; 
    protected static class MyEntry<K, V> implements Entry<K, V> {
    protected K key;
    protected V value;

    public MyEntry(K k, V v) {
        key = k;
        value = v;
    }
    
    public K getKey() { 
        return key; }

    public V getValue() {
         return value; }

    public String toString() { 
        return "(" + key + "," + value + ")"; }
    }
    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
        comp = new DefaultComparator<K>();
    }

    public HeapPriorityQueue(Comparator<K> c) {
    heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
    comp = c;
    }

    public void setComparator(Comparator<K> c) throws IllegalStateException {
        if (!isEmpty())
        throw new IllegalStateException("Priority queue is not empty");
        comp = c;
    }

    public int size() { 
        return heap.size(); }
    
    public boolean isEmpty() { 
        return heap.size() == 0; 
    }
    
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
            return heap.root().element();
    }

    public Entry<K, V> insert(K k, V x) throws InvalidKeyException {
        checkKey(k); // pode lançar um InvalidKeyException
        Entry<K, V> entry = new MyEntry<K, V>(k, x);
        upHeap(heap.add(entry));
        return entry;
    }

    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
        Entry<K, V> min = heap.root().element();
        if (size() == 1) heap.remove();
        else {
            heap.replace(heap.root(), heap.remove());
            downHeap(heap.root());
        }
        return min;
    }

    protected void checkKey(K key) throws InvalidKeyException {
        try {
            comp.compare(key, key);
        } catch (Exception e) {
            throw new InvalidKeyException("Invalid key");
        }
    }

    protected void upHeap(Position<Entry<K, V>> v) {
        Position<Entry<K, V>> u;
        while (!heap.isRoot(v)) {
            u = heap.parent(v);
            if (comp.compare(u.element().getKey(), v.element().getKey()) <= 0) break;
            swap(u, v);
            v = u;
        }
    }

    protected void downHeap(Position<Entry<K, V>> r) {
        while (heap.isInternal(r)) {
            Position<Entry<K, V>> s; // a posição do menor filho
        if (!heap.hasRight(r)) s = heap.left(r);
        else if (comp.compare(heap.left(r).element().getKey(), heap.right(r).element().getKey()) <= 0)
            s = heap.left(r);
        else s = heap.right(r);
        if (comp.compare(s.element().getKey(), r.element().getKey()) < 0) {
            swap(r, s);
            r = s;
        } else break;
        }
    
    }
    
    protected void swap(Position<Entry<K, V>> x, Position<Entry<K, V>> y) {
            Entry<K, V> temp = x.element();
            heap.replace(x, y.element());
            heap.replace(y, temp);
        }
    public String toString() {
        return heap.toString();
    }
        
}