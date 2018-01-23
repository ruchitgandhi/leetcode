public class HouseRobber_Three {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode leftRight = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        TreeNode rightRight = new TreeNode(1);

        root.left = left;
        root.right = right;

        left.right = leftRight;
        left.left = null;

        right.left = null;
        right.right = rightRight;

        leftRight.left = leftRight.right = null;
        rightRight.left = rightRight.right = null;

        System.out.println(rob(root));
    }

    private static int rob(TreeNode root) {
        return calculateMaxScore(root);
    }

    private static int calculateMaxScore(TreeNode node) {
        int leftScore = 0, rightScore = 0, score1, score2;
        if (node != null) {
            if (node.left != null) {
                leftScore = calculateMaxScore(node.left.left);
                leftScore += calculateMaxScore(node.left.right);
            }
            if (node.right != null) {
                rightScore = calculateMaxScore(node.right.left);
                rightScore += calculateMaxScore(node.right.right);
            }
            score1 = node.val + leftScore + rightScore;

            leftScore = calculateMaxScore(node.left);
            rightScore = calculateMaxScore(node.right);

            score2 = leftScore + rightScore;

            return Math.max(score1, score2);
        }
        return 0;
    }
}
