// LinkedList
public class LinkedList<T> {
    private static class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    ListNode head;

    // Find the node with the value and remove it
    public T delete(V value) {

        ListNode curr = this.head;
        ListNode prev = null;

        while (currNode != null) {
            if (curr.data != value) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                return curr.data;
            }
        }
        return null;
    }

    // Add at the end of the list
    public void add(T data) {
        ListNode newNode = new Node(data);

        if (this.head == null) {
            head = newNode; 
        } else {
            ListNode curr = this.head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;

        }
    }
}
