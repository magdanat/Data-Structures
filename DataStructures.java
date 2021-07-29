// Binary Tree Traversals

// In-order
public static void inOrderTraversal(TreeNode node) {
    if (node != null) {
        inOrderTraversal(node.left);
        visit(node);
        inOrderTraversal(node.right);
    }
}

// Pre-Order
public static void preOrderTraversal(TreeNode node) {
    if (node != null) {
        visit(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}

// Post-Order Traversal
public static void postOrderTraversal(TreeNode node) {
    if (node != null) {
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        visit(node);
    }
}

// TODO: Min-heap 
// TODO: Understand compareTo 
class MinHeap { 
    // How many nodes a node can have 
    private static final int NUM_CHILDREN = 2;

    private int externalSize; 
    private T[] heap;

    public MinHeap() {
        this.heap = new int[10];
        this.externalSize = 0;
    }

    // Insertion for an item into a heap.
    // Check if we need to expand the array, otherwise
    // Put the item in the array, increase internal size, then start sifting the item
    // 1. Insert at the bottom, then percolate up 
    // O (logn) run time
    public void insert(T item) {
        if (item == null) {
            throw IllegalArgumentException();
        } 

        // 
        if (this.size() == heap.length - 1) {
            this.expandHeap();
        }

        this.heap[this.size()] = item;
        this.externalSize++;

        // Want to pass the index
        this.percolateUp(this.size() - 1);
    }


    // 1. Remove minimum
    // 2. Swap minimum with last element (bottommost right)
    // 3. Bubble down element, swapping with its children until min-heap property is restored 
    // O (logn) runtime
    public T removeMin() {
        if (this.isEmpty()) {
            throw new EmptyContainerException();
        }

        T min = this.heap[0];
        this.heap[0] = this.heap[this.size() - 1];
        this.heap[this.size() - 1] = null;
        this.exertnalSize--;
        this.percolateDown(0);

        return min;
    }

    public int size() {
        return this.externalSize;
    }

    // Sift Up
    // 1. Get a reference to the parent
    //  2. Check if parent is larger than our value
    //  3. If it is swap
    private percolateUp(int index) {
        if (index != 0) {
            int parentIndex = (index - 1) / NUM_CHILDREN;

            // If parent is larger, swap
            if (this.heap[parentIndex].compareTo(this.heap[index]) > 0) {
                T oldParent = this.heap[parentIndex];
                this.heap[parentIndex] = this.heap[index];
                this.heap[index] = oldParent;

                this.percolateUp(parentIndex);
            }

        }
    }

    // Sift down 
    // Want to iterate through all the children and compare
    // Check if there are children nodes
    // Find the smallest index 
    private percolateDown(int index) {
        int  minChildIndex = index;

        // Check if there's at least one child, if not
        // leaf node and skip loop
        if (NUM_CHILDREN * index + 1 < this.size()) {
            // Compare parent to each child
            for (int i = 1; i <= NUM_CHILDREN; i++ ) {

                int childIndex = NUM_CHILDREN * index + 1;

                // Need to account for children going out of index
                if (childIndex < this.size() && this.heap[childIndex].compareTo(this.heap[minChildIndex]) < 0 ) { 

                    // Update smallest index
                    minChildIndex = childIndex;
                }
            }
        }
    }

    private expandHeap() {
        T[] largerHeap = new T[this.size() * 2];
        // Copy elements
        for (int i = 0; i < this.size() ; i++) {
            largerHeap[i] = this.heap[i];
        }
        this.heap = largerHeap;
    }
}

// Graphs
// Breadth-First-Search Pseudo
// Depth-First-Search Pseudo
public class Graph<V, E> {
    // private HashMap<V, List<E>> aList;
    // private List<V> verticesList;

    // public Graph(List<V> vertices, List<E> edges) {
    //     this.aList = new HashMap<V, List<E>>();
    //     this.vertices = vertices;

    //     // Create the list of edges for each vertice

    //     // Put a list in each vertex for aList
    //     for (V vertex : this.vertices) {
    //         List<E> vertexEdges = new Set<E>();
    //         this.aList.put(vertex, vertexEdges);
    //     }

    //     for (E edge : edges) {

    //         V 

    //     }

    // }

    // // Breadth-First-Search
    // private void bfs(V source, V destination) {
    //     List<E> shortestPath = 


    // }

    // Depth-First Search
    private void dfs() {

    }
}

/*
    Breadth first search
    Visit each of a node's neighbors before visitng any of their neighbors
    

    Pseudocode:
    void search(Node root) {
        Queue queue = new Queue()
        root.marked = true
        queue.enqueue(root) // Add to the end of queue

        while !queue.isEmpty()
            Node r = queue.dequeue() // Remote from the front of the queue
            visit(r)

        for each Node n in r.adjacent:
            if n.marked == false:
                n.marked = true
                queue.enqueue(n)
    }
*/


public class Graph {
    // Breadth-First Search
    private HashMap<Node, LinkedList<Node>> adjacencyList;
    // private List<E> edges;

    public class Node {
        int n;
        String name;
        boolean visited;

        private Node(int n, String name) {
            this.n = n;
            this.name = name;
            visited = false;
        }
    }


    // public static void search(Node root) {
    //     // if (root == null) {
    //     //     return NullPointerExceptionError;
    //     // } else {
    //     //     Queue queue = new Queue();
    //     //     HashSet<Node> visited = new HashMap<Node>();

    //     //     visit(root); // do something
    //     //     root.visited = true;
            
    //     //     // Look into neighbors and check if they're visited
    //     //     foreach (Node n in root.adjacent) {
    //     //         if (!n.visited) {
    //     //             search(n)
    //     //         }
    //     //     }
    //     // }
    // }
    }
}