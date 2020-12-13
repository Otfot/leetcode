// Source:

/************************************************
 Each step you may move to adjacent numbers on the row below.
 [
      [2],
     [3,4],
    [6,5,7],
   [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 ************************************************/

package triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] store = new Integer[triangle.size()][triangle.size()];
        System.out.println(store.length);
        return solotion(triangle, 0, 0, store);
    }

    static int solotion(List<List<Integer>> triangle,  int r, int c, Integer[][] store) {

        // 最后一行直接返回
        if(r == store.length-1){ return triangle.get(r).get(c); }
        // 已经填过的直接返回
        if(store[r][c] != null){
            return store[r][c];
        }

        int left = solotion(triangle, r+1, c, store);
        int right = solotion(triangle, r+1,c+1, store);
        store[r][c] = triangle.get(r).get(c) + ((left < right) ? left : right);
        return store[r][c];
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>(Arrays.asList(1));
        List<Integer> sub2 = new ArrayList<>(Arrays.asList(1,2));
        res.add(sub);
        res.add(sub2);
        Triangle.minimumTotal(res);
    }


}

/*
1. 使用对象数组，默认为 null 解决了普通数组默认值为 0 无法判断是否访问过的问题
2. 从下而上的递归方式，思路需要多练习下
 */
