public class FindBottomLeftTreeValue {
    private static int minValue = Integer.MAX_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);

        TreeNode temp = new TreeNode(1);
        temp.left = temp.right = null;

        TreeNode temp2 = new TreeNode(3);
        temp2.left = temp2.right = null;

        node.left = temp;
        node.right = temp2;

        System.out.println(findBottomLeftValue(node));
    }

    private static int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueStartingAtDepth(root, 1);
    }

    private static int findBottomLeftValueStartingAtDepth(TreeNode root, int i) {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else if (root.left == null && root.right == null) {
            minValue = Math.min(minValue, root.val);
        } else {
            //minValue = Math.min(minValue, findBottomLeftValueStartingAtDepth())
        }
        return 0;
    }
}
