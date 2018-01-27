import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = null;
        left.left.left = left.left.right = null;

        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(4);
        right.right.left = right.right.right = null;

        right.left = new TreeNode(2);
        right.left.right = null;

        right.left.left = new TreeNode(4);
        right.left.left.left = right.left.left.right = null;

        root.left = left;
        root.right = right;

        List<TreeNode> result = findDuplicateSubtrees(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).val);
        }
    }

    private static Map<String, Integer> subtreeMap;
    private static List<TreeNode> result;

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtreeMap = new HashMap<>();
        result = new ArrayList<>();
        findString(root);
        return result;
    }

    private static String findString(TreeNode root) {
        if (root == null) {
            return " ";
        } else {
            String returnValue = String.valueOf(root.val) + findString(root.left) + findString(root.right);

            subtreeMap.put(returnValue, subtreeMap.getOrDefault(returnValue, 0) + 1);
            if (subtreeMap.get(returnValue) == 2) {
                result.add(root);
            }

            return returnValue;
        }
    }
}
