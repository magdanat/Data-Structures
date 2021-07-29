// Queues
// First in first out
// Need to keep track of first & last
public class Queue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public Queuenode(T data) {
            this.data = data;
        }

        private QueueNode<T> first;
        private QueueNode<T> last;

        public void add(T item) {
            QueueNode<T> t = new QueueNode<T> (item);
            if (last != null) {
                last.next = t;
            }

            last = t;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) throw new NoSuchElementException();
            T data =  first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) throw new NoSuchElementException();
            return first.data;
        }

        public boolean is3() {
            return first == null;
        }
    }
}