import java.util.ArrayList;
import java.util.Queue;
import java.util.Collection;

/**
 * <b>
 *     Trees
 * </b>
 * <p>
 *     Array, Stack, Queue, LinkedList all are linear DS. DS is tool to help store data to get the
 *     meaning  full info from it.
 *     Trees can store the hierarchical data. eg Company CEO on top and others reporting them.
 *     <p>
 *         Basic Terminology:
 *         Nodes ->
 *          --> Top level node -> root node -> Only one in a Tree
 *          --> Connection between Nodes is called Edges
 *          --> GreatGrandParent --> Grandparent (Ancestors) --> Parent --> Child (Descendants)
 *          --> siblings if originates from same Parent
 *          --> Root node is a node without Parent
 *          --> End point nodes are called Leave Nodes, which doesn't have any child node
 *          <p>
 *              <b> Height  of a Tree:</b>
 *              Height of node means distance from particular node to farthest Leave node, count the edges.
 *              Root node height == max of all the children height + 1; this is also called height of a Tree.
 *          </p>
 *          <p>
 *              Binary Tree: for every node, no of Child Nodes <=2.
 *              It has only left and right child. Also it can have left sub Tree and right sub Tree.
 *          </p>
 *     </p>
 *     <p>
 *         <b>Recursion Basics:</b><p>
 *         1. Assumption: Decide what your function does & assume that it does.<p>
 *         2. Main Logic: Solving problem using sub problems</p><p>
 *         3. Base condition: When to stop</p>
 *         </p>
 *     </p>
 * </p>
 */
public class day62_advDSA_Trees1Structure {
    static class Node {
        int data;
        Node left; ///reference variable
        Node right;
        Node (int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * <b>Tree traversals:</b>
     * <p>1. Preorder: N L R -> Node before left and right child </p>
     * <p>2. Inorder L N R -> Node in between left and right child,, [Left sub tree] [Node] [Right sub Tree] </p>
     * <p>3. Postorder L R N -> Node after left and right child </p>
     * <p>4. Level order </p>
     * @param args
     */
    static void InorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        InorderTraversal(root.left);
        System.out.print(root.data+" ");
        InorderTraversal(root.right);
    }
    static void PreorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        PreorderTraversal(root.left);
        PreorderTraversal(root.right);
    }
    static void PostorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        PostorderTraversal(root.left);
        PostorderTraversal(root.right);
        System.out.print(root.data+" ");

    }
    static int max (int i, int j) {
        if (i > j)
            return i;
        else
            return j;
    }
    static int GetHeightOfLSubTree(Node root) {
        if (root == null) {
            return -1;
        }
        int l = GetHeightOfLSubTree(root.left);

        int r = GetHeightOfLSubTree(root.right);
        //System.out.println("leftsubtree height: "+l+" rightsubtree height:"+r);
        return max(l, r) +1;
    }

    /**
     * LevelorderTraversal: Recursion will not be useful.
     * This is level by level.
     * @param root
     */
    static void LevelorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        /*
        Queue<Node>q = new Queue<Node>();
        q.add(root);
        Node a = q.peek();
        System.out.println(" "+a.data);
        q.remove();
        if(a.left != null) {
            q.add(a.left);
        }
        if (a.right != null) {
            q.add(a.right);
        }*/
    }

    /**
     * Derive root node from PreOrder, the first one (N L R).
     * Now find the same root node from Inorder tree, the left side of Nodes will be left side subtree and right side will be right side subtree.
     * @param PreOrderRoot: Array of Preorder tree
     * @param InOrderRoot: Array of  Inorder tree
     * @param Ps
     * @param Pe
     * @param Is
     * @param Ie
     * @return
     */
    static Node DrawUniqueTreeFromPreAndInorderArray(int []PreOrderRoot, int[]InOrderRoot, int Ps, int Pe, int Is, int Ie) {

        return null;
    }

    static int getIndex(int val, ArrayList<Integer>in, int s, int e) {
        int idx = -1;
        for (int i = s; i < e; i++) {
            if (in.get(i) == val) {
                idx = i;
                break;
            }
        }
        return idx;
    }
    static Node buildTree(Node root, ArrayList<Integer> in, ArrayList<Integer> post, int s, int e, int pos) {
        if (s > e) {
            return null;
        }
        root = new Node(in.get(pos));
        int idx = getIndex(root.data, in, s, e);

        root.right = buildTree(root, in, post, idx+1, e, pos-1);
        root.left = buildTree(root, in, post, s, idx-1, pos-(e-idx)-1);

        return root;
    }
    static Node DrawTreeFromInorderAndPostorder(ArrayList<Integer> Inorder, ArrayList<Integer> Postorder) {

        int N = Postorder.size() -1;
        Node tree = null;
        tree = buildTree(tree, Inorder, Postorder, 0, N, N);
        return tree;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node n1 = new Node(6);
        Node n2 = new Node(9);
        Node n3 = new Node(10);
        root.left = n1;
        n1.left = n2;
        n1.right = n3;

        Node n4 = new Node(3);
        Node n5 = new Node (14);
        Node n6 = new Node(20);
        root.right = n4;
        n4. right = n5;
        n5.left = n6;
        System.out.println("PreorderTraversal: "); PreorderTraversal(root);
        System.out.println();
        System.out.println("InorderTraversal: "); InorderTraversal(root);
        System.out.println();
        System.out.println("PostorderTraversal: ");PostorderTraversal(root);
        System.out.println();
        System.out.println("GetHeightOfLSubTree: "+GetHeightOfLSubTree(root));
    }
}
