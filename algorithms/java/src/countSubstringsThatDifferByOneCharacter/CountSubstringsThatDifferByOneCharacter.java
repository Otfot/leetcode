// Source: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/


/************************************************
 Input: s = "aba", t = "baba"
 Output: 6
 Explanation: The following are the pairs of substrings from s and t that differ by exactly 1 character:
 ("aba", "baba")
 ("aba", "baba")
 ("aba", "baba")
 ("aba", "baba")
 ("aba", "baba")
 ("aba", "baba")

 The underlined portions are the substrings that are chosen from s and t.
 ************************************************/

package countSubstringsThatDifferByOneCharacter;

public class CountSubstringsThatDifferByOneCharacter {

    public static int countSubstrings(String s, String t) {
        int res = 0;

        for(int i = 0; i < s.length(); i++)
            res += solution(s, t, i, 0);
        for(int j = 1; j < t.length(); j++)
            res += solution(s, t, 0, j);

        return res;
    }

    static int solution(String s, String t, int i, int j) {
        int res = 0, pre = 0, cur = 0, n = s.length(), m = t.length();

        while (i < n && j < m) {
            cur += 1;
            if (s.charAt(i) != t.charAt(j)) {
                pre = cur;
                cur = 0;
            }

            res += pre;
            i += 1; j += 1;
        }

        return res;

    }

    public static void main(String[] args) {
        CountSubstringsThatDifferByOneCharacter.countSubstrings("aba", "baba");
    }
}

/*
1. 对于相似性代码，要尝试抽取成函数
2. 思路会决定算法实现的难易程度
 */