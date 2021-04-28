import java.security.InvalidKeyException;
import java.util.Map.Entry;


public interface Map<K, V> {

    public int size();

    public boolean isEmpty();

    public V put(K key, V value) throws InvalidKeyException;

    public V get(K key) throws InvalidKeyException;

    public V remove(K key) throws InvalidKeyException;

    public Iterable<K> keySet();

    public Iterable<V> values();

    public Iterable<Entry<K, V>> entrySet();

}
