// Source: https://leetcode.com/problems/design-an-ordered-stream

/**********************************************
 Input
 [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 Output
 [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

 Explanation
 // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
 OrderedStream os = new OrderedStream(5);
 os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
 os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
 os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
 os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
 os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
 // Concatentating all the chunks returned:
 // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
 // The resulting order is the same as the order above.
***************************************************************/
package designAnOrderedStream;


import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    String[] streamList;
    int ptr;

    public OrderedStream(int n) {
        streamList = new String[n+1];
        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        streamList[id] = value;

        ArrayList<String> orderedStreams = new ArrayList<String>();
        for (int i=ptr; i<=streamList.length; i++) {
            if (streamList[i] == null) break;
            orderedStreams.add(streamList[i]);
            ptr++;
        }

        return orderedStreams;
    }
}

/*
1. 除非静态常量，否则通过构造函数赋初值
2. 想要利用 key-value 时，如果 key 为 Integer，思考能否使用数组来实现 （没有删除操作且需要遍历查询）
 */
