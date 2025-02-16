package dp.dpontrees;

public class MaximumPathSumFromAnyNodetoanyNode {

    // TreeNode class to represent a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Helper method to recursively calculate the maximum path sum and update the answer
    private int dp(TreeNode root, int[] res) {
        if (root == null) {
            return 0; // If the node is null, the sum is 0
        }

        // Recursively calculate the sum for the left and right subtrees
        int leftSum = dp(root.left, res);
        int rightSum = dp(root.right, res);

        // Calculate the maximum path sum considering the current node
        int pathSum = Math.max(Math.max(leftSum, rightSum)+root.val , root.val);//temp

        // Calculate the total sum passing through the current node
        int totalSum = Math.max(pathSum, root.val + leftSum + rightSum);//ans

        // Update the global maximum path sum
        res[0] = Math.max(res[0], totalSum);

        // Return the maximum path sum to be passed to the parent
        return pathSum;
    }

    // Method to return the maximum path sum of the binary tree
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1]; // Array to store the maximum path sum (since int is passed by value)
        res[0] = Integer.MIN_VALUE; // Initialize to minimum value
        dp(root, res); // Call the dp function to calculate the maximum path sum
        return res[0]; // Return the maximum path sum
    }

    // Main method for testing the maxPathSum function
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Call maxPathSum to calculate and print the result
        MaximumPathSumFromAnyNodetoanyNode solution = new MaximumPathSumFromAnyNodetoanyNode();
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }
}
