package dp.dpontrees;

public class MaximumPathSumFromLeafNodeToLeafNode {

    // TreeNode class to represent a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Helper method to recursively calculate the maximum path sum between two leaf nodes
    private int findMaxLeafToLeafSum(TreeNode root, int[] res) {
        if (root == null) {
            return 0; // If the node is null, return 0
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftSum = findMaxLeafToLeafSum(root.left, res);
        int rightSum = findMaxLeafToLeafSum(root.right, res);

        // If the node is a leaf node, return its value
        if (root.left == null && root.right == null) {
            return root.val;
        }

        // If the node has both left and right children, calculate the path sum through this node
        if (root.left != null && root.right != null) {
            // Update the result with the maximum sum through this node
            int totalSum = root.val + leftSum + rightSum;
            res[0] = Math.max(res[0], totalSum); // Update the global result
            return root.val + Math.max(leftSum, rightSum); // Return the maximum path sum to the parent
        }

        // If the node has only one child, return the sum of the node's value and that child's sum
        if (root.left != null) {
            return root.val + leftSum;
        }
        return root.val + rightSum;
    }

    // Method to return the maximum path sum between two leaf nodes
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1]; // Array to store the result (since integers are passed by value)
        res[0] = Integer.MIN_VALUE; // Initialize the result to the minimum value

        // Call the helper method to calculate the maximum path sum from leaf to leaf
        findMaxLeafToLeafSum(root, res);

        return res[0]; // Return the result
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Call the maxPathSum method to calculate and print the result
        MaximumPathSumFromLeafNodeToLeafNode solution = new MaximumPathSumFromLeafNodeToLeafNode();
        System.out.println("Maximum Path Sum from Leaf to Leaf: " + solution.maxPathSum(root));
    }
}



//animation
//https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/6182028/animated-video-simplest-solution-you-ll-see/