import java.util.*;
import java.util.LinkedList;

public class day87_advDSA7_Graph1 {
    /**
     * <p>
     *     Path in directed graph
     * </p>
     * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such
     * that there is a edge directed from node B[i][0] to node B[i][1].
     * Find whether a path exists from node 1 to node A.
     * Return 1 if path exists else return 0.
     * NOTE:
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     * Problem Constraints
     * 2 <= A <= 105
     * 1 <= M <= min(200000,A*(A-1))
     * 1 <= B[i][0], B[i][1] <= A
     * Input Format
     * The first argument given is an integer A representing the number of nodes in the graph.
     * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a
     * edge directed from node B[i][0] to node B[i][1].
     * Output Format
     * Return 1 if path exists between node 1 to node A else return 0.
     * Example Input
     * Input 1:
     *  A = 5
     *  B = [  [1, 2]
     *         [4, 1]
     *         [2, 4]
     *         [3, 4]
     *         [5, 2]
     *         [1, 3] ]
     * Input 2:
     *  A = 5
     *  B = [  [1, 2]
     *         [2, 3]
     *         [3, 4]
     *         [4, 5] ]
     * Example Output
     * Output 1:
     *  0
     * Output 2:
     *  1
     * Example Explanation
     * Explanation 1:
     *  The given doens't contain any path from node 1 to node 5 so we will return 0.
     * Explanation 2:
     *  Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
     */
    public static int PathinDirectedGrapth(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the directed graph
        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
        }

        // Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];

        queue.offer(1);  // Start from node 1
        visited[1] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // Check if we have reached the destination node A
            if (currentNode == A) {
                return 1;
            }

            // Explore the neighbors of the current node
            for (int neighbor : graph.get(currentNode)) {
            //for (int neighbor = 1; neighbor <= graph.get(currentNode).size(); neighbor++) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        // No path found from node 1 to node A
        return 0;
    }
/**
 *<p>Cycle in Directed Graph</p>
 *Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such
 * that there is a edge directed from node B[i][0] to node B[i][1].
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 */
    public static int isCycleInGraph(int A, int[][]B){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }
        // Build the directed graph
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        // Perform BFS for each node
        for (int i = 1; i <= A; i++) {
            if (isCycleExist(graph, i)) {
                return 1;  // Cycle detected
            }
        }
        return 0;  // No cycle detected
    }

    private boolean isCycleExist(List<List<Integer>> graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor : graph.get(currentNode)) {
                if (visited[neighbor]) {
                    return true;  // Cycle detected
                }

                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }

        return false;  // No cycle detected
    }
    public static void main(String[] args) {
        /* ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer>C = new ArrayList<>(2);
        C.add(2);
        C.add(3);
        B.add(0, C);
        System.out.println(PathinDirectedGrapth(2, B));
         */
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>() {{ add(1); add(2); }});
        B.add(new ArrayList<Integer>() {{ add(2); add(3); }});
        B.add(new ArrayList<Integer>() {{ add(3); add(4); }});
        B.add(new ArrayList<Integer>() {{ add(4); add(5); }});

        int result = PathinDirectedGrapth(A, B);
        System.out.println(result);
    }
}
