// Source: https://leetcode.com/problems/binary-tree-inorder-traversal/

/********************************
 * 输出二叉树中序遍历
 *
 Input: root = [1,null,2,3]
 Output: [1,3,2]
 Input: root = []
 Output: []
 Input: root = [1]
 Output: [1]
 ********************************/

package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null != root)
            solution(result, root);
        return result;
    }

    static void solution(List<Integer> result, TreeNode node) {

        if (null != node.left)
            solution(result, node.left);

        result.add(node.val);

        if (null != node.right) {
            solution(result, node.right);
        }
    }

    public static void main(String[] args) {

        TreeNode root3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, null, null);
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(root));
    }
}
