// Source: https://leetcode.com/problems/unique-binary-search-trees/


package uniqueBinarySearchTrees;

import binaryTreeInorderTraversal.BinaryTreeInorderTraversal;

public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] way = new int[n+1];
        way[0] = 1;
        way[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                way[i] += way[j-1] * way[i-j];
            }
        }
        return way[n];
    }

    public static void main(String[] args) {
        System.out.println(UniqueBinarySearchTrees.numTrees(3));

    }
}

/*
1. 要思考能否将子计算缓存起来
 */