public class HouseRobber_Three_Improved {
    private static class TreeNode {
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
        int result[] = calculateScores(root);
        return Math.max(result[0], result[1]);
    }

    //First value is "not robbed" and second value is "robbed"
    private static int[] calculateScores(TreeNode root) {
        int result[] = new int[2];
        if (root != null) {
            int leftScore[] = calculateScores(root.left);
            int rightScore[] = calculateScores(root.right);

            result[0] = Math.max(leftScore[0], leftScore[1]) + Math.max(rightScore[0], rightScore[1]);
            result[1] = root.val + leftScore[0] + rightScore[0];
        }
        return result;
    }
}
