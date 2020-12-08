// Source: https://leetcode.com/problems/get-maximum-in-generated-array/

/**********************************************
 Input: n = 7
 Output: 3
 Explanation: According to the given rules:
 nums[0] = 0
 nums[1] = 1
 nums[(1 * 2) = 2] = nums[1] = 1
 nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 nums[(2 * 2) = 4] = nums[2] = 1
 nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 nums[(3 * 2) = 6] = nums[3] = 2
 nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
 **********************************************/

package getMaximumInGeneratedArray;

public class MaximumInGeneratedArray {

    public static int getMaximumGenerated(int n) {

        int[] gen = new int[n+1];

        if (n==0) return 0;

        gen[1] = 1;
        int i = 2, max = 1;

        while(i <=n) {
            if((i % 2) == 1) {
                gen[i] = gen[i/2] + gen[i/2+1];
            } else {
                gen[i] = gen[i/2];
            }
            max = Math.max(max, gen[i]);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(MaximumInGeneratedArray.getMaximumGenerated(4));
    }

/*
1. 变量如果只使用一次，直接定义在函数中，不要直接定义在类中
2. 数组会被默认赋初值
3. 对于类似斐波那契数列这种有特定计算公式的迭代计算，实现算法时不一定要使用递归
    从高到低计算，也可以从底到高计算并保存每次结果
 */
}
