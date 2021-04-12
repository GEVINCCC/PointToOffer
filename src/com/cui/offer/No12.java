package com.cui.offer;

// 矩阵中的路径
public class No12 {

    public static void main(String[] args) {
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED";
        char[][] board2 = {{'a','b'},{'c','d'}};
        String word2 = "abcd";
        System.out.println(exist(board1, word1));
        System.out.println(exist(board2, word2));
    }

    public static boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {        // 寻找矩阵中等于字符串第一个字符的元素作为遍历起点
                    if (hasPath(board, word.toCharArray(), i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPath(char[][] board, char[] word, int i, int j, int wordIndex) {

        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word[wordIndex]) {  // 剪枝条件
            return false;
        }

        if(wordIndex == word.length - 1) {   // 若通过遍历了剪枝条件但字符串已经匹配到最后一个字符，返回true
            return true;
        }

        board[i][j] = '\0';   // 若当前字符已匹配，设置为空字符表示已访问

        // 或连接表示匹配到一条路径即可
        boolean result = hasPath(board, word, i - 1 , j, wordIndex + 1) || hasPath(board, word, i, j - 1, wordIndex + 1) || hasPath(board, word, i + 1, j, wordIndex + 1) || hasPath(board, word, i, j + 1, wordIndex + 1);

        board[i][j] = word[wordIndex];   // 修改回原字符

        return result;
    }
}
