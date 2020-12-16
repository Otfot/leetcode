// Source: https://leetcode.com/problems/validate-binary-search-tree/

/********************************
 Input: root = [5,1,4,null,null,3,6]
 Output: false
 Explanation: The root node's value is 5 but its right child's value is 4.

 Integer range
 *******************************/
package  validateBinarySearchTree;



public  class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        boolean status = false;

        status = solution(root, null, null);

        return status;
    }

    static boolean solution(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        return (min == null || root.val > min) && (max == null || root.val < max) && solution(root.left, min, root.val) && solution(root.right, root.val, max);
    }

    public static void main(String[] args) {

    }
}

/*
1. 当前节点满足 BST 同时确保子节点也要满足
2. 一个 BST 树，其中序遍历的值一定是递增的，可以通过中序遍历求解
 */