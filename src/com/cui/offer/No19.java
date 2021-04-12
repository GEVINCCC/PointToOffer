package com.cui.offer;


// 正则表达式匹配
public class No19 {

    public static void main(String[] args) {
        String A = "aab";
        String B = "c*a*b";
        System.out.print(isMatch(A, B));
    }

    // 解法一：递归
    public static boolean isMatch(String A, String B) {
        if (A.length() == 0) {                // 字符串长度为0，需要检查下正则串
            if (B.length() % 2 == 1) {        // 若正则串长度为奇数，则必不匹配，如“ab*”
                return false;
            }
            // 正则串长度为偶数
            for (int i = 0; i < B.length(); i += 2) {
                if (B.charAt(i + 1) != '*')          // 若不是“a*b*的形式，则必不匹配”
                    return false;
            }
            return true;
        }

        if (B.length() == 0) {               // 正则串长度为0，此时必不匹配
            return false;
        }

        char a1 = A.charAt(0);          // a1表示字符串第一个字符
        char b1 = B.charAt(0);         // b1表示正则串第一个字符
        char b2 = '\0';
        if (B.length() > 1) {
            b2 = B.charAt(1);
        }

        if (b2 != '*') {
            if (b1 != '.' && b1 != a1) {
                return false;
            }
            // b1为’.‘ 或 b1等于a1的情况
            return isMatch(A.substring(1), B.substring(1));
        } else {
            if (b1 != '.' && b1 != a1) {
                return isMatch(A, B.substring(2));
            }
            // b1为’.‘ 或 b1等于a1的情况
            return isMatch(A.substring(1), B) || isMatch(A, B.substring(2));
        }
    }

    // 解法二：动态规划
    public static boolean isMatch2(String A, String B) {

        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;   // A和B都是空串时，可以匹配
        for(int j = 2; j <= B.length(); j+=2) {               // A为空串且B不为空串时，如果是形如 a * a *的形式
            if(B.charAt(j-1) == '*' && dp[0][j-2] == true)
                dp[0][j] = true;
        }

        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                if(B.charAt(j-1) == A.charAt(i-1)||B.charAt(j-1) == '.')  // 如果B[j-1]是正常字符且等于A[i-1]或B[j-1]是'.'
                    dp[i][j] = dp[i-1][j-1];
                if(B.charAt(j-1) == '*' ) {    // 如果B[j-1]是'*'，此时要根据B[j-2]的值分两种情况考虑
                    if(B.charAt(j-2) != A.charAt(i-1)) {   // 如果B[j-2]是正常字符且不等于A[i-1]
                        dp[i][j] = dp[i][j - 2];
                    }
                    if(B.charAt(j-2) == '.' || B.charAt(j-2) == A.charAt(i-1)) { // 如果B[j-2]是'.'或B[j-2]等于A[i-1]，此时B[j-2]在A的末尾可能出现0~n次
                        dp[i][j] = dp[i - 1][j] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
