/*

NOTE: Using recursion is not allowed.

Problem1:
Given a binary tree, return the inorder traversal of its nodes' values.
inorder ~ LDR: Left, Data, Right

Problem2:
Given a binary tree, return the preorder traversal of its nodes values.
preorder ~ DLR: Data, Left, Right


Problem3:
Given a binary tree, return the Postorder traversal of its nodes values.
Postorder ~ LRD

problem4:
You are given the root node of a binary tree A. You have to find the height of the given tree.
A binary tree's height is the number of nodes along the longest path from the root node down to
the farthest leaf node.

problem5:
You are given the root node of a binary tree A. You have to find the number of nodes in this tree.

problem6:
Given the root of a binary tree A. Return the sum of all the nodes of the binary tree.

problem7:
Given a binary tree, find and return the sum of node value of all left leaves in it.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
    public int[] inorderTraversal(TreeNode A) {
        Stack<TreeNode>stack = new Stack<TreeNode>();
        ArrayList<Integer>ret = new ArrayList<Integer>();
        TreeNode curr = A;
        while(curr != null || !stack.isEmpty()) {
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        int[] arr = ret.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    public int[] preorderTraversal(TreeNode A) {
        Stack<TreeNode>stack = new Stack<TreeNode>();
        List<Integer>ret = new ArrayList<Integer>();

        TreeNode curr = A;
        stack.push(curr);
        while(!stack.isEmpty()) {
            TreeNode N = stack.pop();
            if (N != null) {
                ret.add(N.val);
                stack.push(N.right);
                stack.push(N.left);
            }
        }
        //int[] res = new Integer[ret.size()];
        //res = ret.toArray(res);

        int[] arr = ret.stream().mapToInt(i -> i).toArray();
        //arr.le
        return arr;
    }
    public int[] postorderTraversal(TreeNode A) {
        Stack<TreeNode>stack = new Stack<TreeNode>();
        List<Integer>ret = new ArrayList<Integer>();

        TreeNode curr = A;
        stack.push(curr);
        while(!stack.isEmpty()) {
            TreeNode N = stack.pop();
            if(N!=null) {
                ret.add(N.val);
                stack.push(N.left);
                stack.push(N.right);
            }

        }
        //int[] res = new Integer[ret.size()];
        //res = ret.toArray(res);
        int[] arr = ret.stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        for (int i = 0; i < n/2; i++){
            int tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = tmp;
        }
        return arr;
    }
    public int max(int a , int b){
        if (a >= b){
            return a;
        } else {
            return b;
        }
    }
    public int getTreeHeight(TreeNode A) {
        int l, r = 0, res = 0;
        if(A == null){
            return 0;
        }
        l = getTreeHeight(A.left);
        r = getTreeHeight(A.right);
        res = 1+ max(l, r);
        return res;
    }
    public int getNoOfNodesInTree(TreeNode A) {
        int l, r = 0, res = 0;
        if(A == null){
            return 0;
        }
        l = getNoOfNodesInTree(A.left);
        r = getNoOfNodesInTree(A.right);
        res = l +r + 1;
        return res;
    }
    public int getSumOfTree(TreeNode A) {
        int l, r = 0, res = 0;
        if(A == null){
            return 0;
        }
        l = getSumOfTree(A.left);
        r = getSumOfTree(A.right);
        res = l +r + A.val;
        return res;
    }
    public int getSumOfLeftLeavesInTree(TreeNode A, boolean isLeft) {
        int l = 0, r = 0, res = 0;
        if(A == null){
            return 0;
        }
        if (A.left == null && A.right == null & isLeft) {
            return A.val; //data;
        }
        return getSumOfLeftLeavesInTree(A.left, true) + getSumOfLeftLeavesInTree(A.right, false);
    }
}

public class TreePracticeWithoutRecursion {
//     * Definition for binary tree

    public static void main(String[] args) {
    TreeNode mytree = new TreeNode(1);
    TreeNode mytree1 = new TreeNode(2);
    mytree.left = mytree1;
    TreeNode mytree2 = new TreeNode(3);
    mytree.right = mytree2;

    TreeNode mytree3 = new TreeNode(5);
    mytree1.left = mytree3;

    System.out.println(mytree.getSumOfLeftLeavesInTree(mytree, false));
    }
}
