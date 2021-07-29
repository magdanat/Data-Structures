

public class Graph {
    // Breadth-First Search
    private HashMap<Node, LinkedList<Node>> adjacencyList;

    public class Node {
        int n;
        String name;
        Node children[];

        private Node(int n, String name) {
            this.n = n;
            this.name = name;
            visited = false;
        }
    }

    /*
    Breadth-first-search
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
    public void bfsearch(Node root) {
        if (root == null) {
            return NullPointerExceptionError;
        } else {
            Queue queue = new Queue();
            HashSet<Node> visited = new HashMap<Node>();
            queue.add(root);

            while(!nextToVisit.isEmpty()) {
                Node node = queue.remove();

                if (!visited.contains(node)) {
                    visited.add(node);
                }

                // Check nodes children and add each child to the queue
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
        }
    }

    /*
        Depth-First-Search
            Visit a node a and then iterate through each of a's neighbors.
            When visiting a node b that is a neighbor of a, we visit all of 
            b's neighbors before going on to a's other neighbors. 

        Pseudo-Code:
            void search(Node root) {
                if (root == null) {
                    return 
                }
                visit(root) // do stuff
                root.visited = true
                for each Node n in root.adjacent:
                    if n.visited == false:
                        search(n);
            }
    */
    public void dfsearch(Node root) {
            if (root == null) {
                throw NullPointerExceptionError;
            }
            root.visited = true;
            for (Node n : root.adjacent) {
                if (!n.visited) {
                    dfsearch(n);
                }
            }
    }
}
