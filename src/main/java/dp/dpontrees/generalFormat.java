package dp.dpontrees;

public class generalFormat {

    // TreeNode definition for binary tree nodes
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Pair class to hold the height and diameter
    static class Pair {
        int first;  // height
        int second; // diameter
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to compute the height and diameter of a binary tree
    public static Pair func(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0); // Return height 0 and diameter 0 for null node
        }

        // Recursively calculate the height and diameter of left and right subtrees
        Pair left = func(root.left);
        Pair right = func(root.right);

        // Height is 1 + the maximum height of left or right subtree
        int height = 1 + Math.max(left.first, right.first);//temp ans

        // Diameter is the maximum of:
        // 1. Diameter of left subtree
        // 2. Diameter of right subtree
        // 3. The sum of the heights of left and right subtree (i.e., through this node)
        int diameter = Math.max(left.second, Math.max(right.second, left.first + right.first));

        // Return the height and the diameter as a pair
        return new Pair(height, diameter);
    }

    // Function to compute the diameter of the binary tree
    public static int diameterOfBinaryTree(TreeNode root) {
        return func(root).second; // Return the diameter stored in the second field of the Pair
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of the binary tree: " + diameterOfBinaryTree(root));
    }
}

//      1
//     / \
//    2   3
//   / \
//  4   5
