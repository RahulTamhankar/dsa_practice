package dp.dpontrees;

public class diameterofBinaryTree {

    // TreeNode class to represent a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Method to calculate the height of the binary tree and the diameter
    private int solve(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int l = solve(root.left, res);  // Height of left subtree
        int r = solve(root.right, res); // Height of right subtree

        // Calculate the height of the current node
        int temp = 1 + Math.max(l, r); // Height is 1 + max(left height, right height)

        // Update the maximum diameter (sum of left and right subtree heights)
        res[0] = Math.max(res[0], l + r); // Diameter can be the sum of left and right heights

        // Return the height of the current node
        return temp;
    }

    // Method to return the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1]; // Array to store the maximum diameter (since integers are passed by value)
        solve(root, res);
        return res[0]; // Return the maximum diameter found
    }

    public static void main(String[] args) {
        // Create the binary tree
        diameterofBinaryTree tree = new diameterofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Call the diameterOfBinaryTree method and print the result
        System.out.println("Diameter of the tree is: " + tree.diameterOfBinaryTree(root));
    }
}
