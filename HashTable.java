// Hash Table
public class HashTable<T> {
    int[] arr = new int[10];

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(int key) {
        return key % this.arr.length;
    }

    public T get(int key) {
        int index = hash(key);
        Node<K,V> node = this.arr[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // Doesn't consider load factor atm. 
    public void push(int K, String value) {
        int index = hash(key);
        Node<K, V> n = this.arr[index];

        while (n != null) {
            if (n.key == k) {
                n.value = value;
                return;
            }
        }

        Node <K, V> n2 = new Node<K, V>(key, value);
        this.size++;
        n.next = n2;
    }

    public T remove(int key) {
        int index = hash(key);
        Node<K, V> n = this.arr[index];
        Node<K, V> prev = null;
        while (n != null) {
            if (n.key == key) {
                break;
            }
            prev = n;
            n = n.next;
        }

        // Never found key 
        if (n == null) {
            return null;
        }

        this.size--;
        prev.next = n.next;
        String val = n.value;
        n.next = null;

        return val; 

    }
}