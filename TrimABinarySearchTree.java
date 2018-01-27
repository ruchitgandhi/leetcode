public class TrimABinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static void main(String[] args) {
        /*TreeNode root =  new TreeNode(1);
        TreeNode temp = new TreeNode(0);
        temp.left = temp.right = null;
        root.left = temp;
        TreeNode temp2 = new TreeNode(2);
        temp2.left = temp2.right = null;
        root.right = temp2;
        System.out.println(trimBST(root, 1, 2).val);*/

        TreeNode root = new TreeNode(3);
        TreeNode temp = new TreeNode(0);
        root.left = temp;
        TreeNode temp2 = new TreeNode(2);
        temp.left = null;
        temp.right = temp2;

        TreeNode temp3 = new TreeNode(1);
        temp2.left = temp3;
        temp2.right = null;

        temp3.left = temp3.right = null;

        root.left = temp;
        TreeNode temp4 = new TreeNode(4);
        temp4.left = temp4.right = null;
        root.right = temp4;
        System.out.println(trimBST(root, 1, 3).val);
    }

    private static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root != null) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            if (root.val <= R && root.val >= L) {
                return root;
            } else if (root.val > R) {
                return root.left;
            } else {
                return root.right;
            }
        }
        return null;
    }
}
